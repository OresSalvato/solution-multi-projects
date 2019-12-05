package controllers;

import com.ores.salvato.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public final class RestUserServiceController {

  private UserRepository repository;
  private User anyUser;

  @Autowired
  public RestUserServiceController(UserRepository repository) {
    this.repository = repository;
  }

  private boolean isInvalidID(@NonNull String id){
    return id.equals(User.INVALID_ID);
  }
  private void throwIfInvalidId(String id){
    if (isInvalidID(id)){
      throw new RuntimeException("Invalid Id received - ");
    }
  }

  @PostMapping()
  public User add(@RequestBody final User item) {
    return repository.save(item);
  }

  @PutMapping("{id}")
  public User update(@PathVariable final String id, @RequestBody final User item) {
    throwIfInvalidId(id);
    throwIfInvalidId(item.getId());
    return repository.findById(id).map(user -> {
      user.setName(item.getName());
      user.setLastName(item.getLastName());
      user.setEmail(item.getEmail());
      user.setPassword(item.getPassword());
      user.setActive(item.getActive());
      return repository.save(user);
    }).orElseGet(() -> repository.save(item));
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable final String id) {
    throwIfInvalidId(id);
    repository.deleteById(id);
  }

  @GetMapping()
  public List<User> getAll() {
    return repository.findAll();
  }

  @GetMapping("{id}")
  public User getById(@PathVariable final String id) {
    throwIfInvalidId(id);
    return repository.findById(id).get();
  }

//  @Override
//  @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
//  @ResponseBody
//  public User findByName(@PathVariable final String name) {
//    String jxQuery = String.format("/.[name='%s']", name);
//    return jsonDB.dbTemplate.findOne(jxQuery, collectionName);
//  }
//
//  @RequestMapping(value = "find{surname}", method = RequestMethod.GET)
//  @ResponseBody
//  public List<User> findBySurName(@RequestParam final String surname) {
//    String jxQuery = String.format("/.[lastName='%s']", surname);
//
//    Role r = new Role();
//    r.setName("");
//    return jsonDB.dbTemplate.find(jxQuery, collectionName);
//  }
}