package kh.edu.rupp.ite.e_librar_ite_se1

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kh.edu.rupp.ite.e_librar_ite_se1.adapter.BookListAdapter
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item
import kh.edu.rupp.ite.e_librar_ite_se1.viewmodel.BookApiStatus

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl : String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri)
    }
}

@BindingAdapter("listData")
    fun bindRecycleView(recyclerView: RecyclerView, data : List<Item>?){
        val adapter = recyclerView.adapter as BookListAdapter
        adapter.submitList(data)
}

@BindingAdapter("bookApiStatus")
fun bindStatus(statusImageView: ImageView , status: BookApiStatus){
    when(status){
        BookApiStatus.LOADING->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        BookApiStatus.DONE->{
            statusImageView.visibility = View.GONE
        }
        BookApiStatus.ERROR->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}