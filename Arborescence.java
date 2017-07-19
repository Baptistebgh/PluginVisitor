import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.*;

public class Arborescence {
	
	static int total = 0;
	static int sansextension = 0;

	//Prend en param�tre le chemin
	public static int StringCompteur(String docPath) throws IOException{
		
		int count = 0;
		int d = 0;
		
		FileInputStream fis = new FileInputStream(docPath);

		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		
	
		while ((l.readLine())!=null) 
			{

				count = l.getLineNumber();
			}
		
			
			return(count);
		}
	
	
	/*
	 * private static int getLines(String docPath) throws IOException { 
		File fichier = new File(docPath);
		FileReader fr=new FileReader(fichier);
		BufferedReader br=new BufferedReader(fr); 
		int i=0;
		boolean isEOF=false;
		do{
		String t=br.readLine();
		if(t!=null){
		isEOF=true;
		t=t.replaceAll("\\n|\\t|\\s", "");
		if((!t.equals("")) && (!t.startsWith("//"))) {
		i = i + 1;
		}
		}
		else {
		isEOF=false;
		}
		}while(isEOF);
		br.close();
		fr.close();
		return i;
		}
	*/
	
	public static HashMap  recurseDirs(String repertoire, HashMap L){
		File fichier = new File(repertoire);
		String list[] ={};
		StringBuffer a = new StringBuffer();
		a=a.append(" ");
		
		
		if (fichier.isDirectory())
		{
			list = fichier.list();
		
			for (int i = 0; i < list.length ; i++)
			{					
				File var= new File(repertoire+ File.separatorChar + list[i]);
				if(var.isDirectory() && !list[i].startsWith(".") && !list[i].startsWith("target")){
							
					
					recurseDirs(repertoire+"/" +list[i], L);
					
				}
				else{
					
					// tous les fichiers que l'on ignore dans le d�compte	
					if(!list[i].startsWith(".") && !list[i].startsWith("target") && !list[i].endsWith(".otf") && !list[i].endsWith(".eot") && !list[i].endsWith(".svg") && !list[i].endsWith(".ttf") && !list[i].endsWith(".woff")
							&& !list[i].endsWith(".woff2") && !list[i].endsWith(".gif") && !list[i].endsWith(".png") && !list[i].endsWith(".jpg") && !list[i].endsWith(".jpeg") && !list[i].endsWith(".ico") && !list[i].endsWith(".log")){
				    if(!list[i].contains(".")){
							try {
								sansextension=sansextension+StringCompteur(repertoire+"/"+list[i]);
								total=total+StringCompteur(repertoire+"/"+list[i]);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					else if (L.containsKey(list[i].substring(list[i].lastIndexOf(".")))){
							int h = (int) L.get(list[i].substring(list[i].lastIndexOf(".")));
							try {
								h=h+StringCompteur(repertoire+"/"+list[i]);
								L.put(list[i].substring(list[i].lastIndexOf(".")),h);
								total=total+StringCompteur(repertoire+"/"+list[i]);
										
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					
					else{
						try {
							L.put(list[i].substring(list[i].lastIndexOf(".")),StringCompteur(repertoire+"/"+list[i]));
							total=total+StringCompteur(repertoire+"/"+list[i]);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
				
			}
			
			}
	}
		
		
		return L;
				
	} 
	
	 public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map )
	 {
     List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>( map.entrySet() );
     Collections.sort( list, new Comparator<Map.Entry<K, V>>(){
         public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
         {
             return (o2.getValue()).compareTo( o1.getValue() );
         }
     } 
     );

     Map<K, V> result = new LinkedHashMap<K, V>();
     for (Map.Entry<K, V> entry : list)
     {
         result.put( entry.getKey(), entry.getValue() );
     }
     return result;
 }

	public static void main (String[] args){
		
		HashMap lesfichiers = new HashMap();

		float [] taille= new float [40];
		recurseDirs("D:/Users/beghinb/lutece-dev4", lesfichiers);
		lesfichiers.put("total",total);
		lesfichiers.put("sans_extension", sansextension);
		System.out.println(sortByValue(lesfichiers));		
	}
}