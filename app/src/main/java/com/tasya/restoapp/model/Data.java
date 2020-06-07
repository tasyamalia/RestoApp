package com.tasya.restoapp.model;

import java.util.ArrayList;

public class Data {
    private ArrayList<Users> users;
    private ArrayList<Menus> menus;
    private ArrayList<Categories> categories;

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }
    public ArrayList<Menus> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menus> menus) {
        this.menus = menus;
    }

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categories> categories) {
        this.categories = categories;
    }

}
