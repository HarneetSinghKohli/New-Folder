package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class customerDetails {
	
	private String CustId;
	private String name;
	private courses coursesDetails;
	private job jobDetails;
	
	
	public String getCustId() {
		return CustId;
	}
	public void setCustId(String custId) {
		CustId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public courses getCoursesDetails() {
		return coursesDetails;
	}
	public void setCoursesDetails(courses coursesDetails) {
		this.coursesDetails = coursesDetails;
	}
	public job getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(job jobDetails) {
		this.jobDetails = jobDetails;
	}



	
	

}
