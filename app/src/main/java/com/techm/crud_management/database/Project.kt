package com.techm.competency.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** Project Data Class */
@Entity(tableName = "project_data_table")
data class Project(

    @PrimaryKey(autoGenerate = true)
    var Id: Int,
    @ColumnInfo(name = "project_id")
    var projectId: String,

    @ColumnInfo(name = "project_name")
    var projectName: String

  )