import java.io.FileNotFoundException;
import java.io.IOException;

interface Visitor {

	public void visit(String docPath) throws  IOException;
}
