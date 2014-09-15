package functions.problems;

/**
 * Created by marieclemessy on 14/09/2014.
 */
public interface Problem {

    public void setParameterValue(String parameter_name, int parameter_value) throws NoSuchFieldException, IllegalAccessException;

    public Long compute();





}
