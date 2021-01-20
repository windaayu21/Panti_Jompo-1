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
public class Penanggung_Controller {

    @FXML
    private Button btnkmbl;
    @FXML
    private TextField noid;
    @FXML
    private TextField nama;
    @FXML
    private TextField jenis;
    @FXML
    private TextField status;
    @FXML
    private TextField alamat;
    @FXML
    private TextField nomor;
    @FXML
    private Button btntbh;
    @FXML
    private TableView<data_pj> tbpj;
    @FXML
    private TableColumn<data_pj, Integer> colnomor;
    @FXML
    private TableColumn<data_pj, String> colnama;
    @FXML
    private TableColumn<data_pj, String> coljenis;
    @FXML
    private TableColumn<data_pj, String> colstatus;
    @FXML
    private TableColumn<data_pj, String> colalamat;
    @FXML
    private TableColumn<data_pj, Integer> colhp;

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
    
    public ObservableList<data_pj> getdataList(){
         ObservableList<data_pj> datalist = FXCollections.observableArrayList();
         Connection conn = getConnection();
         String querry = "SELECT * FROM penanggung_jawab";
         Statement st;
         ResultSet rs;
         try{
        st =  conn.createStatement();
        rs = st.executeQuery(querry);
        data_pj penanggung_jawab;
        while (rs.next()){
            penanggung_jawab = new data_pj(rs.getInt("id_pj"),rs.getString("nama_pj"),rs.getString("jenis_kelamin"),rs.getString("status_keluarga"),rs.getString("alamat"),rs.getInt("no_hp"));
            datalist.add(penanggung_jawab);
        }
         }catch (Exception ex){ 
             ex.printStackTrace();
         }
         return datalist;
    }
    
    
    public void showdata(){
         ObservableList<data_pj> list = getdataList();
         
         colnomor.setCellValueFactory(new PropertyValueFactory<data_pj,Integer>("id_pj"));
         colnama.setCellValueFactory(new PropertyValueFactory<data_pj,String>("nama_pj"));
         coljenis.setCellValueFactory(new PropertyValueFactory<data_pj,String>("jenis_kelamin"));
         colstatus.setCellValueFactory(new PropertyValueFactory<data_pj,String>("Status_keluarga"));
         colalamat.setCellValueFactory(new PropertyValueFactory<data_pj,String>("alamat"));
         colhp.setCellValueFactory(new PropertyValueFactory<data_pj,Integer>("no_hp"));

         
         tbpj.setItems(list);
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
        String query  = "INSERT INTO penanggung_jawab VALUES(" + noid.getText()+",'"+nama.getText()+"','"+jenis.getText()+"','"+status.getText()+"','"+alamat.getText()+"',"+nomor.getText()+")";
        executeQuery(query);
        showdata();
    }

    @FXML
    private void klik(MouseEvent event) {
    data_pj klik = tbpj.getSelectionModel().getSelectedItem();
    noid.setText(""+klik.getId_pj());
    nama.setText(klik.getNama_pj());
    jenis.setText(""+klik.getJenis_kelamin());
    status.setText(""+klik.getStatus_keluarga());
    alamat.setText(""+klik.getAlamat());
    nomor.setText(""+klik.getNo_hp());
    }
    
}
