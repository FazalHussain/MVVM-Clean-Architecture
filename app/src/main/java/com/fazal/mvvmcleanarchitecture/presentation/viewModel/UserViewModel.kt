package com.fazal.mvvmcleanarchitecture.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fazal.mvvmcleanarchitecture.data.models.User
import com.fazal.mvvmcleanarchitecture.data.repository.UserRepository
import javax.inject.Inject

/**
 * User View Model Class
 */
class UserViewModel @Inject constructor(val userRepository: UserRepository) : ViewModel() {

    lateinit var userLiveData : MutableLiveData<User>

    fun callData() {
        userLiveData = userRepository.getUsersMutableLiveData()
    }
}