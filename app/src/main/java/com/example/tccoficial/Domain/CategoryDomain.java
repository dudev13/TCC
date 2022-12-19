package com.example.tccoficial.Domain;

import java.io.Serializable;

public class CategoryDomain implements Serializable{
    private String title;
    private String pic;
    private String desc;
    private Double fee;


    public CategoryDomain(String title,  String pic, String desc, String fee) {
        super();
        this.title = title;
        this.desc = desc;
        this.fee = Double.valueOf(fee);
        this.pic = pic;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getFee(){return fee;}

    public void  setFee (String fee){this.fee = Double.valueOf(fee);}
}

