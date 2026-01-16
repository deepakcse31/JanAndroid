package com.example.janandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<MyListData> listdata;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        recyclerView=findViewById(R.id.rvrecycle);
        listdata=new ArrayList<>();
        listdata.add(new MyListData("Apple","This is Apple",R.mipmap.app_icon));
        listdata.add(new MyListData("Mango","This is Mango",R.mipmap.app_icon));
        listdata.add(new MyListData("Banana","This is Banana",R.mipmap.app_icon));
        listdata.add(new MyListData("Grapes","This is Grapes",R.mipmap.app_icon));
        listdata.add(new MyListData("Orange","This is Orange",R.mipmap.app_icon));
        listdata.add(new MyListData("Guava","This is Guava",R.mipmap.app_icon));
        listdata.add(new MyListData("Pineapple","This is Pineapple",R.mipmap.app_icon));

        RecyclerViewAdapter adapter=new RecyclerViewAdapter(listdata);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}