package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import baglantiMysql.Baglanti;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SampleController {
	
	Baglanti BaglantiOrnek=new Baglanti();
	Connection baglanti= BaglantiOrnek.baglantiAyar();
	ResultSet sonuc=null;
	PreparedStatement ps=null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btngiris;

    @FXML
    private TextField txtkadi;

    @FXML
    private PasswordField txtsifre;

    @FXML
    void btngiris_click(ActionEvent event) {
    	  String sorgu= "select * from users where KullaniciAd=? and Sifre=? ";
          try {
   		ps=baglanti.prepareStatement(sorgu);
   		ps.setString(1, txtkadi.getText());
   		ps.setString(2, txtsifre.getText());
   		sonuc=ps.executeQuery();
   		
   		
   		if(!sonuc.next()) {
   			System.out.println("Kullanici Adin veya Parolan Yanlýþ");
   		}
   		
   		
   		else {
   			
   			Stage stage1=new Stage();
   			AnchorPane pane1;
   			try {
   				pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("Hali.fxml"));
   				Scene scene1=new Scene(pane1);
   				stage1.setScene(scene1);
   				stage1.show();
   			} catch (IOException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   			
   			
   		}
   		
   		
   		
   	} catch (SQLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
          

       }

    

    

    @FXML
    void initialize() {
     }
    
}
