package com.hibernate.Ferreteria.mapper;

import com.hibernate.Ferreteria.DTOs.ArticuloDTO;
import com.hibernate.Ferreteria.Entity.Articulos;

public class ArticuloMapper {
    public static ArticuloDTO toDTO(Articulos articulos){
        return  new ArticuloDTO(
                articulos.getId(),
                articulos.getNombrearticulo(),
                articulos.getPrecio(),
                articulos.getStock()
        );
    }
 public static Articulos toEntity(ArticuloDTO dto){
       Articulos articulos=new Articulos();

       articulos.setId(dto.getId());
       articulos.setNombrearticulo(dto.getNombrearticulo());
       articulos.setPrecio(dto.getPrecio());
       articulos.setStock(dto.getStock());
       return articulos;
 }
}
