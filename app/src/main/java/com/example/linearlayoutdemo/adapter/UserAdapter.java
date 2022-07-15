package com.example.linearlayoutdemo.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.linearlayoutdemo.R;
import com.example.linearlayoutdemo.data.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<User> userList;

    public UserAdapter(Activity activity, List<User> userList) {
        this.activity = activity;
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_user,parent,false);
        ProductHoder holder = new ProductHoder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHoder hoder = (ProductHoder) holder;
        User model = userList.get(position);
        hoder.tvId.setText(model.id);
        hoder.tvName.setText(model.username);
        hoder.tvGender.setText(model.gender);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ProductHoder extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView tvName;
        TextView tvGender;

        public ProductHoder (@NonNull View itemview){
            super(itemview);
            tvId = itemview.findViewById(R.id.tvID);
            tvName = itemview.findViewById(R.id.tvUserName);
            tvGender = itemview.findViewById(R.id.tvGender);
        }

    }
}
