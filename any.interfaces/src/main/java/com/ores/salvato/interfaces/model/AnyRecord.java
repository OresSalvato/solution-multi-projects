package com.ores.salvato.interfaces.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

//@Data
//@EqualsAndHashCode(callSuper = true)
public class AnyRecord extends AnyRecordType {
  public AnyRecord(){
    super.setId(UUID.randomUUID().toString());
  }
}
