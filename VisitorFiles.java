import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VisitorFiles implements Visitor{

	HashMap L = new HashMap();
	int sansextension=0;
	int total=0;

	public static <K, V extends Comparable<? super V>> HashMap sortByValue( Map<K, V> map )
	{
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>( map.entrySet() );
		Collections.sort( list, new Comparator<Map.Entry<K, V>>(){
			public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
			{
				return (o2.getValue()).compareTo( o1.getValue() );
			}
		} 
				);

		HashMap result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list)
		{
			result.put( entry.getKey(), entry.getValue() );
		}
		
		return result;
	}

	
	public void visit(String docPath) throws IOException {

		

		if(testextend(docPath)){
			if(!docPath.contains(".")){
				sansextension=sansextension+1;
				total=total+1;
				L.put("sans_extension",sansextension);
			}

			else if (L.containsKey(docPath.substring(docPath.lastIndexOf(".")))){
				int h = (int) L.get(docPath.substring(docPath.lastIndexOf(".")));
				h=h+1;
				L.put(docPath.substring(docPath.lastIndexOf(".")),h);
				total=total+1;

			}	

			else{
				L.put(docPath.substring(docPath.lastIndexOf(".")),1);
				total=total+1;


			}
			L.put("total", total);

		}
	}

	public HashMap getfichiers() {

		return sortByValue(L);
	}
	
	public boolean testextend(String docPath){
		if(!docPath.startsWith(".") && !docPath.startsWith("target") && !docPath.endsWith(".otf") && !docPath.endsWith(".gitignore") && !docPath.endsWith(".eot") && !docPath.endsWith(".svg") && !docPath.endsWith(".ttf") && !docPath.endsWith(".woff")
				&& !docPath.endsWith(".woff2") && !docPath.endsWith(".gif") && !docPath.endsWith(".png") && !docPath.endsWith(".jpg") && !docPath.endsWith(".jpeg") && !docPath.endsWith(".ico") && !docPath.endsWith(".log")){
			return true;
		}
		return false;
	}

}