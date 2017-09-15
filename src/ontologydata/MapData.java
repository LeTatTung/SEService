package ontologydata;

import java.util.ArrayList;

public class MapData {
private String key;
private ArrayList<String> object;

public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public ArrayList<String> getObject() {
	return object;
}
public void setObject(ArrayList<String> object) {
	this.object = object;
}

public MapData(){
	
}

public MapData(String key, ArrayList<String> object) {
	super();
	this.key = key;
	this.object = object;
}


}
