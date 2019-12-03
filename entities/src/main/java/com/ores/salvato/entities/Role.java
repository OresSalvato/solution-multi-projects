package com.ores.salvato.entities;
import com.ores.salvato.interfaces.model.AnyRecord;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role")
public class Role extends AnyRecord {

  @Column(name = "role")
  private String role;
}