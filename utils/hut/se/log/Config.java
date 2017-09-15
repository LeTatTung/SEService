package hut.se.log;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import ws.ShareData;

/**
 * Lấy các thông số cấu hình trong file Cấu hình
 * 
 * @author DatTT
 */

public class Config {
	private static Config configInstance;
	private static Properties properties;
	
	private static String DataFolder;
	private static String DefaultOntologyFileName;
	private static String DefaultAnnotationFolder;
	
	private static String RuleFolder;
	private static String DocumentFolder;
	private static String BackupFolder;
	private static String TempFolder;
	
	private static String Database;
	
	
	/**
	 * Tên file cấu hình
	 */
	private static final String PROPERTY_FILE = "config.properties";

	static
	{
		configInstance = new Config();
		configInstance.regenerateProperties();
	}
	
	
	public static Properties getProperties() {
		return properties;
	}


	public static String getRuleFolder() {
		return RuleFolder;
	}


	public static String getDocumentFolder() {
		return DocumentFolder;
	}


	public static String getBackupFolder() {
		return BackupFolder;
	}


	public static String getDataFolder() {
		return DataFolder;
	}

	public static String getTempFolder() {
		return TempFolder;
	}

	public static String getDatabase() {
		return Database;
	}


	public static String getDefaultOntologyFileName() {
		return DefaultOntologyFileName;
	}


	public static String getDefaultAnnotationFolder() {
		return DefaultAnnotationFolder;
	}


	/**
	 * Load file thuộc tính vào lớp Properties
	 */
    public Properties loadProperty() {
        Properties properties = new Properties();
        try {
        	//InputStream in = new FileInputStream(PROPERTY_FILE);
            properties.load(this.getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
    
	/**
	 * Sinh lại và lưu các thông số cấu hình trong file cấu hình
	 */
	public int regenerateProperties()
	{
		String baseDir = "";
		try {
			File f = new File(new URI(this.getClass().getClassLoader().getResource("config.properties").toString()));
			baseDir = f.getParentFile().getParentFile().getAbsolutePath();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		properties = loadProperty();//Load từ file cấu hình
		
		DefaultOntologyFileName = properties.getProperty("DefaultOntologyFileName");
		DataFolder = new File(baseDir+File.separator+properties.getProperty("DataFolder")).getAbsolutePath();
		DefaultAnnotationFolder=properties.getProperty("DefaultAnnotationFolder");
		
		RuleFolder=properties.getProperty("RuleFolder");
		DocumentFolder=properties.getProperty("DocumentFolder");
		BackupFolder=properties.getProperty("BackupFolder");
		TempFolder=properties.getProperty("TempFolder");
		
		Database = properties.getProperty("Database");
		
		return 0;
	}

}
