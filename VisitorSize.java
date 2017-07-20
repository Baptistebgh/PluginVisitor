import java.io.BufferedReader;
import java.io.File;
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

public class VisitorSize implements Visitor{
	
	HashMap L = new HashMap();
	float sansextension=0;
	float total=0;
	
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
		float size = 0;
		int d = 0;
	
		File fis = new File(docPath);

		size=fis.length();
	
	
	if(!docPath.startsWith(".") && !docPath.startsWith("target") && !docPath.endsWith(".otf") && !docPath.endsWith(".eot") && !docPath.endsWith(".svg") && !docPath.endsWith(".ttf") && !docPath.endsWith(".woff")
		&& !docPath.endsWith(".woff2") && !docPath.endsWith(".gif") && !docPath.endsWith(".png") && !docPath.endsWith(".jpg") && !docPath.endsWith(".jpeg") && !docPath.endsWith(".ico") && !docPath.endsWith(".log")){
		if(!docPath.contains(".")){
			sansextension=sansextension+size;
			total=total+size;
			L.put("sans_extension",sansextension);
	}

		else if (L.containsKey(docPath.substring(docPath.lastIndexOf(".")))){
			float h = (float) L.get(docPath.substring(docPath.lastIndexOf(".")));
				h=h+size;
				L.put(docPath.substring(docPath.lastIndexOf(".")),h);
				total=total+size;

		}	

		else{
			L.put(docPath.substring(docPath.lastIndexOf(".")),size);
			total=total+size;

	
		}
		L.put("total", total);

		}
	}

	public HashMap getsizeL() {

	return sortByValue(L);
	}
	
}