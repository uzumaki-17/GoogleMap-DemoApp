import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.PayLoad;
import files.ReusableMethods;
public class Basics {

	public static void main(String[] args) {
//		Add Place APi POST Method
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response1 =  given().log().all().queryParam("key", "qaclick").header("Content-Type","application/json")
		.body(PayLoad.GetPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
//		AddPlace>>UpdatePlace with new address>>GetPlace to validate if new response is present in the response
		JsonPath js1 = new JsonPath(response1);//take string as input and return json body(parsing json)
		String placeId = js1.getString("place_id");
		
		
		System.out.println(response1);
		System.out.println(placeId);
		
		
//		UPDATE place Place API
		
		String newAddress = "circuit house road singrauli mp";
		
		String response2 = given().log().all().queryParam("key", "qaclick").header("Content-Type","application/json").body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when()
		.put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated")).extract().response().asString();
		JsonPath js2 = new JsonPath(response2);
		
//		GET Place
		String response3 = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		
		
		JsonPath js3 =  ReusableMethods.rawToJson(response3);
		String actualaddress = js3.get("address");
		System.out.println(actualaddress);
		Assert.assertEquals(actualaddress, newAddress);

		
		
		

}

}
