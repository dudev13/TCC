package com.example.tccoficial.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tccoficial.Adapter.TesteAdapter;
import com.example.tccoficial.Domain.FoodDomain;
import com.example.tccoficial.R;

import java.util.ArrayList;

public class Category4Activity extends AppCompatActivity {

    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerViewPopularList;
    private RecyclerView recyclerViewCategotyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout usuarioBtn = findViewById(R.id.usuarioBtn);
        LinearLayout suportBtn = findViewById(R.id.suportBtn);
        LinearLayout opbtn = findViewById(R.id.optionBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category4Activity.this,MainActivity.class));
            }
        });

        usuarioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category4Activity.this,UsuarioActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category4Activity.this,CartActivity.class));
            }
        });

        suportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category4Activity.this,SuportActivity.class));
            }
        });

        opbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Category4Activity.this, Options.class));
            }
        });
    }



    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularList = findViewById(R.id.view4);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Petit Gato","petitgato", "Brownie", 22.00,5,5,400));
        foodlist.add(new FoodDomain("Brownelícia","brownelicia", "Delicioso Brownie da casa", 29.99,5,5,400));

        adapter2=new TesteAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

}