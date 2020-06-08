package com.techm.crud_management.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.techm.crud_management.callback.ResponseCallback
import com.techm.crud_management.roomdatabase.ModelEmployeeRegistration
import com.techm.crud_management.model.ModelEmployee
import com.techm.crud_management.repository.RepositoryViewModel
import com.techm.crud_management.roomdatabase.ModelProject
import com.techm.crud_management.utils.ResponseStatus
import kotlinx.coroutines.launch
import org.jetbrains.annotations.NotNull

class ViewModelAddEmployee(@NotNull application: Application) :
    AndroidViewModel(application) {
    private var repositoryViewModel: RepositoryViewModel = RepositoryViewModel(application)
    var mEmployeeResponse: MutableLiveData<ModelEmployee> =
        MutableLiveData<ModelEmployee>()
    var mProjectData: LiveData<List<ModelProject>> =
        repositoryViewModel.getAllProjectData()

    var mEmployeeResponseUpdate: MutableLiveData<ModelEmployeeRegistration> =
        MutableLiveData<ModelEmployeeRegistration>()

    /**
     * Calling room methods
     */
    fun insertEmployee(employeeInformation: ModelEmployeeRegistration) = viewModelScope.launch {
        if (repositoryViewModel.insertEmployee(employeeInformation) > 0)
            mEmployeeResponse.value = ModelEmployee("", ResponseStatus.SUCCESS)
        else
            mEmployeeResponse.value = ModelEmployee("", ResponseStatus.FAIL)
    }
    fun updateEmployee(employeeInformation: ModelEmployeeRegistration) = viewModelScope.launch {
        if (repositoryViewModel.updateEmployee(employeeInformation) > 0)
            mEmployeeResponse.value = ModelEmployee("", ResponseStatus.SUCCESS)
        else
            mEmployeeResponse.value = ModelEmployee("", ResponseStatus.FAIL)
    }

    fun getEmployeeData(employeeId: String)= viewModelScope.launch {
        mEmployeeResponseUpdate.value=repositoryViewModel.getEmployee(employeeId)
    }
}