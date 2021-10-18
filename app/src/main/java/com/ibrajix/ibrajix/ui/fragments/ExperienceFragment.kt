/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ibrajix.ibrajix.R
import com.ibrajix.ibrajix.databinding.FragmentExperienceBinding
import com.ibrajix.ibrajix.ui.adapter.ExperienceAdapter
import com.ibrajix.ibrajix.utils.viewBinding
import com.ibrajix.ibrajix.viewModel.MeViewModel

class ExperienceFragment : Fragment() {

    private val binding by viewBinding(FragmentExperienceBinding::bind)

    private val meViewModel by viewModels<MeViewModel> {
        MeViewModel.MeListViewModelFactory(requireContext())
    }

    lateinit var experienceAdapter: ExperienceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experience, container, false)
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
        //handle clicks if any
    }

    private fun setUpAdapter(){
        experienceAdapter = ExperienceAdapter()
        binding.rcvExperience.adapter = experienceAdapter
    }

    private fun observeData(){
        meViewModel.experienceLiveData.observe(viewLifecycleOwner){
           experienceAdapter.submitList(it)
        }
    }

}