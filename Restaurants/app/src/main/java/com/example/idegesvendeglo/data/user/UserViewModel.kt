package com.example.idegesvendeglo.data.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.idegesvendeglo.data.user.User
import com.example.idegesvendeglo.data.user.UserDatabase
import com.example.idegesvendeglo.data.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
    }

    fun addUser(user: User)
    {
         viewModelScope.launch(Dispatchers.IO) {
         repository.addUser(user)
        }
    }


    fun readAllData():LiveData<User>
    {
        return repository.readAllData()
    }
}