package com.techm.competency.database

/**
 * Repository module for handling data operations.
 */
class ProjectRepository(private val dao : ProjectDAO) {

    val projects = dao.getAllProjects()

    suspend fun insert(project: Project):Long{
       return dao.insertProject(project)
    }

    suspend fun update(project: Project):Int{
        return dao.updateProject(project)
    }

    suspend fun delete(project: Project) : Int{
       return dao.deleteProject(project)
    }

    suspend fun deleteAll() : Int{
        return dao.deleteAll()
    }

}