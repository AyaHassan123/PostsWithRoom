package com.example.postswithroom.dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.postswithroom.dataBase.dao.PostsDao;
import com.example.postswithroom.pojo.PostModel;

@Database(entities = PostModel.class,version =2, exportSchema = false)
public abstract class MyDataBase  extends RoomDatabase {

    public  static  final  String DB_NAME = "PostsDataBase";
    private static  MyDataBase myDataBase;

    public  abstract PostsDao postsDao();
    public static synchronized MyDataBase getInstance(Context context){
        if (myDataBase == null){
            myDataBase = Room.databaseBuilder(context.getApplicationContext(),
                    MyDataBase.class, MyDataBase.DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return myDataBase;
    }
}
