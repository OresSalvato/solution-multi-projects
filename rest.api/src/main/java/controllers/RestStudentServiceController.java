package controllers;
//RestStudentRepository implements IAnyRecord (IAnyRepository)

import com.ores.salvato.entities.Student;
import com.ores.salvato.entities.User;
import com.ores.salvato.interfaces.model.IAnyRecord;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@Controller
@RequestMapping(value = "/student")
public class RestStudentServiceController implements IAnyRecord<Student> {

  private final Map<String, Student> allItems = new HashMap<String, Student>();
  private int keyIndex = 0;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public Student add(@RequestBody final Student item) {
    item.setId(UUID.randomUUID().toString());
    this.allItems.put( item.getId(), item);
    return item;
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  @ResponseBody
  public Student update(@PathVariable final String id, @RequestBody final Student item) {
    if ((item.getId() == Student.INVALID_ID) || (id == Student.INVALID_ID)) {
      throw new RuntimeException("Invalid Id received - ");
    }
    this.allItems.put(id, item);
    return item;
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@PathVariable final String id) {
    this.allItems.remove(id);
    return;
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<Student> getAll() {
    Collection<Student> items = allItems.values();
    return new ArrayList<Student>(items);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  @ResponseBody
  public Student getById(@PathVariable final String id) {
    return this.allItems.get(id);
  }

  @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
  @ResponseBody
  public Student findByName(@PathVariable final String name) {
    Student target = null;
    for (final Student item : this.allItems.values()) {
      if (name.equals(item.getName())) {
        target = item;
        break;
      }
    }
    return target;
  }

  @PostConstruct
  public void init() {
    Student anyStudent;
    {
      anyStudent = new Student();
      anyStudent.setAge(666);
      anyStudent.setName("Undertaker");
      anyStudent.setRegistrationNumber("999-666-999");
      this.add(anyStudent);
    }
    {
      anyStudent = new Student();
      anyStudent.setAge(55);
      anyStudent.setName("Kane");
      anyStudent.setRegistrationNumber("876-123-444");
      this.add(anyStudent);
    }{
      anyStudent = new Student();
      anyStudent.setAge(99);
      anyStudent.setName("The Priest");
      anyStudent.setRegistrationNumber("123-000-321");
      this.add(anyStudent);
    }
  }
}