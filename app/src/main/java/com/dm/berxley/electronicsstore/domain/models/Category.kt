package com.dm.berxley.electronicsstore.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Category(
    @PrimaryKey val id: Int,
    val name: String,
    val offer_message: String,
    val display_image_url: String,
)