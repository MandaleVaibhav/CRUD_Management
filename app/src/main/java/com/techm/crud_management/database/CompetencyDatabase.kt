package com.techm.competency.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/** Room Database Class */
@Database(entities = [Employee::class, Project::class], version = 2)
abstract class CompetencyDatabase : RoomDatabase() {

    abstract val projectDAO: ProjectDAO
    abstract val employeeDAO: EmployeeDAO

    companion object {
        @Volatile
        private var INSTANCE: CompetencyDatabase? = null
        fun getInstance(context: Context): CompetencyDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CompetencyDatabase::class.java,
                        "competency_data_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}

