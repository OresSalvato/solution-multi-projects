package com.ores.salvato.interfaces.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractId {
  public static final String INVALID_ID = "-1";

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true)
  @Getter
  @Setter(AccessLevel.PROTECTED)
  private String id = INVALID_ID;

  // Constructor
  protected AbstractId(String id) {
    this.setId(id);
  }

  // Constructor
  protected AbstractId() {
    {
      this.setId(UUID.randomUUID().toString());
    }
  }
}
