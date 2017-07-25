import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

import org.json.JSONObject;

import org.omg.CORBA.portable.InputStream;

public class Main {

	public static void main(String[] args) {
		
		VisitorCompteur visitCount = new VisitorCompteur();
		VisitorFiles visitFiles = new VisitorFiles();
		VisitorSize visitSize= new VisitorSize();
		VisitorStatic visitStatic= new VisitorStatic();
		VisitorClass visitClass= new VisitorClass();
		VisitorPlugin visitPlugin= new VisitorPlugin();
		
		FilesStructure.accept(visitSize, "/home/oscar/Documents/lutece-dev2");
		FilesStructure.accept(visitCount, "/home/oscar/Documents/lutece-dev2");
		FilesStructure.accept(visitStatic, "/home/oscar/Documents/lutece-dev2");
		FilesStructure.accept(visitFiles, "/home/oscar/Documents/lutece-dev2");
		FilesStructure.accept(visitClass, "/home/oscar/Documents/lutece-dev2");
		FilesStructure.accept(visitPlugin, "/home/oscar/Documents/lutece-dev2");
		
		HashMap mapSize = visitSize.getsizeL();
		HashMap mapFile = visitFiles.getfichiers();
		HashMap mapCount = visitCount.getL();
		int T = visitStatic.getstatic();
		int C = visitClass.getclass();
		String[] M = visitPlugin.getplugin();
		for (int k=0; k< M.length; k++){
			if (M[k]!=null){
				System.out.println(M[k]);
			}
		}
		
		
		//JSON

		// Size in JSON
		JSONObject jsonSize = new JSONObject();
		Set<String> sizeSet= mapSize.keySet();
	    String[] stringSize = sizeSet.toArray(new String[sizeSet.size()]);
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
	    	
	    	if (A.equals(1)){
	    		jsonFile.put(stringFile[k], A+" fichier");
	    	}else{
	    		jsonFile.put(stringFile[k], A+" fichiers");
	    	}
	    }
	    System.out.printf( "\n\nNumber of files: %s", jsonFile.toString(2) );
	    
	    
	  //Number of Static Class and Class in JSON
	  JSONObject jsonClass = new JSONObject();
	  jsonClass.put("Nombre de m�thodes Statiques", T);
	  jsonClass.put("Nombre de classes", C);

	  System.out.printf( "\n\nJSON Classes: %s", jsonClass.toString(2) );

	}

}

