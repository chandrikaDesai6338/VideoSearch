package com.example.videosearch.dependecyInject.component;


import com.example.videosearch.dependecyInject.module.GifModule;
import com.example.videosearch.viewModel.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {GifModule.class})
public interface ApplicationComponent {
    void inject (MainViewModel viewModel);

}