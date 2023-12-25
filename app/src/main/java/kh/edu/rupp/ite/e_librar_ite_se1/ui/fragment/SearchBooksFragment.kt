package kh.edu.rupp.ite.e_librar_ite_se1.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kh.edu.rupp.ite.e_librar_ite_se1.databinding.FragmentSearchBooksBinding
import kh.edu.rupp.ite.e_librar_ite_se1.viewmodel.MainViewModel


class SearchBooksFragment : Fragment() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBooksBinding.inflate(inflater)
        return binding.root
    }


}