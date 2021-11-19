package com.zeligstoreoficial.ZeligStoreOficial.Controllers;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.usuariosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Entities.zapatosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.zapatosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Zapatos")
public class zapatosController {

    @Autowired
    private zapatosInterface zapatosRepository;

    @GetMapping("/showAllZapatos")
    public ResponseEntity<List<zapatosEntitie>> sp_LoginAPP(){
        List<zapatosEntitie> zapatoslist = zapatosRepository.sp_s_Shoes();
        return new ResponseEntity(zapatoslist, HttpStatus.OK);
    }
}
