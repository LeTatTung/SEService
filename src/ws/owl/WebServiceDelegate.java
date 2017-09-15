package ws.owl;

import java.util.ArrayList;
import ontologydata.*;
import ontologyDataSructure.*;
import saveDocumentData.DocumentSaveData;
import user.Message;
import ws.ShareData;
import annotationData.*;

@javax.jws.WebService(targetNamespace = "http://owl.ws/", serviceName = "WebServiceService", portName = "WebServicePort")
public class WebServiceDelegate {

	ws.owl.WebService webService = new ws.owl.WebService();

	public void removeCodeIndividual(String owlFileName, String uri,
			Boolean remove) {
		webService.removeCodeIndividual(owlFileName, uri, remove);
	}

	public Message backupOWL(String owlFileName) {
		return webService.backupOWL(owlFileName);
	}

	public boolean isInitited(String owlFileName) {
		return webService.isInitited(owlFileName);
	}

	public boolean reloadOntology(String owlFileName) {
		return webService.reloadOntology(owlFileName);
	}

	public ShareData getShareData() {
		return webService.getShareData();
	}

	public ArrayList<String> listClassInstance(String owlFileName,
			String classname) {
		return webService.listClassInstance(owlFileName, classname);
	}

	public ArrayList<String> listAllRelatedInstance(String owlFileName,
			String classname) {
		return webService.listAllRelatedInstance(owlFileName, classname);
	}

	public ArrayList<PropertyData> getAllClassProperties(String owlFileName,
			String classname) {
		return webService.getAllClassProperties(owlFileName, classname);
	}

	public ArrayList<ClassData> getSubClasses(String owlFileName,
			String classname, Boolean direct) {
		return webService.getSubClasses(owlFileName, classname, direct);
	}

	public ArrayList<ClassData> getSuperClasses(String owlFileName,
			String classname) {
		return webService.getSuperClasses(owlFileName, classname);
	}

	public String getPropertySpecificDataType(String owlFileName,
			String propertyname) {
		return webService
				.getPropertySpecificDataType(owlFileName, propertyname);
	}

	public ArrayList<String> getObjectPropertyRanges(String owlFileName,
			String propertyname) {
		return webService.getObjectPropertyRanges(owlFileName, propertyname);
	}

	public ArrayList<String> getObjectPropertyDomains(String owlFileName,
			String propertyname) {
		return webService.getObjectPropertyDomains(owlFileName, propertyname);
	}

	public ResourceData getDomain(String owlFileName, String propertyname) {
		return webService.getDomain(owlFileName, propertyname);
	}

	public ArrayList<PropertyData> getSubProperties(String owlFileName,
			String propertyname) {
		return webService.getSubProperties(owlFileName, propertyname);
	}

	public ArrayList<PropertyData> getSuperProperties(String owlFileName,
			String propertyname) {
		return webService.getSuperProperties(owlFileName, propertyname);
	}

	public ArrayList<ClassData> listClasses(String owlFileName) {
		return webService.listClasses(owlFileName);
	}

	public ArrayList<PropertyData> listProperties(String owlFileName) {
		return webService.listProperties(owlFileName);
	}

	public void writeToOWL(String owlFileName, String fileName) {
		webService.writeToOWL(owlFileName, fileName);
	}

	public void saveDocumentToOWL(String owlFileName, String fileName) {
		webService.saveDocumentToOWL(owlFileName, fileName);
	}

	public ClassData getClassByName(String owlFileName, String className) {
		return webService.getClassByName(owlFileName, className);
	}

	public ClassData getClassByShortName(String owlFileName,
			String classShortName) {
		return webService.getClassByShortName(owlFileName, classShortName);
	}

	public PropertyData getPropertyByName(String owlFileName,
			String propertyName) {
		return webService.getPropertyByName(owlFileName, propertyName);
	}

	public PropertyData getPropertyByShortName(String owlFileName,
			String propertyShortName) {
		return webService
				.getPropertyByShortName(owlFileName, propertyShortName);
	}

	public boolean createInstance(String owlFileName, String instancename,
			String classname) {
		return webService.createInstance(owlFileName, instancename, classname);
	}

	public Boolean checkExistIndividual(String owlFileName,
			String individualName) {
		return webService.checkExistIndividual(owlFileName, individualName);
	}

	public IndividualData getIndividualByName(String owlFileName,
			String individualName) {
		return webService.getIndividualByName(owlFileName, individualName);
	}

	public IndividualData getIndividualByShortName(String owlFileName,
			String individualName) {
		return webService.getIndividualByShortName(owlFileName, individualName);
	}

	public void addDatatypeProperty(String owlFileName, String propertyname,
			String value, String individualname) {
		webService.addDatatypeProperty(owlFileName, propertyname, value,
				individualname);
	}

	public void addObjectProperty(String owlFileName, String property,
			String individualValue, String individualname) {
		webService.addObjectProperty(owlFileName, property, individualValue,
				individualname);
	}

	public ArrayList<ArrayListData> SparqlResultList(String owlFileName,
			String querystring) {
		return webService.SparqlResultList(owlFileName, querystring);
	}

	public QueryData SparqlResultMap(String owlFileName, String querystring) {
		return webService.SparqlResultMap(owlFileName, querystring);
	}

	public ArrayList<String> getValueOfSpecificPropertyForIndividual(
			String owlFileName, String instanceID, String propertyName) {
		return webService.getValueOfSpecificPropertyForIndividual(owlFileName,
				instanceID, propertyName);
	}

	public ArrayList<BKIndividualProperty> getValuesOfIndividual(
			String owlFileName, String instanceID) {
		return webService.getValuesOfIndividual(owlFileName, instanceID);
	}

	public void saveValuesOfIndividual(String owlFileName,
			ArrayList<InstanceData> instanceDataList, Boolean isBig) {
		webService.saveValuesOfIndividual(owlFileName, instanceDataList, isBig);
	}

	public void addLabelForResource(String owlFileName, String resourceID,
			LanguageEnum languageType, String label) {
		webService.addLabelForResource(owlFileName, resourceID, languageType,
				label);
	}

	public String getLabelFromResource(String owlFileName, String resourceID,
			LanguageEnum languageType) {
		return webService.getLabelFromResource(owlFileName, resourceID,
				languageType);
	}

	public void removeIndividual(String owlFileName, String individualName) {
		webService.removeIndividual(owlFileName, individualName);
	}

	public String getClassOfIndividual(String owlFileName, String individualName) {
		return webService.getClassOfIndividual(owlFileName, individualName);
	}

	public DocumentSaveData getDocumentSaveData(String owlFileName,
			String fullId) {
		return webService.getDocumentSaveData(owlFileName, fullId);
	}

	public ArrayList<String> getPropertiesOfClassByRange(String owlFileName,
			String className, String rangeClass) {
		return webService.getPropertiesOfClassByRange(owlFileName, className,
				rangeClass);
	}

	public Message validateUser(String username, String password) {
		return webService.validateUser(username, password);
	}

	public Message addUser(String username, String password, String uri) {
		return webService.addUser(username, password, uri);
	}

	public Message removeUser(String username) {
		return webService.removeUser(username);
	}

	public Message changePassword(String username, String currentPassword,
			String newPassword) {
		return webService
				.changePassword(username, currentPassword, newPassword);
	}

}