/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fahrika
 */
public class DataBarang2 {
    int jumlah,harga;
    String id_barang, nama_barang;
    
    public DataBarang2(String id_barang, String nama_barang, int jumlah,int harga ){
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.jumlah = jumlah;
        this.harga = harga;
       
        
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }
    
    
}
