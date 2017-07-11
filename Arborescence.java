import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Arborescence {

	//Prend en paramètre le chemin
	public static void StringCompteur(String docPath) throws IOException{
		
		int count = 0;
		
		FileInputStream fis = new FileInputStream(docPath);

		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		
		while ((l.readLine())!=null) 
			{
				count = l.getLineNumber();
			}
			System.out.println("Le fichier "+docPath+" contient "+count+" lignes.");
		}
	
	public static StringBuffer recurseDirs(String repertoire, StringBuffer b){
		File fichier = new File(repertoire);
		String list[] ={};
		StringBuffer a = new StringBuffer();
		String L[]={};
		a=a.append(" ");
		
		
		if (fichier.isDirectory())
		{
			list = fichier.list();
		
			for (int i = 0; i < list.length ; i++)
			{
				
				
				
				
				
				File var= new File(repertoire+ File.separatorChar + list[i]);
				if(var.isDirectory() && !list[i].startsWith(".") && !list[i].startsWith("target")){
					
					
					
					recurseDirs(repertoire+"/" +list[i], b);
					
				}
				else{
					
						
					
					b.append(repertoire+"/"+list[i]).append("\r\n");
					try {
						StringCompteur(repertoire+"/"+list[i]);
					} catch (IOException e) {
						e.printStackTrace();
					}
						
					
				}
				
			}
			
		}
		
		StringBuffer c = new StringBuffer();
		return c;

	}

	public static void main (String[] args){
		StringBuffer fichiers = new StringBuffer();
		System.out.println(recurseDirs("D:/Users/beghinb/lutece-dev4", fichiers));
		
	}

}