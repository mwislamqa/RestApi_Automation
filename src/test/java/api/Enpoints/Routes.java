package api.Enpoints;

import io.restassured.RestAssured;

public class Routes {
	

	private static String Path_URL= "/public/v2/users";
	
	public static String creat_url = "https://gorest.co.in/public/v2/users";
	
	public static String find_url = "/public/v2/users/{id}";//test will be failed bcoz endpoint is id.
	///api/users
	public static String update_url = "https://gorest.co.in/public/v2/users/{api_id}";

}
