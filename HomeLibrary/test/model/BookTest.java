package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
	Book a;
	Book b;
	@Before
	public void SetUp() {
		a = new Book("aa","aa","aa",0,true,0);
		b = new Book("aa","aa","aa",0,true,0);
		a.setResultNum(0);
		b.setResultNum(1);
	}
	@Test
	public void testEquals() {
		Boolean expected = true;
		Boolean result = a.equals(b);
		Assert.assertEquals(expected, result);
	}
}
