/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.model

import android.content.res.Resources
import com.ibrajix.ibrajix.R

fun meList(resources: Resources) : List<Me> {

    return listOf(

        Me(
            type = "About",
            content = resources.getString(R.string.about_me)
        ),

        Me(
            type = "Skills",
            content = resources.getString(R.string.my_skills)
        ),

        Me(
            type = "Languages",
            content = resources.getString(R.string.languages)
        ),

        Me(
            type = "Technologies",
            content = resources.getString(R.string.technologies)
        ),

    )
}

fun projectList(resources: Resources) : List<Projects> {

    return listOf(

        Projects(
            name = resources.getString(R.string.dmp),
            description = resources.getString(R.string.dmp_desc),
            url = resources.getString(R.string.dmp_url),
            image = R.drawable.ic_dmp
        ),

        Projects(
            name = resources.getString(R.string.news_fly),
            description = resources.getString(R.string.news_fly_desc),
            url = resources.getString(R.string.newsfly_url),
            image = R.drawable.ic_news_fly
        ),

        Projects(
            name = resources.getString(R.string.snapchat_clone),
            description = resources.getString(R.string.snapchat_clone_desc),
            url = resources.getString(R.string.snapchat_clone_url),
            image = R.drawable.ic_snapchat_clone
        ),

        Projects(
            name = resources.getString(R.string.branch_clone),
            description = resources.getString(R.string.branch_clone_desc),
            url = resources.getString(R.string.branch_clone_url),
            image = R.drawable.ic_branch
        ),

        Projects(
            name = resources.getString(R.string.dcc),
            description = resources.getString(R.string.dcc_desc),
            url = resources.getString(R.string.dcc_url),
            image = R.drawable.ic_dcc
        ),

        Projects(
            name = resources.getString(R.string.capital_land),
            description = resources.getString(R.string.capital_land_desc),
            url = resources.getString(R.string.capital_land_url),
            image = R.drawable.ic_capital_land
        ),

    )
}

fun experienceList(resources: Resources) : List<Experience> {

    return listOf(

        Experience(
            companyName = resources.getString(R.string.company_1_name),
            duration = "09/2020 - 09/2021",
            role = "Software Engineer",
            roleDescription = resources.getString(R.string.company_1_role_desc)
        ),

        Experience(
            companyName = resources.getString(R.string.company_2_name),
            duration = "02/2020 - 08/2020",
            role = "Developer",
            roleDescription = resources.getString(R.string.company_2_role_desc)
        ),

        Experience(
            companyName = resources.getString(R.string.company_3_name),
            duration = "03/2019 - 12/2019",
            role = "Developer",
            roleDescription = resources.getString(R.string.company_3_role_desc)
        )

    )

}