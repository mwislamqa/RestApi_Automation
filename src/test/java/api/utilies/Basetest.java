package api.utilies;

import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;

import api.Enpoints.User;

public class Basetest {
	String token;
	public static User user;
	public static Faker fakeData;
	static String auth;
	public static Object token() {
	
		String token = "3bc87675be6f4adc53980d0eed71e9c7b3a34d093e20f989829de46b5a8c0d6a";
		String name = "Bearer ";
		return auth = name + token;  
	
	}
	
	
	
	
	@BeforeTest
	public void SetUp() {
//		String token = "3bc87675be6f4adc53980d0eed71e9c7b3a34d093e20f989829de46b5a8c0d6a";
//		String name = "Bearer ";
//		auth = name + token;  
		
		
		fakeData = new Faker();
		user = new User();
		user.setName("md islam");
		//user.setJob(fakeData.job().position());
		user.setEmail(fakeData.internet().emailAddress());
		user.setGender("male");
		user.setStatus("active");
		
	
		
		

	}
	
}
