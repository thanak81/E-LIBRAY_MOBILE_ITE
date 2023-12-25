package kh.edu.rupp.ite.e_librar_ite_se1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kh.edu.rupp.ite.e_librar_ite_se1.databinding.HomeListItemsBinding
import kh.edu.rupp.ite.e_librar_ite_se1.model.BookDataObject
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item
import kh.edu.rupp.ite.e_librar_ite_se1.viewmodel.MainViewModel


class BookListAdapter(val clickListener:BookListener): ListAdapter<
        Item,BookListAdapter.BookViewHolder>(DiffCallback){

    inner class BookViewHolder(var binding: HomeListItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(clickListener:BookListener,item : Item){
            binding.book = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layout = HomeListItemsBinding.inflate(LayoutInflater.from(parent.context))

        return BookViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = getItem(position)
        holder.onBind(clickListener,book)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem:  Item, newItem: Item): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areContentsTheSame(oldItem:Item, newItem:  Item): Boolean {
            return oldItem==newItem
        }


    }

}

class BookListener(val clickListener: (bookItem : Item)-> Unit){
    fun onClick(bookItem:Item) = clickListener(bookItem)
}