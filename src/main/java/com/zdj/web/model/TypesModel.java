package com.zdj.web.model;

import java.util.List;

public class TypesModel {

    private String name;
    private int id;
    private List<TypesModel> smallTypes;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSmallTypes(List<TypesModel> smallTypes) {
        this.smallTypes = smallTypes;
    }

    public List<TypesModel> getSmallTypes() {
        return smallTypes;
    }

}