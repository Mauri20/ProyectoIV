package com.zeligstoreoficial.ZeligStoreOficial.Controllers;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.usuariosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Repositories.usuariosInterface;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /*
    @GetMapping("/checkUser/{user}/{pass}")
    public ResponseEntity<List<usuariosEntitie>> sp_LoginAPP(@PathVariable("user") String user, @PathVariable("pass") String pass){
        List<usuariosEntitie> userLoger = userRepository.sp_LoginAPP(user, pass);
        return new ResponseEntity(userLoger, HttpStatus.OK);
    }*/

    @GetMapping("/checkUser/{user}/{pass}")
    public boolean sp_LoginAPP(@PathVariable("user") String user, @PathVariable("pass") String pass){
        boolean validar = false;
        List<usuariosEntitie> userLoger = userRepository.sp_LoginAPP(user, pass);
        if(!userLoger.isEmpty()){
            System.out.println("=> User has been found succesfully!");
            return validar = true;
        }
        else{
            System.out.println("=> User has not been found :(");
            return validar;
        }
    }
}
