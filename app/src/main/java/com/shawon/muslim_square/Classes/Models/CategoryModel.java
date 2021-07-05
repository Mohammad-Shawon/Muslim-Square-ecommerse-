package com.shawon.muslim_square.Classes.Models;

public class CategoryModel {
    String categoryIconLink,categoryTitle;

    public CategoryModel(String categoryIconLink, String categoryTitle) {
        this.categoryIconLink = categoryIconLink;
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryIconLink() {
        return categoryIconLink;
    }

    public void setCategoryIconLink(String categoryIconLink) {
        this.categoryIconLink = categoryIconLink;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
