package repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.massifsource.sync.db.h2.model.Directory;
import com.massifsource.sync.db.h2.repository.DirectoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/db-beans.xml" })
public class TestRepository {

	@Autowired
	@Qualifier("directoryRepository")
	private DirectoryRepository directoryRepository;
	
	@Test
	public void testSimpleQuery() {
		assertEquals(4, directoryRepository.findAll().size());
	}
	
	@Test
	public void testInsert() {
		directoryRepository.save(new Directory ("test 5"));
		assertEquals(5, directoryRepository.findAll().size());
	}

}

