package com.techm.crud_management.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project")
class ModelProject(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var projectName:String
)