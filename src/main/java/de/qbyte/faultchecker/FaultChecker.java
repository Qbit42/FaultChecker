package de.qbyte.faultchecker;

import static org.junit.Assert.fail;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class FaultChecker implements TestRule {

	/* ***** PROPERTIES ***** */

	private Fault fault = null;

	/* ***** METHODS ***** */

	public void expect(Fault fault) {

		this.fault = fault;
	}

	public Statement apply(Statement base, Description description) {

		return new Statement() {
			@Override
			public void evaluate() throws Throwable {

				// execute test case
				try {
					base.evaluate();
				}
				
				// exception was thrown
				catch (Throwable e) {
					
					// exception expected
					if (hasFault())
						compareFault(e);
					
					// exception not expected
					else
						throw e;
					
					// finish evaluation
					return;
				}
				
				// no exception was thrown, but expected
				if (hasFault())
					fail("missing exception");
			}
		};
	}

	private boolean hasFault() {

		return this.fault != null;
	}

	private void compareFault(Throwable e) {

		this.fault.compare(e);
	}

}
