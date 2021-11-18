package com.zeligstoreoficial.ZeligStoreOficial.Repositories;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.usuariosEntitie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface usuariosInterface extends CrudRepository<usuariosEntitie, Integer> {

    @Query(value = "{call sp_LoginApp(:PUsuario, :PPassword)}", nativeQuery = true)
    List<usuariosEntitie> sp_LoginAPP(@Param("PUsuario") String P_Usuario, @Param("PPassword") String P_Password);

    @Query(value = "{call sp_s_usuario(:pUsuario)}", nativeQuery = true)
    List<usuariosEntitie> sp_s_Usuario(@Param("pUsuario") String p_Usuario);
}
