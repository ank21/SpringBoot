package com.stock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stock.model.Company;
import com.stock.repository.CompanyRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringJPATest {

	@Autowired
	TestEntityManager tm;
	@Autowired
	CompanyRepo crepo;
	
	
	@Test
	public void findByName() {
		
		Company cm=new Company();
		cm.setSymbol("pi");
		cm.setCname("1347");
		Company t=tm.persist(cm);
		
		Company te=crepo.findOne(t.getSymbol());
		System.out.println(te.getCname());
		assertEquals(cm.getCname(),te.getCname());
	}
}
