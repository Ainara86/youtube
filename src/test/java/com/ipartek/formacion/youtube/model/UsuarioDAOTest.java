package com.ipartek.formacion.youtube.model;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioDAOTest {

	private static UsuarioDAO dao = null;
	private static Usuario uMock = null;
	private static final String NOMBRE = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	private static final String PASSWORD = "aaaaaaaaaaaaaaaaaaaa";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = UsuarioDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		uMock = new Usuario(NOMBRE, PASSWORD);
		assertTrue("Deberia haber insertado un usuario Mock",dao.insert(uMock));
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(uMock.getId());
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public void testInsert() {
		assertFalse("usuario null", dao.insert(null));
		assertFalse("usuario repetido", dao.insert(uMock));
		
		// probar nombre, password, rol =null
		uMock.setNombre(null);
		assertFalse("nombre null", dao.insert(null));
		
		uMock.setPassword(null);
		assertFalse("password null", dao.insert(null));
		
		uMock.setNombre(NOMBRE+"1");//51 caractes
		assertFalse("nombre >50", dao.insert(null));
		
		uMock.setPassword(PASSWORD+"1");//21caracteres
		assertFalse("nombre >20", dao.insert(null));
		
	
		
		
		//insert correcta lo comprobamos en el SetUp()
	}

}
