package id.idn.fahru.retrofitapp.retrofit

import id.idn.fahru.retrofitapp.retrofit.pojo.ResponseNews
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Imam Fahrur Rofi on 27/07/2020.
 */
interface RetrofitInterfaces {
    @GET("v2/top-headlines?country=id&apiKey=api_key_antum")
    suspend fun topHeadlines() : Response<ResponseNews>
}
