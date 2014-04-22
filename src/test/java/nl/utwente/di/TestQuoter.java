package nl.utwente.di;

import nl.utwente.di.Quoter;

import org.junit.Test;
import org.junit.Assert;

public class TestQuoter {
	@Test
	public void testBook1() throws Exception {
		Quoter quoter = new Quoter();
		double price = quoter.getBookPrice("1");
		Assert.assertEquals("Price of book1", 10.0, price, 0.0);
	}
}
