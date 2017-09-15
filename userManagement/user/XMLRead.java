package user;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.*;
import org.w3c.dom.*;


public class XMLRead {
	private String file;
	public XMLRead(String file)
	{
		this.file = file;
	}
    public ArrayList<User> readUser() throws Exception  { 
    	ArrayList<User> result = new ArrayList<User>();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document doc = builder.parse(new File(file));

        Element rootElement = doc.getDocumentElement();

        NodeList list = rootElement.getElementsByTagName("user");
        
        for (int i = 0; i < list.getLength(); i++) {
        	Node childNode = list.item(i);
        	
        	NamedNodeMap map=childNode.getAttributes();
        	String password = "";
        	String username = "";
        	String uri = "";
        	for (int j=0; j<map.getLength(); ++j)
        	{
        		Node node = map.item(j);        		
        		if (node!=null)
        		{
        			String s =node.getNodeName();
        			if (s.equals("password"))
        				password = node.getNodeValue();
        			if (s.equals("username"))
        				username = node.getNodeValue();
        			if (s.equals("uri"))
        				uri = node.getNodeValue();
        		}
        	}
        	if (username != "" && password != "")
        	{
        		User user = new User(username, password, uri);
        		result.add(user);
        	}
        }
        return result;
    }
}
