package com.yyyu.mdfeaturetestdemo.coordinator_layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yyyu.mdfeaturetestdemo.R;

/**
 * 功能：CoordinatorLayout测试
 *
 * Created by yyyu on 2017/2/22.
 */

public class CoordinatorActivity extends AppCompatActivity{

    private RecyclerView rv_coo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        initView();
    }

    private void initView() {
        rv_coo = (RecyclerView) findViewById(R.id.rv_coo);

        rv_coo.setAdapter(new MyAdapter());
        rv_coo.setLayoutManager(new LinearLayoutManager(this));
    }

    private class  MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = LayoutInflater.from(CoordinatorActivity.this).inflate(R.layout.item_rv_coo , parent , false);
            return new MyViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.getTv_item_info().setText("测试数据"+position);
        }

        @Override
        public int getItemCount() {
            return 15;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

         private TextView tv_item_info;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_item_info = (TextView) itemView.findViewById(R.id.tv_item_info);
        }

        public TextView getTv_item_info() {
            return tv_item_info;
        }
    }



}
