package com.example.asd;
public class goods {
    private String name;
    private String price;
    private Integer icon;
    public goods(String name,String price,Integer icon){
        this.name=name; this.price=price;this.icon=icon;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }
}