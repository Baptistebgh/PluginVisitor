import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;



	public class VisitorPlugin implements Visitor{
        int totalplugin=0;
		int totalmodule=0;
		int depedencies=0;
		String[] list= new String[2000];
		public void visit(String docPath) throws IOException {
			

			if (docPath.endsWith("pom.xml")){
			FileReader fileReader = new FileReader(docPath);;
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line =bufferedReader.readLine() ;
			while (line != null) {
				
				String truline=line.trim();
				depedencies=depedencies+1;
				if(truline.startsWith("<depedency>")){
				 depedencies=0;
				}
	         if(truline.startsWith("<artifactId>plugin") && depedencies!=2) {
	        	 String nomplugin = truline;
	        	 totalplugin=totalplugin+1;
	        	
	        	 list[totalmodule+totalplugin]=nomplugin;
	         }
	         else if(truline.startsWith("<artifactId>module")&& depedencies!=2){
	        	 String nommodule = truline;
	        	 totalmodule=totalmodule+1 ;
	        	 
	        	 list[totalmodule+totalplugin]=nommodule;
	         }
	         
				line = bufferedReader.readLine();
			}
			}
		}
		

		public String[] getplugin() {
			
			int total= totalmodule+totalplugin;
			list[0]="il y a "+total+" modules et plugins";

			return list;
		}
		

	}


