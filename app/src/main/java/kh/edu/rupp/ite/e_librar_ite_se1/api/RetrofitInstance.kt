package kh.edu.rupp.ite.e_librar_ite_se1.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item
import kh.edu.rupp.ite.e_librar_ite_se1.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Create Retrofit Instance object (skeleton)
class RetrofitInstance {
    companion object {
        private val gson = GsonBuilder()
            .create()
        private val retrofit =
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        object BookApi{
            val api : BooksAPI by lazy {
                retrofit.create(BooksAPI::class.java)
            }
        }

}