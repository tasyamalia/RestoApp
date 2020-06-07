package com.tasya.restoapp.model;

public class Menus {
    private int id_kategori;
    private int id_menu;
    private String nama_menu;
    private String foto_menu;
    private String deskripsi_menu;
    private String harga_menu;

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getFoto_menu() {
        return foto_menu;
    }

    public void setFoto_menu(String foto_menu) {
        this.foto_menu = foto_menu;
    }

    public String getDeskripsi_menu() {
        return deskripsi_menu;
    }

    public void setDeskripsi_menu(String deskripsi_menu) {
        this.deskripsi_menu = deskripsi_menu;
    }

    public String getHarga_menu() {
        return harga_menu;
    }

    public void setHarga_menu(String harga_menu) {
        this.harga_menu = harga_menu;
    }
}
