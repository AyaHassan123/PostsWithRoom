package com.example.postswithroom.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.postswithroom.dataBase.MyDataBase;
import com.example.postswithroom.pojo.PostModel;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class PostsRepo {

    public static MutableLiveData<List<PostModel>> postModelMutableLiveData = new MutableLiveData<>();
    public static MutableLiveData<String> error = new MutableLiveData<>();

    public static  void  addData(PostModel  postModel, Context context){

        MyDataBase
                .getInstance(context)
                .postsDao()
                .insertPost(postModel)
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    public  static void getData(Context context){
        MyDataBase
                .getInstance(context)
                .postsDao()
                .getPosts()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<PostModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<PostModel> postModels) {

                        postModelMutableLiveData.setValue(postModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        error.setValue(e.getLocalizedMessage());
                    }
                });
    }
}
