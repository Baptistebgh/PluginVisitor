import java.util.HashMap;
import java.util.Set;

import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		
		VisitorCompteur visitCount = new VisitorCompteur();
		VisitorFiles visitFiles = new VisitorFiles();
		VisitorSize visitSize= new VisitorSize();
		VisitorStatic visitStatic= new VisitorStatic();
		VisitorClass visitClass= new VisitorClass();
		
		FilesStructure.accept(visitSize, "D:/Users/beghinb/lutece-dev4");
		FilesStructure.accept(visitCount, "D:/Users/beghinb/lutece-dev4");
		FilesStructure.accept(visitStatic, "D:/Users/beghinb/lutece-dev4");
		FilesStructure.accept(visitFiles, "D:/Users/beghinb/lutece-dev4");
		FilesStructure.accept(visitClass, "D:/Users/beghinb/lutece-dev4");
		
		HashMap mapSize = visitSize.getsizeL();
		HashMap mapFile = visitFiles.getfichiers();
		HashMap mapCount = visitCount.getL();
		int T = visitStatic.getstatic();
		int C = visitClass.getclass();
		
		/*
		System.out.println(mapSize);
		System.out.println(mapCount);
		System.out.println(" Il y a "+T+" m√©thodes static dans ce dossier");
		System.out.println(mapFile);
		System.out.println(" Il y a "+C+" class dans ce dossier");
		*/
		
		//JSON
		
		// Size in JSON
		JSONObject jsonSize = new JSONObject();
		Set<String> M= mapSize.keySet();
	    String[] stringSize = M.toArray(new String[M.size()]);
	    for(int k =0; k < stringSize.length;k++){
	    	Object A = mapSize.get(stringSize[k]);
		    jsonSize.put(stringSize[k], A);
	    }
	    System.out.printf( "\n\nSize: %s", jsonSize.toString(2) );
	    
	    
	    //Line Count in JSON
	    JSONObject jsonCount = new JSONObject();
		Set<String> countSet= mapCount.keySet();
	    String[] stringCount = countSet.toArray(new String[countSet.size()]);
	    for(int k =0; k < stringCount.length;k++){
	    	Object A = mapCount.get(stringCount[k]);
		    jsonCount.put(stringCount[k], A);
	    }
	    System.out.printf( "\n\nLine Count: %s", jsonCount.toString(2) );
	    
	    
	    //File Count in JSON
	    JSONObject jsonFile = new JSONObject();
		Set<String> fileSet= mapFile.keySet();
	    String[] stringFile = fileSet.toArray(new String[fileSet.size()]);
	    for(int k =0; k < stringFile.length;k++){
	    	Object A = mapFile.get(stringFile[k]);
	    	System.out.println(A);
	    	if (A.equals(1)){
	    		jsonFile.put(stringFile[k], A+" fichier");
	    	}else{
	    		jsonFile.put(stringFile[k], A+" fichiers");
	    	}
	    }
	    System.out.printf( "\n\nNumber of files: %s", jsonFile.toString(2) );
	    
	    
	  //Number of Static Class and Class in JSON
	  JSONObject jsonClass = new JSONObject();
	  jsonClass.put("Nombre de mÈthodes Statiques", T);
	  jsonClass.put("Nombre de classes", C);

	  System.out.printf( "\n\nJSON Classes: %s", jsonClass.toString(2) );
	}

}

