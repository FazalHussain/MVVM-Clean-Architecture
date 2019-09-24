package com.fazal.mvvmcleanarchitecture.di.user

import androidx.lifecycle.ViewModel
import com.fazal.mvvmcleanarchitecture.di.ViewModelKey
import com.fazal.mvvmcleanarchitecture.presentation.viewModel.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class UserViewModelModule {

    /**
     * Binds the user view model dependency with [ViewModelKey] to group similar [ViewModel]
     *
     * Under the hood it is providing [com.example.advancedagger2.viewmodel.AuthViewModel]
     */
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindAuthViewModel(userViewModel: UserViewModel) : ViewModel

}