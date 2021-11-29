package com.zeligstoreoficial.ZeligStoreOficial.Repositories;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.estilosEntitie;
import com.zeligstoreoficial.ZeligStoreOficial.Entities.zapatosEntitie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface estilosInterface extends CrudRepository<estilosEntitie, Integer> {
    @Query(value = "Select * from estilos", nativeQuery = true)
    List<zapatosEntitie> sp_s_Shoes(@Param("pMarca") String p_Marca);
}
