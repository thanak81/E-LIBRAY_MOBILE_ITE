package kh.edu.rupp.ite.e_librar_ite_se1.model

import com.google.gson.annotations.SerializedName

data class BookDataObject(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)