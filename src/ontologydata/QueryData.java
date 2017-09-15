package ontologydata;
import java.util.ArrayList;
import java.util.Map;

import ontologyDataSructure.*;;
public class QueryData {
	private ArrayList<String> VariableList;
	private ArrayList<MapData> ResultMap;
	public ArrayList<String> getVariableList() {
		return VariableList;
	}
	public void setVariableList(ArrayList<String> variableList) {
		VariableList = variableList;
	}
	public ArrayList<MapData> getResultMap() {
		return ResultMap;
	}
	public void setResultMap(ArrayList<MapData> resultMap) {
		ResultMap = resultMap;
	}
	public QueryData(ArrayList<String> variableList,
			ArrayList<MapData> resultMap) {
		super();
		VariableList = variableList;
		ResultMap = resultMap;
	}
	
	public QueryData(){
		
	}
	
	public QueryData(QueryResultMapData result){
	super();
	Map<String, ArrayList<String>> tmpmap = result.getResultMap();
	ArrayList<MapData> tmp = new ArrayList<MapData>();
	for (String key:tmpmap.keySet())
	{
		MapData tmpmapdata = new MapData();
		tmpmapdata.setKey(key);
		tmpmapdata.setObject(tmpmap.get(key));
		tmp.add(tmpmapdata);
	}
	this.VariableList = result.getVariableList();
	this.ResultMap = tmp;
	}
}
