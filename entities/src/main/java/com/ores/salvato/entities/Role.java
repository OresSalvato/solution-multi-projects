package com.ores.salvato.entities;
import com.ores.salvato.interfaces.model.AnyRecordType;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role")
public class Role extends AnyRecordType  implements Serializable {

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