package files;

public class OAuth2Data {
public static String returnCodeValue(){
	String Url="https://rahulshettyacademy.com/getCourse.php?code=4%2FzgFXgTlGrbQxIUwJla-z4vCWTQ0prfxIho1V4iLkupB8cw0son4s4LU-5Sa6-9Z6an-d60FNnbhDVDG_3uQ5Cwk&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent#";
	String partial_Url=Url.split("code=")[1].split("&scope")[0];
	//String final_Url=partial_Url.split("&scope")[0];
	//System.out.println(partial_Url);
	return partial_Url;
}
}
