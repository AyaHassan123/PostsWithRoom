package com.example.postswithroom.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.postswithroom.R;
import com.example.postswithroom.databinding.ActivityMainBinding;
import com.example.postswithroom.pojo.PostModel;
import com.example.postswithroom.ui.adapter.PostAdapter;
import com.example.postswithroom.viewModels.PostViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public PostViewModel postViewModel ;
    public PostModel postModel;
    public ActivityMainBinding binding;
    PostAdapter postAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main);
        postViewModel =ViewModelProviders.of(this).get(PostViewModel.class);
        onclicks();
    }

    private void onclicks(){

        binding.insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                showToast("Success",getApplicationContext());
            }
        });

        binding.getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }
    private void showToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    private void setData(){
         postModel = new PostModel(binding.editTexttitle.getText().toString(),binding.editTextBody.getText().toString());
         postViewModel.setData(postModel,getApplicationContext());
    }
    private  void  getData(){
        postViewModel.getData(getApplicationContext());
        postViewModel.postModelMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {

                postAdapter = new PostAdapter();
                binding.postsRecyclerView.setAdapter(postAdapter);

                postAdapter.setList(postModels);
                postAdapter.notifyDataSetChanged();
            }
        });
    }
}
