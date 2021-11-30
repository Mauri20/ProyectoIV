package com.claseoct.zeligstore.APISpring

import com.claseoct.zeligstore.Models.CategoriaClass
import com.claseoct.zeligstore.Models.EstiloClass
import com.claseoct.zeligstore.Models.MarcaClass
import com.claseoct.zeligstore.Models.ZapatosClass
import com.claseoct.zeligstore.RequestClass.ZapatoRequest
import retrofit2.Response
import retrofit2.http.*

interface ZapatosAPI {

    @GET("Zapatos/showAllZapatos")
    suspend fun showAllShoes(): Response<List<ZapatosClass>>

    //Funcion para cargar los zapatos por categoria
    @GET
    suspend fun showAllShoes2(@Url url:String): Response<List<ZapatosClass>>

    //Funcion para traer los estilos de los zapatos
    @GET("Estilos/All")
    suspend fun showStyles():Response<List<EstiloClass>>

    @GET("Marcas/All")
    suspend fun showMarcas():Response<List<MarcaClass>>
    @GET("Categorias/All")
    suspend fun showCategorias():Response<List<CategoriaClass>>

    @POST("Zapatos/saveZapato")
    suspend fun saveZapato(@Body zapatoRequest: ZapatoRequest):Response<Boolean>

}