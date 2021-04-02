package com.ninjati.devops.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Producto")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductoMO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    @NotEmpty
    public String Descripcion;
    @NotNull
    public Double Precio;
    @NotNull
    public Integer Cantidad;

    /*public ProductoMO() {
    }*/
}
