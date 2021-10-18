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
import com.ibrajix.ibrajix.databinding.FragmentMeBinding
import com.ibrajix.ibrajix.ui.adapter.MeAdapter
import com.ibrajix.ibrajix.utils.viewBinding
import com.ibrajix.ibrajix.viewModel.MeViewModel

class MeFragment : Fragment() {

    private val binding by viewBinding(FragmentMeBinding::bind)

    private val meViewModel by viewModels<MeViewModel> {
        MeViewModel.MeListViewModelFactory(requireContext())
    }

    lateinit var meAdapter: MeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me, container, false)
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

        //on click linkTree link
        binding.txtLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(resources.getString(R.string.linktree)))
            startActivity(intent)
        }

    }

    private fun setUpAdapter(){
        meAdapter = MeAdapter()
        binding.rcvMe.adapter = meAdapter
    }

    private fun observeData(){

        meViewModel.meLiveData.observe(viewLifecycleOwner){
            meAdapter.submitList(it)
        }

    }


}