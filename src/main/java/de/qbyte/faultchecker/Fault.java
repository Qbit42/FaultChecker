package de.qbyte.faultchecker;

import static org.junit.Assert.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

public class Fault {

	/* ***** PROPERTIES ***** */

	private final Deque<FaultElement> faults = new LinkedList<>();

	/* ***** CONSTRUCTORS ***** */

	public Fault(Class<? extends Throwable> clazz) {

		FaultElement element = new FaultElement(clazz);

		this.faults.offerLast(element);
	}

	public Fault(Class<? extends Throwable> clazz, String message) {

		FaultElement element = new FaultElement(clazz, message);

		this.faults.offerLast(element);
	}

	/* ***** CONSTRUCTOR EXTENTIONS ***** */

	public Fault cause(Class<? extends Throwable> clazz) {

		FaultElement element = new FaultElement(clazz);

		this.faults.peekLast().connect(element);
		this.faults.offerLast(element);

		return this;
	}

	public Fault cause(Class<? extends Throwable> clazz, String message) {

		FaultElement element = new FaultElement(clazz, message);

		this.faults.peekLast().connect(element);
		this.faults.offerLast(element);

		return this;
	}

	/* ***** METHODS ***** */

	public void compare(Throwable e) {

		FaultElement f = this.faults.pollFirst();
		Throwable t = e;
		int index = 1;
		
		do {
			
			assertEquals(index + " Class:", f.getClazz(), t.getClass());
			assertEquals(index + " Message:", f.getMessage(), t.getMessage());
			
			f = this.faults.pollFirst();
			t = e.getCause();
			index++;
			
		} while (f != null);
	}

	/* ***** CLASSES ***** */

	public class FaultElement {

		/* ***** PROPERTIES ***** */

		private final Class<? extends Throwable>	clazz;
		private String								message	= null;

		/* ***** CONSTRUCTORS ***** */

		public FaultElement(Class<? extends Throwable> clazz) {
			this.clazz = clazz;
		}

		public FaultElement(Class<? extends Throwable> clazz, String message) {
			this.clazz = clazz;
			this.message = message;
		}

		/* ***** METHODS ***** */

		public void connect(FaultElement cause) {

			if (this.message == null) {
				String n = cause.getClazz().getName();
				String m = cause.getMessage();
				this.message = (m != null) ? (n + ": " + m) : n;
			}
		}

		/* ***** GETTER / SETTER ***** */

		public Class<? extends Throwable> getClazz() {

			return this.clazz;
		}

		public String getMessage() {

			return this.message;
		}

		public void setMessage(String message) {

			this.message = message;
		}
	}

}
