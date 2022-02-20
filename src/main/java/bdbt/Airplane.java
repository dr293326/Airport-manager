package bdbt;

public class Airplane {
	private int id_samolotu;
	private String rok_produkcji;
	private int id_przewoznika;
	private int id_modelu;
	
	public Airplane(int id_samolotu, String rok_produkcji, int id_przewoznika, int id_modelu) {
		super();
		this.id_samolotu = id_samolotu;
		this.rok_produkcji = rok_produkcji;
		this.id_przewoznika = id_przewoznika;
		this.id_modelu = id_modelu;
	}
	
	public Airplane() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public int getId_samolotu() {
		return id_samolotu;
	}
	public void setId_samolotu(int id_samolotu) {
		this.id_samolotu = id_samolotu;
	}
	public String getRok_produkcji() {
		return rok_produkcji;
	}
	public void setRok_produkcji(String rok_produkcji) {
		this.rok_produkcji = rok_produkcji;
	}
	public int getId_przewoznika() {
		return id_przewoznika;
	}
	public void setId_przewoznika(int id_przewoznika) {
		this.id_przewoznika = id_przewoznika;
	}
	public int getId_modelu() {
		return id_modelu;
	}
	public void setId_modelu(int id_modelu) {
		this.id_modelu = id_modelu;
	}
	@Override
	public String toString() {
		return "Airplane [id_samolotu=" + id_samolotu + ", rok_produkcji=" + rok_produkcji + ", id_przewoznika="
				+ id_przewoznika + ", id_modelu=" + id_modelu + "]";
	}
	
	public boolean validate() {
		
		if (rok_produkcji.equals("") || rok_produkcji == null) {
			return false;
		}
		
		if (id_przewoznika == 0) {
			return false;
		}
		
		if (id_modelu == 0) {
			return false;
		}
		return true;
	}
	
}
