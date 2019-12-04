package controllers;

import com.ores.salvato.entities.Product;
import com.ores.salvato.interfaces.model.IAnyRecord;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "product")
public class RestProductServiceController implements IAnyRecord<Product> {

  private final Map<String, Product> allItems = new HashMap<>();
  private Product anyProduct;
  private int keyIndex = 0;

  private boolean isInvalidID(@NonNull String id){
    return id.equals(Product.INVALID_ID);
  }
  private void throwIfInvalidId(String id){
    if (isInvalidID(id)){
      throw new RuntimeException("Invalid Id received - ");
    }
  }

  @PostMapping()
  public Product add(@RequestBody final Product item) {
    this.allItems.put(item.getId(), item);
    return item;
  }

  @PutMapping("{id}")
  public Product update(@PathVariable final String id, @RequestBody final Product item) {
    throwIfInvalidId(id);
    throwIfInvalidId(item.getId());
    this.allItems.replace(id, item);
    return item;
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable final String id) {
    throwIfInvalidId(id);
    this.allItems.remove(id);
  }

  @GetMapping()
  public List<Product> getAll() {
    Collection<Product> items = allItems.values();
    return new ArrayList<>(items);
  }

  @GetMapping("{id}")
  public Product getById(@PathVariable final String id) {
    throwIfInvalidId(id);
    return this.allItems.get(id);
  }

  @GetMapping("search/{name}")
  public Product findByName(@PathVariable final String name) {
    Product target = null;
    for (final Product item : this.allItems.values()) {
      if (name.equals(item.getName())) {
        target = item;
        break;
      }
    }
    return target;
  }
}