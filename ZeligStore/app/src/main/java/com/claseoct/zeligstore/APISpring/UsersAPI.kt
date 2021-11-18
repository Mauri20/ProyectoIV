package com.claseoct.zeligstore.APISpring

import com.claseoct.zeligstore.Models.UsersClass
import retrofit2.http.Body
import retrofit2.http.POST

interface UsersAPI {

    @POST("Usuarios/newRegisterUser")
    suspend fun nuevoRegistro(@Body user:UsersClass)
}