package com.ores.salvato.interfaces.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

@EqualsAndHashCode
public abstract class AbstractId {
  public static final String INVALID_ID = "-1";

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
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
