import java.util.HashMap;

interface Visitable {

	public void accept(Visitor visitor, String docPath);
}
