package kh.edu.rupp.ite.e_librar_ite_se1.model

import com.google.gson.annotations.SerializedName

data class BookDataObject(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int?
)