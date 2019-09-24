package com.fazal.mvvmcleanarchitecture.di;

import androidx.lifecycle.ViewModel;

import java.lang.annotation.*;

import dagger.MapKey;

@MapKey
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}