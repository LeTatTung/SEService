package consistent;

public class ConsistentOntology {
	public static final String SEC_NAMESPACE="http://hut.edu.vn/ontology/sourcecode#";
	public static final String DOC_NAMESPACE="http://hut.edu.vn/ontology/document#";
	
	public static String prefix =   
		  "\nPREFIX SEC: <"+SEC_NAMESPACE+"> "
		+ "\nPREFIX DOC: <"+DOC_NAMESPACE+"> "
		+ "\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
		+ "\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
		+ "\nPREFIX fn: <http://www.w3.org/2005/xpath-functions#> " 
		+ "\nPREFIX owl: <http://www.w3.org/2002/07/owl#> "
		+ "\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>";
	
	public static final String DOC_TYPE_CLASS=DOC_NAMESPACE+"Document";
	public static final String SECTION =DOC_NAMESPACE+"Section";
	public static final String PARAGRAPH=DOC_NAMESPACE+"Paragraph";
	public static final String IMAGE=DOC_NAMESPACE+"Image";
	
	public static final String SECTION_HAS_SECTION =DOC_NAMESPACE+"hasSection";
	public static final String SECTION_HAS_PARAGRAPH =DOC_NAMESPACE+"hasParagraph";
	public static final String SECTION_HAS_IMAGE =DOC_NAMESPACE+"hasImage";
	public static final String SECTION_HAS_FULL_INDEX =DOC_NAMESPACE+"numberingPartOfSection";
	public static final String SECTION_HAS_LEVEL =DOC_NAMESPACE+"levelOfSection";
	public static final String DOCUMENT_ELEMENT_HAS_TEXT_CONTENT = DOC_NAMESPACE+"hasTextContent";
	public static final String DOCUMENT_ELEMENT_HAS_PAGE_BEGIN = DOC_NAMESPACE+"hasBeginPage";
	public static final String DOCUMENT_ELEMENT_HAS_PAGE_END = DOC_NAMESPACE+"hasEndPage";
	public static final String DOCUMENT_HAS_PAGE_NUMBERS = DOC_NAMESPACE+"totalPagesOfDocument";
	
	public static final String REQUIREMENT = SEC_NAMESPACE + "Requirement";
	public static final String WORKSPACE = SEC_NAMESPACE + "Workspace";
	public static final String PROJECT = SEC_NAMESPACE + "Project";
	public static final String FOLDERSOURCECODE = SEC_NAMESPACE + "FolderSourceCode";
	public static final String PACKAGE = SEC_NAMESPACE + "Package";
	public static final String LAYER = SEC_NAMESPACE + "Layer";
	public static final String LIBRARY = SEC_NAMESPACE + "Library";
	public static final String SOURCEFILE = SEC_NAMESPACE + "SourceFile";
	public static final String JAVAPRIMARYTYPE = SEC_NAMESPACE + "JavaPrimaryType";
	public static final String CLASS = SEC_NAMESPACE + "Class";
	public static final String CONSTRUCTOR = SEC_NAMESPACE + "Constructor";
	public static final String VARIABLE = SEC_NAMESPACE + "Variable";
	public static final String FIELD  = SEC_NAMESPACE+"Field";
	public static final String PARAMATER  = SEC_NAMESPACE+"Paramater";
	public static final String JAVAMODIFIER  = SEC_NAMESPACE+"JavaModifier";
	public static final String HAS_PARAMETER  = SEC_NAMESPACE+"hasParameter";
	public static final String ABSTRACT_CLASS  = SEC_NAMESPACE+"AbstractClass";

	public static final String METHODSIGNATURE = SEC_NAMESPACE + "MethodSignature";
	public static final String INTERFACE = SEC_NAMESPACE + "Interface";
	public static final String METHOD = SEC_NAMESPACE + "Method";
	public static final String COMMENT = SEC_NAMESPACE + "Comment";
	public static final String TEST = SEC_NAMESPACE + "Test";
	public static final String UNIT_TEST = SEC_NAMESPACE + "UnitTest";
	public static final String INTERGRATION_TEST = SEC_NAMESPACE + "IntegrationTest";
	public static final String CLASS_METRIC = SEC_NAMESPACE + "ClassMetric";	
	public static final String PACKAGE_METRIC = SEC_NAMESPACE + "PackageMetric";
	public static final String LAYER_METRIC = SEC_NAMESPACE + "LayerMetric";
	public static final String METHOD_METRIC = SEC_NAMESPACE + "MethodMetric";	
	public static final String PROJECT_METRIC = SEC_NAMESPACE + "ProjectMetric";	
	



	public static final String HAS_PROJECT = SEC_NAMESPACE + "hasProject";
	public static final String HAS_FOLDER_SOURCE = SEC_NAMESPACE+"hasFolderSourceCode";
	public static final String HAS_LIBRARY = SEC_NAMESPACE + "hasLibrary";
	public static final String HAS_PACKAGE = SEC_NAMESPACE + "hasPackage";
	public static final String HAS_CLASS   = SEC_NAMESPACE + "hasClass";
	public static final String HAS_INTERFACE  = SEC_NAMESPACE + "hasInterface";

	public static final String USES_METHOD = SEC_NAMESPACE + "usesMethod";
	public static final String HAS_TYPE = SEC_NAMESPACE + "hasType";
	public static final String HAS_VARIABLE = SEC_NAMESPACE + "hasVariable";
	public static final String HAS_MODIFIER = SEC_NAMESPACE + "hasModifier";
	public static final String HAS_SOURCE = SEC_NAMESPACE + "hasJavaSourceFile";
	public static final String HAS_METHODSIGNATURE = SEC_NAMESPACE + "hasMethodSignature";
	public static final String EXTENDS = SEC_NAMESPACE + "extendsClass";
	public static final String HAS_METHOD = SEC_NAMESPACE + "hasMethod";
	public static final String METHOD_OF = SEC_NAMESPACE + "methodOf";
	public static final String FULL_PATH = SEC_NAMESPACE + "hasFullPath";
	public static final String IMPLEMENTS_INTERFACE = SEC_NAMESPACE + "implementsInterface";
	public static final String HAS_CONSTRUCTOR = SEC_NAMESPACE + "hasConstructor";
	public static final String HAS_FIELD = SEC_NAMESPACE + "hasField";


	public static final String NUM_INTERFACES = SEC_NAMESPACE+"mectricNumberOfInterfaces";
	public static final String NUM_CLASSES =SEC_NAMESPACE+"mectricNumberOfClasses";
	public static final String NUM_ATTRIBUTES =SEC_NAMESPACE+ "mectricNumberOfAttributes";
	public static final String NUM_METHODS = SEC_NAMESPACE+"mectricNumberOfMethods";
	public static final String HAS_METRIC = SEC_NAMESPACE + "hasMetric";


	public static final String IS_TEST_OF = SEC_NAMESPACE + "isTestOf";
	public static final String HAS_TEST = SEC_NAMESPACE + "hasTest";

	
	public static final String HAS_COMMENT = SEC_NAMESPACE + "hasComment";
	public static final String RETURN_TYPE = SEC_NAMESPACE + "returnType";
	public static final String HAS_PARAMATER_TYPE = SEC_NAMESPACE + "hasParameter";
	public static final String  AUTHOR = SEC_NAMESPACE+"javadocAuthor";
	public static final String  DESCRIPTION = SEC_NAMESPACE+"javadocDescription";
	public static final String  PARAMS = SEC_NAMESPACE+"javadocParams";
	public static final String  RETURN = SEC_NAMESPACE+"javadocReturn";
	
 
	public static final String HAS_TEXT_CONTENT = DOC_NAMESPACE + "hasTextContent";
	
	
	public static final String IN_PAGE = DOC_NAMESPACE+"elementInPage";
	public static final String HAS_RELATION_SOURCE = DOC_NAMESPACE+"docRelatedToCode";
	public static final String CREATED_AT = DOC_NAMESPACE+"documentOrElementcreatedAt";
	
	//file luu select
	public static String selectFile = "C:/workspace/MitaniSEPlugin/select.properties";
	
	
	public static final String TYPE_VIEW_ALL="viewAll";
	public static final String TYPE_VIEW_COMPONENT ="viewComponent";
	
}
