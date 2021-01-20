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
public class data_pj {
    private int id_pj;
    private String nama_pj ;
    private String jenis_kelamin;
    private String status_keluarga;
    private String alamat;
    private int no_hp;

    public data_pj(int id_pj, String nama_pj, String jenis_kelamin, String status_keluarga, String alamat, int no_hp) {
        this.id_pj = id_pj;
        this.nama_pj = nama_pj;
        this.jenis_kelamin = jenis_kelamin;
        this.status_keluarga = status_keluarga;
        this.alamat = alamat;
        this.no_hp = no_hp;
    }

    public int getId_pj() {
        return id_pj;
    }

    public String getNama_pj() {
        return nama_pj;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public String getStatus_keluarga() {
        return status_keluarga;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getNo_hp() {
        return no_hp;
    }

    public void setId_pj(int id_pj) {
        this.id_pj = id_pj;
    }

    public void setNama_pj(String nama_pj) {
        this.nama_pj = nama_pj;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public void setStatus_keluarga(String status_keluarga) {
        this.status_keluarga = status_keluarga;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNo_hp(int no_hp) {
        this.no_hp = no_hp;
    }

    
}
