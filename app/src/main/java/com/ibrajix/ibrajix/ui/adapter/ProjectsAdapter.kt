/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrajix.ibrajix.databinding.RcvLytProjectsBinding
import com.ibrajix.ibrajix.model.Projects

class ProjectsAdapter(private val onClickListener: OnProjectsItemClickListener) : ListAdapter<Projects, ProjectsAdapter.ProjectsViewHolder>(
    ProjectsDiffCallback
) {

    class ProjectsViewHolder private constructor(private val binding: RcvLytProjectsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Projects){

            binding.txtProjectName.text = item.name
            binding.txtProjectDescription.text = item.description
            binding.txtUrl.text = item.url
            item.image?.let { binding.imgProject.setImageResource(it) }
        }

        companion object{
            fun from(parent: ViewGroup) : ProjectsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RcvLytProjectsBinding.inflate(layoutInflater, parent, false)
                return ProjectsViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        return ProjectsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {

        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }


        holder.itemView.setOnClickListener {
            if (item != null) {
                //handle clicks
                onClickListener.onClickNews(item)
            }
        }
    }

    object ProjectsDiffCallback : DiffUtil.ItemCallback<Projects>() {

        override fun areItemsTheSame(oldItem: Projects, newItem: Projects): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Projects, newItem: Projects): Boolean {
            return oldItem == newItem
        }

    }

    class OnProjectsItemClickListener(val clickListener: (projects: Projects) -> Unit){
        fun onClickNews(projects: Projects) = clickListener(projects)
    }

}