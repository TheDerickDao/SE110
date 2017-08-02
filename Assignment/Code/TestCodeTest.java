import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestCodeTest
{
	@Test
	public void testExceedAmount()
	{
	assertEquals("Backer Pledge < 0", "Not Exceeded", TestCode.exceedAmount(-3.0, 2.0, 5.0));
	assertEquals("Current Amount < 0", "Not Exceeded", TestCode.exceedAmount(1.0, -1.0, 5.0));
	assertEquals("Total Amount < 0", "Exceeded", TestCode.exceedAmount(2.0, 3.0, -1.0));
	assertEquals("Backer Pledge < 0 & Current Amount < 0", "Not Exceeded", TestCode.exceedAmount(-2.0, -1.0, 5.0));
	assertEquals("Backer Pledge < 0 & Total Amount < 0", "Exceeded", TestCode.exceedAmount(-1.0, 2.0, -5.0));
	assertEquals("Current Amount < 0 & Total Amount < 0", "Equal", TestCode.exceedAmount(1.0, -2.0, -5.0));
	assertEquals("All Imports < 0", "Equal", TestCode.exceedAmount(-1.0, -2.0, -5.0));
	assertEquals("All Imports > 0", "Not Exceeded", TestCode.exceedAmount(1.0, 2.0, 5.0));
	}
	
	@Test
	public void testSearch()
	{
	assertEquals("Description contains Search Word", "Found", TestCode.search("Projection","The Arc of Projection"));
	assertEquals("Description doesn't contain Search Word", "Not Found", TestCode.search("Orange","The Plane's Wings"));
	assertEquals("Description is the same as the Search Word", "Found", TestCode.search("Orange is orange","Orange is orange"));
	}
	
	@Test
	public void testFundingPerDay()
	{
	assertEquals("Current Amount < 0", 1.0, TestCode.fundingPerDay(-1.0, 5.0, 5), 0.0001);
	assertEquals("Total Amount < 0", 0.1, TestCode.fundingPerDay(0.0, -1.0, 10), 0.0001);
	assertEquals("Days Left < 0", 0.0, TestCode.fundingPerDay(2.0, 5.0, -2), 0.0001);
	assertEquals("Current Amount < 0 & Total Amount < 0", 0.1, TestCode.fundingPerDay(-1.0, -2.0, 10), 0.0001);
	assertEquals("Current Amount < 0 & Days Left < 0", 0.0, TestCode.fundingPerDay(-2.0, 12.0, -2), 0.0001);
	assertEquals("Total Amount < 0 & Days Left < 0", 0.0, TestCode.fundingPerDay(2.0, -5.0, -5), 0.0001);
	assertEquals("All Imports < 0", 0.0, TestCode.fundingPerDay(-5.0, -2.0, -3), 0.0001);
	assertEquals("All Imports > 0", 0.5, TestCode.fundingPerDay(3.0, 10.0, 14), 0.0001);
	}
}