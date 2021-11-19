package com.zeligstoreoficial.ZeligStoreOficial.Controllers;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.usuariosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Entities.zapatosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.zapatosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Zapatos")
public class zapatosController {

    @Autowired
    private zapatosInterface zapatosRepository;

    @GetMapping("/showAllZapatos/{marca}")
    public ResponseEntity<List<zapatosEntitie>> sp_showShoes(@PathVariable("marca") String marca){
        List<zapatosEntitie> zapatoslist = zapatosRepository.sp_s_Shoes(marca);
        return new ResponseEntity(zapatoslist, HttpStatus.OK);
    }

    @GetMapping("/showAllZapatosByCategory/{categoria}/{marca}")
    public ResponseEntity<List<zapatosEntitie>> sp_showShoesbyCategory(@PathVariable("categoria") String categoria,@PathVariable("marca") String marca){
        List<zapatosEntitie> zapatoslist = zapatosRepository.sp_s_ShoesByCategory(categoria,marca);
        return new ResponseEntity(zapatoslist, HttpStatus.OK);
    }
}
