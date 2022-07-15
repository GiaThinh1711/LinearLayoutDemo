package com.example.linearlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.linearlayoutdemo.adapter.UserAdapter;
import com.example.linearlayoutdemo.data.AppDatabase;
import com.example.linearlayoutdemo.data.User;

import java.util.List;

public class ListUserActivity extends AppCompatActivity {
    RecyclerView rvUser;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        appDatabase = AppDatabase.getAppDatabase(this);
        List<User> list = appDatabase.userDao().getAllUser();

        UserAdapter adapter = new UserAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rvUser = findViewById(R.id.rvUser);
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);

    }
}
