package annotationData;

import java.util.ArrayList;

import com.hp.hpl.jena.ontology.Individual;

import ontologyDataSructure.BKClass;
import ontologyManager.OntologyManager;

public class OntologyClassData {
	String nodeID;
	NodeData nodeData;
	OntologyManager ontManager;
	
	/**
	 * Ham khoi tao co tham so
	 * @param nodeID: uri cua class
	 * @param nodeData: tap du lieu
	 * @param ontManager: model hien thoi dang su dung boi server
	 */
	public OntologyClassData(String nodeID, OntologyManager ontManager) {
		super();
		this.nodeID = nodeID;
		this.ontManager = ontManager;
		nodeData   = new NodeData();
	}

	public OntologyClassData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NodeData getNodeData() {
		return nodeData;
	}
	
	/**
	 * Ham xay dung tap du lieu tra ve phia client
	 */
	public void buildNodeClassData(){
		int countSubClass;
		BKClass subClass;
		BKClass rootClass = ontManager.getClassByName(this.nodeID);
		//Viet cau query vay
		
		NodeData rootnode = new NodeData();
		ArrayList<BKClass> lisSubClass = ontManager.listSubClasses(this.nodeID, true);
		countSubClass= lisSubClass.size();		
		rootnode.setLabel(rootClass.getLocalName()+"("+countSubClass+")");
	    rootnode.setId(rootClass.getLocalName());	    
	    nodeData.getChildList().add(rootnode);
	    for(int i=0; i<lisSubClass.size();i++){
	    	subClass = lisSubClass.get(i);
	    	buildSubData(subClass.getURI(),rootnode);
	    }
	    
	}
	
	public void buildSubData(String nodeID,NodeData rootnode){
		int countSubClass = 0;
		BKClass subClass;
		
		BKClass rootClass = ontManager.getClassByName(nodeID);
		ArrayList<BKClass> lisSubClass = ontManager.listSubClasses(nodeID, true);
		NodeData subnode = new NodeData();
		countSubClass= lisSubClass.size();	
		subnode.setLabel(rootClass.getLocalName()+"("+countSubClass+")");
		subnode.setId(rootClass.getLocalName());
		rootnode.getChildList().add(subnode);
		
		for(int i=0; i<lisSubClass.size();i++){
			subClass = lisSubClass.get(i);			
			if(subClass.isHasSubClass()){
				buildSubData(subClass.getURI(),subnode);
			}
		}
	}
	
}
