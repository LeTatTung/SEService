package ws.owl;

import hut.se.log.Config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import consistent.ConsistentOntology;

import ontologydata.*;
import ontologyDataSructure.*;
import ontologyManager.OntologyManager;
import ontologyOperator.IndividualOperator;
import saveDocumentData.DocumentElement;
import saveDocumentData.DocumentSaveData;
import saveDocumentData.Section;
import saveDocumentData.SectionDataAdapter;
import user.Message;
import user.UserManagement;
import ws.ShareData;
import annotationData.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import deleteCode.RemoveCodeComponent;


public class WebService {
	private Logger logger=Logger.getLogger(this.getClass());
	/**
	 * Bien shareData duoc tao ra de quan ly cac ontologyManager
	 */
	public static ShareData shareData = new ShareData();

	
	public WebService() {
		// TODO Auto-generated constructor stub
	}

	public void removeCodeIndividual(String owlFileName, String uri, Boolean remove){
		RemoveCodeComponent removeCodeComponent = new RemoveCodeComponent();
		removeCodeComponent.deleteCodeIndividual(owlFileName, uri, remove);
	}
	
	public Message backupOWL(String owlFileName){
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy'T'HH_mm_ss");
        Date date = new Date();
        String ID=dateFormat.format(date);
		String fileName = "BackupOwlData_"+ID+".owl";
		
		String fullPath = Config.getDataFolder()+File.separator+Config.getDefaultAnnotationFolder()+File.separator+Config.getBackupFolder();
		fullPath += File.separator+fileName;
		File dir=new File(fullPath);
		
		try
		{
			shareData.getOntologyManager(owlFileName).writeToOWL(dir.getAbsolutePath());
		}
		catch (Exception ex)
		{
			return new Message("Fatal Error! Reason:\n "+ex.getMessage(), false);
		}
		return new Message("Successfully backup data: "+dir.getAbsolutePath(), true);
	}
	
	/**
	 * Xem mot ontology da duoc load chua
	 * @param owlFileName
	 * @return
	 */
	public boolean isInitited(String owlFileName){
		return shareData.isInitited(owlFileName);
	}
	
	/**
	 * Load vao mot ontology (neu da ton tai thi load lai)
	 * @param owlFileName
	 * @return
	 */
	public boolean reloadOntology(String owlFileName){
		return shareData.reloadOntologyManager(owlFileName);
	}
	
	public ShareData getShareData(){
		return shareData;
	}



	/**
	 * Liệt kê các instance của 1 class trong ontology co ten la owlFileName o
	 * trong thu muc chua ontology
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


	/**
	 * Liệt kê các instance của một class và cả instance của các subclass
	 * 
	 * @param classname
	 * @return
	 */
	public ArrayList<String> listAllRelatedInstance(String owlFileName,
			String classname) {
		return shareData.getOntologyManager(owlFileName)
				.listAllRelatedInstance(classname);
	}

	/**
	 * Liệt kê các Property của class
	 * 
	 * @param classname:LocalName
	 *            của class
	 * @return: danh sách các PropertyData lưu trữ thông tin về các property
	 */
	public ArrayList<PropertyData> getAllClassProperties(String owlFileName,
			String classname) {
		ArrayList<PropertyData> result = new ArrayList<PropertyData>();
		ArrayList<BKProperty> listbk = shareData
				.getOntologyManager(owlFileName).listAllClassProperties(
						classname);
		for (int i = 0; i < listbk.size(); i++) {
			BKProperty tmpbk = listbk.get(i);
			result.add(new PropertyData(tmpbk));
		}
		return result;
	}

	/**
	 * Liệt kê các subclass của một class
	 * 
	 * @param classname:LocalName
	 *            của class
	 * @return:Danh sách các ClassData lưu trữ thông tin về các subclass
	 */
	public ArrayList<ClassData> getSubClasses(String owlFileName, String classname, Boolean direct) {
		ArrayList<ClassData> result = new ArrayList<ClassData>();
		ArrayList<BKClass> listbk = shareData.getOntologyManager(owlFileName).listSubClasses(classname, direct);
		for (int i = 0; i < listbk.size(); i++) {
			BKClass tmpbk = listbk.get(i);
			result.add(new ClassData(tmpbk));
		}
		return result;
	}
	

	/**
	 * Liệt kê các superclass của một class
	 * 
	 * @param classname:LocalName
	 *            của class
	 * @return:Danh sách các ClassData lưu trữ thông tin về các superclass
	 */
	public ArrayList<ClassData> getSuperClasses(String owlFileName,
			String classname) {
		ArrayList<ClassData> result = new ArrayList<ClassData>();
		ArrayList<BKClass> listbk = shareData.getOntologyManager(owlFileName)
				.listSuperClasses(classname);
		for (int i = 0; i < listbk.size(); i++) {
			BKClass tmpbk = listbk.get(i);
			result.add(new ClassData(tmpbk));
		}
		return result;
	}

	/**
	 * Lấy kiểu dữ liệu của một DatatypeProperty
	 * 
	 * @param propertyname:LocalName
	 *            của Property
	 * @return:tên kiểu dữ liệu
	 */
	public String getPropertySpecificDataType(String owlFileName,
			String propertyname) {
		return shareData.getOntologyManager(owlFileName)
				.getPropertySpecificDataType(propertyname);
	}

	/**
	 * Lấy Range của một ObjectProperty
	 * 
	 * @param propertyname:LocalName
	 *            của ObjectProperty
	 * @return:Danh sách tên các range
	 */
	public ArrayList<String> getObjectPropertyRanges(String owlFileName,String propertyname) {
		return shareData.getOntologyManager(owlFileName).getObjectPropertyRanges(propertyname);
	}
	
	/**
	 * Lấy Domain của một ObjectProperty
	 * 
	 * @param propertyname:LocalName
	 *            của ObjectProperty
	 * @return:Danh sách tên các range
	 */
	public ArrayList<String> getObjectPropertyDomains(String owlFileName,String propertyname) {
		return shareData.getOntologyManager(owlFileName).getObjectPropertyDomains(propertyname);
	}

	
	/**
	 * Lấy về Domain của một property
	 * 
	 * @param propertyname
	 * @return
	 */
	public ResourceData getDomain(String owlFileName, String propertyname) {
		return new ResourceData(shareData.getOntologyManager(owlFileName).getDomain(propertyname));
	}
	
	/**
	 * Liệt kê các SubProperty của một Property
	 * 
	 * @param propertyname
	 * @return : danh sách các PropertyData lưu trữ thông tin của các
	 *         SubProperty
	 */
	public ArrayList<PropertyData> getSubProperties(String owlFileName,
			String propertyname) {
		ArrayList<PropertyData> result = new ArrayList<PropertyData>();
		ArrayList<BKProperty> listbk = shareData
				.getOntologyManager(owlFileName)
				.listSubProperties(propertyname);
		for (int i = 0; i < listbk.size(); i++) {
			BKProperty tmpbk = listbk.get(i);
			result.add(new PropertyData(tmpbk));
		}
		return result;
	}

	/**
	 * Liệt kê các SuperProperty của một Property
	 * 
	 * @param propertyname
	 * @return : danh sách các PropertyData lưu trữ thông tin của một
	 *         SuperProperty
	 */
	public ArrayList<PropertyData> getSuperProperties(String owlFileName,
			String propertyname) {
		ArrayList<PropertyData> result = new ArrayList<PropertyData>();
		ArrayList<BKProperty> listbk = shareData
				.getOntologyManager(owlFileName).listSuperProperties(
						propertyname);
		for (int i = 0; i < listbk.size(); i++) {
			BKProperty tmpbk = listbk.get(i);
			result.add(new PropertyData(tmpbk));
		}
		return result;
	}

	/**
	 * Liệt kê các Class của một ontology
	 * 
	 * @return : danh sách các ClassData lưu trữ thông tin của các Class
	 */
	public ArrayList<ClassData> listClasses(String owlFileName) {
		ArrayList<ClassData> result = new ArrayList<ClassData>();
		ArrayList<BKClass> listbk = shareData.getOntologyManager(owlFileName)
				.listClasses();
		for (int i = 0; i < listbk.size(); i++) {
			BKClass tmpbk = listbk.get(i);
			result.add(new ClassData(tmpbk));
		}
		return result;
	}

	/**
	 * Liệt kê các Property của một ontology
	 * 
	 * @return : danh sách các PropertyData lưu trữ thông tin của các Property
	 */
	public ArrayList<PropertyData> listProperties(String owlFileName) {
		ArrayList<PropertyData> result = new ArrayList<PropertyData>();
		ArrayList<BKProperty> listbk = shareData
				.getOntologyManager(owlFileName).listProperties();
		for (int i = 0; i < listbk.size(); i++) {
			BKProperty tmpbk = listbk.get(i);
			result.add(new PropertyData(tmpbk));
		}
		return result;
	}

	/**
	 * Ghi ontology ra một file
	 * 
	 * @param fileName : tên file để ghi ontology
	 */
	public void writeToOWL(String owlFileName, String fileName) {
		String fullPath = Config.getDataFolder()+File.separator+Config.getDefaultAnnotationFolder();
		fullPath += File.separator+fileName+".owl";
		File dir=new File(fullPath);
		
		shareData.getOntologyManager(owlFileName).writeToOWL(dir.getAbsolutePath()+File.separator+fileName);
	}
	
	/**
	 * Ghi ontology ra một file
	 * 
	 * @param fileName : tên file để ghi ontology
	 */
	public void saveDocumentToOWL(String owlFileName, String fileName) {
		String fullPath = Config.getDataFolder()+File.separator+Config.getDefaultAnnotationFolder()+File.separator+Config.getDocumentFolder();
		fullPath += File.separator+fileName+".owl";
		File dir=new File(fullPath);
		
		shareData.getOntologyManager(owlFileName).writeToOWL(dir.getAbsolutePath());
	}

	/**
	 * Lấy một Class trong ontology theo tên
	 * 
	 * @param className
	 * @return
	 */
	public ClassData getClassByName(String owlFileName, String className) {
		return new ClassData(shareData.getOntologyManager(owlFileName)
				.getClassByName(className));
	}

	/**
	 * Lấy một Class trong ontology theo localName
	 * 
	 * @param classShortName
	 * @return
	 */
	public ClassData getClassByShortName(String owlFileName,
			String classShortName) {
		if (shareData.getOntologyManager(owlFileName).getClassByShortName(
				classShortName) != null)
			return new ClassData(shareData.getOntologyManager(owlFileName)
					.getClassByShortName(classShortName));
		return null;
	}

	/**
	 * Lấy một Property trong ontology theo tên
	 * 
	 * @param propertyName
	 * @return
	 */
	public PropertyData getPropertyByName(String owlFileName,
			String propertyName) {
		return new PropertyData(shareData.getOntologyManager(owlFileName)
				.getPropertyByName(propertyName));
	}

	/**
	 * Lấy một Property trong ontology theo localName
	 * 
	 * @param propertyShortName
	 * @return
	 */
	public PropertyData getPropertyByShortName(String owlFileName, String propertyShortName) {
		return new PropertyData(shareData.getOntologyManager(owlFileName)
				.getPropertyByShortName(propertyShortName));
	}
	
	/**
	 * Tạo instance trong một class, có dùng hasDirectType
	 * 
	 * @param instancename
	 * @param classname
	 * @return
	 */
	public boolean createInstance(String owlFileName, String instancename, String classname) {
		IndividualOperator individualOperator = shareData.getOntologyManager(owlFileName).createInstance(instancename, classname);
		if (individualOperator != null)
			return true;
		else
			return false;
	}

	public Boolean checkExistIndividual(String owlFileName, String individualName)
	{
		return shareData.getOntologyManager(owlFileName).checkexitsIndividual(individualName);
	}

	public IndividualData getIndividualByName(String owlFileName, String individualName) {
		return new IndividualData(shareData.getOntologyManager(owlFileName)
				.getIndividualInfoByName(individualName));

	}

	public IndividualData getIndividualByShortName(String owlFileName, String individualName) {
		return new IndividualData(shareData.getOntologyManager(owlFileName)
				.getIndividualInfoByShortName(individualName));
	}

	/**
	 * Thêm một giá trị thuộc tính kiểu Datatype cho Individual
	 * 
	 * @param propertyname
	 * @param value
	 * @param individualname
	 */
	public void addDatatypeProperty(String owlFileName,String propertyname, String value,
			String individualname) {
		shareData.getOntologyManager(owlFileName).addDatatypePropertyForIndividual(propertyname, value,
				individualname);
	}

	/**
	 * Thêm một ObjectProperty cho Individual
	 * 
	 * @param property
	 * @param individualValue
	 * @param individualname
	 */
	public void addObjectProperty(String owlFileName,String property, String individualValue,
			String individualname) {
		shareData.getOntologyManager(owlFileName).addObjectProperty(property, individualValue, individualname);
	}

	/**
	 * Thực hiện câu truy vấn Sparql
	 * 
	 * @param querystring
	 * @return Danh sách các ArrayListData,trong đó ArrayListData đầu tiên chứa
	 *         danh sách các biến, các ArrayList tiếp theo chứa các bộ giá trị
	 */
	public ArrayList<ArrayListData> SparqlResultList(String owlFileName, String querystring) {
		ArrayList<ArrayListData> result = new ArrayList<ArrayListData>();
		ArrayList<ArrayList<String>> tmplist = shareData.getOntologyManager(owlFileName)
				.SparqlResultList(querystring);
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

		return result;
	}

	/**
	 * Thực hiện câu truy vấn Sparql
	 * 
	 * @param querystring
	 * @return kết quả trả về là QueryResultData chứa danh sách các biến và map,
	 *         1 map là các cặp biến và giá trị tuơng ứng
	 */
	public QueryData SparqlResultMap(String owlFileName, String querystring) {
		return new QueryData(shareData.getOntologyManager(owlFileName).SparqlResultMap(querystring));
	}



	/**
	 * Lay ve gia tri cu the mot property cua mot individual
	 * 
	 * @param instanceID
	 * @param propertyName
	 * @return
	 */
	public ArrayList<String> getValueOfSpecificPropertyForIndividual(String owlFileName,
			String instanceID, String propertyName) {
		return shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(instanceID,
				propertyName);

	}
	
	/**
	 * Lay ve tat cac cac gia tri cua 1 individual
	 * Co sap xep thuoc tinh
	 * Co gia tri dung truoc, sau do sap xep theo abc
	 * @param owlFileName
	 * @param instanceID
	 * @return
	 */
	public ArrayList<BKIndividualProperty> getValuesOfIndividual(String owlFileName, String instanceID)
	{
		return shareData.getOntologyManager(owlFileName).getValuesOfIndividual(instanceID);
	}

	
	
	/**
	 * Lưu tất cả cục dữ liệu liên quan tới 1 instance
	 * Cấu trúc dữ liệu đầu vào là list: ArrayList<annotationData.InstanceData>
	 * @param owlFileName
	 * @param instanceDataList
	 * @param isBig Thuat toan cho phep load nhanh hon, chi co tac dung voi du lieu tuong doi lon
	 */
	public void saveValuesOfIndividual(String owlFileName, ArrayList<InstanceData> instanceDataList, Boolean isBig)
	{
		logger.info("Begin saving allInstanceData ...");
		OntologyManager ontmanager;
		if (!isBig)
			ontmanager = shareData.getOntologyManager(owlFileName);
		else
			ontmanager = ShareData.loadJustOntology();
		
		for (InstanceData newInstance: instanceDataList) {			
			//Lấy ra các thuộc tính cho từng instanceData
			String className = newInstance.getClassName();
			String instanceID = newInstance.getInstanceID();
			String instanceLabel = newInstance.getInstanceLabel();
			
			ArrayList<PropertyMapData> dataPropertyList = newInstance.getDataPropertyList();
			ArrayList<PropertyMapData> objectPropertyList = newInstance.getObjectPropertyList();
			
			//Tiến hành ghi dữ liệu
			if (instanceID != null && instanceID != "")
			try {
				IndividualOperator individualOperator = ontmanager.createInstance(instanceID, className);
				if (individualOperator != null)
				{
					if (instanceLabel != null) {
						ontmanager.addLabelForResource(instanceID, LanguageEnum.EN, instanceLabel);
					}
	
					//save DataProperty
					if (dataPropertyList != null) {
						for (PropertyMapData pMD:dataPropertyList) {
							
							String dataProperty = pMD.getPropertyname();
							String dataPropertyValue = pMD.getValue();
							logger.info(dataProperty);
							ontmanager.addDatatypePropertyForIndividual(dataProperty, dataPropertyValue, individualOperator);
						}
					}
					
					//save ObjectProperty
					if (objectPropertyList != null) {
						for (PropertyMapData pMD:objectPropertyList) {
							String propertyName = pMD.getPropertyname();
							String instanceName = pMD.getTypeClass();
							String objectPropertyValue = pMD.getValue();
							
							
							if (!ontmanager.checkexitsIndividual(objectPropertyValue)) {
								ontmanager.createInstance(objectPropertyValue,instanceName);
							}						
							ontmanager.addObjectProperty(propertyName,objectPropertyValue, instanceID);
						}
	
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.error(ex.getMessage());
			}			
		}
		
		if (isBig)
		{
			DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy'T'HH_mm_ss");
	        Date date = new Date();
	        String ID=dateFormat.format(date);
			String fileName = "tmpModel"+ID;
			
			String fullPath = Config.getDataFolder()+File.separator+Config.getDefaultAnnotationFolder()+File.separator+Config.getTempFolder();
			fullPath += File.separator+fileName+".owl";
			File file=new File(fullPath);
			ontmanager.writeToOWL(file.getAbsolutePath());
			
			//Lấy URL để load ontology vào model goc
			URL url = null;
			try {
				url = file.toURL();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			shareData.getOntologyManager(owlFileName).readOntology(url.toString());		
			
			//Xoa file tam
			file.delete();
		}
		logger.info("End saving allInstanceData.");
	}

	/**
	 * Thêm label cho một resource
	 * 
	 * @param resourceID
	 * @param languageType
	 * @param label
	 */
	public void addLabelForResource(String owlFileName, String resourceID,
			LanguageEnum languageType, String label) {
		shareData.getOntologyManager(owlFileName).addLabelForResource(resourceID, languageType, label);
	}

	/**
	 * Lấy về label của một resource
	 * 
	 * @param resourceID
	 * @param languageType
	 * @return
	 */
	public String getLabelFromResource(String owlFileName, String resourceID,
			LanguageEnum languageType) {
		return shareData.getOntologyManager(owlFileName).getLabelFromResource(resourceID, languageType);
	}


	/**
	 * Xóa một individual trong ontology
	 * 
	 * @param individualName
	 */
	public void removeIndividual(String owlFileName, String individualName) {
		shareData.getOntologyManager(owlFileName).removeIndividual(individualName);
	}

	public String getClassOfIndividual(String owlFileName, String individualName) {
		return shareData.getOntologyManager(owlFileName).getClassOfIndividual(individualName);
	}
	
	/**
	 * Lay ra cau truc du lieu cua mot document duoc save trong ontology
	 * @param owlFileName
	 * @param fullId cua document trong ontology
	 * @return
	 */
	public DocumentSaveData getDocumentSaveData(String owlFileName, String fullId){
		String fileName = fullId.substring(ConsistentOntology.DOC_NAMESPACE.length());
		DocumentSaveData saveDocumentData = new DocumentSaveData();
		Section root = new Section();
		ArrayList<DocumentElement> paragraphs = new ArrayList<DocumentElement>();
		ArrayList<DocumentElement> images = new ArrayList<DocumentElement>();
		SectionDataAdapter adapter = new SectionDataAdapter();
		
		root.setId(fullId+".Section_root");
		root.setLabel("Section_root");
		try {
			//root = root.createAllChildSection(owlFileName, root.getId(), paragraphs, images);
			root = adapter.createAllChildSection(owlFileName, root.getId(), paragraphs, images);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		saveDocumentData.setId(fullId);
		saveDocumentData.setPageNumbers(Integer.valueOf(shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(fullId, ConsistentOntology.DOCUMENT_HAS_PAGE_NUMBERS).get(0)));
		saveDocumentData.setLabel(fileName);
		saveDocumentData.setFileName(fileName);
		saveDocumentData.setRootSection(root);
		saveDocumentData.setImages(images);
		saveDocumentData.setParagraphs(paragraphs);
		return saveDocumentData;
	}
	
	/**
	 * Lay ra tat ca cac thuoc tinh cua lop className co range la rangeClass
	 * @param owlFileName
	 * @param className
	 * @param rangeClass
	 * @return
	 */
	public ArrayList<String> getPropertiesOfClassByRange(String owlFileName, String className, String rangeClass){
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<PropertyData> listPropertyData = getAllClassProperties(owlFileName, className);
		for (int i=0; i<listPropertyData.size(); i++){
			String propertyURI = listPropertyData.get(i).getPropertURI();
			ArrayList<String> range = getObjectPropertyRanges(owlFileName, propertyURI);
			if ((range.size()>0)&&(range.get(0).equalsIgnoreCase(rangeClass))){
				result.add(propertyURI);
			}
		}
		return result;
	}

	
	/**
	 * Validate nguoi dung
	 * @param username
	 * @param password
	 * @return account hop le hay khong
	 */
	public Message validateUser(String username, String password)
	{		
		try {
			UserManagement um =  new UserManagement();
			return um.validateUser(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return Message.FATAL_ERROR;
		}
	}

	/**
	 * Them 1 user moi
	 * @param username
	 * @param password
	 * @return message tra ve
	 */
	public Message addUser(String username, String password, String uri)
	{
		try {
			UserManagement um =  new UserManagement();
			return um.addUser(username, password, uri);
		} catch (Exception e) {
			e.printStackTrace();
			return Message.FATAL_ERROR;
		}
	}
	
	/**
	 * Xoa 1 user
	 * @param username
	 * @return message tra ve
	 */
	public Message removeUser(String username)
	{
		try {
			UserManagement um =  new UserManagement();
			return um.removeUser(username);
		} catch (Exception e) {
			e.printStackTrace();
			return Message.FATAL_ERROR;
		}
	}
	
	/**
	 * Doi pass cho 1 user, ke ca admin
	 * @param username
	 * @param currentPassword
	 * @param newPassword
	 * @return message
	 */
	public Message changePassword(String username, String currentPassword, String newPassword)
	{
		try {
			UserManagement um =  new UserManagement();
			return um.changePassword(username, currentPassword, newPassword);
		} catch (Exception e) {
			e.printStackTrace();
			return Message.FATAL_ERROR;
		}
	}
}
