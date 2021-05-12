package dog_shoppingmall_proj.impl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dog_shoppingmall_proj.dto.Dog;
import dog_shoppingmall_proj.util.JdbcUtil;

public class DogDaoImplTest {
	private static Connection con = JdbcUtil.getConnection();
	private static DogDaoImpl dao = DogDaoImpl.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

//	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSetCon() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectDogList() {
		System.out.printf("%s()%n","testSelectDogList");
		List<Dog> dogList = dao.selectDogList();
		Assert.assertNotNull(dogList);
		for(Dog d: dogList) {
			System.out.println(d);
		}
	}

	@Test
	public void testSelectDog() {
		System.out.printf("%s()%n", "testSelectDog");
		int dog = 1;
		Dog searchDog = dao.selectDog(dog);
		Assert.assertNotNull(searchDog);
		System.out.println(searchDog);
	}

	@Test
	public void testInsertDog() {
		System.out.printf("%s()%n", "testInsertDog");
		Dog newDog = new Dog(5, "비숑", 5000, "shong.jpg", "프랑스", 1 , 20 , "귀엽다", 0);
		int res = dao.insertDog(newDog);
		Assert.assertEquals(1, res);
	}

	@Test
	public void testUpdateReadCount() {
		System.out.printf("%s()%n", "testUpdateReadCount");
		int res = dao.updateReadCount(1);
		Assert.assertEquals(1, res);
		System.out.println("res >>" +res);
		
	}

}
