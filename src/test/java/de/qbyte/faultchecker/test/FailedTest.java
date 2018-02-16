package de.qbyte.faultchecker.test;

import org.junit.Rule;
import org.junit.Test;

import de.qbyte.faultchecker.Fault;
import de.qbyte.faultchecker.FaultChecker;
import de.qbyte.faultchecker.exception.Exception1;
import de.qbyte.faultchecker.exception.Exception2;
import de.qbyte.faultchecker.exception.Exception3;

public class FailedTest {
	
	@Rule
	public FaultChecker fc = new FaultChecker();

	@Test
	public void test00() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class));
		
		// don't throw exception
		
	}

	@Test
	public void o() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class));
		
		// create exception
		Exception1 exc1 = new Exception1();
		
		// throw exception
		throw exc1;
	}

	@Test
	public void m() {

		// handle exception
		
		// create exception
		Exception1 exc1 = new Exception1("first exception");
		
		// throw exception
		throw exc1;
	}

	@Test
	public void co_o() {

		// handle exception
		
		// create exception
		Exception2 exc2 = new Exception2();
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void co_m() {
		
		// handle exception
		
		// create exception
		Exception2 exc2 = new Exception2("second exception");
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void co_co_o() {
		
		// handle exception
		
		// create exception
		Exception3 exc3 = new Exception3();
		Exception2 exc2 = new Exception2(exc3);
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void co_co_m() {
		
		// handle exception
		
		// create exception
		Exception3 exc3 = new Exception3("third exception");
		Exception2 exc2 = new Exception2(exc3);
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void co_cm_o() {
		
		// handle exception
		
		// create exception
		Exception3 exc3 = new Exception3();
		Exception2 exc2 = new Exception2("second exception", exc3);
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void co_cm_m() {
		
		// handle exception
		
		// create exception
		Exception3 exc3 = new Exception3("third exception");
		Exception2 exc2 = new Exception2("second exception", exc3);
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void cm_o() {

		// handle exception
		
		// create exception
		Exception2 exc2 = new Exception2();
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void cm_m() {

		// handle exception
		
		// create exception
		Exception2 exc2 = new Exception2("second exception");
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void cm_co_o() {

		// handle exception
		
		// create exception
		Exception3 exc3 = new Exception3();
		Exception2 exc2 = new Exception2(exc3);
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void cm_co_m() {
		
		// handle exception
		
		// create exception
		Exception3 exc3 = new Exception3("third exception");
		Exception2 exc2 = new Exception2(exc3);
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void cm_cm_o() {

		// handle exception
		
		// create exception
		Exception3 exc3 = new Exception3();
		Exception2 exc2 = new Exception2("second exception", exc3);
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void cm_cm_m() {

		// handle exception
		
		// create exception
		Exception3 exc3 = new Exception3("third exception");
		Exception2 exc2 = new Exception2("second exception", exc3);
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

}
