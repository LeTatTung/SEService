package annotationData;

import java.util.ArrayList;


import ontologyDataSructure.LanguageEnum;
import ws.ShareData;

public class ActionNodeData {
	String nodeID;
	NodeData nodeData;
	ShareData shareData = new ShareData();
	
	//String prefix = "http://hut.edu.vn/ontology/sourcecode#";
	public static String prefix_source =  "http://hut.edu.vn/ontology/sourcecode#";
	
	
	public ActionNodeData(String nodeID) {
		super();
		this.nodeID =nodeID;
		nodeData   = new NodeData();
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public NodeData getNodeData() {
		return nodeData;
	}
	
	public void getWorkspaceData(){
		 String label,resourceProjectID;
		 /*
		 //B1: lay individual
		 Individual folderIndividual=ontManager.getIndividual(nodeID);
		 //B2
		 
		 folderIndividual.listPropertyValues(arg0)
		 
		 //B3
          */		 
		 ArrayList<String> listProject = shareData.getOntologyManager(null).getValueOfSpecificPropertyForIndividual(nodeID, prefix_source+"hasProject");
		 for(int i=0;i<listProject.size();i++){
			    NodeData projectnode = new NodeData();
			    resourceProjectID = listProject.get(i).toString();
			    label = shareData.getOntologyManager(null).getLabelFromResource(resourceProjectID, LanguageEnum.EN);
			    projectnode.setLabel(label);
			    projectnode.setId(resourceProjectID);
			    projectnode.setNodetype(NodeType.WORKSPACE);
				nodeData.getChildList().add(projectnode);	
				getProjectData(projectnode,listProject.get(i).toString());
		 }
	}
	public void getProjectData(NodeData nodedata, String classNodeId) {
		String label,resourceSourceFolderID;
		if (nodedata == null)
			nodedata = nodeData;
		ArrayList<String> listSourceFolder = shareData.getOntologyManager(null).getValueOfSpecificPropertyForIndividual(classNodeId,prefix_source+"hasFolderSourceCode");
		for (int i = 0; i < listSourceFolder.size(); i++) {
			NodeData sourcefoldernode = new NodeData();
			resourceSourceFolderID = listSourceFolder.get(i).toString();
			label = shareData.getOntologyManager(null).getLabelFromResource(resourceSourceFolderID, LanguageEnum.EN);
			sourcefoldernode.setLabel(label);
			sourcefoldernode.setId(resourceSourceFolderID);
			sourcefoldernode.setNodetype(NodeType.FOLDERSOURCE);
			nodedata.getChildList().add(sourcefoldernode);
			getFolderSourceCode(sourcefoldernode, resourceSourceFolderID);
		}

	}

	public void getFolderSourceCode(NodeData nodedata, String classNodeId) {
		String label,resourcePackageID;
		if (nodedata == null)nodedata = nodeData;
		ArrayList<String> listPackage = shareData.getOntologyManager(null).getValueOfSpecificPropertyForIndividual(classNodeId,prefix_source+"hasPackage");
		for (int i = 0; i < listPackage.size(); i++) {
			NodeData packagenode = new NodeData();
			
			resourcePackageID = listPackage.get(i).toString();
			label = shareData.getOntologyManager(null).getLabelFromResource(resourcePackageID,LanguageEnum.EN);
			packagenode.setLabel(label);
			packagenode.setId(resourcePackageID);
			packagenode.setNodetype(NodeType.PACKAGE);
			nodedata.getChildList().add(packagenode);
			getClassData(packagenode, resourcePackageID);
		}
	}
	public void getClassData(NodeData packagenode,String classNodeId){
		String label,resourceClassID;
		if (packagenode == null)packagenode = nodeData;
		ArrayList<String> listClass = shareData.getOntologyManager(null).getValueOfSpecificPropertyForIndividual(classNodeId, prefix_source+"hasClass");
		for(int i=0;i<listClass.size();i++){
			    NodeData classnode = new NodeData();
			   
			    resourceClassID = listClass.get(i).toString();
			    System.out.println("Dang phan tich toi Class"+resourceClassID);
			    label = shareData.getOntologyManager(null).getLabelFromResource(resourceClassID, LanguageEnum.EN);
			    classnode.setLabel(label);
			    classnode.setId(resourceClassID);
			    classnode.setNodetype(NodeType.CLASS);
			    packagenode.getChildList().add(classnode);
			    //Lay cac subclass
			    getClassData(classnode,resourceClassID);
			    getFieldData(classnode,resourceClassID);
			    getMethodData(classnode,resourceClassID);
			   
			    
		 } 
	}
	
	
	public void getFieldData(NodeData nodedata,String classNodeId){
		String label,resourceFieldID;
		if (nodedata == null)nodedata = nodeData;
		ArrayList<String> listField = shareData.getOntologyManager(null).getValueOfSpecificPropertyForIndividual(classNodeId, prefix_source+"hasField");
		for(int i=0;i<listField.size();i++){
		    NodeData fieldnode = new NodeData();
		    resourceFieldID = listField.get(i).toString();
		    label = shareData.getOntologyManager(null).getLabelFromResource(resourceFieldID, LanguageEnum.EN);
		    System.out.println("Dang phan tich toi field "+label);
		    fieldnode.setLabel(label);
		    fieldnode.setId(resourceFieldID);
		    ArrayList<String> listTypeField = shareData.getOntologyManager(null).getValueOfSpecificPropertyForIndividual(resourceFieldID, prefix_source+"hasModifier");
			fieldnode.setListtype(listTypeField);
		    fieldnode.setNodetype(NodeType.FIELD);
		    nodedata.getChildList().add(fieldnode);	
		    
	    } 
		
	}
	public void getMethodData(NodeData nodedata,String classNodeId){
		String label,resourceMethodID;
		if (nodedata == null)nodedata = nodeData;
		ArrayList<String> listMethod = shareData.getOntologyManager(null).getValueOfSpecificPropertyForIndividual(classNodeId, prefix_source+"hasMethod");
		for(int i=0;i<listMethod.size();i++){
		    NodeData methodnode = new NodeData();
		    resourceMethodID = listMethod.get(i).toString();
		    System.out.println("Dang phan tich toi method"+ resourceMethodID);
		    label = shareData.getOntologyManager(null).getLabelFromResource(resourceMethodID, LanguageEnum.EN);
		    methodnode.setLabel(label); 
		    methodnode.setId(resourceMethodID);
		    /*ArrayList<String> listTypeField = new ArrayList<String>();
		    try{
			    listTypeField = ontManager.getValueOfSpecificPropertyForIndividual("R.ttt.src.ttt.Activator.java.Activator.start", "hasModifier");
				methodnode.setListtype(listTypeField);
		    }catch(Exception ex){
		    	System.out.println(ex.getMessage());
		    }*/
			
		    ArrayList<String> listTypeField = shareData.getOntologyManager(null).getValueOfSpecificPropertyForIndividual(resourceMethodID, prefix_source+"hasModifier");
		    methodnode.setListtype(listTypeField);
		    methodnode.setNodetype(NodeType.METHOD);
		    nodedata.getChildList().add(methodnode);	
		    
	    } 
		
	}
	
	
}
