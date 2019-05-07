package org.ics.test;

import org.ics.facade.FacadeLocal;
import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.TestCase;

public class TestCaseBean extends TestCase {

	FacadeLocal facade;

	public TestCaseBean(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext();
		facade=(FacadeLocal)context.lookup("java:global/MovRewEAR/MovieReviewProject/Facade!org.ics.facade.FacadeLocal");

	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		facade=null;
	}
	public void testFacadeFindByMovieName() throws Exception {
		facade.findByMovieName("Drive");

	}
	public void testFacadeCreateReview2() throws Exception {
		facade.createReview2("Drive", 9);

	}
}
