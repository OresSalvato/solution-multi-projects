//package com.ores.salvato.interfaces.controller;
//import com.ores.salvato.interfaces.model.AnyRecord;
//import com.ores.salvato.interfaces.model.IAnyRecord;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//public class AnyServiceController<T extends AnyRecord> implements IAnyRecord<T> {
//
////  private final String collectionName = T.class.getAnnotation(Document.class).collection();
//  private final Map<Integer, T> allItems = new HashMap<Integer, T>();
//  private int keyIndex = 0;
//
////  public Map<Integer, T> setDAO(Map<Integer, T> inboundDAO) {
////    allItems.putAll(inboundDAO);
////    return allItems;
////  }
//
//  //public class RestUserServiceController<User extends AnyRecord> extends AnyServiceController<User>{
////  private final Map<Integer, User> allItems = new HashMap<Integer,User>();
////
////  public  RestUserServiceController (){
////    AnyRecord rec;
////    rec= new entity.User();
////    rec.setName("Lohs");
////    rec.setId(3);
////    allItems.put(3, (User) rec);
////    this.setDAO(allItems);
////  }
////}
//  @RequestMapping(method = RequestMethod.POST)
//  @ResponseBody
//  public T add(@RequestBody final T item) {
//    final String newId = String.valueOf(this.keyIndex++);
//    item.setId(newId);
//    this.allItems.put(Integer.valueOf(newId), item);
//    return item;
//  }
//
//  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//  @ResponseBody
//  public T update(@PathVariable final String id, @RequestBody final T item) {
//    if ((item.getId() == T.INVALID_ID) || (id == T.INVALID_ID)) {
//      throw new RuntimeException("Invalid Id receieved - ");
//    }
//    this.allItems.put(Integer.valueOf(id), item);
//    return item;
//  }
//
//  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//  @ResponseStatus(value = HttpStatus.OK)
//  public void delete(@PathVariable final String id) {
//    this.allItems.remove(id);
//    return;
//  }
//
//  @RequestMapping(method = RequestMethod.GET)
//  @ResponseBody
//  public List<T> getAll() {
//    Collection<T> items = allItems.values();
//    return new ArrayList<T>(items);
//  }
//
//  @RequestMapping(value = "{id}", method = RequestMethod.GET)
//  @ResponseBody
//  public T getById(@PathVariable final String id) {
//    return this.allItems.get(id);
//  }
//
//  @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
//  @ResponseBody
//  public T findByName(@PathVariable final String name) {
//    T target = null;
//    for (final T item : this.allItems.values()) {
//      if (name.equals(item.getName())) {
//        target = item;
//        break;
//      }
//    }
//    return target;
//  }
//}