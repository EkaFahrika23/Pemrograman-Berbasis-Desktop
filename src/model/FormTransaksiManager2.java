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
public class FormTransaksiManager2 {
    int id_transaksi, jumlah, harga, total_harga;
    String tanggal, nama_karyawan, nama_barang;
    
    public FormTransaksiManager2(int id_transaksi, String nama_karyawan, String tanggal, String nama_barang, int jumlah, int harga, int total_harga ){
        this.id_transaksi = id_transaksi;
        this.nama_karyawan = nama_karyawan;
        this.tanggal = tanggal;
        this.nama_barang = nama_barang;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total_harga = total_harga;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
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

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }
    
}
