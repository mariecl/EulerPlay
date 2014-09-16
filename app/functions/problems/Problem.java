package functions.problems;

import java.util.Map;
import java.util.Set;

/**
 * Created by marieclemessy on 14/09/2014.
 */
public interface Problem {

    public void setParametersValue(Set<Map.Entry<String,String[]>> entries) throws NoSuchFieldException, IllegalAccessException;

    public Long compute();





}
