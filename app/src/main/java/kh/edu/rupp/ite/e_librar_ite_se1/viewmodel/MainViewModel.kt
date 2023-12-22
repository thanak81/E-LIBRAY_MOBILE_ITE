package kh.edu.rupp.ite.e_librar_ite_se1.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.edu.rupp.ite.e_librar_ite_se1.api.RetrofitInstance
import kh.edu.rupp.ite.e_librar_ite_se1.model.BookDataObject
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item

import kotlinx.coroutines.launch


enum class BookApiStatus {LOADING,DONE,ERROR}
class MainViewModel() :ViewModel() {

    private val _myResponse : MutableLiveData<BookApiStatus> = MutableLiveData()
    val myResponse : LiveData<BookApiStatus>
        get() = _myResponse;

    private val _book : MutableLiveData<Item> = MutableLiveData();
     val book : LiveData<Item> get() = _book

    private val _books : MutableLiveData<BookDataObject> = MutableLiveData();
    val books : LiveData<BookDataObject> get() = _books

    fun getBookList(){
        viewModelScope.launch {
            _myResponse.value = BookApiStatus.LOADING
            try {
                Log.d("MainViewModel","${BookApiStatus.DONE}")
                _books.value = RetrofitInstance.BookApi.api.getBook();
                _myResponse.value = BookApiStatus.DONE
            }catch (e: java.lang.Exception){
                e.printStackTrace()
                _myResponse.value = BookApiStatus.ERROR
//                _books.value = ;
                Log.e("MainViewModel","${e.message}")
            }
        }
    }

    fun onBookItemClicked(book: Item){
        _book.value = book
    }
}