<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ReDeFer RDF2HTML - RDF to HTML+RDFa Renderer</title>
	<link href="style/input.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
	  function setFormAction(form) {
	    var actionSelectionField = document.getElementById('action').options;
	     form.action = actionSelectionField[actionSelectionField.selectedIndex].value;
	    }
	</script>
  </head>
  
  <body>
	<h1>ReDeFer RDF2HTML - RDF to HTML+RDFa Renderer</h1>
	<form accept-charset="UTF-8" name="rdf2html" method="post" target="_blank" onsubmit="setFormAction(this);">
	    <p>Input RDF/XML or URI pointing to RDF/XML content :</p>
	    <p><textarea cols="150" rows="20" name="rdf" id="rdf">
      Input xml (ex: http://dbpedia.org/resource/Semantic_Web)
    </textarea></p>
	    <p>Action:</p>
	    <p><select id="action" name="action">
	      <option value="rdf2html">Generate HTML</option>
	      <option value="rdf2htmlrdfa" selected="selected">Generate HTML with embedded RDFa</option>
	      <option value="rdf2rdfa">Generate just RDFa, without visible HTML</option>
	      <option value="rdf2microdata">Generate just Microdata, without visible HTML</option>
	    </select></p>
	    <p>Mode:</p>
	    <p><select id="mode" name="mode">
	      <option value="html" selected="selected">HTML page (with header, body and CSS applied)</option>
	      <option value="snippet">Snippet (no HTML header, body and no styling)</option>
	    </select></p>
	    <p>Show namespaces:</p>
	    <p><select id="namespaces" name="namespaces">
	      <option value="false" selected="selected">Don't show, use labels for preferred language or local-names</option>
	      <option value="true">Show namespaces, using CURIEs</option>
	    </select></p>
	    <p>Language (en, es, de, fr,...):</p>
	    <p><input type="text" value="en" id="language" name="language" /> (Filters preferred language if defined in input RDF using xml:lang)</p>
	    <!-- p>Input format:</p>
	    <p><select name="lang" id="lang">
			<option selected="selected" value="RDF/XML">RDF/XML</option>
			<option value="N-TRIPLE">N-Triples</option>
			<option value="N3">N3</option>
		</select></p -->
	    <input type="submit" name="Submit" value="Submit" />
	</form>
  </body>
</html>
