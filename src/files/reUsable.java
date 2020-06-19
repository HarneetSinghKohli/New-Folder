package files;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class reUsable {


	public static JsonPath rawToJsonResponse(String serviceResponse){
		JsonPath js=new JsonPath(serviceResponse);
		return js;
	}
	
	
	public static String rawToJsonResponseKeyValue(JsonPath js,String responseParentKey)
	{
		String responseValue = js.getString(responseParentKey);
		return responseValue;
	}
	
	public static int getKeyObjectCount(JsonPath js,String responseParentKey){
		int count=js.getInt(""+responseParentKey+".size()");
		System.out.println("Value of count variable "+count);
		return count;
	}
	
	public static void iterateOverArray(JsonPath js,String responseParentKey,String responseChildkey){
		int count=getKeyObjectCount(js, responseParentKey);
		System.out.println("Value of count variable "+count);
		for(int i=0;i<count;i++){
			String value=js.getString(""+responseParentKey+"["+i+"]."+responseChildkey+"");
			System.out.println("Value of "+responseChildkey+"  "+value);
		}
	}
	public static void getArrayNodeValue(JsonPath js,String responseParentKey,String responseChildkey,String responseChildkeyNode,String getValue){
		int count=getKeyObjectCount(js, responseParentKey);
		for(int i=0;i<count;i++){
			String value=js.getString(""+responseParentKey+"["+i+"]."+responseChildkey+"");
			if(value.equalsIgnoreCase(responseChildkeyNode)){
				System.out.println("Value of "+responseChildkeyNode+" :"+js.getString(""+responseParentKey+"["+i+"]."+getValue+""));
				break;
			}
		}
	}
	
	public static int iterateOverArrayForPrice(JsonPath js,String responseParentKey,String responseChildkey){
		int count=getKeyObjectCount(js, responseParentKey);
		int price1=0;
		for(int i=0;i<count;i++){
			String value=js.getString(""+responseParentKey+"["+i+"]."+responseChildkey+"");
			int price=Integer.valueOf(value);
			price1+=price;
			System.out.println("Price ="+price1);
			System.out.println("Value of "+responseChildkey+"  "+value);
			
		}
		System.out.println("Final price is :"+price1);
		return price1;
	}
	
	public static void iterateOverArray2(JsonPath js,String responseParentKey){
		int count=getKeyObjectCount(js, responseParentKey);
		System.out.println("Value of count variable "+count);
		for(int i=0;i<count;i++){
			String value=js.getString(""+responseParentKey+"["+i+"]");
			js.getObject(""+responseParentKey+"["+i+"]", String.class);
			System.out.println("Value of is"+js.getObject(""+responseParentKey+"["+i+"]", String.class));
		}
	}
	
	
	
	
	
}
