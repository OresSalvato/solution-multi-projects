package com.ores.salvato.interfaces.model;

import java.util.UUID;

public class AnyRecord extends AnyRecordType {
  public AnyRecord(){
    super.setId(UUID.randomUUID().toString());
  }
}
