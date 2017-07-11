package fr.paris.lutece.plugins.example.service;
import java.io.File;

public class Arborescence {

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
				if(var.isDirectory()){
					
					recurseDirs(repertoire+"/" +list[i], b);
					
				}
				else{
					b.append(repertoire+"/"+list[i]).append("\r\n");
					
					
					
				}
				
			}
			
		}
		return b;
		
		
	
		


	}

	public static void main (String[] args){
		StringBuffer fichiers = new StringBuffer();
		System.out.println(recurseDirs("/home/oscar/nouveau tp/lutece-dev-example", fichiers));
		
	}

}