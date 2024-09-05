package com.dm.berxley.electronicsstore.presentation.onboarding.intro.components

import androidx.annotation.DrawableRes
import com.dm.berxley.electronicsstore.R

data class Page(@DrawableRes val image: Int, val description: String)

val pages = listOf(
    Page(R.drawable.logo, "Welcome to Latech!"),
    Page(R.drawable.world_illustration, "The best tech market"),
    Page(R.drawable.computer_illustration, "A lot of exclusives"),
    Page(R.drawable.sales_illustration, "Sales all the time"),
)
