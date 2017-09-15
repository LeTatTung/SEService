package saveDocumentData;

import java.util.ArrayList;

public class Section extends DocumentElement {
	private String fullIndex;
	private ArrayList<Section> childrens;
	private int level;
	
	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public Section() {
	}

	

	public String getFullIndex() {
		return fullIndex;
	}



	public void setFullIndex(String fullIndex) {
		this.fullIndex = fullIndex;
	}



	public ArrayList<Section> getChildrens() {
		return childrens;
	}



	public void setChildrens(ArrayList<Section> childrens) {
		this.childrens = childrens;
	}



	public void addChildren(Section section) {
		this.getChildrens().add(section);
	}
}
