package kh.edu.rupp.ite.e_librar_ite_se1.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kh.edu.rupp.ite.e_librar_ite_se1.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



// Create Retrofit Instance object (skeleton)
object RetrofitInstance {

        private val moshi by lazy {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }
        private val retrofit by lazy {
            Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(Constants.BASE_URL)
                .build()
        }

        val api : BooksAPI by lazy {
            retrofit.create(BooksAPI::class.java)
        }

}