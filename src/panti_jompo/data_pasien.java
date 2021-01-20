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
public class data_pasien {
    private int id_pasien;
    private String nama_pasien;
    private String jenis_kelamin;
    private int umur;
    private String tanggal_masuk;
    private String tanggal_lahir;
    private String status;
    private int id_pj;

    public data_pasien(int id_pasien, String nama_pasien, String jenis_kelamin, int umur, String tanggal_masuk, String tanggal_lahir, String status, int id_pj) {
        this.id_pasien = id_pasien;
        this.nama_pasien = nama_pasien;
        this.jenis_kelamin = jenis_kelamin;
        this.umur = umur;
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_lahir = tanggal_lahir;
        this.status = status;
        this.id_pj = id_pj;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public int getUmur() {
        return umur;
    }

    public String getTanggal_masuk() {
        return tanggal_masuk;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public String getStatus() {
        return status;
    }

    public int getId_pj() {
        return id_pj;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId_pj(int id_pj) {
        this.id_pj = id_pj;
    }

   

    
   

}
