package com.ocean.myinterviewapp8thapril11am;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoffeeModel {

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("ingredients")
    private List<String> ingredients = null;
    @SerializedName("id")
    private Integer id;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public Integer getId() {
        return id;
    }
}
