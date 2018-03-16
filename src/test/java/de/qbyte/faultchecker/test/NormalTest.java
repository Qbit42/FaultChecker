package de.qbyte.faultchecker.test;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.qbyte.faultchecker.Fault;
import de.qbyte.faultchecker.FaultChecker;
import de.qbyte.faultchecker.exception.Exception1;
import de.qbyte.faultchecker.exception.Exception2;
import de.qbyte.faultchecker.exception.Exception3;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NormalTest {
	
	@Rule
	public FaultChecker fc = new FaultChecker();

	@Test
	public void t01_o() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class));
		
		// create exception
		Exception1 exc1 = new Exception1();
		
		// throw exception
		throw exc1;
	}

	@Test
	public void t02_m() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class, "first exception"));
		
		// create exception
		Exception1 exc1 = new Exception1("first exception");
		
		// throw exception
		throw exc1;
	}

	@Test
	public void t03_co_o() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class).cause(Exception2.class));
		
		// create exception
		Exception2 exc2 = new Exception2();
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void t04_co_m() {
		
		// handle exception
		this.fc.expect(new Fault(Exception1.class).cause(Exception2.class, "second exception"));
		
		// create exception
		Exception2 exc2 = new Exception2("second exception");
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void t05_co_co_o() {
		
		// handle exception
		this.fc.expect(new Fault(Exception1.class).cause(Exception2.class).cause(Exception3.class));
		
		// create exception
		Exception3 exc3 = new Exception3();
		Exception2 exc2 = new Exception2(exc3);
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void t06_co_co_m() {
		
		// handle exception
		this.fc.expect(new Fault(Exception1.class).cause(Exception2.class).cause(Exception3.class, "third exception"));
		
		// create exception
		Exception3 exc3 = new Exception3("third exception");
		Exception2 exc2 = new Exception2(exc3);
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void t07_co_cm_o() {
		
		// handle exception
		this.fc.expect(new Fault(Exception1.class).cause(Exception2.class, "second exception").cause(Exception3.class));
		
		// create exception
		Exception3 exc3 = new Exception3();
		Exception2 exc2 = new Exception2("second exception", exc3);
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void t08_co_cm_m() {
		
		// handle exception
		this.fc.expect(new Fault(Exception1.class).cause(Exception2.class, "second exception").cause(Exception3.class, "third exception"));
		
		// create exception
		Exception3 exc3 = new Exception3("third exception");
		Exception2 exc2 = new Exception2("second exception", exc3);
		Exception1 exc1 = new Exception1(exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void t09_cm_o() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class, "first exception").cause(Exception2.class));
		
		// create exception
		Exception2 exc2 = new Exception2();
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void t10_cm_m() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class, "first exception").cause(Exception2.class, "second exception"));
		
		// create exception
		Exception2 exc2 = new Exception2("second exception");
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void t11_cm_co_o() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class, "first exception").cause(Exception2.class).cause(Exception3.class));
		
		// create exception
		Exception3 exc3 = new Exception3();
		Exception2 exc2 = new Exception2(exc3);
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}
	
	@Test
	public void t12_cm_co_m() {
		
		// handle exception
		this.fc.expect(new Fault(Exception1.class, "first exception").cause(Exception2.class).cause(Exception3.class, "third exception"));
		
		// create exception
		Exception3 exc3 = new Exception3("third exception");
		Exception2 exc2 = new Exception2(exc3);
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void t13_cm_cm_o() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class, "first exception").cause(Exception2.class, "second exception").cause(Exception3.class));
		
		// create exception
		Exception3 exc3 = new Exception3();
		Exception2 exc2 = new Exception2("second exception", exc3);
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

	@Test
	public void t14_cm_cm_m() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class, "first exception").cause(Exception2.class, "second exception").cause(Exception3.class, "third exception"));
		
		// create exception
		Exception3 exc3 = new Exception3("third exception");
		Exception2 exc2 = new Exception2("second exception", exc3);
		Exception1 exc1 = new Exception1("first exception", exc2);
		
		// throw exception
		throw exc1;
	}

}
