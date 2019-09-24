package com.fazal.mvvmcleanarchitecture.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.fazal.mvvmcleanarchitecture.R
import com.fazal.mvvmcleanarchitecture.presentation.viewModel.UserViewModel
import com.fazal.mvvmcleanarchitecture.presentation.viewModel.ViewModelProviderFactory
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProviders.of(this, viewModelProviderFactory)
            .get(UserViewModel::class.java)

        userViewModel.callData()

        userViewModel.userLiveData.observe(this, Observer { user ->
            Log.d("user", user.name)
        })
    }
}
