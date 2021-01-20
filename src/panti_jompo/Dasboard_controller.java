package panti_jompo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Sntn_Prnwr
 */
public class Dasboard_controller {

    @FXML
    private Button btnpj;
    @FXML
    private Button btnpr;
    @FXML
    private Button btnps;
    @FXML
    private Button btndd;
    @FXML
    private Button btnkmr;
    @FXML
    private Button btnrjg;

    @FXML
     void pj(ActionEvent event) throws IOException {
         Parent view6=FXMLLoader.load(getClass().getResource("Penanggung.fxml"));
                Scene scene6=new Scene(view6);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene6);
                window.show();
    }

    @FXML
     void perawat(ActionEvent event) throws IOException {
        Parent view6=FXMLLoader.load(getClass().getResource("perawat.fxml"));
        Scene scene6=new Scene(view6);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene6);
        window.show();
    }

    @FXML
     void pasien(ActionEvent event) throws IOException {
        Parent view6=FXMLLoader.load(getClass().getResource("Pasien.fxml"));
        Scene scene6=new Scene(view6);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene6);
        window.show();
    }

    @FXML
     void data(ActionEvent event) throws IOException {
        Parent view6=FXMLLoader.load(getClass().getResource("tampil.fxml"));
        Scene scene6=new Scene(view6);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene6);
        window.show();
    }

    @FXML
     void kamar(ActionEvent event) throws IOException {
        Parent view6=FXMLLoader.load(getClass().getResource("kamar.fxml"));
        Scene scene6=new Scene(view6);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene6);
        window.show();
    }
     
    
    @FXML
    void ranjang(ActionEvent event) throws IOException {
        Parent view6=FXMLLoader.load(getClass().getResource("ranjang.fxml"));
        Scene scene6=new Scene(view6);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene6);
        window.show();
        
    }
    
}
