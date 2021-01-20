/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panti_jompo;

/**
 *
 * @author Sntn_Prnwr
 */
public class data_perawat {
    private int id_perawat;
    private String nama_perawat;
    private String jenis_kelamin;
    private int id_pasien;

    public data_perawat(int id_perawat, String nama_perawat, String jenis_kelamin, int id_pasien) {
        this.id_perawat = id_perawat;
        this.nama_perawat = nama_perawat;
        this.jenis_kelamin = jenis_kelamin;
        this.id_pasien = id_pasien;
    }

    public int getId_perawat() {
        return id_perawat;
    }

    public String getNama_perawat() {
        return nama_perawat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public void setId_perawat(int id_perawat) {
        this.id_perawat = id_perawat;
    }

    public void setNama_perawat(String nama_perawat) {
        this.nama_perawat = nama_perawat;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }


   
    
}
