package kh.edu.rupp.ite.e_librar_ite_se1.ui.fragment

import android.database.Observable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kh.edu.rupp.ite.e_librar_ite_se1.databinding.FragmentBookDetailBinding
import kh.edu.rupp.ite.e_librar_ite_se1.model.BookDataObject
import kh.edu.rupp.ite.e_librar_ite_se1.model.Item
import kh.edu.rupp.ite.e_librar_ite_se1.viewmodel.MainViewModel


class BookDetailFragment : Fragment() {
    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookDetailBinding.inflate(inflater);

        binding.lifecycleOwner = viewLifecycleOwner
        binding.bookItem = viewModel



        return binding.root
    }

}