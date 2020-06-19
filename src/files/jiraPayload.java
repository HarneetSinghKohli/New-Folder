package files;

public class jiraPayload {

	public static String loginData(){
		String body="{\r\n" + 
				"	\"username\":\"harneets58\",\r\n" + 
				"	\"password\":\"Jira@123456\"\r\n" + 
				"}";
		return body;
	}

	public static String createIssue(){
		String body="{\r\n" + 
				"	\"fields\":{\r\n" + 
				"		\"project\":{\r\n" + 
				"			\"key\":\"RES\"\r\n" + 
				"		},\r\n" + 
				"		\"summary\":\"Rest Issue Issue related to Customer API\",\r\n" + 
				"		\"description\":\"Creating an issue for Rest Project\",\r\n" + 
				"		\"issuetype\":{\r\n" + 
				"			\"name\":\"Bug\"\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"}";
		return body;
	}
	public static String addComment(){
		String body="{\r\n" + 
				"    \"body\": \"Commenting on JIRa issue\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
		return body;
	}
}
