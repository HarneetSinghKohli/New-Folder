package pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class courses {

	private List<WebAutomation> WebAutomationDetails;
	private List<Api> ApiAutomationDetails;
	private List<Mobile> MobilAutomationDetails;
	
	public List<WebAutomation> getWebAutomationDetails() {
		return WebAutomationDetails;
	}
	public void setWebAutomationDetails(List<WebAutomation> WebAutomationDetails) {
		this.WebAutomationDetails = WebAutomationDetails;
	}
	public List<Api> getApiAutomationDetails() {
		return ApiAutomationDetails;
	}
	public void setApiAutomationDetails(List<Api> ApiAutomationDetails) {
		this.ApiAutomationDetails = ApiAutomationDetails;
	}
	public List<Mobile> getMobilAutomationDetails() {
		return MobilAutomationDetails;
	}
	public void setMobilAutomationDetails(List<Mobile> MobilAutomationDetails) {
		this.MobilAutomationDetails = MobilAutomationDetails;
	}
	
}
