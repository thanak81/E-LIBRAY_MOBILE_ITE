package kh.edu.rupp.ite.e_librar_ite_se1.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.edu.rupp.ite.e_librar_ite_se1.api.RetrofitInstance
import kh.edu.rupp.ite.e_librar_ite_se1.model.BookDataObject
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item
import kh.edu.rupp.ite.e_librar_ite_se1.repository.Repository
import kh.edu.rupp.ite.e_librar_ite_se1.repository.Repository1

import kotlinx.coroutines.launch
import retrofit2.http.Query


enum class BookApiStatus {LOADING,DONE,ERROR}
class MainViewModel() :ViewModel() {
    private val _myResponse : MutableLiveData<BookApiStatus> = MutableLiveData()
    val myResponse : LiveData<BookApiStatus>
        get() = _myResponse;

    private val _book : MutableLiveData<Item> = MutableLiveData();
     val book : LiveData<Item> get() = _book

    private val _books : MutableLiveData<BookDataObject> = MutableLiveData();
    val books : LiveData<BookDataObject> get() = _books


    fun getBookList(query: String){
        viewModelScope.launch {
            _myResponse.value = BookApiStatus.LOADING
            try {
                _books.value  = Repository(query).getBooks() ;
                Log.d("MainViewModel","${_book.value}")
                _myResponse.value = BookApiStatus.DONE
            }catch (e: java.lang.Exception){
                e.printStackTrace()
                _myResponse.value = BookApiStatus.ERROR
//                _books.value = ;
                Log.e("MainViewModel","${e.message}")
            }
        }
    }
    fun defaultBookDisplay(){
        viewModelScope.launch {
            try {
                _myResponse.value = BookApiStatus.DONE
                _books.value = Repository1().getBooks();
            }catch (e : Exception){
                Log.e("MainViewModel","${e.message}")

            }
        }
    }


    fun onBookItemClicked(book: Item){
        _book.value = book
    }
}