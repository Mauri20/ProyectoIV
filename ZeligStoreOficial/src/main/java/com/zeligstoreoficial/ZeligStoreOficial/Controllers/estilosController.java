package com.zeligstoreoficial.ZeligStoreOficial.Controllers;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.estilosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Entities.usuariosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.estilosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("Estilos")
public class estilosController {
    @Autowired
    private estilosInterface estiloRepository;
    //=========== Funcion para traer los estilos ==========
    @GetMapping("/All")
    public List<estilosEntitie> AllStylesInBD(){
        return(List<estilosEntitie>) estiloRepository.findAll();
    }
}
