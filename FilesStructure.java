import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FilesStructure{
	
	static int total = 0;
	static int sansextension = 0;

	public static void accept(Visitor visitor,String repertoire) {


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
				if(var.isDirectory() && testrepo(list[i])){
							
					
					accept(visitor, repertoire+"/" +list[i]);
					
				}
				else if(!var.isDirectory() ){
					
					try {
						visitor.visit(repertoire+ File.separatorChar + list[i]);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
					// tous les fichiers que l'on ignore dans le d�compte	
					
				}
				
			}
}
	
	public static boolean testrepo(String test){
		if(test.startsWith("PluginVisitor") || test.startsWith("target") || test.startsWith(".")){
		return false; 
	}
	
		return true;

}
}
