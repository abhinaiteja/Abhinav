package BDD;

import java.io.IOException;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import cucumber.api.junit.Cucumber;

public class CustomRunner extends Cucumber {

	public CustomRunner(@SuppressWarnings("rawtypes") Class clazz) throws InitializationError, IOException {
		super(clazz);
	}
	
	@Override
	public void run(RunNotifier notifier) {
		System.out.println("Executing from Customrunner");
		notifier.addListener(new CustomListener());
		super.run(notifier);
	}
}