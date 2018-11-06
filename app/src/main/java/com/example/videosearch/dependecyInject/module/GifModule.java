package com.example.videosearch.dependecyInject.module;

import com.example.videosearch.Repository;
import com.example.videosearch.model.RepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GifModule {

    @Provides
    @Singleton
    public Repository providesGiphyRepository(RepositoryImpl repository){
        return repository;
    }
}