package com.ores.salvato.interfaces.model;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//public interface ICrud<T> {
//  @ResponseBody T add(@RequestBody final T any);
//  @ResponseBody T update(@PathVariable final String id, @RequestBody final T any);
//  void delete(@PathVariable final String id);
//}

public interface ICrud<T> {
   T add( final T any);
   T update( final String id,  final T any);
  void delete( final String id);
}