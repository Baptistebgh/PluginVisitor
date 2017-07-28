import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;



	public class VisitorPlugin implements Visitor{
       
		String t = new String();
		
		public void visit(String docPath) throws IOException {
			

			if (docPath.endsWith("pom.xml")){
			FileReader fileReader = new FileReader(docPath);;
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line =bufferedReader.readLine() ;
			while (line != null) {
				
				String truline=line.trim();
				
				if(truline.startsWith("<componentName>")){
				 t=truline;
				
				}
		      }
			}
		}
		

		public String getplugin() {
			
			
		

			return t;
		}
		

	}


