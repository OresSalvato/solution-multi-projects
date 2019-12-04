package com.ores.salvato.interfaces.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
//@Accessors(fluent = true, chain = true)
// Fluent : removes any get set prefix from properties
// Chain  : return it self
public abstract class AnyRecordType {

    public static final String INVALID_ID = "-1";

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Setter(AccessLevel.PROTECTED)
    private String id = INVALID_ID;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    public String name;
}
