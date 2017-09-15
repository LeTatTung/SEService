package saveDocumentData;

import java.util.ArrayList;

public class DocumentSaveData {
	private String id;
	private String label;
	private String fileName;
	private int pageNumbers;
	
	private Section rootSection;
	private ArrayList<DocumentElement> paragraphs;
	private ArrayList<DocumentElement> images;
	
	
	public int getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public void DocumentSaveData()
	{
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Section getRootSection() {
		return rootSection;
	}
	public void setRootSection(Section rootSection) {
		this.rootSection = rootSection;
	}
	public ArrayList<DocumentElement> getParagraphs() {
		return paragraphs;
	}
	public void setParagraphs(ArrayList<DocumentElement> paragraphs) {
		this.paragraphs = paragraphs;
	}
	public ArrayList<DocumentElement> getImages() {
		return images;
	}
	public void setImages(ArrayList<DocumentElement> images) {
		this.images = images;
	}
	
}
