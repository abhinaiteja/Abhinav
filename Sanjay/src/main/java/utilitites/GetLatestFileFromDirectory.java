package utilitites;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.ss.formula.functions.Now;
import org.testng.Assert;

public class GetLatestFileFromDirectory {

	public static void main(String[] args) {
		
		
		 ZonedDateTime dateTime = Instant.ofEpochMilli(millis)
		            .atZone(ZoneId.of("Australia/Sydney"));
		 
		long test_timestamp = 1562342834L;
		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp),
				TimeZone.getDefault().toZoneId());

		System.out.println("Epoch milli is - " + date.toString());

		convertUnixTimestamp();
		
		Assert.assertTrue(false);
		
		System.out.println("Call Get Latest File");
		
		getLatestFile();

//		Date dateObject = Date.from(Instant.ofEpochSoun)
		
	}

	private static void convertUnixTimestamp() {

		long unixSeconds = 1562340112;
		// convert seconds to milliseconds
		Date date = new java.util.Date(unixSeconds*1000L); 
		
		// the format of your date
		LocalDateTime ldtObj = LocalDateTime.now();
		String formattedDate = ldtObj.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy  hh:mm:ss")).toString();
		System.out.println("Format of Date is  - " + formattedDate);
		
//		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); 
		
		// give a timezone reference for formatting (see comment at the bottom)
//		sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4")); 
//		String formattedDate = sdf.format(date);
//		System.out.println(formattedDate);
	}

	/*
	 * Description:Use this method to get the list of latest file Author: Zaheer
	 * Abbas
	 */
	private static void getLatestFile() {
		File file1 = new File(System.getProperty("user.dir"));
		File[] listOfFiles = file1.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
//				System.out.println("File name - " + listOfFiles[i].getName());
				System.out.println("File abs path - " + listOfFiles[i].getAbsolutePath());
				System.out.println("File last modified is - " + listOfFiles[i].lastModified());
			} 
//			else if (listOfFiles[i].isDirectory()) {
//				System.out.println("Directory name - " + listOfFiles[i].getName());
//				System.out.println("Directory abs path- " + listOfFiles[i].getAbsolutePath());
//			}
		}

//		for (File adsf : listFiles) {
//			System.out.println(adsf.getName() + " - " + " Date created is : - " + 
//		
//					LocalDateTime.parse()
//		LocalDateTime.parse(adsf.lastModied()).format(DateTimeFormatter.ofPattern("dd MMM yyyy hhmmss"))));
//		}
	}

}
