package kh.edu.rupp.ite.e_librar_ite_se1.api

import kh.edu.rupp.ite.e_librar_ite_se1.model.Amphibian
import kh.edu.rupp.ite.e_librar_ite_se1.model.BookDataObject
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item
import kh.edu.rupp.ite.e_librar_ite_se1.model.VolumeInfo
import kh.edu.rupp.ite.e_librar_ite_se1.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksAPI{
//    @GET("books/v1/volumes")
    @GET("android-basics-kotlin-unit-4-pathway-2-project-api.json")
    suspend fun getBook(
//        @Query("q")
//        searchQuery : String = "react",
//        @Query("key")
//        apiKey: String = Constants.API_KEY
    ) : List<Amphibian>
}