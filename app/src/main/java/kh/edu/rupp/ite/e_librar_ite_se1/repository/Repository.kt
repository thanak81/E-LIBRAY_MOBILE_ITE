package kh.edu.rupp.ite.e_librar_ite_se1.repository

import kh.edu.rupp.ite.e_librar_ite_se1.api.RetrofitInstance.api
import kh.edu.rupp.ite.e_librar_ite_se1.model.BookDataObject


interface BookRepository{
    suspend fun getBooks(): BookDataObject
}
class Repository(private val query: String) : BookRepository{
        override suspend fun getBooks() : BookDataObject{
           return api.getBook(query)
        }
}

class Repository1: BookRepository{
    override suspend fun getBooks(): BookDataObject {
        return api.getBook("java")
    }

}