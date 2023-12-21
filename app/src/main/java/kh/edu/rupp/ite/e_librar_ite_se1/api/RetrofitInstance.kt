package kh.edu.rupp.ite.e_librar_ite_se1.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kh.edu.rupp.ite.e_librar_ite_se1.model.BookDataObject
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item
import kh.edu.rupp.ite.e_librar_ite_se1.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



// Create Retrofit Instance object (skeleton)
class RetrofitInstance {
    companion object {
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        private val retrofit =
            Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(Constants.BASE_URL)
                .build()
        }

        object BookApi{
            val api : BooksAPI by lazy {
                retrofit.create(BooksAPI::class.java)
            }
        }

}