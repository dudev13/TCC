package com.example.tccoficial.Helper;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.tccoficial.Domain.FoodDomain;
import com.example.tccoficial.Interface.ChangeNumberItemsListener;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listFood=getListCart();
        boolean existAlready=false;
        int n=0;
        for (int i = 0; i < listFood.size(); i++){
            if (listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if (existAlready){
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        }else {
            listFood.add(item);
        }

        tinyDB.putListObject("CardList", listFood);
        Toast.makeText(context,"Adicionou ao Carrinho", Toast.LENGTH_SHORT).show();

    }



    public ArrayList<FoodDomain> getListCart(){
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberFood(ArrayList<FoodDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if(listFood.get(position).getNumberInCart()==1){
            listFood.remove(position);
        } else {
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CardList", listFood);
        changeNumberItemsListener.changed();
    }
    public void plusNumberFood(ArrayList<FoodDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CardList",listFood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<FoodDomain>listfood2=getListCart();
        double fee=0;
        for (int i = 0; i < listfood2.size(); i++) {
            fee=fee+(listfood2.get(i).getFee()*listfood2.get(i).getNumberInCart());
        }
        return fee;
    }
}
