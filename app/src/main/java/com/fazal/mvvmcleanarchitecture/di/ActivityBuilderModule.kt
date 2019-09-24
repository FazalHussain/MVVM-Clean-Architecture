package com.fazal.mvvmcleanarchitecture.di

import com.fazal.mvvmcleanarchitecture.di.user.UserViewModelModule
import com.fazal.mvvmcleanarchitecture.presentation.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This Class {@linkplain ActivityBuilderModule} is responsible for for android injection
 * for the activity with in the application to avoid the seprate injection in each activity
 *
 * {@linkplain dagger.android.AndroidInjection#inject(Activity)}
 *
 */
@Module
abstract class ActivityBuilderModule {

    /**
     * Automatically create sub-component with module
     *
     * @return The [MainActivity]
     */
    @ContributesAndroidInjector(modules = [UserViewModelModule::class])
    abstract fun contributeMainActivity() : MainActivity

}