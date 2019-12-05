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
@Table(name=Product.TABLE_NAME)
public class Product extends AnyRecord implements Serializable {
    public static final String TABLE_NAME= "product_data";

    @Column(name="description")
    public String description;
}
