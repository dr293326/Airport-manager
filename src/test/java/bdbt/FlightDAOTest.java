package bdbt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class FlightDAOTest {
	
	FlightDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL1");
		dataSource.setUsername("DROMANOWSKI");
		dataSource.setPassword("h>FHvtN293326");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao = new FlightDAO(new JdbcTemplate(dataSource));
	}

	@Test
	void testList() {
		List<Flight> flightList = dao.list();
		assertTrue(!flightList.isEmpty());
	}

	@Test
	void testSave() {
		//Flight flight = new Flight(0,"2020-",2 , 2);
		//dao.save(flight);
	}

	@Test
	void testGet() {
		int id = 1;
		Flight flight = dao.get(id);
		
		assertNotNull(flight);
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		int id= 43;
		dao.delete(id);
	}

}
