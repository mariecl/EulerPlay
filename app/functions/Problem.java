package functions;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem {
	public int id;
	public String name;
	public String question;
	public ArrayList<HashMap<String, Object>> parameters;

	public Problem(int id, String name, String question, ArrayList<HashMap<String, Object>> parameters) {
		this.id = id;
		this.name = name;
		this.question = question;
		this.parameters = parameters;
	}
}