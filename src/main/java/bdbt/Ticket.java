package bdbt;

public class Ticket {
	private int id_biletu;
	private int cena;
	private int rzad;
	private int nr_miejsca;
	private String klasa;
	private String czy_przy_oknie;
	private String czy_platny_bagaz;
	private int id_lotu;
	private Integer id_pasazera;
	
	
	
	public Ticket(int id_biletu, int cena, int rzad, int nr_miejsca, String klasa, String czy_przy_oknie,
			String czy_platny_bagaz, int id_lotu, Integer id_pasazera) {
		super();
		this.id_biletu = id_biletu;
		this.cena = cena;
		this.rzad = rzad;
		this.nr_miejsca = nr_miejsca;
		this.klasa = klasa;
		this.czy_przy_oknie = czy_przy_oknie;
		this.czy_platny_bagaz = czy_platny_bagaz;
		this.id_lotu = id_lotu;
		this.id_pasazera = id_pasazera;
	}
	
	public Ticket() {
		//super();
		// TODO Auto-generated constructor stub
	}

	
	public int getId_biletu() {
		return id_biletu;
	}
	public void setId_biletu(int id_biletu) {
		this.id_biletu = id_biletu;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public int getRzad() {
		return rzad;
	}
	public void setRzad(int rzad) {
		this.rzad = rzad;
	}
	public int getNr_miejsca() {
		return nr_miejsca;
	}
	public void setNr_miejsca(int nr_miejsca) {
		this.nr_miejsca = nr_miejsca;
	}
	public String getKlasa() {
		return klasa;
	}
	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}
	public String getCzy_przy_oknie() {
		return czy_przy_oknie;
	}
	public void setCzy_przy_oknie(String czy_przy_oknie) {
		this.czy_przy_oknie = czy_przy_oknie;
	}
	public String getCzy_platny_bagaz() {
		return czy_platny_bagaz;
	}
	public void setCzy_platny_bagaz(String czy_platny_bagaz) {
		this.czy_platny_bagaz = czy_platny_bagaz;
	}
	public int getId_lotu() {
		return id_lotu;
	}
	public void setId_lotu(int id_lotu) {
		this.id_lotu = id_lotu;
	}
	public Integer getId_pasazera() {
		return id_pasazera;
	}
	public void setId_pasazera(Integer id_pasazera) {
		this.id_pasazera = id_pasazera;
	}

	@Override
	public String toString() {
		return "Ticket [id_biletu=" + id_biletu + ", cena=" + cena + ", rzad=" + rzad + ", nr_miejsca=" + nr_miejsca
				+ ", klasa=" + klasa + ", czy_przy_oknie=" + czy_przy_oknie + ", czy_platny_bagaz=" + czy_platny_bagaz
				+ ", id_lotu=" + id_lotu + ", id_pasazera=" + id_pasazera + "]";
	}
	
	public boolean validate() {
		
		if (cena == 0) {
			return false;
		}
		
		if (rzad == 0) {
			return false;
		}
		
		if (nr_miejsca == 0) {
			return false;
		}
		
		if (klasa.equals("") || klasa == null) {
			return false;
		}
		
		if (czy_przy_oknie.equals("") || czy_przy_oknie == null) {
			return false;
		}
		
		if (czy_platny_bagaz.equals("") || czy_platny_bagaz == null) {
			return false;
		}
		
		if (id_lotu == 0) {
			return false;
		}
		
		if (id_pasazera == 0) {
			return false;
		}
		return true;
	}
	
}
