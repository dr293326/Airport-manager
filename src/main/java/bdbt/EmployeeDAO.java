package bdbt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public EmployeeDAO(JdbcTemplate jDBCTemplate) {
		super();
		jdbcTemplate = jDBCTemplate;
	}
	
	/* List */
	public List<Employee> list() {
		String sql = "SELECT * FROM PRACOWNICY ORDER BY ID_PRACOWNIKA";
		
		List<Employee> employeeList = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(Employee.class));
		return employeeList;
	}

	// Create
	public void save(Employee employee) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("PRACOWNICY").usingColumns("IMIE","NAZWISKO","PLEC","PESEL","DATA_URODZENIA","NR_TELEFONU","NR_PASZPORTU","NR_DOWODU_OSOBISTEGO","ZGODA_ZAGRANICA","ID_PRZEWOZNIKA","ID_ADRESU");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		insertActor.execute(param);
	}

	// Read
	public Employee get(int id) {
		Object[] args = {id};
		
		String sql = "SELECT * FROM PRACOWNICY WHERE ID_PRACOWNIKA = "+ args[0];
		Employee employee = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Employee.class));
		
		return employee;
	}


	// Update
	public void update(Employee employee) {
		String sql = "UPDATE PRACOWNICY SET imie=:imie, nazwisko=:nazwisko,"
				+ "plec=:plec, pesel=:pesel, data_urodzenia=TO_DATE(:data_urodzenia, 'YYYY MM DD HH24:MI:SS'), "
				+ "nr_telefonu=:nr_telefonu, nr_paszportu=:nr_paszportu, "
				+ "nr_dowodu_osobistego=:nr_dowodu_osobistego, "
				+ "zgoda_zagranica=:zgoda_zagranica, id_przewoznika=:id_przewoznika, "
				+ "id_adresu=:id_adresu WHERE id_pracownika=:id_pracownika";
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		template.update(sql, param);
		
	}

	// Delete
	public void delete(int id) {
		String sql = "DELETE FROM PRACOWNICY WHERE id_pracownika = ?";
		jdbcTemplate.update(sql, id);
	}
}
