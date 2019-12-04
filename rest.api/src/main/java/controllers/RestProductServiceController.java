package controllers;

import com.ores.salvato.entities.Product;
import com.ores.salvato.interfaces.model.IAnyRecord;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import repositories.ProductRepository;

import java.util.*;

@RestController
@RequestMapping(value = "product")
public class RestProductServiceController {// implements IAnyRecord<Product> {

  //@Autowired
  @Getter
  @Setter(AccessLevel.PROTECTED)
  private ProductRepository repository;

  private final Map<String, Product> allItems = new HashMap<>();
  private Product anyProduct;
  private int keyIndex = 0;

  private boolean isInvalidID(@NonNull String id) {
    return id.equals(Product.INVALID_ID);
  }

  private void throwIfInvalidId(String id) {
    if (isInvalidID(id)) {
      throw new RuntimeException("Invalid Id received - ");
    }
  }

  @PostMapping()
  public Product add(@RequestBody final Product item) {
    return repository.saveAndFlush(item);
    //this.allItems.put(item.getId(), item);
    //return item;
  }

  @PutMapping("{id}")
  public Product update(@PathVariable final String id, @RequestBody final Product item) {
    throwIfInvalidId(id);
    throwIfInvalidId(item.getId());
    return repository.findById(id).map(product -> {
      product.setName(item.getName());
      product.setDescription(item.getDescription());
      return repository.save(product);
    }).orElseGet(() -> repository.save(item));
    //this.allItems.replace(id, item);
    //return item;
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable final String id) {
    throwIfInvalidId(id);
    repository.deleteById(id);
    // this.allItems.remove(id);
  }

  @GetMapping()
  public List<Product> getAll() {
    return repository.findAll();
    //Collection<Product> items = allItems.values();
    //return new ArrayList<>(items);
  }

  @GetMapping("{id}")
  public Product getById(@PathVariable final String id) {
    throwIfInvalidId(id);
    return repository.findById(id).get();
    //return this.allItems.get(id);
  }

//  @GetMapping("search/{name}")
//  public Product findByName(@PathVariable final String name) {
//    Product target = null;
//    for (final Product item : this.allItems.values()) {
//      if (name.equals(item.getName())) {
//        target = item;
//        break;
//      }
//    }
//    return target;
//  }
}