package com.zeligstoreoficial.ZeligStoreOficial.Repositories;

import com.zeligstoreoficial.ZeligStoreOficial.Entities.zapatosEntitie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface zapatosInterface extends CrudRepository<zapatosEntitie, Integer> {

    @Query(value = "{call sp_s_Zapatos(:pMarca)}", nativeQuery = true)
    List<zapatosEntitie> sp_s_Shoes(@Param("pMarca") String p_Marca);

    @Query(value = "{call sp_s_ZapatosCategoria(:pCategoria,:pMarca)}", nativeQuery = true)
    List<zapatosEntitie> sp_s_ShoesByCategory(@Param("pCategoria") String p_Categoria,@Param("pMarca") String p_Marca);

    @Query(value = "{call sp_i_Zapatos(:pTalla,:pColor,:pPrecio,:pUrl,:pIdCategoria,:pIdModelo,:pIdEstilo)}",nativeQuery = true)
    Integer sp_i_Zapatos(
            @Param("pTalla") Double p_Talla,
            @Param("pColor") String p_Color,
            @Param("pPrecio") Double p_Precio,
            @Param("pUrl") String p_Url,
            @Param("pIdCategoria") Integer p_IdCategoria,
            @Param("pIdModelo") Integer p_IdModelo,
            @Param("pIdEstilo") Integer p_IdEstilo
    );
}
