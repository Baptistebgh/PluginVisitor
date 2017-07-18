import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Hashtable;

public class Arborescence {

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
	
	public static HashMap  recurseDirs(int c, String total, String repertoire, StringBuffer b, HashMap L){
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
					
					
					
					recurseDirs(c,total,repertoire+"/" +list[i], b, L);
					
				}
				else{
					
					// tous les fichiers que l'on ignore dans le d�compte	
					if(!list[i].startsWith(".") && !list[i].startsWith("target") && !list[i].endsWith(".otf") && !list[i].endsWith(".eot") && !list[i].endsWith(".svg") && !list[i].endsWith(".ttf") && !list[i].endsWith(".woff")
							&& !list[i].endsWith(".woff2") && !list[i].endsWith(".gif") && !list[i].endsWith(".png") && !list[i].endsWith(".jpg") && !list[i].endsWith(".jpeg") && !list[i].endsWith(".ico") && !list[i].endsWith(".log")){
						
					if (L.containsKey(list[i].substring(list[i].lastIndexOf(".")))){
							int h = (int) L.get(list[i].substring(list[i].lastIndexOf(".")));
							try {
								h=h+StringCompteur(repertoire+"/"+list[i]);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							L.put(list[i].substring(list[i].lastIndexOf(".")),h);
							try {
								c=c+StringCompteur(repertoire+"/"+list[i]);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							L.put(total,c);
								
						
					}
					else{
						try {
							L.put(list[i].substring(list[i].lastIndexOf(".")),StringCompteur(repertoire+"/"+list[i]));
							c=c+StringCompteur(repertoire+"/"+list[i]);
							L.put(total,c);
							
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
		int valeurtotal=0;
		String total= "total";
		lesfichiers.put("total", valeurtotal);
		float [] taille= new float [40];
		StringBuffer fichiers = new StringBuffer();
		System.out.println(recurseDirs(valeurtotal, total,"D:/Users/beghinb/lutece-dev4", fichiers, lesfichiers));
		
	}

}