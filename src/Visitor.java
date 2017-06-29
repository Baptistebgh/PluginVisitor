import java.io.IOException;

public interface Visitor {
	
	public String visit(Fichier doc) throws IOException;
	
}
