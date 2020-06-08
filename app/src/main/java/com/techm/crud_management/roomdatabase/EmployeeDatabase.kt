package com.techm.crud_management.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techm.crud_management.EmployeeDao
import com.techm.crud_management.model.ModelEmployee
import com.techm.crud_management.roomdatabase.ModelEmployeeRegistration
import com.techm.crud_management.roomdatabase.ModelProject
import com.techm.crud_management.roomdatabase.ProjectDao

/**
 * This class is creating for room database
 */
@Database(entities = [ModelEmployeeRegistration::class, ModelProject::class], version = 2)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun getEmployeeDao(): EmployeeDao
    abstract fun getProjectDao(): ProjectDao
    companion object {
        @Volatile
        private var instance: EmployeeDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            EmployeeDatabase::class.java, "employee_database.db"
        )
            .fallbackToDestructiveMigration()//we need it when we increase version number
            .build()
    }
}