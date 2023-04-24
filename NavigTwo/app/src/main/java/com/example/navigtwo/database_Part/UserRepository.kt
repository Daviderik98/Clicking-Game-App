package com.example.navigtwo.database_Part

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class UserRepository(private val userDB: UserDataBase,
private val coroutineScope: CoroutineScope) {
    fun addOneUser(userOne: User){
        userDB.userDao().addOneUser(userOne)
    }

    fun fetchUserList(): List<User>{
        return userDB.userDao().fetchAllUsers()
    }

    fun performDatabaseOperation(
        dispatcher: CoroutineDispatcher,
        databaseOperation: suspend() -> Unit){
        coroutineScope.launch(dispatcher){
            databaseOperation()
        }
    }
}