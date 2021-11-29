package com.claseoct.zeligstore.APISpring

import com.claseoct.zeligstore.Models.UsersClass
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsersAPI {

    @POST("Usuarios/newRegisterUser")
    suspend fun nuevoRegistro(@Body user:UsersClass)

    @GET("Usuarios/checkUser/{user}/{pass}")
    suspend fun loginUser(@Path("user") user:String, @Path("pass") pass:String):Response<Boolean>

    @GET("Usuarios/checkUserIfExists/{user}")
    suspend fun verifyUser(@Path("user") user: String):Response<Boolean>

    @GET("Usuarios/returnTypeAccess/{user}/{pass}")
    suspend fun returnTypeUser(@Path("user") user:String, @Path("pass") pass:String):Response<List<UsersClass>>
}