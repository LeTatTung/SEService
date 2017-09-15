package annotationData;

import java.util.ArrayList;



public class NodeData {
	
	private NodeType nodetype;
	private String label;
	private String id;
	private ArrayList<NodeData> childList;
	private NodeData parent;
	private ArrayList<String> listtype;
	public NodeType getNodetype() {
		return nodetype;
	}

	public ArrayList<String> getListtype() {
		return listtype;
	}

	public void setListtype(ArrayList<String> listtype) {
		this.listtype = listtype;
	}

	public void setNodetype(NodeType nodetype) {
		this.nodetype = nodetype;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<NodeData> getChildList() {
		return childList;
	}

	public void setChildList(ArrayList<NodeData> childList) {
		this.childList = childList;
	}

	public NodeData getParent() {
		return parent;
	}

	public void setParent(NodeData parent) {
		this.parent = parent;
	}

	public NodeData(){
		childList = new ArrayList<NodeData>();
	}
	
	
}
	