package baglantiMysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Baglanti {
    public Connection baglanti;
	public Connection baglantiAyar() {
	
		
		//String UserName="root";
		//String Password="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//String url=+DbName+UserName+Password;
			
			baglanti=DriverManager.getConnection("jdbc:mysql://localhost/haliyikama?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baglanti;
	}
}
