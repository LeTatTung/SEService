package ontologydata;
import ontologyDataSructure.*;;
public class ClassData {
	private String ClassName;
	private String ClassURI;
	private String enComment;
	
	private String enLabel;
	
	private String vnComment;
	
	private String vnLabel;
	
	private boolean hasSubClass;
	private boolean hasSuperClass;
	public ClassData() {
	}

	public ClassData(String name, String uri) {
		super();

		this.setClassName(name);
		this.setClassURI(uri);

	}
	
	public ClassData(BKClass bkclass)
	{
		super();
		this.ClassName = bkclass.getLocalName();
		this.ClassURI = bkclass.getURI();
		this.enComment = bkclass.getEnComment();
		this.enLabel = bkclass.getEnLabel();
		this.vnComment = bkclass.getVnComment();
		this.vnLabel = bkclass.getVnLabel();
		this.hasSubClass = bkclass.isHasSubClass();
		this.hasSuperClass = bkclass.isHasSuperClass();
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassURI(String classURI) {
		ClassURI = classURI;
	}

	public String getClassURI() {
		return ClassURI;
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

	public boolean isHasSubClass() {
		return hasSubClass;
	}

	public void setHasSubClass(boolean hasSubClass) {
		this.hasSubClass = hasSubClass;
	}

	public boolean isHasSuperClass() {
		return hasSuperClass;
	}

	public void setHasSuperClass(boolean hasSuperClass) {
		this.hasSuperClass = hasSuperClass;
	}

}