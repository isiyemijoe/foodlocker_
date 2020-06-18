package com.joe.foodlocker_;

public class Food {
    String name;
    String thumbnail;
    String Description;
    String category;
    String Price;

    public Food(String name, String thumbnail, String description, String category, String price) {
        this.name = name;
        this.thumbnail = thumbnail;
        Description = description;
        this.category = category;
        Price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
