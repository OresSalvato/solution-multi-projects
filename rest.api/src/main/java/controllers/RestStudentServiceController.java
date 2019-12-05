package controllers;

import com.ores.salvato.entities.Student;
import repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class RestStudentServiceController{

  private StudentRepository repository;
  private Student anyStudent;

  @Autowired
  public RestStudentServiceController(StudentRepository repository) {
    this.repository = repository;
  }

  private boolean isInvalidID(@NonNull String id) {
    return id.equals(Student.INVALID_ID);
  }

  private void throwIfInvalidId(String id) {
    if (isInvalidID(id)) {
      throw new RuntimeException("Invalid Id received - ");
    }
  }

  @PostMapping()
  public Student add(@RequestBody final Student item) {
    return repository.save(item);
  }

  @PutMapping("{id}")
  public Student update(@PathVariable final String id, @RequestBody final Student item) {
    throwIfInvalidId(id);
    throwIfInvalidId(item.getId());
    return repository.findById(id).map(student -> {
      student.setName(item.getName());
      student.setAge (item.getAge());
      student.setRegistrationNumber(item.getRegistrationNumber());
      return repository.save(student);
    }).orElseGet(() -> repository.save(item));
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable final String id) {
    throwIfInvalidId(id);
    repository.deleteById(id);
  }

  @GetMapping()
  public List<Student> getAll() {
    return repository.findAll();
  }

  @GetMapping("{id}")
  public Student getById(@PathVariable final String id) {
    throwIfInvalidId(id);
    return repository.findById(id).get();
  }

  @GetMapping(value = "search/{name}")
  public Student findByName(@PathVariable final String name) {
    Student target = null;
//    for (final Student item : this.repository. .allItems.values()) {
//      if (name.equals(item.name)) {
//        target = item;
//        break;
//      }
//    }
    return target;
  }

  @PostConstruct
  public void init() {
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