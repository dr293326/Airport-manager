package bdbt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class TicketDAOTest {

	TicketDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL1");
		dataSource.setUsername("DROMANOWSKI");
		dataSource.setPassword("h>FHvtN293326");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao = new TicketDAO(new JdbcTemplate(dataSource));
	}

	@Test
	void testList() {
		List<Ticket> ticketList = dao.list();
		assertTrue(!ticketList.isEmpty());
	}
	
	@Test
	void testList2() {
		List<Ticket> ticketList = dao.list(1);
		assertTrue(!ticketList.isEmpty());
	}
	
	@Test
	void testListAvailable() {
		List<Ticket> ticketList = dao.listAvailable();
		assertTrue(!ticketList.isEmpty());
	}

	@Test
	void testSave() {
		Ticket ticket = new Ticket(0,300 ,3, 1, "biznes", "T", "T", 3, 1);
		dao.save(ticket);
	}

	@Test
	void testGet() {
		int id = 1;
		Ticket ticket = dao.get(id);
		
		assertNotNull(ticket);
	}

	@Test
	void testUpdate() {
		Ticket ticket = new Ticket(21,400 ,3, 1, "biznes", "T", "T", 3, 1);
		dao.update(ticket);
	}

	@Test
	void testDelete() {
		int id= 43;
		dao.delete(id);
	}

}
