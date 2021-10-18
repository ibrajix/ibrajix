/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ibrajix.ibrajix.R
import com.ibrajix.ibrajix.databinding.FragmentProjectsBinding
import com.ibrajix.ibrajix.ui.adapter.ProjectsAdapter
import com.ibrajix.ibrajix.utils.viewBinding
import com.ibrajix.ibrajix.viewModel.MeViewModel

class ProjectsFragment : Fragment() {

    private val binding by viewBinding(FragmentProjectsBinding::bind)

    lateinit var projectsAdapter: ProjectsAdapter

    private val meViewModel by viewModels<MeViewModel> {
        MeViewModel.MeListViewModelFactory(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        setUpAdapter()
        observeData()
        handleClicks()
    }

    private fun handleClicks(){
        //
    }

    private fun setUpAdapter(){
        projectsAdapter = ProjectsAdapter(onClickListener = ProjectsAdapter.OnProjectsItemClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.url))
            startActivity(intent)
        })
        binding.rcvProjects.adapter = projectsAdapter
    }

    private fun observeData(){

        meViewModel.projectsLiveData.observe(viewLifecycleOwner){
            projectsAdapter.submitList(it)
        }

    }

}