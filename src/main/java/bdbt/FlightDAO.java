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
public class FlightDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public FlightDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// List
	public List<Flight> list() {
		String sql = "SELECT * FROM LOTY ORDER BY ID_LOTU";

		List<Flight> flightList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Flight.class));
		return flightList;
	}
	
	// Create
	public void save(Flight flight) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("LOTY").usingColumns("DATA_ODLOTU","DATA_PRZYLOTU","CZY_MIEDZYNARODOWY","CZY_BIZNES_KLASA", "ID_PRZEWOZNIKA", "ID_PASA", "ID_LOTNISKA_ODLOTU", "ID_LOTNISKA_PRZYLOTU", "ID_SAMOLOTU");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(flight);
		insertActor.execute(param);
	}
	
	// Read
	public Flight get(int id) {
		Object[] args = {id};
		
		String sql = "SELECT * FROM LOTY WHERE ID_LOTU = "+ args[0];
		Flight flight = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Flight.class));
		
		return flight;
	}
	
	// Update
	public void update(Flight flight) {
		String sql = "UPDATE LOTY SET data_odlotu=TO_DATE(:data_odlotu, 'YYYY MM DD HH24:MI:SS'), "
				+ "data_przylotu=TO_DATE(:data_przylotu, 'YYYY MM DD HH24:MI:SS'), czy_miedzynarodowy=:czy_miedzynarodowy,"
				+ "czy_biznes_klasa=:czy_biznes_klasa, id_przewoznika=:id_przewoznika, "
				+ "id_pasa=:id_pasa, id_lotniska_odlotu=:id_lotniska_odlotu,"
				+ "id_lotniska_przylotu=:id_lotniska_przylotu, id_samolotu=:id_samolotu "
				+ "WHERE id_lotu=:id_lotu";
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(flight);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		template.update(sql, param);
	}
	
	// Delete
	public void delete(int id) {
		String sql = "DELETE FROM LOTY WHERE id_lotu = ?";
		jdbcTemplate.update(sql, id);
	}
}
