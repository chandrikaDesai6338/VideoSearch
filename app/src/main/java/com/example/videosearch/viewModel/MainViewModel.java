package com.example.videosearch.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.videosearch.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.subjects.BehaviorSubject;

import static com.example.videosearch.GifApplication.getAppComponent;

public class MainViewModel extends ViewModel {

    private static final int SEARCH_RESPONSE_LIMIT = 20;

    @Inject
    Repository repository;

    //For callbacks to View
    private MutableLiveData<List<String>> gifUrlsList;
    private BehaviorSubject<Boolean> isLoading = BehaviorSubject.create();

    private String searchQuery = "cat";
    private int currentPage = 0;

    public MainViewModel() {
        getAppComponent().inject(this);
    }

    //To handle onScrollChanged
    public BehaviorSubject<Boolean> isLoading() {
        return isLoading;
    }

    private void loadGiphies() {
        int offset = currentPage * SEARCH_RESPONSE_LIMIT;
        repository
                .searchGif(searchQuery, SEARCH_RESPONSE_LIMIT, offset)
                .subscribe(this::setGifUrlsList);
    }

    private void setGifUrlsList(List<String> gifUrlsList) {
        this.gifUrlsList.postValue(gifUrlsList);
        this.isLoading.onNext(true);
    }

    public MutableLiveData<List<String>> getGifUrlsList() {
        if (gifUrlsList == null) {
            gifUrlsList = new MutableLiveData<>();
            loadGiphies();
        }
        return gifUrlsList;
    }

    public void setNewSearchQuery(String query) {
        this.searchQuery = query;
        currentPage = 0;
        loadGiphies();
    }

    public void loadNewGifPackage() {
        ++currentPage;
        loadGiphies();
    }

}
