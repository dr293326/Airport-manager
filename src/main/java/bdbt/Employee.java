package bdbt;

public class Employee {
	
	private int id_pracownika;
	private String imie;
	private String nazwisko;
	private String plec;
	private String pesel;
	private String data_urodzenia;
	private String nr_telefonu;
	private String nr_paszportu;
	private String nr_dowodu_osobistego;
	private String zgoda_zagranica;
	private int id_przewoznika;
	private int id_adresu;
	
	public Employee(int id_pracownika, String imie, String nazwisko, String plec, String pesel, String data_urodzenia,
			String nr_telefonu, String nr_paszportu, String nr_dowodu_osobistego, String zgoda_zagranica,
			int id_przewoznika, int id_adresu) {
		super();
		this.id_pracownika = id_pracownika;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.plec = plec;
		this.pesel = pesel;
		this.data_urodzenia = data_urodzenia;
		this.nr_telefonu = nr_telefonu;
		this.nr_paszportu = nr_paszportu;
		this.nr_dowodu_osobistego = nr_dowodu_osobistego;
		this.zgoda_zagranica = zgoda_zagranica;
		this.id_przewoznika = id_przewoznika;
		this.id_adresu = id_adresu;
	}

	public Employee() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public int getId_pracownika() {
		return id_pracownika;
	}

	public void setId_pracownika(int id_pracownika) {
		this.id_pracownika = id_pracownika;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPlec() {
		return plec;
	}

	
	public void setPlec(String plec) {
		this.plec = plec;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public String getData_urodzenia() {
		return data_urodzenia;
	}

	public void setData_urodzenia(String data_urodzenia) {
		this.data_urodzenia = data_urodzenia;
	}
	
	public String getNr_telefonu() {
		return nr_telefonu;
	}

	public void setNr_telefonu(String nr_telefonu) {
		this.nr_telefonu = nr_telefonu;
	}

	public String getNr_paszportu() {
		return nr_paszportu;
	}

	public void setNr_paszportu(String nr_paszportu) {
		this.nr_paszportu = nr_paszportu;
	}

	public String getNr_dowodu_osobistego() {
		return nr_dowodu_osobistego;
	}

	public void setNr_dowodu_osobistego(String nr_dowodu_osobistego) {
		this.nr_dowodu_osobistego = nr_dowodu_osobistego;
	}

	public String getZgoda_zagranica() {
		return zgoda_zagranica;
	}

	public void setZgoda_zagranica(String zgoda_zagranica) {
		this.zgoda_zagranica = zgoda_zagranica;
	}

	public int getId_przewoznika() {
		return id_przewoznika;
	}

	public void setId_przewoznika(int id_przewoznika) {
		this.id_przewoznika = id_przewoznika;
	}

	public int getId_adresu() {
		return id_adresu;
	}

	public void setId_adresu(int id_adresu) {
		this.id_adresu = id_adresu;
	}

	@Override
	public String toString() {
		return "Employee [id_pracownika=" + id_pracownika + ", imie=" + imie + ", nazwisko=" + nazwisko + ", plec="
				+ plec + ", pesel=" + pesel + ", data_urodzenia=" + data_urodzenia + ", nr_telefonu=" + nr_telefonu
				+ ", nr_paszportu=" + nr_paszportu + ", nr_dowodu_osobistego=" + nr_dowodu_osobistego
				+ ", zgoda_zagranica=" + zgoda_zagranica + ", id_przewoznika=" + id_przewoznika + ", id_adresu="
				+ id_adresu + "]";
	}
	
	public boolean validate() {
		
//		if (id_pracownika == 0) {
//			return false;
//		}
		
		if (imie.equals("") || imie == null) {
			return false;
		}
		
		if (nazwisko.equals("") || nazwisko == null) {
			return false;
		}
		
		if (plec.equals("") || plec == null) {
			return false;
		}
		
		if (pesel.equals("") || pesel == null) {
			return false;
		}
		
		if (data_urodzenia.equals("") || data_urodzenia == null) {
			return false;
		}
		
		if (nr_telefonu.equals("") || nr_telefonu == null) {
			return false;
		}
		
		if (nr_paszportu.equals("") || nr_paszportu == null) {
			return false;
		}
		
		if (nr_dowodu_osobistego.equals("") || nr_dowodu_osobistego == null) {
			return false;
		}
		
		if (zgoda_zagranica.equals("") || zgoda_zagranica == null) {
			return false;
		}
		
		if (id_przewoznika == 0) {
			return false;
		}
		
		if (id_przewoznika == 0) {
			return false;
		}
		
		return true;
	}

}
