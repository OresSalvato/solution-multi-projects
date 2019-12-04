package com.ores.salvato.interfaces.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data()
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class AnyRecord extends AbstractId {

    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    public String name;
}
