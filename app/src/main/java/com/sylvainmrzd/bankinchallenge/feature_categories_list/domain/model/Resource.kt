package com.sylvainmrzd.bankinchallenge.feature_categories_list.domain.model

data class Resource(
    val id: String,
    val resource_uri: String,
    val resource_type: String,
    val name: String,
    val parent: Parent?,
    val custom: Boolean,
    val is_deleted: Boolean)
