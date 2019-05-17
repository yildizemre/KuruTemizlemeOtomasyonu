package application;

public class ModelHaliTable {
	
	
	int id;
	String musteriad, musteritel,haliboyut,toplamfiyat,durum;
	
public ModelHaliTable(int id, String musteriad,String musteritel,String haliboyut,String toplamfiyat,String durum) {
		this.setId(id);
		this.setMusteriad(musteriad);
		this.setHaliboyut(haliboyut);
		this.setMusteritel(musteritel);
		this.setToplamfiyat(toplamfiyat);
		this.setDurum(durum);
	}
	
	
	public ModelHaliTable() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMusteriad() {
		return musteriad;
	}
	public void setMusteriad(String musteriad) {
		this.musteriad = musteriad;
	}
	public String getMusteritel() {
		return musteritel;
	}
	public void setMusteritel(String musteritel) {
		this.musteritel = musteritel;
	}
	public String getHaliboyut() {
		return haliboyut;
	}
	public void setHaliboyut(String haliboyut) {
		this.haliboyut = haliboyut;
	}
	public String getToplamfiyat() {
		return toplamfiyat;
	}
	public void setToplamfiyat(String toplamfiyat) {
		this.toplamfiyat = toplamfiyat;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}

	
	
}
