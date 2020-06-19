package files;

import org.testng.annotations.DataProvider;

public class payload {

	static String customerUpdatedName="Dilpreet";	
	
	
	public static String aadMortgage(){
		
		String body="{\r\n" + 
				"    \"Mortgage\": \"M000001\",\r\n" + 
				"    \"name\": \"Harneet\",\r\n" + 
				"    \"age\": \"26\",\r\n" + 
				"    \"loan Details\": {\r\n" + 
				"        \"mortgageNumber\": \"M000001\",\r\n" + 
				"        \"loanType\": \"CI\"\r\n" + 
				"    },\r\n" + 
				"    \"productdetails\": {\r\n" + 
				"        \"pName\": \"FLEX\",\r\n" + 
				"        \"term\": \"5Years\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		return body;}
	
	public static String createCustomerData(String name,String designation){
		String body="{\r\n" + 
				"	\"custId\": \"001\",\r\n" + 
				"	\"name\": \""+name+"\",\r\n" + 
				"	\"address\": {\r\n" + 
				"		\"locality\": \"Pitampura\",\r\n" + 
				"		\"state\": \"Delhi\"\r\n" + 
				"	},\r\n" + 
				"	\"jobDetails\": {\r\n" + 
				"		\"designation\": \""+designation+"\",\r\n" + 
				"		\"companyDetails\": {\r\n" + 
				"			\"compName\": \"Sopra\",\r\n" + 
				"			\"place\": \"Noida\"\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"}";
		return body;
	}
	
	public static String putCustomerData(){
		String body="{\r\n" + 
				"	\"name\":\""+customerUpdatedName+"\"\r\n" + 
				"}\r\n" + 
				"";
		return body;
	}
	
	
	//Parameterized API test with Multiple data sets
	@DataProvider(name="customerNames")
	public Object[][] getData(){
	
		//Creating an object of multidimensional array and intialising it
		return new Object[][] {{"harneet","Engineer"},{"Honey","Engineer"},{"Honey1","Engineer"}};
		
	}
	
	
	
	
	
	
}