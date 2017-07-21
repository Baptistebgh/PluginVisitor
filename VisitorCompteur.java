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

public class VisitorCompteur implements Visitor{

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
		Set<String> M= result.keySet();
		String[] S = M.toArray(new String[M.size()]);
		for(int k =0; k<S.length;k++){
			int h = (int)result.get(S[k]);
			result.put(S[k], h+" lignes");
		}

		return result;
	}

	@Override
	public void visit(String docPath) throws IOException {
		int count = 0;
		int d = 0;

		FileInputStream fis = new FileInputStream(docPath);

		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));


		while ((l.readLine())!=null) 
		{

			count = l.getLineNumber();
		}


		if(testextend(docPath)){
			if(!docPath.contains(".")){
				sansextension=sansextension+count;
				total=total+count;
				L.put("sans_extension",sansextension);
			}

			else if (L.containsKey(docPath.substring(docPath.lastIndexOf(".")))){
				int h = (int) L.get(docPath.substring(docPath.lastIndexOf(".")));
				h=h+count;
				L.put(docPath.substring(docPath.lastIndexOf(".")),h);
				total=total+count;

			}	

			else{
				L.put(docPath.substring(docPath.lastIndexOf(".")),count);
				total=total+count;


			}
			L.put("total", total);

		}
	}

	public HashMap getL() {

		return sortByValue(L);
	}
	
	public boolean testextend(String docPath){
		if(!docPath.startsWith(".") && !docPath.startsWith("target") && !docPath.endsWith(".otf") && !docPath.endsWith(".eot") && !docPath.endsWith(".svg") && !docPath.endsWith(".ttf") && !docPath.endsWith(".woff")
				&& !docPath.endsWith(".woff2") && !docPath.endsWith(".gif") && !docPath.endsWith(".png") && !docPath.endsWith(".jpg") && !docPath.endsWith(".jpeg") && !docPath.endsWith(".ico") && !docPath.endsWith(".log")){
			return true;
		}
		return false;
	}

}