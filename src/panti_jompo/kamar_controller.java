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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sntn_Prnwr
 */
public class kamar_controller {

    @FXML
    private Button btnkmb;
    @FXML
    private Button btntmbh;
    @FXML
    private TextField nomor;
    @FXML
    private TextField nama;
    @FXML
    private TextField pasien;
    @FXML
    private TextField identitas;
    @FXML
    private TextField kapasitas;
    @FXML
    private TableView<data_kamar> tbkamar;
    @FXML
    private TableColumn<data_kamar, Integer> colkamar;
    @FXML
    private TableColumn<data_kamar, String> colnama;
    @FXML
    private TableColumn<data_kamar, Integer> colkapasitas;
    @FXML
    private TableColumn<data_kamar, Integer> colpasien;
    @FXML
    private TableColumn<data_kamar, Integer> colidentitas;
    @FXML
    private Button btnupdate;

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
    
    public ObservableList<data_kamar> getdataList(){
         ObservableList<data_kamar> datalist = FXCollections.observableArrayList();
         Connection conn = getConnection();
         String querry = "SELECT * FROM kamar";
         Statement st;
         ResultSet rs;
         try{
        st =  conn.createStatement();
        rs = st.executeQuery(querry);
        data_kamar kamar;
        while (rs.next()){
            kamar = new data_kamar(rs.getInt("no_kamar"),rs.getString("nama_kamar"),rs.getInt("kapasitas"),rs.getInt("id_pasien"),rs.getInt("id_pj"));
            datalist.add(kamar);
        }
         }catch (Exception ex){ 
             ex.printStackTrace();
         }
         return datalist;
    }
    
    
    public void showdata(){
         ObservableList<data_kamar> list = getdataList();
         
         colkamar.setCellValueFactory(new PropertyValueFactory<data_kamar,Integer>("no_kamar"));
         colnama.setCellValueFactory(new PropertyValueFactory<data_kamar,String>("nama_kamar"));
         colkapasitas.setCellValueFactory(new PropertyValueFactory<data_kamar,Integer>("kapasitas"));
         colpasien.setCellValueFactory(new PropertyValueFactory<data_kamar,Integer>("id_pasien"));
         colidentitas.setCellValueFactory(new PropertyValueFactory<data_kamar,Integer>("id_pj"));


         
         tbkamar.setItems(list);
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
        String query  = "INSERT INTO kamar VALUES(" + nomor.getText()+",'"+nama.getText()+"',"+kapasitas.getText()+","+pasien.getText()+","+identitas.getText()+")";
        executeQuery(query);
        showdata();
    }

    @FXML
    private void update(ActionEvent event) {
        String query = "UPDATE kamar SET kapasitas = '"+kapasitas.getText()+ "'WHERE no_kamar = "+nomor.getText()+"";
        executeQuery(query);
        showdata();
    }

    @FXML
    private void klik(MouseEvent event) {
    data_kamar klik = tbkamar.getSelectionModel().getSelectedItem();
    nomor.setText(""+klik.getNo_kamar());
    nama.setText(klik.getNama_kamar());
    pasien.setText(""+klik.getId_pasien());
    identitas.setText(""+klik.getId_pj());
    kapasitas.setText(""+klik.getKapasitas());

    }
    }
    

