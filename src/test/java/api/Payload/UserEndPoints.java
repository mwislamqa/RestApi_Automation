package api.Payload;

import static api.utilies.Basetest.token;

import java.util.ResourceBundle;

import api.Enpoints.Routes;
import api.Enpoints.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;;

public class UserEndPoints {
	// static String auth=null;
	// this method for call property file instead of FilInputString class.
	public static ResourceBundle callURLfromPropertyfile() {

		ResourceBundle bundle = ResourceBundle.getBundle("URLs");
		return bundle;
	}

	public static Response create_user(User payload) {

//		String token = "3bc87675be6f4adc53980d0eed71e9c7b3a34d093e20f989829de46b5a8c0d6a";
//		String name = "Bearer ";
//		auth = name + token;  

		Response res = RestAssured.given()
								.header("Authorization", token())
								.contentType("application/json")
								.body(payload)
							.when()
								.post(Routes.creat_url);

		return res;
	}

	// this method for find created user
	public static Response findUser(int userID) {// this parameter will be the endpoint

		RestAssured.baseURI = "https://gorest.co.in";

		return RestAssured.given()
							.pathParam("id", userID)// id will be {id}
							.header("Authorization", token())
							.contentType("application/json; charset=utf-8")
						.when()
							.get(Routes.find_url);

	}

	// update user info

	public static Response update_user(int user_id, User payload) {

		Response res = RestAssured.given()
				                  .pathParam("api_id", user_id)
				                  .header("Authorization", token())
				                  .contentType("application/json")
							.body(payload)
							.when()
							     .put(Routes.update_url);

		return res;
	}

	public static Response deleteUser(int userID) {// this parameter will be the endpoint

		RestAssured.baseURI = "https://gorest.co.in";

		return RestAssured.given()
							.pathParam("id", userID)// id will be {id}
							.header("Authorization", token())
							.contentType("application/json; charset=utf-8")

							.when()
								.delete(Routes.find_url);

	}

}
