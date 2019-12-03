package com.ores.salvato.interfaces.model;

import java.util.List;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.PathVariable;
//
//
//public interface ILs<T> {
//  @ResponseBody
//  List<T> getAll();
//  @ResponseBody T getById(@PathVariable final String id);
//  @ResponseBody T findByName(@PathVariable final String name);
//}
public interface ILs<T> {
  List<T> getAll();
   T getById( final String id);
   T findByName( final String name);
}
