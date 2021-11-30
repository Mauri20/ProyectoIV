package com.zeligstoreoficial.ZeligStoreOficial.Controllers;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.categoriasEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Entities.marcasEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.categoriasInterface;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.marcasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("Marcas")
public class marcasController {
    @Autowired
    private marcasInterface marcasRepository;
    //=========== Funcion para traer los estilos ==========
    @GetMapping("/All")
    public List<marcasEntitie> AllStylesInBD(){
        return(List<marcasEntitie>) marcasRepository.findAll();
    }
}
