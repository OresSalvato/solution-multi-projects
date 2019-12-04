package com.ores.salvato.interfaces.model;

// IAnyRepository extends CrudRepository<T, Long>
public interface IAnyRecord<T> extends ICrud<T>, ILs<T> {

}
