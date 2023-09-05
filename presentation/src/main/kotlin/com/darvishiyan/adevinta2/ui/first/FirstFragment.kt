package com.darvishiyan.adevinta2.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.darvishiyan.adevinta2.databinding.FragmentFirstBinding
import com.darvishiyan.adevinta2.ui.first.state.FirstPageState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FirstViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = FragmentFirstBinding.inflate(inflater, container, false).apply { _binding = this }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FirstAdapter {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(it))
        }

        lifecycleScope.launch {
            viewModel.fetchState.collect {
                when (it) {
                    is FirstPageState.Success -> adapter.submitList(it.value)
                    is FirstPageState.Error -> Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show().run { it.error?.printStackTrace() }
                    FirstPageState.Noting -> {}
                }
            }
        }

        viewModel.fetchImages()
        binding.motorListView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
