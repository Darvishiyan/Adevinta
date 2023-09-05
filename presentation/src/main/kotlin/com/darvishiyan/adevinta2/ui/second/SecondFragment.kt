package com.darvishiyan.adevinta2.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.darvishiyan.adevinta2.databinding.FragmentSecondBinding
import com.darvishiyan.adevinta2.util.ImageSize
import com.darvishiyan.adevinta2.util.normalizeMobileImageUrl
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentSecondBinding.inflate(inflater, container, false).apply { _binding = this }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = args.uri.normalizeMobileImageUrl(imageSize = ImageSize.LARGE)
        Picasso.get().load(url).into(binding.myImg)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
