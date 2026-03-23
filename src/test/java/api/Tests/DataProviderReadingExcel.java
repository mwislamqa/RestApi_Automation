package api.Tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import api.Enpoints.User;
import api.Payload.UserEndPoints;
import api.utilies.DataProviders;
import io.restassured.response.Response;

public class DataProviderReadingExcel {
	public User user;
	@Test(dataProvider ="testData", dataProviderClass = DataProviders.class)
	public void cretePostMethod(String Name, String Job){
		
		user = new User();
		user.setName(Name);
		//user.setJob(Job);
		
		Response res=UserEndPoints.create_user(user);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 201);
		
		
		
	}

}
