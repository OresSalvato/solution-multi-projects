package com.ores.salvato.entities;
import com.ores.salvato.interfaces.model.AnyRecord;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="students", schema = "students.db")
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Student extends AnyRecord {

    public void setId(){
        super.setId(UUID.randomUUID().toString());
    }

    @Column(name="regnum" , unique = true)
    private String registrationNumber;

    @Column(name="age")
    private int age;

}