package ws.data;

import hut.se.log.Config;

import java.util.ArrayList;
import java.util.List;

import ontologyDataSructure.LanguageEnum;
import ontologyManager.OntologyManager;
import ontologydata.ArrayListData;
import ontologydata.MapData;
import ws.ShareData;
import annotationData.*;

public class DataService {

	private ActionNodeData nodeData;
	private OntologyClassData classData;
	private String nodeID;
	ShareData shareData = new ShareData();

	/**
	 * Xem mot ontology da duoc load chua
	 * 
	 * @param owlFileName
	 * @return
	 */
	public boolean isInitited(String owlFileName) {
		return shareData.isInitited(owlFileName);
	}

	/**
	 * Load vao mot ontology (neu da ton tai thi load lai)
	 * 
	 * @param owlFileName
	 * @return
	 */
	public boolean reloadOntology(String owlFileName) {
		return shareData.reloadOntologyManager(owlFileName);
	}

	public void saveAnnotationClient(String owlFileName,
			ArrayList<InstanceData> instanceDataList) {
		System.out.println("Dang load file JavaDocumentOntology");
		OntologyManager ontmanager = shareData.getOntologyManager(owlFileName);
		// check();
		for (int i = 0; i < instanceDataList.size(); i++) {
			System.out.println("Dang phan tich phan tu thu" + i);
			InstanceData newInstance = instanceDataList.get(i);
			String className = newInstance.getClassName();
			String instanceID = newInstance.getInstanceID();
			String instanceLabel = newInstance.getInstanceLabel();
			ArrayList<PropertyMapData> dataPropertyList = newInstance
					.getDataPropertyList();
			ArrayList<PropertyMapData> objectPropertyList = newInstance
					.getObjectPropertyList();
			try {

				System.out.println("InstanceID:" + instanceID);
				if (!ontmanager.checkexitsIndividual(instanceID)) {
					ontmanager.createInstance(instanceID, className);
					if (instanceLabel != null) {
						ontmanager.addLabelForResource(instanceID,
								LanguageEnum.EN, instanceLabel);
					}
				} else {
					if (instanceLabel != null) {
						ontmanager.addLabelForResource(instanceID,
								LanguageEnum.EN, instanceLabel);
					}
				}

				if (dataPropertyList != null) {
					for (int j = 0; j < dataPropertyList.size(); j++) {
						String dataProperty = dataPropertyList.get(j)
								.getPropertyname();
						String dataPropertyValue = dataPropertyList.get(j)
								.getValue();
						// ontManager.createInstance(objectPropertyValue,
						// instanceName);
						// Thuc hien doi voi source code
						// ontManager.addDatatypePropertyForIndividual(dataProperty,
						// dataPropertyValue,
						// "http://hut.edu.vn/ontology/sourcecode#"+instanceID);
						// Thuc hien doi voi document
						ontmanager.addDatatypePropertyForIndividual(
								dataProperty, dataPropertyValue, instanceID);
					}
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			if (objectPropertyList != null) {
				for (int j = 0; j < objectPropertyList.size(); j++) {
					System.out.println("--------------------" + j
							+ "-------------------");
					/*
					 * Ten cua propery muon ghi vao ontology vi du: hasComment
					 */
					String propertyName = objectPropertyList.get(j)
							.getPropertyname();
					// vi du:Ta can them hasComment commenthere.Trong do
					// commenthere
					// la 1 individual nhung co the no
					// chua dc tao.Truyen kieu vao de no
					// tao individual dung la lop
					// Comment va gia tri la commenthere
					String instanceName = objectPropertyList.get(j)
							.getTypeClass();
					String objectPropertyValue = objectPropertyList.get(j)
							.getValue();
					/*
					 * Tao individual cua lop instanceName, gia tri truyen vao
					 * la objectPropertyValue
					 */
					if (!ontmanager.checkexitsIndividual(objectPropertyValue)) {
						ontmanager.createInstance(objectPropertyValue,
								instanceName);
					}
					// thuc hien doi voi source code
					// ontManager.addObjectProperty(propertyName,"http://hut.edu.vn/ontology/sourcecode#"+objectPropertyValue,
					// "http://hut.edu.vn/ontology/sourcecode#"+instanceID);
					// thuc hien doi voi document
					ontmanager.addObjectProperty(propertyName,
							objectPropertyValue, instanceID);
				}

			}

		}
		System.out.println("Dang ghi file");
		// ontManager.writeToOWL("C:/JavaSourceCodeOntology1.owl");
		ontmanager.writeToOWL(Config.getDataFolder() + owlFileName);
		shareData.reloadOntologyManager(owlFileName);
	}

	public NodeData getNodeData(String nodeID) {
		if (!nodeID.equals(this.nodeID)) {
			nodeData = new ActionNodeData(nodeID);
		}
		nodeData.getWorkspaceData();
		NodeData root = nodeData.getNodeData();

		return root;
	}

	public ArrayList<MapData> getValuePropertyIndividual(String owlFileName,
			String[] listProperty, String instanceID) {
		ArrayList<MapData> listValueProperty = new ArrayList<MapData>();
		OntologyManager ontManager = shareData.getOntologyManager(owlFileName);
		for (int i = 0; i < listProperty.length; i++) {
			MapData mapData = new MapData();
			mapData.setKey(listProperty[i]);
			ArrayList<String> listValue = ontManager
					.getValueOfSpecificPropertyForIndividual(instanceID,
							listProperty[i]);
			mapData.setObject(listValue);
			listValueProperty.add(mapData);
		}
		return listValueProperty;
	}

	/**
	 * Thực hiện câu truy vấn Sparql
	 * 
	 * @param querystring
	 * @return Danh sách các ArrayListData,trong đó ArrayListData đầu tiên chứa
	 *         danh sách các biến, các ArrayList tiếp theo chứa các bộ giá trị
	 */
	public ArrayList<ArrayListData> SparqlResultList(String owlFileName,
			String querystring) {
		ArrayList<ArrayListData> result = new ArrayList<ArrayListData>();
		ArrayList<ArrayList<String>> tmplist = shareData.getOntologyManager(
				owlFileName).SparqlResultListLocalName(querystring);
		if (tmplist != null) {
			for (int i = 0; i < tmplist.size(); i++) {
				ArrayList<String> tmpdata = tmplist.get(i);
				ArrayListData arraylistdata = new ArrayListData();
				List<String> tmpstringlist = new ArrayList<String>();
				for (int j = 0; j < tmpdata.size(); j++) {
					tmpstringlist.add(tmpdata.get(j));

				}
				arraylistdata.setData(tmpstringlist);
				result.add(arraylistdata);
			}
		}

		return result;
	}

	public NodeData getClassData(String owlFileName, String nodeID) {
		classData = new OntologyClassData(nodeID, shareData
				.getOntologyManager(owlFileName));
		classData.buildNodeClassData();
		NodeData root = classData.getNodeData();
		return root;
	}

	/*
	 * Ham nhan 3 list gom co: Image, Section, Paragraph tu phia client Xu ly
	 * cho truong hop dung auto analyze de phan tich, su dung gate
	 */

	public void processAutoAnalyze(ArrayList<DocumentData> listImage,
			ArrayList<DocumentData> listSection,
			ArrayList<DocumentData> listParagraph) {

		ArrayList<DocumentData> t = listImage;
		System.out.println(t.size());
	}

	/*
	 * Ham tao 1 instance moi,phuc vu cho viec tao test,hay 1 requirement moi
	 */
	public void creatArtifactInstance(String owlFileName, String id,
			String nameClass) {
		if (!shareData.getOntologyManager(owlFileName).checkexitsIndividual(id)) {
			shareData.getOntologyManager(owlFileName).createInstance(id,
					nameClass);
		}
	}

	/**
	 * Liệt kê các instance của class
	 * 
	 * @param classname:LocalName
	 *            của class
	 * @return: danh sách tên các instance của class
	 */
	public ArrayList<String> listClassInstance(String owlFileName,
			String classname) {
		return shareData.getOntologyManager(owlFileName).listAllClassInstance(
				classname);
	}
}
