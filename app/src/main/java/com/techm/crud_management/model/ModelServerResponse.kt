package com.techm.crud_management.model

import com.techm.crud_management.roomdatabase.ModelEmployeeRegistration
import com.techm.crud_management.utils.ResponseStatus


/**
 * This class is for handle server response
 * */
class ModelServerResponse(var data:ArrayList<ModelEmployeeRegistration> ,var errorMessage:String="",var status: ResponseStatus)