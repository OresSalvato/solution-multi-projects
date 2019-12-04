package controllers;

import com.ores.salvato.entities.Role;
import com.ores.salvato.entities.User;
import com.ores.salvato.interfaces.model.IAnyRecord;

import org.springframework.lang.NonNull;
import repositories.JsonDbRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
//import static spring.SpringDemo.SpringDemoApplication.repo;

@Controller
@RequestMapping(value = "/user")
public final class RestUserServiceController implements IAnyRecord<User> {
  private final String collectionName ="User";
  private JsonDbRepository jsonDB ;//= ((JsonDbRepository)repo);

  private boolean isInvalidID(@NonNull String id){
    return id.equals(User.INVALID_ID);
  }
  private void throwIfInvalidId(String id){
    if (isInvalidID(id)){
      throw new RuntimeException("Invalid Id received - ");
    }
  }

  @Override
  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public User add(@RequestBody final User item) {
    jsonDB.dbTemplate.insert(item,collectionName);
    return item;
  }

  @Override
  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  @ResponseBody
  public User update(@PathVariable final String id, @RequestBody final User item) {
    throwIfInvalidId(id);
    throwIfInvalidId(item.getId());
    jsonDB.dbTemplate.upsert(item, collectionName);
    return item;
  }

  @Override
  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@PathVariable final String id) {
    throwIfInvalidId(id);
    User userToDelete = new User();
    //userToDelete.setId(id);
    jsonDB.dbTemplate.remove(userToDelete, collectionName);
  }

  @Override
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<User> getAll() {
    return jsonDB.dbTemplate.getCollection(User.class);
  }

  @Override
  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  @ResponseBody
  public User getById(@PathVariable final String id) {
    throwIfInvalidId(id);
    return jsonDB.dbTemplate.findById(id,collectionName);
  }

  @Override
  @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
  @ResponseBody
  public User findByName(@PathVariable final String name) {
    String jxQuery = String.format("/.[name='%s']", name);
    return jsonDB.dbTemplate.findOne(jxQuery, collectionName);
  }

  @RequestMapping(value = "find{surname}", method = RequestMethod.GET)
  @ResponseBody
  public List<User> findBySurName(@RequestParam final String surname) {
    String jxQuery = String.format("/.[lastName='%s']", surname);

    Role r = new Role();
    r.setName("");
    return jsonDB.dbTemplate.find(jxQuery, collectionName);
  }
}