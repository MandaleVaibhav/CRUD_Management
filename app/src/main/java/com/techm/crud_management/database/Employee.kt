package com.techm.competency.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** Employee Data Class */
@Entity(tableName = "employee_data_table")
data class Employee(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "employee_id")
    var employeeId: Int,

    @ColumnInfo(name = "employee_name")
    var employeeName: String,

    @ColumnInfo(name = "designation")
    var designation: String,

    @ColumnInfo(name = "competency")
    var competency: String,

    @ColumnInfo(name = "projectname")
    var projectname: String

)