package com.bwei.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<>();
    private RecyclerView recycletview;
    private Asder asder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            list.add("item" + i);

        }

    }

    private void initView() {
        recycletview = (RecyclerView) findViewById(R.id.recycletview);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                recycletview.setLayoutManager(manager);
                asder = new Asder(list, MainActivity.this);
                recycletview.setAdapter(asder);
                //条目点击事件
                asder.setOnItemClickListener(new Asder.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GridLayoutManager grid = new GridLayoutManager(MainActivity.this, 3);
                recycletview.setLayoutManager(grid);
                //多条目展示
                grid.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return position % 10 == 0 ? 3 : 1;
                    }
                });
                recycletview.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.HORIZONTAL));
                recycletview.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
                recycletview.setItemAnimator(new DefaultItemAnimator());
                asder = new Asder(list, MainActivity.this);
                recycletview.setAdapter(asder);
                //条目点击事件
                asder.setOnItemClickListener(new Asder.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StaggeredGridLayoutManager stagger = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                recycletview.setLayoutManager(stagger);
                recycletview.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.HORIZONTAL));
                recycletview.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
                asder = new Asder(list, MainActivity.this);
                recycletview.setAdapter(asder);
                //条目点击事件
                asder.setOnItemClickListener(new Asder.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
