package api.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.Payload.UserEndPoints;
import api.responseBody.ResponsePojo;
import api.utilies.Basetest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class Run_Test extends Basetest {
	static int idPath;

	@Test(priority = 1)
	public void createUser() {

////		String path = System.getProperty("user.dir");
////		System.out.println(path);
//
//		//Response res = UserEndPoints.create_user(user);
//		
//		
//		//String body = res.getBody().asPrettyString();
//		//System.out.println(body);
//		// idpath variable from response body, able to call any method.
//		idPath = res.jsonPath().getInt("id");
//		System.out.println("josnpath" + idPath);
//		res.then().log().all();
//		Assert.assertEquals(res.getStatusCode(), 201);
		
		//---------------------------
		//create pojo class for deserilize json object to java object
		ResponsePojo res = UserEndPoints.create_user(user).as(ResponsePojo.class);
		System.out.println(res.getId());
		idPath =res.getId();
		System.out.println(res.getName());
		Assert.assertEquals(res.getName(), "md islam");
		

	}

	@Test(priority = 2,dependsOnMethods= {"createUser"})
	public void findUser() {

		// idPath value is passing user/endpoint
		Response res = UserEndPoints.findUser(idPath);
		System.out.println(res.asPrettyString());
		//String name = ((ResponsePojo) res).getName();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		JsonPath path =res.jsonPath();
		String userName =path.get("name");
		Assert.assertEquals(userName, "md islam");
		
		
		String useremail =path.get("email");
		Assert.assertEquals(useremail, user.getEmail());
		
		
		String userstatus =path.get("status");
		Assert.assertEquals(userstatus, "active");
	}

	@Test(priority = 3,dependsOnMethods= {"createUser"})
	public void updateUser() {

		// update userName and email
		user.setName(fakeData.name().username());
		user.setEmail(fakeData.internet().emailAddress());

		Response res = UserEndPoints.update_user(idPath, user);
		String body = res.getBody().asPrettyString();
		System.out.println(body);
		// System.out.println(res);
		// res.getBody().asPrettyString();
//		System.out.println(body);
		// res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);

	}

	@Test(priority = 4,dependsOnMethods= {"createUser"}, enabled =true)
	public void deleteCreatedUser() {
		Response res = UserEndPoints.deleteUser(idPath);
		Assert.assertEquals(res.getStatusCode(), 204);
	}

}
