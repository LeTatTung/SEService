package user;
import java.io.*;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class XMLWrite {
	private String file;
	public XMLWrite(String file)
	{
		this.file = file;
	}
	
    public void saveUser(ArrayList<User> lstUser) throws Exception{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document testDoc = builder.newDocument();

        Element el = testDoc.createElement("root");
        testDoc.appendChild(el);

        for (User user: lstUser)
        {
        	Element userNode = testDoc.createElement("user");
        	userNode.setAttribute("password", user.getPassword());
        	userNode.setAttribute("username", user.getUsername());
        	userNode.setAttribute("uri", user.getUri());
        	el.appendChild(userNode);        	
        }
        
        DOMSource source = new DOMSource(testDoc);
        
        PrintStream ps = new PrintStream(file);
        StreamResult result = new StreamResult(ps);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.transform(source, result);
    }    
    
    public static void main(String args[])
    {
    	XMLWrite write= new XMLWrite("C:\\workspace\\Data\\db.xml");
    	ArrayList<User> lstUser = new ArrayList<User>();
    	lstUser.add(new User("admin", "admin", ""));
    	try {
			write.saveUser(lstUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
