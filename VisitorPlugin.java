import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;



	public class VisitorPlugin implements Visitor{
        int totalplugin=0;
		int totalmodule=0;
		int depedencies=0;
		int lol=0;
		String[] list= new String[2000];
		public void visit(String docPath) throws IOException {
			

			if (docPath.endsWith("pom.xml")){
			FileReader fileReader = new FileReader(docPath);;
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line =bufferedReader.readLine() ;
			while (line != null && lol!=2) {
				
				String truline=line.trim();
				depedencies=depedencies+1;
				if(truline.startsWith("<depedency>")){
				 depedencies=0;
				}
	         if(truline.startsWith("<artifactId>")) {
	        	 String nomplugin = truline;
	        	 totalplugin=totalplugin+1;
	        	 list[0]=nomplugin;
	        	 lol+=1;
	         }
	         else if(truline.startsWith("<artifactId>module")&& depedencies!=2){
	        	 String nommodule = truline;
	        	 totalmodule=totalmodule+1 ;
	        	 list[totalmodule+totalplugin]=nommodule;
	        	 lol=1;
	         }
	         
				line = bufferedReader.readLine();
			}
			}
		}
		

		public String[] getplugin() {
			
			int total= totalmodule+totalplugin;
			

			return list;
		}
		

	}


