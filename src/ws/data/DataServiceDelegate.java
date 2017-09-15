package ws.data;

import java.util.ArrayList;
import ontologydata.ArrayListData;
import ontologydata.MapData;
import annotationData.*;

@javax.jws.WebService(targetNamespace = "http://data.ws/", serviceName = "DataServiceService", portName = "DataServicePort")
public class DataServiceDelegate {

	ws.data.DataService dataService = new ws.data.DataService();

	public boolean isInitited(String owlFileName) {
		return dataService.isInitited(owlFileName);
	}

	public boolean reloadOntology(String owlFileName) {
		return dataService.reloadOntology(owlFileName);
	}

	public void saveAnnotationClient(String owlFileName,
			ArrayList<InstanceData> instanceDataList) {
		dataService.saveAnnotationClient(owlFileName, instanceDataList);
	}

	public NodeData getNodeData(String nodeID) {
		return dataService.getNodeData(nodeID);
	}

	public ArrayList<MapData> getValuePropertyIndividual(String owlFileName,
			String[] listProperty, String instanceID) {
		return dataService.getValuePropertyIndividual(owlFileName,
				listProperty, instanceID);
	}

	public ArrayList<ArrayListData> SparqlResultList(String owlFileName,
			String querystring) {
		return dataService.SparqlResultList(owlFileName, querystring);
	}

	public NodeData getClassData(String owlFileName, String nodeID) {
		return dataService.getClassData(owlFileName, nodeID);
	}

	public void processAutoAnalyze(ArrayList<DocumentData> listImage,
			ArrayList<DocumentData> listSection,
			ArrayList<DocumentData> listParagraph) {
		dataService.processAutoAnalyze(listImage, listSection, listParagraph);
	}

	public void creatArtifactInstance(String owlFileName, String id,
			String nameClass) {
		dataService.creatArtifactInstance(owlFileName, id, nameClass);
	}

	public ArrayList<String> listClassInstance(String owlFileName,
			String classname) {
		return dataService.listClassInstance(owlFileName, classname);
	}

}