package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



import baglantiMysql.Baglanti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HaliController {

	Baglanti BaglantiOrnek=new Baglanti();
	Connection baglanti= BaglantiOrnek.baglantiAyar();
	ResultSet sonuc=null;
	Statement st=null;
   PreparedStatement ps=null;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtad;

    @FXML
    private TextField txttel;

    @FXML
    private TextField txtboyut;

    @FXML
    private TextField txtfiyat;

    @FXML
    private TextField txtdurum;

    @FXML
    private Button btnekle;

    @FXML
    private Button btnguncelle;

    @FXML
    private Button btnsil;

    @FXML
    private Button btncikis;

    @FXML
    private TableView<ModelHaliTable> tableMusteri;

    @FXML
    private TableColumn<ModelHaliTable, Integer> colid;

    @FXML
    private TableColumn<ModelHaliTable, String> colmad;

    @FXML
    private TableColumn<ModelHaliTable, String> colmtel;

    @FXML
    private TableColumn<ModelHaliTable, String> colhaliboyut;

    @FXML
    private TableColumn<ModelHaliTable, String> coltopfiyat;

    @FXML
    private TableColumn<ModelHaliTable, String> coldurum;
    
    
    ObservableList<ModelHaliTable> tmpList=FXCollections.observableArrayList();
    
    
    // Fonksiyonlar 
    
    public void Listele() {
    	try {
			sonuc=baglanti.createStatement().executeQuery("select * from halilar");
			
			while(sonuc.next()) {
				tmpList.add(new ModelHaliTable(sonuc.getInt("Id"),sonuc.getString("MusteriAd"),sonuc.getString("MusteriTelefon"),sonuc.getString("HaliBoyut"),sonuc.getString("ToplamFiyat"),sonuc.getString("Durumu")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	colid.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colmad.setCellValueFactory(new PropertyValueFactory<>("musteriad"));
    	colmtel.setCellValueFactory(new PropertyValueFactory<>("musteritel"));
    	colhaliboyut.setCellValueFactory(new PropertyValueFactory<>("haliboyut"));
    	coltopfiyat.setCellValueFactory(new PropertyValueFactory<>("toplamfiyat"));
    	coldurum.setCellValueFactory(new PropertyValueFactory<>("durum"));
    	
       
    	
    	tableMusteri.setItems(tmpList);
    }
    
    public void Temizle() {
    	for ( int i = 0; i<tableMusteri.getItems().size(); i++) {
    		tableMusteri.getItems().clear();
    	}
    }
    
    
    public void texttemizle() {
    	txtad.setText("");
    	txttel.setText("");
    	txtboyut.setText("");
    	txtfiyat.setText("");
    	txtdurum.setText("");
    	
    }
    
    

    @FXML
    void btncikis_click(ActionEvent event) {

    	System.exit(0);
    }

    @FXML
    void btnekle_click(ActionEvent event) {

    	String sorgu="insert into halilar(MusteriAd,MusteriTelefon,HaliBoyut,ToplamFiyat,Durumu) values('"+txtad.getText()+"','"+txttel.getText()+"','"+txtboyut.getText()+"','"+txtfiyat.getText()+"','"+txtdurum.getText()+"')";
    	try {
    		
    	
    		st=baglanti.createStatement();
    	    st.executeUpdate(sorgu);
    		Temizle();
		    Listele();
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	texttemizle();
    }

    @FXML
    void btnguncelle_click(ActionEvent event) {
    	
    	ModelHaliTable kayit=new ModelHaliTable();
    	kayit= (ModelHaliTable) tableMusteri.getItems().get(tableMusteri.getSelectionModel().getSelectedIndex());
    	int secilen=kayit.getId();
    	
    	String sorgu="Update halilar Set MusteriAd='"+txtad.getText() +"',MusteriTelefon='"+txttel.getText()+"',HaliBoyut='"+txtboyut.getText()+"',ToplamFiyat='"+txtfiyat.getText()+"',Durumu='"+txtdurum.getText()+"' where Id='"+secilen+"'";
    	try {
    		st=baglanti.createStatement();
    		st.executeUpdate(sorgu);
    		Temizle();
		    Listele();
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	texttemizle();

    }

    @FXML
    void btnsil_click(ActionEvent event) {
    	

    	ModelHaliTable kayit=new ModelHaliTable();
    	kayit= (ModelHaliTable) tableMusteri.getItems().get(tableMusteri.getSelectionModel().getSelectedIndex());
    	//int secilen=kayit.getId();
    	
    	String sorgu="Delete from halilar  where Id="+kayit.getId();
    	try {
    	     st=baglanti.createStatement();
    	     st.executeUpdate(sorgu);
    		Temizle();
    		Listele();
    		
		    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	texttemizle();

    }

    @FXML
    void tblmusteri_clicked(MouseEvent event) {

    	ModelHaliTable kayit=new ModelHaliTable();
    	kayit= (ModelHaliTable) tableMusteri.getItems().get(tableMusteri.getSelectionModel().getSelectedIndex());
    	
    	
    	txtad.setText(kayit.getMusteriad());
    	txttel.setText(kayit.getMusteritel());
    	txtfiyat.setText(kayit.getToplamfiyat());
    	txtboyut.setText(kayit.getHaliboyut());
    	txtdurum.setText(""+kayit.getDurum());
    }

    @FXML
    void initialize() {
      Listele();

    }
}
