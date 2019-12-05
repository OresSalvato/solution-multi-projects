package controllers;

import com.ores.salvato.entities.Product;
import repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class RestProductServiceController {

  private ProductRepository repository;
  private Product anyProduct;

  @Autowired
  public RestProductServiceController(ProductRepository repository) {
    this.repository = repository;
  }

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
    return repository.save(item);
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
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable final String id) {
    throwIfInvalidId(id);
    repository.deleteById(id);
  }

  @GetMapping()
  public List<Product> getAll() {
    return repository.findAll();
  }

  @GetMapping("{id}")
  public Product getById(@PathVariable final String id) {
    throwIfInvalidId(id);
    return repository.findById(id).get();
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