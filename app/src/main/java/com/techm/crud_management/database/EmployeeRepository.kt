package com.techm.competency.database

/**
 * Repository module for handling data operations.
 */
class EmployeeRepository(private val dao : EmployeeDAO) {

    val employees = dao.getAllEmployees()

    suspend fun insert(employee: Employee):Long{
       return dao.insertEmployee(employee)
    }

    suspend fun update(employee: Employee):Int{
        return dao.updateEmployee(employee)
    }

    suspend fun delete(employee: Employee) : Int{
       return dao.deleteEmployee(employee)
    }

    suspend fun deleteAll() : Int{
        return dao.deleteAll()
    }
}