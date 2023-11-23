package tn.aquaguard.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import tn.aquaguard.models.Actualites
import tn.aquaguard.models.Avis

interface ActualiteService {

    @GET("/act")
    suspend fun getAll(): Response<List<Actualites>>

    @GET("/avis/{iduser}/{idactualite}")
    suspend fun getAvisByIds(
        @Path("iduser") iduser: String,
        @Path("idactualite") idactualite: String
    ): Response<Avis>
    @POST("/avis/addupdates")
    suspend fun addOrUpdateAvis(@Body request: Avis): Response<Unit>
    @POST("/avis")
    suspend fun addOnceAvis(@Body request: Avis): Response<Unit>

}