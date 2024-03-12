package files;

public class PayLoad {
	
	public static String GetPlace()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
		
	}
	
	public static String UpdatePlace() {
		
		return "{\r\n"
				+ "\"place_id\":\"2fe585b07317794be609192e4c2a43c3\",\r\n"
				+ "\"address\":\"70 Summer walk, USA 2.0\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
		
	}
}
