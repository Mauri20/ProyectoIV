package com.claseoct.zeligstore.APISpring

import com.claseoct.zeligstore.Models.ZapatosClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ZapatosAPI {

    @GET("Zapatos/showAllZapatos")
    suspend fun showAllShoes(): Response<List<ZapatosClass>>
}