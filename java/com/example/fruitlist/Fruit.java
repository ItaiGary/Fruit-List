package com.example.fruitlist;

public class Fruit {

    public String name;
    public String caloris;
    public int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaloris() {
        return caloris;
    }

    public void setCaloris(String caloris) {
        this.caloris = caloris;
    }

    public Fruit(String name, String caloris, int image) {
        this.name = name;
        this.caloris = caloris;
        this.image = image;
    }
}
