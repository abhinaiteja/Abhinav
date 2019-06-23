package BDD;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

public class CustomListener extends RunListener {

	@Override
	public void testStarted(Description description) throws Exception {
		System.out.println("Test Started from Custom Listener");
	}
}