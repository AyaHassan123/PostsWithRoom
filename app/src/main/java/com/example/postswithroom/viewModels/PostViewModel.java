package com.example.postswithroom.viewModels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.postswithroom.pojo.PostModel;
import com.example.postswithroom.repository.PostsRepo;

import java.util.List;

public class PostViewModel extends ViewModel {

    public static MutableLiveData<List<PostModel>> postModelMutableLiveData = new MutableLiveData<>();
    public static MutableLiveData<String> error = new MutableLiveData<>();

    public PostViewModel() {

        this.postModelMutableLiveData = PostsRepo.postModelMutableLiveData;
        this.error = PostsRepo.error;
    }

    public void  setData(PostModel postModel , Context context){
        PostsRepo.addData(postModel,context);
    }
    public  void getData(Context context){
        PostsRepo.getData(context);
    }
}
