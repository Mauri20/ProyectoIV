package com.zeligstoreoficial.ZeligStoreOficial.Controllers;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.usuariosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Entities.*;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.zapatosInterface;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Zapatos")
public class zapatosController {

    private List<zapatosEntitie> codificarImagen(List<zapatosEntitie> lista){
        List<zapatosEntitie> newLista=new ArrayList<zapatosEntitie>();
        for(int i=0; i<lista.size();i++){
            zapatosEntitie zapato=lista.get(i);
            Path ruta= Paths.get(zapato.getUrl());
            try {
                String imagenCodificada= Base64.encodeBase64URLSafeString(Files.readAllBytes(ruta));
                zapato.setUrl(imagenCodificada);
            }catch (IOException e) {
                e.printStackTrace();
            }
            newLista.add(zapato);
        }
        return newLista;
    }

    @Autowired
    private zapatosInterface zapatosRepository;

    @GetMapping("/showAllZapatos/{marca}")
    public ResponseEntity<List<zapatosEntitie>> sp_showShoes(@PathVariable("marca") String marca){
        List<zapatosEntitie> zapatoslist = zapatosRepository.sp_s_Shoes(marca);

        List<zapatosEntitie> newLista=codificarImagen(zapatoslist);

        return new ResponseEntity(newLista, HttpStatus.OK);
    }

    @GetMapping("/showAllZapatosByCategory/{categoria}/{marca}")
    public ResponseEntity<List<zapatosEntitie>> sp_showShoesbyCategory(@PathVariable("categoria") String categoria,@PathVariable("marca") String marca){
        List<zapatosEntitie> zapatoslist = zapatosRepository.sp_s_ShoesByCategory(categoria,marca);

        List<zapatosEntitie> listaByCategoria=codificarImagen(zapatoslist);

        return new ResponseEntity(listaByCategoria, HttpStatus.OK);
    }
    @PostMapping("/saveZapato/{talla}/{color}/{precio}/{url}/{idCategoria}/{idModelo}/{idEstilo}")
    public ResponseEntity<?> sp_guardarZapato(
            @PathVariable("talla")Double talla,
            @PathVariable("color")String color,
            @PathVariable("precio")Double precio,
            @PathVariable("url")String url,
            @PathVariable("idCategoria")Integer idCategoria,
            @PathVariable("idModelo")Integer idModelo,
            @PathVariable("idEstilo")Integer idEstilo
    ){
        try {
            Integer result=zapatosRepository.sp_i_Zapatos(talla,color,precio,url,idCategoria,idModelo,idEstilo);
            return new ResponseEntity("He devuelto"+result,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity("Hay una Excepcion pero siempre registra.",HttpStatus.CREATED);
        }

    }

}
