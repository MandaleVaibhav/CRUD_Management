package com.techm.crud_management.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Query
import com.techm.crud_management.EmployeeDao
import com.techm.crud_management.roomdatabase.ModelEmployeeRegistration
import com.techm.crud_management.roomdatabase.ModelProject
import com.techm.crud_management.roomdatabase.ProjectDao
import com.techm.crud_management.roomdatabase.EmployeeDatabase

class RepositoryViewModel {


    lateinit var employeeDao: EmployeeDao
    lateinit var projectDao: ProjectDao
    lateinit var allProject: LiveData<List<ModelProject>>
    lateinit var allEmployee: LiveData<List<ModelEmployeeRegistration>>
    constructor(application: Application)
    {
        var employeeDatabase=EmployeeDatabase.invoke(application)
        employeeDao=employeeDatabase.getEmployeeDao()
        projectDao=employeeDatabase.getProjectDao()
        allProject=projectDao.getAllProject()
        allEmployee=employeeDao.getAllEmployee()
    }

    fun getAllProjectData():LiveData<List<ModelProject>>{
        return allProject
    }
    suspend fun insertProject(mModelProject:ModelProject):Long
    {
        return projectDao.insertProject(mModelProject)
    }

    suspend fun insertEmployee(mModelEmployeeRegistration:ModelEmployeeRegistration):Long
    {
        return employeeDao.insertEmployee(mModelEmployeeRegistration)
    }
    suspend fun deleteEmployee(mModelEmployeeRegistration:ModelEmployeeRegistration):Int
    {
        return employeeDao.delete(mModelEmployeeRegistration)
    }
    suspend fun updateEmployee(mModelEmployeeRegistration:ModelEmployeeRegistration):Int
    {
        return employeeDao.updateEmployee(mModelEmployeeRegistration)
    }
    fun getAllEmployeeData():LiveData<List<ModelEmployeeRegistration>>{
        return allEmployee
    }
    suspend fun getEmployee(id: String):ModelEmployeeRegistration
    {
        return employeeDao.findByEmployeeId(id)
    }

}
