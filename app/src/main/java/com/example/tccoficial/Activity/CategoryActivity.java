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

public class CategoryActivity extends AppCompatActivity {

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
                startActivity(new Intent(CategoryActivity.this,MainActivity.class));
            }
        });

        usuarioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this,UsuarioActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this,CartActivity.class));
            }
        });

        suportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this,SuportActivity.class));
            }
        });

        opbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, Options.class));
            }
        });
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularList = findViewById(R.id.view4);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Cebola, Bacon, Cheddar", "cbc","Hamb??rguer artesanal de 160g do delicioso blend de carne da casa, anel de cebola enrolado com bacon, creme de cheddar da casa e cebola crispy no p??o de brioche", 37.50, 5, 20,1300));
        foodlist.add(new FoodDomain("Scott Burguer", "scott","Suculento hamb??rger artesanal de 170gr coberto com delicioso creme de gorgonzola e cebola caramelizada no p??o de brioche.", 31.0, 4, 18,1200));
        foodlist.add(new FoodDomain("Triplo Burger", "triplo","Tr??s hamb??rgueres artesanais smash de 50g, cheddar ingl??s derretido, bacon defumado, picles, cebola roxa e maionese da casa no p??o de brioche.", 39.0, 4, 22,1700));
        foodlist.add(new FoodDomain("Pomodoro Burger", "pomodoro","O verdadeiro parmegiana no p??o. Suculento hamb??rguer artesanal de 160g, molho de tomate pomodoro, mussarela derretida, maionese de r??cula e r??cula no p??o de brioche mais macio da sua vida.", 40.0, 3, 12,900));
        foodlist.add(new FoodDomain("Parmesa Deles", "parmesa","Suculento hamb??rguer artesanal de 160g, dupla crostinha de queijo Parmes??o, cheddar ingl??s, tomate camuflado e maionese verde artesanal da casa no p??o de brioche mais macio da sua vida. Uma verdadeira explos??o de sabores.", 45.0, 5, 15,1150));
        foodlist.add(new FoodDomain("Classicada", "classico","Suculento hamb??rguer artesanal de 160g, cheddar ingl??s derretido, bacon, cebola caramelizada e maionese artesanal no p??o de brioche. Simples e perfeito!", 37.0, 3, 10,850));
        foodlist.add(new FoodDomain("Gororoba Burguer", "beterraba","Hamb??rguer artesanal de beterraba, tomate, r??cula e maionese da casa no p??o de brioche.", 28.0, 2, 10,500));
        foodlist.add(new FoodDomain("FAVORIO 2 VEGGIE", "futuro","Se voc?? n??o come carne/frango: o Favorito 2 Veggie foi feito pra voc??. Burger do Futuro, coberto com creme de cheddar da casa, alface americana e tomate, no p??o de brioche mais macio da vida.", 33.0, 3, 15,850));


        adapter2=new TesteAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}