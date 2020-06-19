package pojo;

public class basicPojo {
/*
	{
		"message":"Hi Harneet",
		"Status":"Single"
	}
*/
	
	
	private String message;					//This variable is just a key of the json
	private String status;
	
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status=status;
	}
	
}
