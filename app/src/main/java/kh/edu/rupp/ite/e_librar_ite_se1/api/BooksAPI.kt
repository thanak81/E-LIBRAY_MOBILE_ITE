package kh.edu.rupp.ite.e_librar_ite_se1.api

import kh.edu.rupp.ite.e_librar_ite_se1.model.BookDataObject
import kh.edu.rupp.ite.e_librar_ite_se1.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksAPI{
    @GET("volumes")
    suspend fun getBookList() :List<BookDataObject>
    @GET("volumes")
    suspend fun getBook(
        @Query(value = "q")
        searchQuery : String,
        @Query(value = "maxResults")
        maxResults : Int = 20,
        @Query(value ="key")
        apiKey: String = Constants.API_KEY
    ) :BookDataObject

    @GET("volumes")
    suspend fun searchBook(
        @Query(value = "q")  searchQuery: String?
    ) : BookDataObject
}