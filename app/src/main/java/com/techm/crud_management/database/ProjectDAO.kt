package com.techm.competency.database

import androidx.lifecycle.LiveData
import androidx.room.*

/** interface to connect with Database and Entity */
@Dao
interface ProjectDAO {

    @Query("SELECT * FROM project_data_table")
    fun getAllProjects(): LiveData<List<Project>>

    @Insert
    suspend fun insertProject(project: Project): Long

    @Update
    suspend fun updateProject(project: Project): Int

    @Delete
    suspend fun deleteProject(project: Project): Int

    @Query("DELETE FROM project_data_table")
    suspend fun deleteAll(): Int

    @Query("Select * from project_data_table where project_name like  :desc")
    fun getSearchResults(desc : String) : LiveData<List<Project>>


}