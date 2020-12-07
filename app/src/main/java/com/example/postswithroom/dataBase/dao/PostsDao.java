package com.example.postswithroom.dataBase.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.postswithroom.pojo.PostModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface PostsDao {

    @Insert
    Completable insertPost(PostModel postModel);

    @Query("select * from posts_table")
    Single<List<PostModel>> getPosts();
}
