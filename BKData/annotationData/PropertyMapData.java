package annotationData;

public class PropertyMapData {

	private String typeClass;//Truyen vao de trong truong hop individual chua dc tao thi ta biet no la o lop individual nao
	private String propertyname;	
	private String value;
	public PropertyMapData() {
		
		// TODO Auto-generated constructor stub
	}
	public PropertyMapData(String type, String propertyname,
			String value) {
		super();
		this.typeClass = type;
		this.propertyname = propertyname;
		this.value = value;
	}
	public String getTypeClass() {
		return typeClass;
	}
	public void setTypeClass(String type) {
		this.typeClass = type;
	}
	public String getPropertyname() {
		return propertyname;
	}
	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
