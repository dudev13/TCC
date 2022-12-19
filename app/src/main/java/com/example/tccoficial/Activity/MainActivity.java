package com.example.tccoficial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tccoficial.Adapter.RecommendedAdapter;
import com.example.tccoficial.Domain.FoodDomain;
import com.example.tccoficial.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategotyList, recyclerViewPopularList;
    private ConstraintLayout burguer,bebida,porcao,sobremesa,option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();
        categoryNavigation();
        perfil();
    }

    private void perfil() {
        ImageView gustavo = findViewById(R.id.gustavo);

        gustavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UsuarioActivity.class));
            }
        });
    }

    private void categoryNavigation() {
        ConstraintLayout burguer = findViewById(R.id.burguer);
        ConstraintLayout bebida = findViewById(R.id.bebida);
        ConstraintLayout porcao = findViewById(R.id.porcao);
        ConstraintLayout sobremesa = findViewById(R.id.sobremesa);


        burguer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CategoryActivity.class));
            }
        });

        bebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Category2Activity.class));
            }
        });

        porcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Category3Activity.class));
            }
        });

        sobremesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Category4Activity.class));
            }
        });
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
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        usuarioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UsuarioActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });

        suportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SuportActivity.class));
            }
        });

        opbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Options.class));
            }
        });
    }



    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Triplo Burger", "triplo","Três hambúrgueres artesanais smash de 50g, cheddar inglês derretido, bacon defumado, picles, cebola roxa e maionese da casa no pão de brioche.", 39.0, 4, 22,1700));
        foodlist.add(new FoodDomain("Classicada", "classico","Suculento hambúrguer artesanal de 160g, cheddar inglês derretido, bacon, cebola caramelizada e maionese artesanal no pão de brioche. Simples e perfeito!", 37.0, 3, 10,850));
        foodlist.add(new FoodDomain("Onion rings","onionrings", "Deliciosas cebolas empanadas crocantes", 18.0,5,5,100));
        foodlist.add(new FoodDomain("Gororoba Burguer", "beterraba","Hambúrguer artesanal de beterraba, tomate, rúcula e maionese da casa no pão de brioche.", 28.0, 2, 10,500));
        foodlist.add(new FoodDomain("Fries","fries", "Porção individual das nossas deliciosas batatas crinkles crocantes.", 11.50,5,5,100));


        adapter2=new RecommendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

}