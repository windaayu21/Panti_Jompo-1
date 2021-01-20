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
public class data_ranjang {
    private int no_ranjang,id_pj,id_pasien,id_perawat,no_kamar;

    public data_ranjang(int no_ranjang, int id_pj, int id_pasien, int id_perawat, int no_kamar) {
        this.no_ranjang = no_ranjang;
        this.id_pj = id_pj;
        this.id_pasien = id_pasien;
        this.id_perawat = id_perawat;
        this.no_kamar = no_kamar;
    }

    public int getNo_ranjang() {
        return no_ranjang;
    }

    public int getId_pj() {
        return id_pj;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public int getId_perawat() {
        return id_perawat;
    }

    public int getNo_kamar() {
        return no_kamar;
    }

    public void setNo_ranjang(int no_ranjang) {
        this.no_ranjang = no_ranjang;
    }

    public void setId_pj(int id_pj) {
        this.id_pj = id_pj;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    public void setId_perawat(int id_perawat) {
        this.id_perawat = id_perawat;
    }

    public void setNo_kamar(int no_kamar) {
        this.no_kamar = no_kamar;
    }
    
}
