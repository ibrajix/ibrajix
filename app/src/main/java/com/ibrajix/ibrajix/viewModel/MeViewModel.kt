/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrajix.ibrajix.data.DataSource

class MeViewModel(dataSource: DataSource) : ViewModel() {

    val meLiveData = dataSource.getMeList()
    val projectsLiveData = dataSource.getProjectsList()
    val experienceLiveData = dataSource.getExperienceList()

    class MeListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MeViewModel(
                    dataSource = DataSource.getDataSource(context.resources)
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}