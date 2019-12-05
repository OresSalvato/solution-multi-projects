package com.ores.salvato.interfaces.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public abstract class AnyRecord extends AbstractId {

    @Getter
    @Setter
    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    public String name;
}
