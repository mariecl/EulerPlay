package models;

import play.db.ebean.Model;

/**
 * Created by marieclemessy on 10/09/2014.
 */
public class Problem extends Model {
    public int problemId;
    public String question = new String("");
    //List de nom des paramètres + données de base?
    public int parameter1;
    public int parameter2;
    public int upperBound;
}
