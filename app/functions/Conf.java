package functions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.api.Application;
import play.api.Play;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;

public class Conf {
    protected static List<Problem_data> problems;

	/**
	* Reads the Json file and generates a List populated with problems
	*/
	public static List<Problem_data> getProblems() {
		if(Conf.problems != null) {
            return Conf.problems;
        }

		// ArrayList that will hold problems and will be returned
		Conf.problems = new ArrayList<Problem_data>();
		ObjectMapper mapper = new ObjectMapper();
        
        try {
        	// Read json file
            File file = new File("conf/problems.json").getAbsoluteFile();
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            // Get Jackson to read the JsonNodes
            JsonNode root = mapper.readTree(fileReader);

            // Loop over problems
            Iterator<JsonNode> elements = root.elements();
            while (elements.hasNext()) {
            	JsonNode problemNode = elements.next();
            	JsonNode parametersNode = problemNode.get("parameters");
            	
            	// Array to hold the parameters of the problem
            	ArrayList<HashMap<String,Object>> parameters = new ArrayList<HashMap<String,Object>>();

            	// Loop over parameters from JSON file
            	Iterator<JsonNode> parametersElements = parametersNode.elements();
            	while (parametersElements.hasNext()) {
            		// Get parameter from JSON file
            		JsonNode parameterNode = parametersElements.next();

            		// Create map holder
            		HashMap<String, Object> parameter = new HashMap<String, Object>();
            		parameter.put("name", parameterNode.get("name").asText());
            		parameter.put("default",parameterNode.get("default").asLong());

            		// Add parameter to map
            		parameters.add(parameter);
            	}

            	// Create new problem instance to represent problem from JSON
            	Problem_data problem = new Problem_data(
            		problemNode.get("id").asInt(),
            		problemNode.get("name").asText(),
            		problemNode.get("question").asText(),
            		parameters
            	);

            	// Add problem to problems' list
            	Conf.problems.add(problem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Conf.problems;
	}
}	