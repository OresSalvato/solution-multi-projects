package controllers;

import com.ores.salvato.entities.Product;
import com.ores.salvato.interfaces.model.IAnyRecord;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(value = "/product")
public class RestProductServiceController implements IAnyRecord<Product> {

  private final Map<String, Product> allItems = new HashMap<String, Product>();
  private int keyIndex = 0;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public Product add(@RequestBody final Product item) {
    //final int newId = this.keyIndex++;
    //item.setId(newId);
    this.allItems.put(item.getId(), item);
    return item;
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  @ResponseBody
  public Product update(@PathVariable final String id, @RequestBody final Product item) {
    if ((item.getId() == Product.INVALID_ID) || (id == Product.INVALID_ID)) {
      throw new RuntimeException("Invalid Id receieved - ");
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
  public List<Product> getAll() {
    Collection<Product> items = allItems.values();
    return new ArrayList<Product>(items);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  @ResponseBody
  public Product getById(@PathVariable final String id) {
    return this.allItems.get(id);
  }

  @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
  @ResponseBody
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