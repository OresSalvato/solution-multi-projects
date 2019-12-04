package com.ores.salvato.entities;
import com.ores.salvato.interfaces.model.AnyRecordType;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role")
public class Role extends AnyRecordType {

  /**
   * Role: get name
   * */
  @Override
  public String getName(){
    return super.getName();
  }

  /**
   * Role: set new name
   * */
  @Override
  public void setName(String roleName){
    super.setName(roleName);
  }
}