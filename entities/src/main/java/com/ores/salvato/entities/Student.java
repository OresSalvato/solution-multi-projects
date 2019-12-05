package com.ores.salvato.entities;

import com.ores.salvato.interfaces.model.AnyRecord;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name=Student.TABLE_NAME)
public class Student extends AnyRecord implements Serializable {
    public static final String TABLE_NAME= "student_data";

    @Column(name="regnum" , unique = true)
    private String registrationNumber;

    @Column(name="age")
    private int age;
}