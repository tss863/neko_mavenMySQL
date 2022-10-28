package com.example.demo.domain;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class NekoTest {
	@Test
	public void testGet() throws Exception {
		Neko neko = new Neko();
		int id = 6;
		String name = new String("ねこ");
		int age = 15;

		//(A-1)
		java.lang.reflect.Field nameField = neko.getClass().getDeclaredField("name"); //(1)
		nameField.setAccessible(true); //(2)
		nameField.set(neko, name); //(3)x
		java.lang.reflect.Field idField = neko.getClass().getDeclaredField("id"); //(1)
		idField.setAccessible(true); //(2)
		idField.set(neko, id); //(3)
		java.lang.reflect.Field ageField = neko.getClass().getDeclaredField("age"); //(1)
		ageField.setAccessible(true); //(2)
		ageField.set(neko, age); //(3)

		//(A-2)
		assertEquals(name, neko.getName());
		assertEquals(id, neko.getId());
		assertEquals(age, neko.getAge());
	}

	@Test
	public void testSet() throws Exception {
		Neko neko = new Neko();
		int id = 6;
		String name = new String("ねこ");
		int age = 15;

		//(B-1)
		Field nameField = neko.getClass().getDeclaredField("name"); //(1)
		nameField.setAccessible(true); //(2)
		neko.setName(name);
		Field idField = neko.getClass().getDeclaredField("id"); //(1)
		idField.setAccessible(true); //(2)
		neko.setId(id);
		Field ageField = neko.getClass().getDeclaredField("age"); //(1)
		ageField.setAccessible(true); //(2)
		neko.setAge(age);

		//(B-2)
		assertEquals(name, (String) nameField.get(neko)); //(3)
		assertEquals(id, idField.get(neko)); //(3)
		assertEquals(age, ageField.get(neko)); //(3)
	}

}
