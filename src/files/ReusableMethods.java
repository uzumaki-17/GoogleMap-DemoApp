package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath rawToJson(String response)
	{
		JsonPath js3 = new JsonPath(response);
		return js3;
	}

}
