package com.alperen.todolistclone.repository

import com.alperen.todolistclone.database.ToDoDatabase
import com.alperen.todolistclone.database.ToDoEntity
import kotlinx.coroutines.flow.Flow

class TodoRepoImpl(private val database: ToDoDatabase):ToDoRepo {
    private val dao = database.todoDao()
    override suspend fun getTodos(): Flow<List<ToDoEntity>> = dao.getTodos()


    override suspend fun addTodo(todo: ToDoEntity) = dao.addTodo(todo)

    override suspend fun updateTodo(todo: ToDoEntity) = dao.updateTodo(todo)

    override suspend fun deleteTodo(todo: ToDoEntity) = dao.deleteTodo(todo)
}