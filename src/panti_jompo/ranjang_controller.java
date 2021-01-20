/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panti_jompo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Sntn_Prnwr
 */
public class ranjang_controller {

    @FXML
    private TextField ranjang;
    @FXML
    private TextField identitas;
    @FXML
    private TextField pasien;
    @FXML
    private TextField perawat;
    @FXML
    private TextField kamar;
    @FXML
    private Button btnkmb;
    @FXML
    private Button btntmbh;
    @FXML
    private TableView<data_ranjang> tbranjang;
    @FXML
    private TableColumn<data_ranjang, Integer> colranjang;
    @FXML
    private TableColumn<data_ranjang, Integer> colidentitas;
    @FXML
    private TableColumn<data_ranjang, Integer> colpasien;
    @FXML
    private TableColumn<data_ranjang, Integer> colperawat;
    @FXML
    private TableColumn<data_ranjang, Integer> colkamar;
    @FXML
    private Button btnhps;


    @FXML
    private void kembali(ActionEvent event) throws IOException {
         Parent view3=FXMLLoader.load(getClass().getResource("Dasboard.fxml"));
                Scene scene3=new Scene(view3);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene3);
    }
        public Connection getConnection(){
         Connection conn;
         try{
              conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/db_panti_jompo","root","");
              return conn;
         }catch (Exception ex){
             System.out.println("eror: " + ex.getMessage());
            return null;
         }
    }
    
    public ObservableList<data_ranjang> getdataList(){
         ObservableList<data_ranjang> datalist = FXCollections.observableArrayList();
         Connection conn = getConnection();
         String querry = "SELECT * FROM ranjang";
         Statement st;
         ResultSet rs;
         try{
        st =  conn.createStatement();
        rs = st.executeQuery(querry);
        data_ranjang ranjang;
        while (rs.next()){
            ranjang = new data_ranjang(rs.getInt("no_ranjang"),rs.getInt("id_pj"),rs.getInt("id_pasien"),rs.getInt("id_perawat"),rs.getInt("no_kamar"));
            datalist.add(ranjang);
        }
         }catch (Exception ex){ 
             ex.printStackTrace();
         }
         return datalist;
    }
    
    
    public void showdata(){
         ObservableList<data_ranjang> list = getdataList();
         
         colranjang.setCellValueFactory(new PropertyValueFactory<data_ranjang,Integer>("no_ranjang"));
         colidentitas.setCellValueFactory(new PropertyValueFactory<data_ranjang,Integer>("id_pj"));
         colpasien.setCellValueFactory(new PropertyValueFactory<data_ranjang,Integer>("id_pasien"));
         colperawat.setCellValueFactory(new PropertyValueFactory<data_ranjang,Integer>("id_perawat"));
         colkamar.setCellValueFactory(new PropertyValueFactory<data_ranjang,Integer>("no_kamar"));
         
         tbranjang.setItems(list);
    }
        private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception ex){
              ex.printStackTrace();
        }
     }
    @FXML
    private void tambah(ActionEvent event) {
         String query  = "INSERT INTO ranjang VALUES(" + ranjang.getText()+",'"+identitas.getText()+"',"+pasien.getText()+","+perawat.getText()+","+kamar.getText()+")";    
        executeQuery(query);
        showdata();
    }

    @FXML
    private void hapus(ActionEvent event) {
      String query ="DELETE FROM ranjang WHERE no_ranjang="+ranjang.getText()+"";
        executeQuery(query);
        showdata();
    }

    @FXML
    private void klik(MouseEvent event) {
    data_ranjang klik = tbranjang.getSelectionModel().getSelectedItem();
    ranjang.setText(""+klik.getNo_ranjang());
    identitas.setText(""+klik.getId_pj());
    pasien.setText(""+klik.getId_pasien());
    perawat.setText(""+klik.getId_perawat());
    kamar.setText(""+klik.getNo_kamar());
    }
    
}
