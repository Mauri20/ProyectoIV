package com.claseoct.zeligstore.APISpring

import com.claseoct.zeligstore.Models.EstiloClass
import com.claseoct.zeligstore.Models.MarcaClass
import com.claseoct.zeligstore.Models.ZapatosClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ZapatosAPI {

    @GET("Zapatos/showAllZapatos")
    suspend fun showAllShoes(): Response<List<ZapatosClass>>

    //Funcion para cargar los zapatos por categoria
    @GET
    suspend fun showAllShoes2(@Url url:String): Response<List<ZapatosClass>>

    //Funcion para traer los estilos de los zapatos
    @GET
    suspend fun showStyles():Response<List<EstiloClass>>

    @GET
    suspend fun showMarcas():Response<List<MarcaClass>>
}