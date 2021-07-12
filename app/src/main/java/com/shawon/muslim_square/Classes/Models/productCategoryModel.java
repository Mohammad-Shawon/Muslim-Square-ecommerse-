package com.shawon.muslim_square.Classes.Models;

public class productCategoryModel {

    String images, name, desc, price;

    public productCategoryModel(String images, String name, String desc, String price) {
        this.images = images;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
