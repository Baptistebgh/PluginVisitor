import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Hashtable;

public class Arborescence {
	
	static int total = 0;
	static int sansextension = 0;

	//Prend en param�tre le chemin
	public static int StringCompteur(String docPath) throws IOException{
		
		int count = 0;
		
		FileInputStream fis = new FileInputStream(docPath);

		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		
		while ((l.readLine())!=null) 
			{
				count = l.getLineNumber();
			}
			
			return(count);
		}
	
	public static HashMap  recurseDirs(String repertoire, StringBuffer b, HashMap L){
		File fichier = new File(repertoire);
		String list[] ={};
		StringBuffer a = new StringBuffer();
		a=a.append(" ");
		
		
		if (fichier.isDirectory())
		{
			list = fichier.list();
		
			for (int i = 0; i < list.length ; i++)
			{
				System.out.println(L.get(total));
					
				File var= new File(repertoire+ File.separatorChar + list[i]);
				if(var.isDirectory() && !list[i].startsWith(".") && !list[i].startsWith("target")){
							
					
					recurseDirs(repertoire+"/" +list[i], b, L);
					
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
							System.out.println(total);
						}
					else if (L.containsKey(list[i].substring(list[i].lastIndexOf(".")))){
							int h = (int) L.get(list[i].substring(list[i].lastIndexOf(".")));
							try {
								h=h+StringCompteur(repertoire+"/"+list[i]);
								L.put(list[i].substring(list[i].lastIndexOf(".")),h);
								total=total+StringCompteur(repertoire+"/"+list[i]);
								// System.out.println(list[i]);
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							System.out.println(total);	
					}
					
					else{
						try {
							L.put(list[i].substring(list[i].lastIndexOf(".")),StringCompteur(repertoire+"/"+list[i]));
							total=total+StringCompteur(repertoire+"/"+list[i]);
							System.out.println(total);
							
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

	public static void main (String[] args){
		HashMap lesfichiers = new HashMap();

		
		float [] taille= new float [40];
		StringBuffer fichiers = new StringBuffer();
		recurseDirs("D:/Users/beghinb/lutece-dev4", fichiers, lesfichiers);
		lesfichiers.put("total",total);
		lesfichiers.put("sansex", sansextension);
		System.out.println(lesfichiers);
	}
}