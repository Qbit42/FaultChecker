package de.qbyte.faultchecker;

import static org.junit.Assert.assertEquals;

import java.util.Deque;
import java.util.Iterator;
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

		this.connect(element);
		this.faults.offerLast(element);

		return this;
	}

	public Fault cause(Class<? extends Throwable> clazz, String message) {

		FaultElement element = new FaultElement(clazz, message);

		this.connect(element);
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
			t = t.getCause();
			index++;

		} while (f != null);
	}

	private void connect(FaultElement cause) {

		Iterator<FaultElement> itr = this.faults.descendingIterator();
		while (itr.hasNext()) {
			FaultElement next = itr.next();
			
			if (!next.hasMessage) {
				String n = cause.getClazz().getName();
				String m = cause.getMessage();
				next.addMessage((m != null) ? (n + ": " + m) : n);
			}
			else
				return;
		}
		
	}

	/* ***** CLASSES ***** */

	public class FaultElement {

		/* ***** PROPERTIES ***** */

		private final Class<? extends Throwable>	clazz;
		private String								message	= null;
		private final boolean						hasMessage;

		/* ***** CONSTRUCTORS ***** */

		public FaultElement(Class<? extends Throwable> clazz) {
			this.clazz = clazz;
			this.hasMessage = false;
		}

		public FaultElement(Class<? extends Throwable> clazz, String message) {
			this.clazz = clazz;
			this.message = message;
			this.hasMessage = true;
		}

		/* ***** METHODS ***** */

		public void addMessage(String message) {
			
			if (this.message == null)
				this.message = message;
			else
				this.message += ": " + message;
		}

		/* ***** GETTER / SETTER ***** */

		public Class<? extends Throwable> getClazz() {

			return this.clazz;
		}

		public String getMessage() {

			return this.message;
		}
	}

}
