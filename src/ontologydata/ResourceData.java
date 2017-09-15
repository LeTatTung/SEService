package ontologydata;
import ontologyDataSructure.*;;
public class ResourceData {
	private String ResourceName;
	private String ResourceURI;
	private String enComment;
	
	private String enLabel;
	
	private String vnComment;
	
	private String vnLabel;
	
	
	public ResourceData() {
	}

	public ResourceData(String name, String uri) {
		super();

		this.setResourceName(name);
		this.setResourceURI(uri);

	}
	
	public ResourceData(BKResource bkResource)
	{
		super();
		this.ResourceName = bkResource.getLocalName();
		this.ResourceURI = bkResource.getURI();
		this.enComment = bkResource.getEnComment();
		this.enLabel = bkResource.getEnLabel();
		this.vnComment = bkResource.getVnComment();
		this.vnLabel = bkResource.getVnLabel();
		
	}

	public void setResourceName(String ResourceName) {
		ResourceName = ResourceName;
	}

	public String getResourceName() {
		return ResourceName;
	}

	public void setResourceURI(String ResourceURI) {
		ResourceURI = ResourceURI;
	}

	public String getResourceURI() {
		return ResourceURI;
	}

	public String getEnComment() {
		return enComment;
	}

	public void setEnComment(String enComment) {
		this.enComment = enComment;
	}

	public String getEnLabel() {
		return enLabel;
	}

	public void setEnLabel(String enLabel) {
		this.enLabel = enLabel;
	}

	public String getVnComment() {
		return vnComment;
	}

	public void setVnComment(String vnComment) {
		this.vnComment = vnComment;
	}

	public String getVnLabel() {
		return vnLabel;
	}

	public void setVnLabel(String vnLabel) {
		this.vnLabel = vnLabel;
	}

	
}