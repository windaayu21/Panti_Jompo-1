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
public class Perawat_controller {

    @FXML
    private Button btnkmb;
    @FXML
    private TextField kode;
    @FXML
    private TextField nama;
    @FXML
    private TextField jenis;
    @FXML
    private TextField pasien;
    @FXML
    private Button btntmbh;
    @FXML
    private TableView<data_perawat> tbperawat;
    @FXML
    private TableColumn<data_perawat, Integer> colper;
    @FXML
    private TableColumn<data_perawat, String> colnama;
    @FXML
    private TableColumn<data_perawat, String> coljenis;
    @FXML
    private TableColumn<data_perawat, Integer> colpasien;

    @FXML
    void kembali(ActionEvent event) throws IOException {
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
    
    public ObservableList<data_perawat> getdataList(){
         ObservableList<data_perawat> datalist = FXCollections.observableArrayList();
         Connection conn = getConnection();
         String querry = "SELECT * FROM perawat";
         Statement st;
         ResultSet rs;
         try{
        st =  conn.createStatement();
        rs = st.executeQuery(querry);
        data_perawat perawat;
        while (rs.next()){
            perawat = new data_perawat(rs.getInt("id_perawat"),rs.getString("nama_perawat"),rs.getString("jenis_kelamin"),rs.getInt("id_pasien"));
            datalist.add(perawat);
        }
         }catch (Exception ex){ 
             ex.printStackTrace();
         }
         return datalist;
    }
    
    
    public void showdata(){
         ObservableList<data_perawat> list = getdataList();
         
         colper.setCellValueFactory(new PropertyValueFactory<data_perawat,Integer>("id_perawat"));
         colnama.setCellValueFactory(new PropertyValueFactory<data_perawat,String>("nama_perawat"));
         coljenis.setCellValueFactory(new PropertyValueFactory<data_perawat,String>("jenis_kelamin"));
         colpasien.setCellValueFactory(new PropertyValueFactory<data_perawat,Integer>("id_pasien"));
      
         
         tbperawat.setItems(list);
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
       String query  = "INSERT INTO perawat VALUES(" + kode.getText()+",'"+nama.getText()+"','"+jenis.getText()+"',"+pasien.getText()+")";
        executeQuery(query);
        showdata();
    }

    @FXML
    private void klik(MouseEvent event) {
    data_perawat klik = tbperawat.getSelectionModel().getSelectedItem();
    kode.setText(""+klik.getId_perawat());
    nama.setText(klik.getNama_perawat());
    jenis.setText(""+klik.getJenis_kelamin());
    pasien.setText(""+klik.getId_pasien());
    }
    
}
