package com.fazal.mvvmcleanarchitecture.data.repository

import androidx.lifecycle.MutableLiveData
import com.fazal.mvvmcleanarchitecture.data.models.User
import javax.inject.Inject

/**
 * User Repository Class
 */
class UserRepository @Inject constructor() {

    lateinit var user: User

    var userMutableLiveData = MutableLiveData<User>()

    fun getUsersMutableLiveData(): MutableLiveData<User> {
        user = User("Fazal")
        userMutableLiveData.value = user
        return userMutableLiveData
    }

}