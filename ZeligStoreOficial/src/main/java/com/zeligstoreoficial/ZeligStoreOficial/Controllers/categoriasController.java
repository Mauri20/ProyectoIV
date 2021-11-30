package com.zeligstoreoficial.ZeligStoreOficial.Controllers;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.categoriasEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Entities.estilosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.categoriasInterface;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.estilosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("Categorias")
public class categoriasController {
    @Autowired
    private categoriasInterface categoRepository;
    //=========== Funcion para traer los estilos ==========
    @GetMapping("/All")
    public List<categoriasEntitie> AllStylesInBD(){
        return(List<categoriasEntitie>) categoRepository.findAll();
    }
}
