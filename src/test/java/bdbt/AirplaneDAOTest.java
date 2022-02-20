package bdbt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class AirplaneDAOTest {

	AirplaneDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL1");
		dataSource.setUsername("DROMANOWSKI");
		dataSource.setPassword("h>FHvtN293326");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao = new AirplaneDAO(new JdbcTemplate(dataSource));
	}

	@Test
	void testList() {
		List<Airplane> airplaneList = dao.list();
		assertTrue(!airplaneList.isEmpty());
	}

	@Test
	void testSave() {
		Airplane airplane = new Airplane(0,"2020",2 , 2);
		dao.save(airplane);
	}

	@Test
	void testGet() {
		int id = 1;
		Airplane airplane = dao.get(id);
		
		assertNotNull(airplane);
	}

	@Test
	void testUpdate() {
		Airplane airplane = new Airplane(1,"2012",1,1);

		dao.update(airplane);
	}

	@Test
	void testDelete() {
		int id= 43;
		dao.delete(id);
	}

}
