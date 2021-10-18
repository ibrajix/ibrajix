/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrajix.ibrajix.R
import com.ibrajix.ibrajix.databinding.RcvLytMeBinding
import com.ibrajix.ibrajix.model.Me


class MeAdapter : ListAdapter<Me, MeAdapter.MeViewHolder> (MeDiffCallback) {

    class MeViewHolder private constructor(private val binding: RcvLytMeBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Me){

            when(item.type){
                "About" -> binding.button.setBackgroundResource(R.drawable.btn_tag_round_green)
                "Skills" -> binding.button.setBackgroundResource(R.drawable.btn_tag_round_yellow)
                "Languages" -> binding.button.setBackgroundResource(R.drawable.btn_tag_round_purple)
                "Technologies" -> binding.button.setBackgroundResource(R.drawable.btn_tag_round_light_blue)
            }

            binding.button.text = item.type
            binding.txtContent.text = item.content
        }

        companion object{
            fun from(parent: ViewGroup) : MeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RcvLytMeBinding.inflate(layoutInflater, parent, false)
                return MeViewHolder(binding)
            }
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeViewHolder {
        return MeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MeViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
        holder.itemView.setOnClickListener {
            if (item != null) {
                //handle clicks
                /*onClickListener.onClickNews(item)*/
            }
        }
    }


    object MeDiffCallback : DiffUtil.ItemCallback<Me>() {

        override fun areItemsTheSame(oldItem: Me, newItem: Me): Boolean {
            return oldItem.type == newItem.type
        }

        override fun areContentsTheSame(oldItem: Me, newItem: Me): Boolean {
            return oldItem == newItem
        }

    }

}