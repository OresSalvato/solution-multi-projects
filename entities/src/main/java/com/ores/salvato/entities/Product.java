package com.ores.salvato.entities;
import com.ores.salvato.interfaces.model.AnyRecord;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="products", schema = "products.db")
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends AnyRecord {

    @Column(name="descr")
    public String description;
}
