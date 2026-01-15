package com.hibernate.Ferreteria.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="articulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "nombrearticulo")
    private String nombrearticulo;

    @Column(name = "precio")
    private double precio;

    @Column(name = "stock")
    private Integer stock;

    @Override
    public String toString (){
        return "articulo {"+
         "id = "+ Id +
                ",Nombre :'"+nombrearticulo+'\''+
                ",precio: "+precio+
                ",stock: "+stock+
                '}';
    }
}
