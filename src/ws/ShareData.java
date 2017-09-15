package ws;

import hut.se.log.Config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import ontologyDataSructure.BKClass;
import ontologyDataSructure.BKProperty;
import ontologyManager.OntologyManager;
import ontologyOperator.ClassOperator;
import ontologyOperator.PropertyOperator;

/**
 * 
 * @author MrHien
 * 
 */
public class ShareData {

	public static OntologyManager defaultOntologyManager =loadDefaultOntologyManger ();
	
	public static Map<String, OntologyManager> ontologyManagerMap = new HashMap<String, OntologyManager>();

	public static OntologyManager loadDefaultOntologyManger()
	{
		OntologyManager result=null; 
		
		//Lay ra folder data trong setting
		File dir=new File(Config.getDataFolder());
		if (dir.isDirectory())
		{
			File f = new File (dir.getAbsolutePath()+File.separator + Config.getDefaultOntologyFileName());
			
			//Lấy URL để load ontology vào model
			URL url = null;
			try {
				url = f.toURL();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
			//Load ontology
			result = new OntologyManager(url.toString());
			
			//Khoi tao cache data:
			for (BKClass cls: result.listClasses())
			{
				ClassOperator oper = result.cacheData.getClassOperator(cls.getURI());
				oper.getAllProperties(true);
				oper.getAllProperties(false);
			}
			for (BKProperty prop: result.listProperties())
			{
				PropertyOperator oper = result.cacheData.getPropertyOperator(prop.getURI());
				oper.getSpecificDataType();
				oper.getListPropertyDomains();
				oper.getListPropertyRanges();
			}
			
			//Load rule
			File annotDir = new File (dir.getAbsolutePath()+File.separator + Config.getDefaultAnnotationFolder()+File.separator+Config.getRuleFolder());
			loadAnnotationFolder(annotDir, result);
			
			//Load annoatation trong thu muc annotation chi ra trong file cau hinh			
			annotDir = new File (dir.getAbsolutePath()+File.separator + Config.getDefaultAnnotationFolder());
			loadAnnotationFolder(annotDir, result);
		}
		return result;
	}
	
	public static OntologyManager loadJustOntology()
	{
		OntologyManager result=null; 
		File dir=new File(Config.getDataFolder());
		if (dir.isDirectory())
		{
			File f = new File (dir.getAbsolutePath()+File.separator + Config.getDefaultOntologyFileName());
			
			//Lấy URL để load ontology vào model
			URL url = null;
			try {
				url = f.toURL();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
			//Load ontology
			result = new OntologyManager(url.toString());
		}
		return result;
	}
	
	/**
	 * This method is used to test
	 * 
	 * @param owlFileName
	 * @return
	 */
	public boolean isInitited(String owlFileName) {
		if ((owlFileName == null)
				|| (owlFileName.equals(Config.getDefaultOntologyFileName())))
			return true;
		else {
			if (ontologyManagerMap.containsKey(owlFileName))
				return true;
			else
				return false;
		}
	}

	/**
	 * Lay mot OntologyManager ma service hien dang quan ly, neu chua co thi load vao.
	 * 
	 * @param key
	 *  Neu key null thi tra ve OntologyManager chung
	 *  Neu key "" thi tra ve OntologyManager chi chua ontology, khong co annotation, khong co luat
	 *  Neu khong lay trong thu muc data
	 * @return
	 */
	public OntologyManager getOntologyManager(String key) {
		OntologyManager ontologyResult = null;
		if (key == null) {
			return defaultOntologyManager;
		} 
		else if (ontologyManagerMap.get(key) == null) 
		{

			File dir = new File(Config.getDataFolder());
			File f;
			if (key.equals(""))
				f = new File (dir.getAbsolutePath() + File.separator + Config.getDefaultOntologyFileName());
			else
				f = new File (dir.getAbsolutePath() + File.separator + key);

			// Lấy URL để load ontology vào model
			URL url = null;
			try {
				url = f.toURL();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			// Load ontology
			ontologyResult = new OntologyManager(url.toString());
			ontologyManagerMap.put(key, ontologyResult);

		} 
		else {
			ontologyResult = ontologyManagerMap.get(key);
		}

		return ontologyResult;
	}

	/**
	 * Xoa mot ontologyManager ra khoi Map
	 * 
	 * @param key
	 * @return
	 */
	public boolean deleteOntologyManager(String key) {
		try {
			ontologyManagerMap.remove(key);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getCause());
			return false;
		}
		return true;
	}

	/**
	 * Xoa va load lai 1 ontologyManager trong Map
	 * 
	 * @param key
	 * @return
	 */
	public boolean reloadOntologyManager(String key) {
		if (key == null){
			defaultOntologyManager = loadDefaultOntologyManger();
			return true;
		}
		else {
			try {
				this.deleteOntologyManager(key);
				this.getOntologyManager(key);
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e.getCause());
				return false;
			}
			return true;
		}
	}
	
	/**
	 * Load tiep cac file owl trong 1 thu muc vao 1 OntologyManager
	 * @param dir
	 * @param result
	 */
	private static void loadAnnotationFolder(File annotDir, OntologyManager result)
	{
		if (annotDir.isDirectory())
		{
			for (File annotFile:annotDir.listFiles())
			{
				String fileName = annotFile.getName();
				String ext = "";
				int dotInd = fileName.lastIndexOf('.');
			    ext = (dotInd > 0) ? fileName.substring(dotInd+1) : "";
				if (annotFile.isFile() && ext.toLowerCase().equals("owl"))
				{
					try {
						URL url = annotFile.toURL();
						System.out.println(url);
						result.readOntology(url.toString());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
