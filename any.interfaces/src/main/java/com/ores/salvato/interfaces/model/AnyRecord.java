package com.ores.salvato.interfaces.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class AnyRecord{

    public static final String INVALID_ID = "-1";
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id = INVALID_ID;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    public String name;
}
