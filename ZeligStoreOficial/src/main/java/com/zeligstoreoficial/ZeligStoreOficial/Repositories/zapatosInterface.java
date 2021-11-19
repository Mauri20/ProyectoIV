package com.zeligstoreoficial.ZeligStoreOficial.Repositories;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.zapatosEntitie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface zapatosInterface extends CrudRepository<zapatosEntitie, Integer> {

    @Query(value = "{call sp_s_Zapatos()}", nativeQuery = true)
    List<zapatosEntitie> sp_s_Shoes();

    @Query(value = "{call sp_s_ZapatosCategoria(:pCategoria)}", nativeQuery = true)
    List<zapatosEntitie> sp_s_ShoesByCategory(@Param("pCategoria") String p_Categoria);
}
