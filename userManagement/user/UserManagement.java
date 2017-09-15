package user;

import hut.se.log.Config;

import java.io.File;
import java.util.ArrayList;

public class UserManagement {
	String file = Config.getDataFolder()+File.separatorChar+Config.getDatabase();
	
	public Message validateUser(String username, String password) throws Exception
	{
		if (username == "" || password == "")
			return new Message("", false);
		XMLRead xmlRead= new XMLRead(file);
		ArrayList<User> lstUser = xmlRead.readUser();
		for (User user: lstUser)
		{
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return new Message(user.getUri(), true);
		}
		return new Message("User is not exist!", false);
	}
	
	public Message addUser(String username, String password, String uri) throws Exception
	{
		if (username == "" || password == "")
			return new Message("Fail! Username or password can not be empty", false);
		XMLRead xmlRead= new XMLRead(file);
		ArrayList<User> lstUser = xmlRead.readUser();
		for (User user: lstUser)
			if (user.getUsername().equals(username))
				return new Message("Can not add user. User Exist!", false);
		XMLWrite xmlWrite = new XMLWrite(file);
		lstUser.add(new User(username, password, uri));
		xmlWrite.saveUser(lstUser);
		return new Message("Save user success!", true);
	}
	
	public Message removeUser(String username) throws Exception
	{
		XMLRead xmlRead= new XMLRead(file);
		ArrayList<User> lstUser = xmlRead.readUser();
		for (int i =0; i<lstUser.size(); ++i)
			if (lstUser.get(i).getUsername().equals(username))
			{
				lstUser.remove(i);
				XMLWrite xmlWrite = new XMLWrite(file);
				xmlWrite.saveUser(lstUser);
				return new Message("Remove user success!", true);
			}
		return new Message("Cannot find the user!", false);
	}
	
	public Message changePassword(String username, String currentPassword, String newPassword) throws Exception
	{
		if (newPassword == "")
			return new Message("Fail! New password can not be empty", false);
		XMLRead xmlRead= new XMLRead(file);
		ArrayList<User> lstUser = xmlRead.readUser();
		for (User user: lstUser)
			if (user.getUsername().equals(username) && user.getPassword().equals(currentPassword))
			{
				if (newPassword!=currentPassword)
				{
					user.setPassword(newPassword);
					XMLWrite xmlWrite = new XMLWrite(file);
					xmlWrite.saveUser(lstUser);
				}
				return new Message("Change user account success!", true);
				
			}
		return new Message("User or password not match!", false);
		
	}
	public static void main (String args[]) throws Exception
	{
		UserManagement um= new UserManagement();
		System.out.println(um.validateUser("DatTT", "dat123456"));
		System.out.println(um.removeUser("dat"));
		System.out.println(um.addUser("dat", "dat", "http://dfd"));
		System.out.println(um.addUser("hien", "hien", "http://dfd"));
		System.out.println(um.changePassword("dat", "dat1", "abcd"));
		System.out.println(um.validateUser("dat", "abcd"));
	}
}
