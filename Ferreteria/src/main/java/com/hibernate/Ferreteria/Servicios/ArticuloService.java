package com.hibernate.Ferreteria.Servicios;

import com.hibernate.Ferreteria.DTOs.ArticuloDTO;
import com.hibernate.Ferreteria.Entity.Articulos;
import com.hibernate.Ferreteria.Repositorio.Repo_Articulos;
import com.hibernate.Ferreteria.mapper.ArticuloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticuloService {
    @Autowired
    private Repo_Articulos repo;

    public List<ArticuloDTO> serv_Consulta(){

        return  repo.findAll().stream().map(ArticuloMapper::toDTO)
                .collect(Collectors.toList());
    }
    public ArticuloDTO serv_Inserta(ArticuloDTO dto){
        Articulos articulos=ArticuloMapper.toEntity(dto);
        Articulos insetado=repo.save(articulos);
        return  ArticuloMapper.toDTO(insetado);
    }
    public ArticuloDTO serv_buscaId(Long id){
        Articulos articulosporId=repo.findById(id)
                .orElseThrow(()-> new RuntimeException(
                        "Articulo con id:"+ id + "no encontrado"));
        return ArticuloMapper.toDTO(articulosporId);
    }
    public ArticuloDTO serv_Actualiza(Long id,ArticuloDTO dto){
        Optional <Articulos> existe =repo.findById(id);
        if(existe.isPresent()){
            Articulos articulos = existe.get();

            articulos.setNombrearticulo(dto.getNombrearticulo());
            articulos.setPrecio(dto.getPrecio());
            articulos.setStock(dto.getStock());

            Articulos actualizado =repo.save(articulos);

            return  ArticuloMapper.toDTO(actualizado);
        }else{
            throw new RuntimeException("Articulo no encontrado con id: "+id);
        }


    }
    public String eliminArticulo(Long id){
        Optional<Articulos> existe =repo.findById(id);
        if(existe.isPresent()){

            repo.deleteById(id);
            return existe.toString() + '\''+" Articulo eliminado correctamente";
        }else {
            return "Articulo: "+id+ " no encontrado";
        }
    }



}
