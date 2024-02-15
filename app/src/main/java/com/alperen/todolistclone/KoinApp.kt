package com.alperen.todolistclone

import android.app.Application
import androidx.room.Room
import com.alperen.todolistclone.database.ToDoDatabase
import com.alperen.todolistclone.repository.ToDoRepo
import com.alperen.todolistclone.repository.TodoRepoImpl
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class KoinApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(module{
                single {
                    Room.databaseBuilder(this@KoinApp,ToDoDatabase::class.java,"db")
                        .build()
                }
                single {
                    TodoRepoImpl(database = get())
                } bind ToDoRepo::class
            })
        }
    }
}