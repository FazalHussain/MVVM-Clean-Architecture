package com.fazal.mvvmcleanarchitecture.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.fazal.mvvmcleanarchitecture.R
import com.fazal.mvvmcleanarchitecture.databinding.ActivityMainBinding
import com.fazal.mvvmcleanarchitecture.presentation.presenter.UserPresenter
import com.fazal.mvvmcleanarchitecture.presentation.viewModel.UserViewModel
import com.fazal.mvvmcleanarchitecture.presentation.viewModel.ViewModelProviderFactory
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var userViewModel: UserViewModel

    private lateinit var mainDataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        userViewModel = ViewModelProviders.of(this, viewModelProviderFactory)
            .get(UserViewModel::class.java)

        userViewModel.userLiveData.observe(this, Observer { user ->
            Log.d("user", user.name)
            mainDataBinding.tv.text = user.name
        })

        mainDataBinding.presenter = object : UserPresenter {
            override fun onClick() {
                userViewModel.callData()

                userViewModel.userLiveData.observe(this@MainActivity, Observer { user ->
                    Log.d("user", user.name)
                    mainDataBinding.tv.text = user.name
                })
            }
        }
    }
}
