package com.darvishiyan.adevinta2.ui.first

import androidx.recyclerview.widget.DiffUtil
import com.darvishiyan.entity.remote.MotorImage

object DiffCallback : DiffUtil.ItemCallback<MotorImage>() {
    override fun areItemsTheSame(oldItem: MotorImage, newItem: MotorImage) = oldItem.set == newItem.set

    override fun areContentsTheSame(oldItem: MotorImage, newItem: MotorImage) = oldItem == newItem
}
