package saveDocumentData;

import java.util.ArrayList;
import java.util.List;

import ws.ShareData;

import consistent.ConsistentOntology;

public class SectionDataAdapter {
	public static ShareData shareData = new ShareData();
	
	/**
	 * Tao cau truc section lay duoc tu ontolgy
	 * 
	 * @param owlFileName
	 * @param id
	 */
	public Section createAllChildSection(String owlFileName, String id, ArrayList<DocumentElement> paragraphs, ArrayList<DocumentElement> images ) {
		// section dang xet
		Section startSection = new Section();
		startSection.setId(id);
		String textContent;
		try {
			textContent = shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(id, ConsistentOntology.DOCUMENT_ELEMENT_HAS_TEXT_CONTENT).get(0);
		} catch (Exception e) {
			textContent = "";
			e.printStackTrace();
		}
		
		
		startSection.setTextContent(textContent);
		
		// set thuoc tinh full index cho section
		try {
			startSection.setFullIndex(shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(id, ConsistentOntology.SECTION_HAS_FULL_INDEX).get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// set thuoc tinh level cho section
		startSection.setLevel(Integer.valueOf(shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(id, ConsistentOntology.SECTION_HAS_LEVEL).get(0)));

		// set page begin cho section
		try {
			startSection.setBeginPage(Integer.valueOf(shareData.getOntologyManager(owlFileName)
					.getValueOfSpecificPropertyForIndividual( id,
							ConsistentOntology.DOCUMENT_ELEMENT_HAS_PAGE_BEGIN)
					.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// set page end cho section
		try {
			startSection.setEndPage(Integer.valueOf(shareData.getOntologyManager(owlFileName)
					.getValueOfSpecificPropertyForIndividual( id,
							ConsistentOntology.DOCUMENT_ELEMENT_HAS_PAGE_END)
					.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// set section con cho section
		List<String> childrensSectionId = new ArrayList<String>();
		try {
			childrensSectionId = shareData.getOntologyManager(owlFileName)
					.getValueOfSpecificPropertyForIndividual(id,
							ConsistentOntology.SECTION_HAS_SECTION);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Tao cac section con
		if (childrensSectionId.size() > 0) {
			startSection.setChildrens(new ArrayList<Section>());
			for (int i = 0; i < childrensSectionId.size(); i++) {
				try {
					startSection.addChildren(createAllChildSection(owlFileName,
							childrensSectionId.get(i), paragraphs, images));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else{
			ArrayList<String> listParagraphID = new ArrayList<String>();
			ArrayList<String> listImageID = new ArrayList<String>();
			listParagraphID = shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual( id, ConsistentOntology.SECTION_HAS_PARAGRAPH);
			listImageID = shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual( id, ConsistentOntology.SECTION_HAS_IMAGE);
			// Lay ra cac thong tin paragraph load vao list cac doi tuong documentElement
			int paragraphSize = listParagraphID.size();
			int imageSize = listImageID.size();
			int nameSpaceLength = ConsistentOntology.DOC_NAMESPACE.length();
			if (paragraphSize>0){
				for(int i=0; i<paragraphSize; i++){
					DocumentElement paragraphData = new DocumentElement();
					String paragraphID = listParagraphID.get(i);
					String paragraphLabel = listParagraphID.get(i).substring(nameSpaceLength);
					String paragraphText = shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual( paragraphID, ConsistentOntology.DOCUMENT_ELEMENT_HAS_TEXT_CONTENT).get(0);
					String pragraphPage = shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual( paragraphID, ConsistentOntology.DOCUMENT_ELEMENT_HAS_PAGE_BEGIN).get(0);
					
					paragraphData.setId(paragraphID);
					paragraphData.setLabel(paragraphLabel);
					paragraphData.setTextContent(paragraphText);
					paragraphData.setBeginPage(Integer.valueOf(pragraphPage));
					paragraphData.setEndPage(Integer.valueOf(pragraphPage));
					// them vao list paragraph truyen vao
					paragraphs.add(paragraphData);
				}
			}
			
			if (imageSize>0){
				for (int i=0; i<imageSize; i++){
					DocumentElement imageData = new DocumentElement();
					String imageID = listImageID.get(i);
					String imageLabel = listImageID.get(i).substring(nameSpaceLength);
					String imageText = shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual( imageID, ConsistentOntology.DOCUMENT_ELEMENT_HAS_TEXT_CONTENT).get(0);
					String imagePage = shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual( imageID, ConsistentOntology.DOCUMENT_ELEMENT_HAS_PAGE_BEGIN).get(0);
					
					imageData.setId(imageID);
					imageData.setLabel(imageLabel);
					imageData.setTextContent(imageText);
					imageData.setBeginPage(Integer.valueOf(imagePage));
					imageData.setEndPage(Integer.valueOf(imagePage));
					// them vao list image truyen vao
					images.add(imageData);
				}
			}
		}
		return startSection;
	}
}
