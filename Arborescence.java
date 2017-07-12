import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Arborescence {

	//Prend en paramètre le chemin
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
	
	public static String recurseDirs(String repertoire, StringBuffer b, int[] L){
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
					
					
					
					recurseDirs(repertoire+"/" +list[i], b, L);
					
				}
				else{
					
						
					if(!list[i].startsWith(".") && !list[i].startsWith("target")){
						
					b.append(repertoire+"/"+list[i]).append("\r\n");
					try {
						if(list[i].endsWith(".java")){
					    L[1]=L[1]+StringCompteur(repertoire+"/"+list[i]);
						L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
						System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
						}
						if(list[i].endsWith(".html")){
						    L[2]=L[2]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".sql")){
						    L[3]=L[3]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".properties")){
						    L[4]=L[4]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".xml")){
						    L[5]=L[5]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".md")){
						    L[6]=L[6]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".txt")){
						    L[7]=L[7]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".jsp")){
						    L[8]=L[8]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						
						
					} catch (IOException e) {
						e.printStackTrace();
					}
						
					
				}
				
			}
			
		}
		}
		
		return ("Le projet contient en tout: "+L[0]+" lignes dont "+ L[1]+" en .java, "+L[2]+" lignes en .html, "+L[3]+" lignes en .sql, "+L[4]+" lignes en .properties, "+L[5]+" lignes en .xml, "+L[6]+" lignes en .md, "+L[7]+" lignes en .txt et "+L[8]+" lignes en .jsp.");
		
	}

	public static void main (String[] args){
		int[] lesfichiers = new int[9];
		StringBuffer fichiers = new StringBuffer();
		System.out.println(recurseDirs("/home/oscar/nouveau tp/lutece-dev-example", fichiers, lesfichiers));
		
	}

}