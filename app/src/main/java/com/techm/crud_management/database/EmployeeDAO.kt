package com.techm.competency.database

import androidx.lifecycle.LiveData
import androidx.room.*

/** interface to connect with Database and Entity */
@Dao
interface EmployeeDAO {

    @Query("SELECT * FROM employee_data_table")
    fun getAllEmployees(): LiveData<List<Employee>>

    @Insert
    suspend fun insertEmployee(employee: Employee): Long

    @Update
    suspend fun updateEmployee(employee: Employee): Int

    @Delete
    suspend fun deleteEmployee(employee: Employee): Int

    @Query("DELETE FROM employee_data_table")
    suspend fun deleteAll(): Int


}