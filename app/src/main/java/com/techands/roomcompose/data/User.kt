package com.techands.roomcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userID: Int,
    var firstName: String,
    var lastName: String,
    var emailAddress: String,
    var mobileNumber: String
):Serializable {
}