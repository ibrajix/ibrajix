/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrajix.ibrajix.databinding.RcvLytExperienceBinding
import com.ibrajix.ibrajix.model.Experience


class ExperienceAdapter : ListAdapter<Experience, ExperienceAdapter.ExperienceViewHolder>(
    ExperienceDiffCallback
) {
    class ExperienceViewHolder private constructor(private val binding: RcvLytExperienceBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Experience){
            binding.txtCompanyName.text = item.companyName
            binding.txtDuration.text = item.duration
            binding.txtRole.text = item.role
            binding.txtRoleDesc.text = item.roleDescription
        }

        companion object{
            fun from(parent: ViewGroup) : ExperienceViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RcvLytExperienceBinding.inflate(layoutInflater, parent, false)
                return ExperienceViewHolder(binding)
            }
        }

    }

    object ExperienceDiffCallback : DiffUtil.ItemCallback<Experience>() {

        override fun areItemsTheSame(oldItem: Experience, newItem: Experience): Boolean {
            return oldItem.companyName == newItem.companyName
        }

        override fun areContentsTheSame(oldItem: Experience, newItem: Experience): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        return ExperienceViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

}