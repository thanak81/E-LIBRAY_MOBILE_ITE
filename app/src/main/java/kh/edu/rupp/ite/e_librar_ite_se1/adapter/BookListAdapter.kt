package kh.edu.rupp.ite.e_librar_ite_se1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kh.edu.rupp.ite.e_librar_ite_se1.databinding.HomeListItemsBinding
import kh.edu.rupp.ite.e_librar_ite_se1.model.Amphibian
import kh.edu.rupp.ite.e_librar_ite_se1.model.BookDataObject
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item
import kh.edu.rupp.ite.e_librar_ite_se1.model.VolumeInfo

class BookListAdapter: ListAdapter<
        Amphibian,BookListAdapter.BookViewHolder>(DiffCallback) {

    inner class BookViewHolder(var binding: HomeListItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item : Amphibian){
            binding.book = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layout = HomeListItemsBinding.inflate(LayoutInflater.from(parent.context))

        return BookViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = getItem(position)
        holder.onBind(book)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Amphibian>(){
        override fun areItemsTheSame(oldItem: Amphibian, newItem:Amphibian): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem:Amphibian, newItem: Amphibian): Boolean {
//            return oldItem == newItem
            return oldItem.type == newItem.type && oldItem.description == newItem.description
        }


    }
}