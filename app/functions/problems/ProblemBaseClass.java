package functions.problems;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/**
 * Created by marieclemessy on 17/09/2014.
 */
public abstract class ProblemBaseClass implements Problem {

    public void setParametersValue(Set<Map.Entry<String,String[]>> entries) throws NoSuchFieldException, IllegalAccessException {
        Class prob = this.getClass();

        //Loops over the parameters found in the query string
        for (Map.Entry<String,String[]> entry: entries) {

            // Gets the name of the parameter
            final String parameterName = entry.getKey();

            // Gets the value to give to the parameter
            // Each key can have several values but we only keep the first one
            final String parameterValue = entry.getValue()[0];

            //Finds the field with the right name
            Field field = prob.getField(parameterName);

            // Attributes parameterValue to the field using parsing
            if (field.getType().getCanonicalName() == "int"){
                field.setInt(this, Integer.parseInt(parameterValue));
            } else if (field.getType().getCanonicalName() == "long") {
                field.setLong(this, Long.parseLong(parameterValue));
            } else if (field.getType().getCanonicalName() == "float") {
                field.setFloat(this, Float.parseFloat(parameterValue));
            } else if (field.getType().getCanonicalName() == "double") {
                field.setDouble(this, Double.parseDouble(parameterValue));
            } else if (field.getType().getCanonicalName() == "short") {
                field.setShort(this, Short.parseShort(parameterValue));
            }
        }
    }



}
