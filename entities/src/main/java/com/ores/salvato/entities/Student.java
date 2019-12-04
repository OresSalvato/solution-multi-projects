package com.ores.salvato.entities;

import com.ores.salvato.interfaces.model.AnyRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="students", schema = "students.db")
@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends AnyRecord implements Serializable {

    @Column(name="regnum" , unique = true)
    private String registrationNumber;

    @Column(name="age")
    private int age;

}