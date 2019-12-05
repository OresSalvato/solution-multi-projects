package com.ores.salvato.entities;

import com.ores.salvato.interfaces.model.AnyRecord;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = Role.TABLE_NAME)
public class Role extends AnyRecord implements Serializable {
  public static final String TABLE_NAME= "role_data";

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