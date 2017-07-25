import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;



	public class VisitorPlugin implements Visitor{
        int totalplugin=0;
		int totalmodule=0;
		String[] list= new String[20];
		public void visit(String docPath) throws IOException {
			

			if (docPath.endsWith(".xml")){
			FileReader fileReader = new FileReader(docPath);;
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line =bufferedReader.readLine() ;
			while (line != null) {
				line=line.trim();
	         if(line.startsWith("<artifactId>plugin")){
	        	 String nomplugin = line;
	        	 totalplugin=totalplugin+1;
	        	 int v = nomplugin.length();
	        	 nomplugin.substring(12,v-13);
	        	 list[totalmodule+totalplugin]=nomplugin;
	         }
	         else if(line.startsWith("<artifactId>module")){
	        	 String nommodule = line;
	        	 totalmodule=totalmodule+1 ;
	        	 int v = nommodule.length();
	        	 nommodule.substring(12,v-13);
	        	 list[totalmodule+totalplugin]=nommodule;
	         }
	         }
				line = bufferedReader.readLine();
			}
		}
		

		public String[] getplugin() {
			list[0]="il y a "+totalmodule+totalplugin+"modules et plugins";

			return list;
		}
		

	}


