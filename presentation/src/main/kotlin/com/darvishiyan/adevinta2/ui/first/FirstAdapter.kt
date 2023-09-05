package com.darvishiyan.adevinta2.ui.first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.darvishiyan.adevinta2.databinding.ItemFragmentFirstBinding
import com.darvishiyan.adevinta2.util.ImageSize
import com.darvishiyan.adevinta2.util.normalizeMobileImageUrl
import com.darvishiyan.entity.remote.MotorImage
import com.squareup.picasso.Picasso

class FirstAdapter(private val action: (String) -> Unit) : ListAdapter<MotorImage, FirstAdapter.ViewHolder>(
    DiffCallback
) {

    class ViewHolder(val binding: ItemFragmentFirstBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFragmentFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        val url = data.uri.normalizeMobileImageUrl(imageSize = ImageSize.SMALL)
        Picasso.get().load(url).into(holder.binding.motorImg)
        holder.binding.root.setOnClickListener { action(data.uri) }
    }
}
