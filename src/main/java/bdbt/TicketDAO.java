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
public class TicketDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public TicketDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// List
	public List<Ticket> list() {
		String sql = "SELECT * FROM BILETY ORDER BY ID_BILETU";

		List<Ticket> ticketList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		return ticketList;
	}
	
	// List particular
	public List<Ticket> list(int id_pasazera) {
		String sql = "SELECT * FROM BILETY WHERE ID_PASAZERA = "+ id_pasazera +" ORDER BY ID_BILETU";

		List<Ticket> ticketList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		return ticketList;
	}
	
	// List
	public List<Ticket> listAvailable() {
		String sql = "SELECT * FROM BILETY WHERE ID_PASAZERA IS NULL ORDER BY ID_BILETU";

		List<Ticket> ticketList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		return ticketList;
	}
	
	// Create
	public void save(Ticket ticket) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("BILETY").usingColumns("CENA", "RZAD", "NR_MIEJSCA", "KLASA", "CZY_PRZY_OKNIE", "CZY_PLATNY_BAGAZ", "ID_LOTU", "ID_PASAZERA");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ticket);
		insertActor.execute(param);
	}
	
	// Read
	public Ticket get(int id) {
		Object[] args = {id};
		
		String sql = "SELECT * FROM BILETY WHERE ID_BILETU = "+ args[0];
		Ticket ticket = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Ticket.class));
		
		return ticket;
	}
	
	// Update
	public void update(Ticket ticket) {
		String sql = "UPDATE BILETY SET cena=:cena, rzad=:rzad, nr_miejsca=:nr_miejsca, klasa=:klasa, "
				+ "czy_przy_oknie=:czy_przy_oknie,"
				+ "czy_platny_bagaz=:czy_platny_bagaz, id_lotu=:id_lotu,"
				+ "id_pasazera=:id_pasazera "
				+ "WHERE id_biletu=:id_biletu";
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ticket);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		template.update(sql, param);
	}
	
	// Delete
	public void delete(int id) {
		String sql = "DELETE FROM BILETY WHERE id_biletu = ?";
		jdbcTemplate.update(sql, id);
	}
}
