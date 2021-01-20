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
public class Pasien_Controller {

    @FXML
    private Button btnkmb;
    @FXML
    private TextField noid;
    @FXML
    private TextField nama;
    @FXML
    private TextField jenis;
    @FXML
    private TextField umur;
    @FXML
    private TextField masuk;
    @FXML
    private TextField lahir;
    @FXML
    private TextField status;
    @FXML
    private TextField nopj;
    @FXML
    private Button btntmbh;
    @FXML
    private TableView<data_pasien> tbpasien;
    @FXML
    private TableColumn<data_pasien, Integer> colpas;
    @FXML
    private TableColumn<data_pasien, String> colnama;
    @FXML
    private TableColumn<data_pasien, String> coljenis;
    @FXML
    private TableColumn<data_pasien, Integer> columur;
    @FXML
    private TableColumn<data_pasien, String> colmasuk;
    @FXML
    private TableColumn<data_pasien, String> collahir;
    @FXML
    private TableColumn<data_pasien, String> colstatus;
    @FXML
    private TableColumn<data_pasien, Integer> colpj;
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
    
    public ObservableList<data_pasien> getdataList(){
         ObservableList<data_pasien> datalist = FXCollections.observableArrayList();
         Connection conn = getConnection();
         String querry = "SELECT * FROM pasien";
         Statement st;
         ResultSet rs;
         try{
        st =  conn.createStatement();
        rs = st.executeQuery(querry);
        data_pasien pasien;
        while (rs.next()){
            pasien = new data_pasien(rs.getInt("id_pasien"),rs.getString("nama_pasien"),rs.getString("jenis_kelamin"),rs.getInt("umur"),rs.getString("tanggal_masuk"),rs.getString("tanggal_lahir"),rs.getString("status"),rs.getInt("id_pj"));
            datalist.add(pasien);
        }
         }catch (Exception ex){ 
             ex.printStackTrace();
         }
         return datalist;
    }
    
    
    public void showdata(){
         ObservableList<data_pasien> list = getdataList();
         
         colpas.setCellValueFactory(new PropertyValueFactory<data_pasien,Integer>("id_pasien"));
         colnama.setCellValueFactory(new PropertyValueFactory<data_pasien,String>("nama_pasien"));
         coljenis.setCellValueFactory(new PropertyValueFactory<data_pasien,String>("jenis_kelamin"));
         columur.setCellValueFactory(new PropertyValueFactory<data_pasien,Integer>("umur"));
         colmasuk.setCellValueFactory(new PropertyValueFactory<data_pasien,String>("tanggal_masuk"));
         collahir.setCellValueFactory(new PropertyValueFactory<data_pasien,String>("tanggal_lahir"));
         colstatus.setCellValueFactory(new PropertyValueFactory<data_pasien,String>("status"));
         colpj.setCellValueFactory(new PropertyValueFactory<data_pasien,Integer>("id_pj"));

         
         tbpasien.setItems(list);
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
    void tambah(ActionEvent event) {
        String query  = "INSERT INTO pasien VALUES("+noid.getText()+",'"+nama.getText()+ "','"+jenis.getText()+"',"+umur.getText()+ ",'"+masuk.getText()+"','"+lahir.getText()+"','"+status.getText()+"',"+nopj.getText()+")";
        executeQuery(query);
        showdata();
    }

    @FXML
    private void update(ActionEvent event) {
        String query = "UPDATE pasien SET status = '"+status.getText()+ "'WHERE id_pasien = "+noid.getText()+"";
        executeQuery(query);
        showdata();
    }

    @FXML
    private void klik(MouseEvent event) {
    data_pasien klik = tbpasien.getSelectionModel().getSelectedItem();
    noid.setText(""+klik.getId_pasien());
    nama.setText(klik.getNama_pasien());
    jenis.setText(klik.getJenis_kelamin());
    umur.setText(""+klik.getUmur());
    masuk.setText(klik.getTanggal_masuk());
    lahir.setText(klik.getTanggal_lahir());
    status.setText(klik.getStatus());
    nopj.setText(""+klik.getId_pj());
    }
    
    }


