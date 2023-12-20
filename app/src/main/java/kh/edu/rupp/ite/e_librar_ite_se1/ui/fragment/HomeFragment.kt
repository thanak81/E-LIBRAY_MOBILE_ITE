package kh.edu.rupp.ite.e_librar_ite_se1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kh.edu.rupp.ite.e_librar_ite_se1.R
import kh.edu.rupp.ite.e_librar_ite_se1.adapter.BookListAdapter
import kh.edu.rupp.ite.e_librar_ite_se1.databinding.FragmentHomeBinding
import kh.edu.rupp.ite.e_librar_ite_se1.viewmodel.MainViewModel

class HomeFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = BookListAdapter()

        viewModel.getBookList()
        return binding.root
    }

}