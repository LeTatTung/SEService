package ontologydata;

import ontologyDataSructure.BKIndividual;

public class IndividualData {
	private String IndividualName;
	private String IndividualURI;
	private String enComment;
	
	private String enLabel;
	
	private String vnComment;
	
	private String vnLabel;

	public String getIndividualName() {
		return IndividualName;
	}

	public void setIndividualName(String individualName) {
		IndividualName = individualName;
	}

	public String getIndividualURI() {
		return IndividualURI;
	}

	public void setIndividualURI(String individualURI) {
		IndividualURI = individualURI;
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
	
	public IndividualData(){
		
	}
	
	public IndividualData(BKIndividual bkIndividual){
		super();
		this.IndividualName = bkIndividual.getLocalName();
		this.IndividualURI = bkIndividual.getURI();
		this.enComment = bkIndividual.getEnComment();
		this.enLabel = bkIndividual.getEnLabel();
		this.vnComment = bkIndividual.getVnComment();
		this.vnLabel = bkIndividual.getVnLabel();
	}
	
}
