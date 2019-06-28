package utilitites;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetLatestFileFromDirectory {

	public static void main(String[] args) {
		System.out.println("Call Get Latest File");
		getLatestFile();

	}

	/*
	 * Description:Use this method to get the list of latest file Author: Zaheer
	 * Abbas
	 */
	private static void getLatestFile() {
		File file1 = new File(System.getProperty("user.dir"));
		try {
			System.out.println(file1.getCanonicalPath());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		File[] listFiles = file1.listFiles();

//		for (File adsf : listFiles) {
//			System.out.println(adsf.getName() + " - " + " Date created is : - " + 
//		
//					LocalDateTime.parse()
//		LocalDateTime.parse(adsf.lastModied()).format(DateTimeFormatter.ofPattern("dd MMM yyyy hhmmss"))));
//		}
	}

}
