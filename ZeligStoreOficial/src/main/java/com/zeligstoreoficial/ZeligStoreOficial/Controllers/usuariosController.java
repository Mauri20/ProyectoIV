package com.zeligstoreoficial.ZeligStoreOficial.Controllers;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.usuariosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.usuariosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Usuarios")
public class usuariosController {

    @Autowired
    private usuariosInterface userRepository;

    //=========== Funcion para Mostrar Todos los Usuario ==========
    @GetMapping("/homeUsers")
    public List<usuariosEntitie> AllUsersInBD(){
        return(List<usuariosEntitie>) userRepository.findAll();
    }

    //=========== Funcion Registrar Nuevo Usuario ==========
    @PostMapping("/newRegisterUser")
    @ResponseBody
    public usuariosEntitie newRegisterUser(@RequestBody usuariosEntitie newUser){
        userRepository.save(newUser);
        return newUser;
    }
}
