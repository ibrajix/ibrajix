/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibrajix.ibrajix.model.*

class DataSource(resources: Resources) {

    private val meList = meList(resources)
    private val meLiveData = MutableLiveData(meList)

    private val projectsList = projectList(resources)
    private val projectsLiveData = MutableLiveData(projectsList)

    private val experienceList = experienceList(resources)
    private val experienceLiveData = MutableLiveData(experienceList)

    fun getMeList(): LiveData<List<Me>> {
        return meLiveData
    }

    fun getExperienceList(): LiveData<List<Experience>> {
        return experienceLiveData
    }

    fun getProjectsList(): LiveData<List<Projects>> {
        return projectsLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }

}