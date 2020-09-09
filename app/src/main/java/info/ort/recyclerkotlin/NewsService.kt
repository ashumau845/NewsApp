package info.ort.recyclerkotlin

import info.ort.recyclerkotlin.Model.NewsClass
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY
const val BASE_URL="http://newsapi.org/";
const val API_KEY="cf6f9003031248d1b7522c8bd3cfcb43";
interface NewsInterface{

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country:String,@Query("page")page:Int): Call<NewsClass>;


    object NewsService{
        val newsinstance:NewsInterface
        init {
            val retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            newsinstance=retrofit.create(NewsInterface::class.java)
        }
    }
}