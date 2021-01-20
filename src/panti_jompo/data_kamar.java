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
public class data_kamar {
    private int no_kamar;
    private String nama_kamar;        
    private int kapasitas;
    private int id_pasien;
    private int id_pj;

    public data_kamar(int no_kamar, String nama_kamar, int kapasitas, int id_pasien, int id_pj) {
        this.no_kamar = no_kamar;
        this.nama_kamar = nama_kamar;
        this.kapasitas = kapasitas;
        this.id_pasien = id_pasien;
        this.id_pj = id_pj;
    }

    public int getNo_kamar() {
        return no_kamar;
    }

    public String getNama_kamar() {
        return nama_kamar;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public int getId_pj() {
        return id_pj;
    }

    public void setNo_kamar(int no_kamar) {
        this.no_kamar = no_kamar;
    }

    public void setNama_kamar(String nama_kamar) {
        this.nama_kamar = nama_kamar;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    public void setId_pj(int id_pj) {
        this.id_pj = id_pj;
    }


    
    
}
