package com.zeligstoreoficial.ZeligStoreOficial.Repositories;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.zapatosEntitie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface zapatosInterface extends CrudRepository<zapatosEntitie, Integer> {

    @Query(value = "{call sp_s_Zapatos(:pMarca)}", nativeQuery = true)
    List<zapatosEntitie> sp_s_Shoes(@Param("pMarca") String p_Marca);

    @Query(value = "{call sp_s_ZapatosCategoria(:pCategoria,:pMarca)}", nativeQuery = true)
    List<zapatosEntitie> sp_s_ShoesByCategory(@Param("pCategoria") String p_Categoria,@Param("pMarca") String p_Marca);

    @Transactional
    @Modifying
    @Query(value = "{call sp_i_Zapatos(:pModelo,:pTalla,:pColor,:pPrecio,:pUrl,:pIdCategoria,:pIdMarca,:pIdEstilo)}",nativeQuery = true)
    int sp_i_Zapatos(
            @Param("pModelo") String p_Modelo,
            @Param("pTalla") double p_Talla,
            @Param("pColor") String p_Color,
            @Param("pPrecio") double p_Precio,
            @Param("pUrl") String p_Url,
            @Param("pIdCategoria") int p_IdCategoria,
            @Param("pIdMarca") int p_IdModelo,
            @Param("pIdEstilo") int p_IdEstilo
    );

}
