package bdbt;

public class Flight {
	private int id_lotu;
	private String data_odlotu;
	private String data_przylotu;
	private String czy_miedzynarodowy;
	private String czy_biznes_klasa;
	private int id_przewoznika;
	private int id_pasa;
	private int id_lotniska_odlotu;
	private int id_lotniska_przylotu;
	private int id_samolotu;
	
	
	public Flight() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public Flight(int id_lotu, String data_odlotu, String data_przylotu, String czy_miedzynarodowy,
			String czy_biznes_klasa, int id_przewoznika, int id_pasa, int id_lotniska_odlotu, int id_lotniska_przylotu,
			int id_samolotu) {
		super();
		this.id_lotu = id_lotu;
		this.data_odlotu = data_odlotu;
		this.data_przylotu = data_przylotu;
		this.czy_miedzynarodowy = czy_miedzynarodowy;
		this.czy_biznes_klasa = czy_biznes_klasa;
		this.id_przewoznika = id_przewoznika;
		this.id_pasa = id_pasa;
		this.id_lotniska_odlotu = id_lotniska_odlotu;
		this.id_lotniska_przylotu = id_lotniska_przylotu;
		this.id_samolotu = id_samolotu;
	}
	
	public int getId_lotu() {
		return id_lotu;
	}
	public void setId_lotu(int id_lotu) {
		this.id_lotu = id_lotu;
	}
	public String getData_odlotu() {
		return data_odlotu;
	}
	public void setData_odlotu(String data_odlotu) {
		this.data_odlotu = data_odlotu;
	}
	public String getData_przylotu() {
		return data_przylotu;
	}
	public void setData_przylotu(String data_przylotu) {
		this.data_przylotu = data_przylotu;
	}
	public String getCzy_miedzynarodowy() {
		return czy_miedzynarodowy;
	}
	public void setCzy_miedzynarodowy(String czy_miedzynarodowy) {
		this.czy_miedzynarodowy = czy_miedzynarodowy;
	}
	public String getCzy_biznes_klasa() {
		return czy_biznes_klasa;
	}
	public void setCzy_biznes_klasa(String czy_biznes_klasa) {
		this.czy_biznes_klasa = czy_biznes_klasa;
	}
	public int getId_przewoznika() {
		return id_przewoznika;
	}
	public void setId_przewoznika(int id_przewoznika) {
		this.id_przewoznika = id_przewoznika;
	}
	public int getId_pasa() {
		return id_pasa;
	}
	public void setId_pasa(int id_pasa) {
		this.id_pasa = id_pasa;
	}
	public int getId_lotniska_odlotu() {
		return id_lotniska_odlotu;
	}
	public void setId_lotniska_odlotu(int id_lotniska_odlotu) {
		this.id_lotniska_odlotu = id_lotniska_odlotu;
	}
	public int getId_lotniska_przylotu() {
		return id_lotniska_przylotu;
	}
	public void setId_lotniska_przylotu(int id_lotniska_przylotu) {
		this.id_lotniska_przylotu = id_lotniska_przylotu;
	}
	public int getId_samolotu() {
		return id_samolotu;
	}
	public void setId_samolotu(int id_samolotu) {
		this.id_samolotu = id_samolotu;
	}
	
	@Override
	public String toString() {
		return "Flight [id_lotu=" + id_lotu + ", data_odlotu=" + data_odlotu + ", data_przylotu=" + data_przylotu
				+ ", czy_miedzynarodowy=" + czy_miedzynarodowy + ", czy_biznes_klasa=" + czy_biznes_klasa
				+ ", id_przewoznika=" + id_przewoznika + ", id_pasa=" + id_pasa + ", id_lotniska_odlotu="
				+ id_lotniska_odlotu + ", id_lotniska_przylotu=" + id_lotniska_przylotu + ", id_samolotu=" + id_samolotu
				+ "]";
	}

	public boolean validate() {

		
		if (data_odlotu.equals("") || data_odlotu == null) {
			return false;
		}
		
		if (data_przylotu.equals("") || data_przylotu == null) {
			return false;
		}
		
		if (czy_miedzynarodowy.equals("") || czy_miedzynarodowy == null) {
			return false;
		}
		
		if (czy_biznes_klasa.equals("") || czy_biznes_klasa == null) {
			return false;
		}
		
		if (id_przewoznika == 0) {
			return false;
		}
		
		if (id_pasa == 0) {
			return false;
		}
		
		if (id_lotniska_przylotu == 0) {
			return false;
		}
		
		if (id_lotniska_odlotu == 0) {
			return false;
		}
		
		if (id_samolotu == 0) {
			return false;
		}
		return true;
	}
	
}
