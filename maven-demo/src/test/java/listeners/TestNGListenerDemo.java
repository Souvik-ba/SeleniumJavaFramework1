package listeners;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	
	@Test
	public void test1(){
		System.out.println("Test Started");
	}
	
	@Test
	public void test2(){
		System.out.println("Test failed");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test3(){
		System.out.println("Test skipped");
		throw new SkipException("Test case skipped");
	}

}
