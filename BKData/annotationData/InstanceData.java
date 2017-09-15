package annotationData;

import java.util.ArrayList;

public class InstanceData {
	// properties
	private String className;
	private String instanceID;
	private String instanceLabel;
	private ArrayList<PropertyMapData> dataPropertyList;
	private ArrayList<PropertyMapData> objectPropertyList;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getInstanceID() {
		return instanceID;
	}

	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}

	public String getInstanceLabel() {
		return instanceLabel;
	}

	public void setInstanceLabel(String instanceLabel) {
		this.instanceLabel = instanceLabel;
	}

	public ArrayList<PropertyMapData> getDataPropertyList() {
		return dataPropertyList;
	}

	public void setDataPropertyList(ArrayList<PropertyMapData> dataPropertyList) {
		this.dataPropertyList = dataPropertyList;
	}

	public ArrayList<PropertyMapData> getObjectPropertyList() {
		return objectPropertyList;
	}

	public void setObjectPropertyList(ArrayList<PropertyMapData> objectPropertyList) {
		this.objectPropertyList = objectPropertyList;
	}

	public InstanceData() {

	}

	public InstanceData(String className, String instanceID,
			String instanceLabel, ArrayList<PropertyMapData> dataPropertyList,
			ArrayList<PropertyMapData> objectPropertyList) {
		super();
		this.className = className;
		this.instanceID = instanceID;
		this.instanceLabel = instanceLabel;
		this.dataPropertyList = dataPropertyList;
		this.objectPropertyList = objectPropertyList;
	}

	
	
	
	

	
	

}
