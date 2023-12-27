package kh.edu.rupp.ite.e_librar_ite_se1.ui.fragment

import android.app.SearchManager.OnCancelListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.room.util.query
import kh.edu.rupp.ite.e_librar_ite_se1.R
import kh.edu.rupp.ite.e_librar_ite_se1.adapter.BookListAdapter
import kh.edu.rupp.ite.e_librar_ite_se1.adapter.BookListener
import kh.edu.rupp.ite.e_librar_ite_se1.databinding.FragmentFavoriteBinding
import kh.edu.rupp.ite.e_librar_ite_se1.databinding.FragmentHomeBinding
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item
import kh.edu.rupp.ite.e_librar_ite_se1.viewmodel.MainViewModel

class HomeFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(queryText: String?): Boolean {
                if(queryText != null){
                    viewModel.getBookList(queryText)
                }
                binding.searchView.clearFocus();
                return true;
            }

            override fun onQueryTextChange(queryText: String?): Boolean {
                if (queryText != null) {
                    viewModel.getBookList(queryText)
                }
                return true
            }
        })

        viewModel.defaultBookDisplay();

//        binding.recyclerView.adapter = BookListAdapter(BookListener { bookItem ->
//            viewModel.onBookItemClicked(bookItem)
//            findNavController()
//                .navigate(R.id.action_homeFragment_to_bookDetailFragment)
//        })

        binding.recyclerView.adapter = BookListAdapter(BookListener{
            viewModel.onBookItemClicked(book= it)
            findNavController()
                .navigate(R.id.action_homeFragment_to_bookDetailFragment)
        })

        return binding.root
    }



}