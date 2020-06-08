package com.techm.crud_management.model

import com.techm.crud_management.roomdatabase.ModelEmployeeRegistration
import com.techm.crud_management.utils.ResponseStatus


/**
 * This class for handle API response
 * */
class ModelEmployee(
    var error: String,
    var status: ResponseStatus
)