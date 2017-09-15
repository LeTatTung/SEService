package deleteCode;

import java.util.ArrayList;

import consistent.ConsistentOntology;
import ws.owl.WebService;

public class RemoveCodeComponent {

	private void deleteField(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listComment = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_COMMENT);
		if(listComment.size() != 0){
			for(String s:listComment){
				WebService.shareData.getOntologyManager(owlFileName).removeIndividual(s);
			}
		}
		
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
		
	}
	
	private void deleteInterface(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listComment = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_COMMENT);
		if(listComment.size() != 0){
			for(String s:listComment){
				WebService.shareData.getOntologyManager(owlFileName).removeIndividual(s);
			}
		}
		
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
		
	}
	private void deleteAbstractClass(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listComment = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_COMMENT);
		if(listComment.size() != 0){
			for(String s:listComment){
				WebService.shareData.getOntologyManager(owlFileName).removeIndividual(s);
			}
		}
		
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
		
	}
	
	private void deleteMethod(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listComment = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_COMMENT);
		if(listComment.size() != 0){
			for(String s:listComment){
				WebService.shareData.getOntologyManager(owlFileName).removeIndividual(s);
			}
		}
		
		ArrayList<String> listParameter = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_PARAMETER);
		if(listParameter.size() != 0){
			for(String s:listParameter){
				WebService.shareData.getOntologyManager(owlFileName).removeIndividual(s);
			}
		}
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
	}
	
	private void deleteParameter(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listComment = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_COMMENT);
		if(listComment.size() != 0){
			for(String s:listComment){
				WebService.shareData.getOntologyManager(owlFileName).removeIndividual(s);
			}
		}
		
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
	}
	
	private void deleteClass(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listComment = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_COMMENT);
		if(listComment.size() != 0){
			for(String s:listComment){
				WebService.shareData.getOntologyManager(owlFileName).removeIndividual(s);
			}
		}
		ArrayList<String> listField = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_FIELD);
		if(listField.size() != 0){
			for(String s:listField){
				deleteField(owlFileName, s, true);
			}
		}
		
		ArrayList<String> listMethod = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_METHOD);
		if(listMethod.size() != 0){
			for(String s:listMethod){
				deleteMethod(owlFileName, s, true);
			}
		}
		
		ArrayList<String> listConstructor = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_CONSTRUCTOR);
		if(listConstructor.size() != 0){
			for(String s:listConstructor){
				/**
				 * Xoa constructor nhu xoa method
				 */
				deleteMethod(owlFileName, s, true);
			}
		}
		
		/**
		 * Mot class lai co the chua nhieu class khac trong no
		 */
		ArrayList<String> listClass = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_CLASS);
		if(listClass.size() != 0){
			for(String s:listClass){
				deleteClass(owlFileName, s, true);
			}
		}
		
		/**
		 * Mot class lai co the chua nhieu interface khac trong no
		 */
		ArrayList<String> listInterface = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_INTERFACE);
		if(listInterface.size() != 0){
			for(String s:listInterface){
				deleteInterface(owlFileName, s, true);
			}
		}
		
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
	}
	
	private void deleteSourceFile(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listClass = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_CLASS);
		if(listClass.size() != 0){
			for(String s:listClass){
				deleteClass(owlFileName, s, true);
			}
		}
		
		ArrayList<String> listInterface = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_INTERFACE);
		if(listInterface.size() != 0){
			for(String s:listInterface){
				deleteInterface(owlFileName, s, true);
			}
		}
		
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
	}
	
	private void deletePackage(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listSourceFile = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_SOURCE);
		if(listSourceFile.size() != 0){
			for(String s:listSourceFile){
				deleteSourceFile(owlFileName, s, true);
			}
		}
		
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
	}
	
	private void deleteFolderSourceCode(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listPackage = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_PACKAGE);
		if(listPackage.size() != 0){
			for(String s:listPackage){
				deletePackage(owlFileName, s, true);
			}
		}
		
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
	}
	
	private void deleteProject(String owlFileName, String uri, boolean removeItself){
		ArrayList<String> listFolderSourceCode = WebService.shareData.getOntologyManager(owlFileName).getValueOfSpecificPropertyForIndividual(uri, ConsistentOntology.HAS_FOLDER_SOURCE);
		if(listFolderSourceCode.size() != 0){
			for(String s:listFolderSourceCode){
				deleteFolderSourceCode(owlFileName, s, true);
			}
		}
		
		if(removeItself){
			WebService.shareData.getOntologyManager(owlFileName).removeIndividual(uri);
		}
	}
	
	public void deleteCodeIndividual(String owlFileName, String uri, Boolean remove){
		String typeOfIndividual =  WebService.shareData.getOntologyManager(owlFileName).getClassOfIndividual(uri);
		
		if(typeOfIndividual.equals(ConsistentOntology.FIELD)){
			deleteField(owlFileName, uri, remove);
		}
		else if(typeOfIndividual.equals(ConsistentOntology.INTERFACE)){
			deleteInterface(owlFileName, uri, remove);
		}
		else if(typeOfIndividual.equals(ConsistentOntology.ABSTRACT_CLASS)){
			deleteAbstractClass(owlFileName, uri, remove);
		}
		else if(typeOfIndividual.equals(ConsistentOntology.METHOD)){
			deleteMethod(owlFileName, uri, remove);
		}
		else if(typeOfIndividual.equals(ConsistentOntology.CLASS)){
			deleteClass(owlFileName, uri, remove);
		}
		else if(typeOfIndividual.equals(ConsistentOntology.PACKAGE)){
			deletePackage(owlFileName, uri, remove);
		}
		else if(typeOfIndividual.equals(ConsistentOntology.SOURCEFILE)){
			deleteSourceFile(owlFileName, uri, remove);
		}
		else if(typeOfIndividual.equals(ConsistentOntology.PARAMATER)){
			deleteParameter(owlFileName, uri, remove);
		}
		else if(typeOfIndividual.equals(ConsistentOntology.FOLDERSOURCECODE)){
			deleteFolderSourceCode(owlFileName, uri, remove);
		}
		else if(typeOfIndividual.equals(ConsistentOntology.PROJECT)){
			deleteProject(owlFileName, uri, remove);
		}
	}
}