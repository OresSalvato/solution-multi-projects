package com.ores.salvato.entities;
import com.ores.salvato.interfaces.model.AnyRecord;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AnyRecord {

  @Column(name = "email")
  @Email(message = "*Please provide a valid Email")
  @NotEmpty(message = "*Please provide an email")
  private String email;

  @Column(name = "password")
  @Size(min = 5, message = "*Your password must have at least 5 characters")
  @NotEmpty(message = "*Please provide your password")
  private String password;

  @Column(name = "last_name")
  @NotEmpty(message = "*Please provide your last name")
  private String lastName;

  @Column(name = "active")
  private int active;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

}