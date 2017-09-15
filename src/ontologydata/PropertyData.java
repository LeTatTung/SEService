package ontologydata;

import ontologyDataSructure.*;

public class PropertyData {

	private String PropertyName;
	private String PropertURI;
	private String enComment;

	private String enLabel;

	private String vnComment;

	private String vnLabel;
	
	private boolean hasSubProperty;
	private boolean hasSuperProperty;
	private boolean isDatatypeProperty;
	private boolean isObjectProperty;

	public void setPropertyName(String propertyName) {
		PropertyName = propertyName;
	}

	public String getPropertyName() {
		return PropertyName;
	}

	public void setPropertURI(String propertURI) {
		PropertURI = propertURI;
	}

	public String getPropertURI() {
		return PropertURI;
	}

	public PropertyData() {

	}

	public PropertyData(String name, String uri) {
		super();
		this.PropertURI = uri;
		this.PropertyName = name;
	}
	
	public PropertyData(BKProperty bkproperty)
	{
		super();
		this.PropertURI = bkproperty.getURI();
		this.PropertyName = bkproperty.getLocalName();
		this.enComment = bkproperty.getEnComment();
		this.enLabel = bkproperty.getEnLabel();
		this.vnComment = bkproperty.getVnComment();
		this.vnLabel = bkproperty.getVnLabel();
		this.hasSubProperty = bkproperty.isHasSubProperty();
		this.hasSuperProperty = bkproperty.isHasSuperProperty();
		this.isDatatypeProperty = bkproperty.isDatatypeProperty();
		this.isObjectProperty = bkproperty.isObjectProperty();
		
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

	public boolean isHasSubProperty() {
		return hasSubProperty;
	}

	public void setHasSubProperty(boolean hasSubProperty) {
		this.hasSubProperty = hasSubProperty;
	}

	public boolean isHasSuperProperty() {
		return hasSuperProperty;
	}

	public void setHasSuperProperty(boolean hasSuperProperty) {
		this.hasSuperProperty = hasSuperProperty;
	}

	public boolean isDatatypeProperty() {
		return isDatatypeProperty;
	}

	public void setDatatypeProperty(boolean isDatatypeProperty) {
		this.isDatatypeProperty = isDatatypeProperty;
	}

	public boolean isObjectProperty() {
		return isObjectProperty;
	}

	public void setObjectProperty(boolean isObjectProperty) {
		this.isObjectProperty = isObjectProperty;
	}

}