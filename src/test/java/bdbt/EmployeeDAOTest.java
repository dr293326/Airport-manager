package bdbt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class EmployeeDAOTest {

	private EmployeeDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL1");
		dataSource.setUsername("DROMANOWSKI");
		dataSource.setPassword("h>FHvtN293326");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao = new EmployeeDAO(new JdbcTemplate(dataSource));
	}

	@Test
	void testList() {
		List<Employee> employeeList = dao.list();
		assertTrue(!employeeList.isEmpty());
	}

	@Test
	void testSave() {
		
		Employee employee = new Employee(0,"Michal", "Kichal", "M", "99082300454", "1990-01-20", "123456789", "ABC 234", "ZXC 123456", "T", 1, 1);
		dao.save(employee);
	}

	@Test
	void testGet() {
		int id = 1;
		Employee employee = dao.get(id);
		
		assertNotNull(employee);
	}

	@Test
	void testUpdate() {
		
		Employee employee = new Employee(43,"Adam","Kowalski","M","98765412312","1990-10-20","123654098","TES123","ABC432121","T",2,2);

		dao.update(employee);
	}

	@Test
	void testDelete() {
		int id= 43;
		dao.delete(id);
	}

}
