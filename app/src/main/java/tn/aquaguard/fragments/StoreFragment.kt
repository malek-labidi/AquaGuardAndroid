package tn.aquaguard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import tn.aquaguard.R
import tn.aquaguard.adapters.ActualitesAdapter
import tn.aquaguard.adapters.StoreAdapter
import tn.aquaguard.databinding.FragmentHomeBinding
import tn.aquaguard.databinding.FragmentProductBinding
import tn.aquaguard.databinding.FragmentStoreBinding
import tn.aquaguard.viewmodel.ActualiteViewModel
import tn.aquaguard.viewmodel.StoreViewModel


class StoreFragment : Fragment() {
    private lateinit var binding: FragmentProductBinding
    private val viewModel: StoreViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProductBinding.inflate(layoutInflater)
        binding.rvproduct.layoutManager = LinearLayoutManager(requireContext())
        binding.rvproduct.adapter= StoreAdapter(emptyList(),viewModel)

        viewModel.products.observe(viewLifecycleOwner) {ActualiteList ->
            binding.rvproduct.adapter = StoreAdapter(ActualiteList,viewModel)
        }
        return binding.root
    }




}