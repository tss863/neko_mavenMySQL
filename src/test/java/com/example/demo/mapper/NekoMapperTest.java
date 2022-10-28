package com.example.demo.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Neko;
import com.example.demo.service.NekoService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class
})
public class NekoMapperTest {

	@Autowired
	NekoService service;

	@Test
	@DatabaseSetup("../testData/NEKO_DEFAULTDATA.xml")
	public void getNekoListTest() {
		List<Neko> nekoList = service.getNekoList();

		Neko neko = nekoList.get(0);
		assertEquals(1, neko.getId());
		assertEquals("ねこ", neko.getName());
		assertEquals(10, neko.getAge());
		neko = nekoList.get(1);
		assertEquals(2, neko.getId());
		assertEquals("みけ", neko.getName());
		assertEquals(3, neko.getAge());
		neko = nekoList.get(2);
		assertEquals(3, neko.getId());
		assertEquals("たま", neko.getName());
		assertEquals(5, neko.getAge());
		neko = nekoList.get(3);
		assertEquals(4, neko.getId());
		assertEquals("くろ", neko.getName());
		assertEquals(2, neko.getAge());
		neko = nekoList.get(4);
		assertEquals(5, neko.getId());
		assertEquals("しろ", neko.getName());
		assertEquals(4, neko.getAge());

	}

	@Test
	@DatabaseSetup("../testData/NEKO_DEFAULTDATA.xml")
	public void insertNekoTest() {

		Neko neko = new Neko();
		neko.setId(6);
		neko.setName("ネコ");
		neko.setAge(100);

		service.insertNeko(neko);
	}

}
