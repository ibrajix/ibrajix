/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.model

import androidx.annotation.DrawableRes

data class Me(
    val type: String,
    val content: String
)

data class Projects(
    val name: String,
    val description: String,
    val url: String,
    @DrawableRes
    val image: Int?
)

data class Experience(
    val companyName: String,
    val role: String,
    val duration: String,
    val roleDescription: String,
)