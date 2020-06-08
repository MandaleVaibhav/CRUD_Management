package com.techm.crud_management.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.techm.crud_management.callback.ResponseCallback
import com.techm.crud_management.model.ModelDeleteEmployee
import com.techm.crud_management.model.ModelServerResponse
import com.techm.crud_management.repository.RepositoryViewModel
import com.techm.crud_management.roomdatabase.ModelEmployeeRegistration
import com.techm.crud_management.utils.ResponseStatus
import kotlinx.coroutines.launch
import org.jetbrains.annotations.NotNull

class ViewModelEmployeeInformation(@NotNull application: Application) :
    AndroidViewModel(application) {
    private var repositoryViewModel: RepositoryViewModel = RepositoryViewModel(application)
    var mEmployeeInformationData: LiveData<List<ModelEmployeeRegistration>> =
        repositoryViewModel.getAllEmployeeData()
    var mEmployeeDeleteStatus: MutableLiveData<ModelDeleteEmployee> =
        MutableLiveData<ModelDeleteEmployee>()
    fun getEmployeeInformation() {
        repositoryViewModel.getAllEmployeeData()

    }

    /**
     * Delete employee API
     * */
    fun deleteEmployee(mModelEmployeeRegistration: ModelEmployeeRegistration) =
        viewModelScope.launch {
            repositoryViewModel.deleteEmployee(mModelEmployeeRegistration)
        }
}