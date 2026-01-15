package com.hibernate.Ferreteria.Controladores;


import com.hibernate.Ferreteria.DTOs.ArticuloDTO;

import com.hibernate.Ferreteria.Servicios.ArticuloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
    @Autowired
    private ArticuloService servicio;

    @GetMapping
    public List<ArticuloDTO> listar(){
        return servicio.serv_Consulta();
    }
    @GetMapping("/{id}")
    public ArticuloDTO buscaId(@PathVariable Long id){
        return servicio.serv_buscaId(id);
    }
    @PostMapping
    public ArticuloDTO insertarArticulo(@RequestBody ArticuloDTO dto){
        return servicio.serv_Inserta(dto);
    }

   @PutMapping("/{id}")
   public ArticuloDTO actualizarArticulo(@PathVariable Long id ,
                                         @RequestBody ArticuloDTO dto){
        return servicio.serv_Actualiza(id,dto);
   }
   @DeleteMapping("/{id}")

    public String borraArticulos(@PathVariable Long id ){
        return servicio.eliminArticulo(id);
   }

}
