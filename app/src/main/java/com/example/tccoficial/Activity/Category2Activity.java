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

public class Category2Activity extends AppCompatActivity {

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
                startActivity(new Intent(Category2Activity.this,MainActivity.class));
            }
        });

        usuarioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category2Activity.this,UsuarioActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category2Activity.this,CartActivity.class));
            }
        });

        suportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category2Activity.this,SuportActivity.class));
            }
        });

        opbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Category2Activity.this, Options.class));
            }
        });
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularList = findViewById(R.id.view4);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Coca Lata","coca", "350ml", 4.50, 4, 0, 200));
        foodlist.add(new FoodDomain("Guaraná Antarctica","guarana", "350ml", 4.50, 4, 0, 200));
        foodlist.add(new FoodDomain("Sprite Original","sprite", "350ml", 4.50, 4 ,0,200));
        foodlist.add(new FoodDomain("Heineken Lata","heineken", "350ml", 6.99,4,0,200));
        foodlist.add(new FoodDomain("Skol Lata","skol", "350ml", 4.00,4,0,200));
        foodlist.add(new FoodDomain("Brahma Duplo Malte","brahma", "350ml", 4.37,4,0,200));

        adapter2=new TesteAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}