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
	
	@Rule
	public FaultChecker bla = new FaultChecker();

	@Test
	public void test00() {

		// handle exception
		this.fc.expect(new Fault(Exception1.class));
//		this.bla.expect(new Fault(AssertionError.class));
		
		// don't throw exception
		
	}

}
