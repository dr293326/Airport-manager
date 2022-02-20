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
public class AirplaneDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AirplaneDAO(JdbcTemplate jDBCTemplate) {
		super();
		jdbcTemplate = jDBCTemplate;
	}

	// List
	public List<Airplane> list() {
		String sql = "SELECT * FROM SAMOLOTY ORDER BY ID_SAMOLOTU";

		List<Airplane> airplaneList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Airplane.class));
		return airplaneList;
	}

	// Create
	public void save(Airplane airplane) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("SAMOLOTY").usingColumns("ROK_PRODUKCJI","ID_PRZEWOZNIKA","ID_MODELU");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(airplane);
		insertActor.execute(param);
	}
	
	// Read
	public Airplane get(int id) {
		Object[] args = {id};
		
		String sql = "SELECT * FROM SAMOLOTY WHERE ID_SAMOLOTU = "+ args[0];
		Airplane airplane = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Airplane.class));
		
		return airplane;
	}
	
	// Update
	public void update(Airplane airplane) {
		String sql = "UPDATE SAMOLOTY SET rok_produkcji=:rok_produkcji, "
				+ "id_przewoznika=:id_przewoznika, id_modelu=:id_modelu "
				+ "WHERE id_samolotu=:id_samolotu";
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(airplane);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		template.update(sql, param);
	}
	
	// Delete
	public void delete(int id) {
		String sql = "DELETE FROM SAMOLOTY WHERE id_samolotu = ?";
		jdbcTemplate.update(sql, id);
	}
}
