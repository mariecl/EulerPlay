package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

/**
 * Created by marieclemessy on 23/09/2014.
 */

@Entity
@Table(name = "ProblemDescriptors")
public class Problems extends Model {
    @Id
    @Column(name = "problemId", nullable = false)
    private int problemId;

    @Column(name = "problemName", nullable = false)
    private String problemName;

    @Column(name = "problemQuestion", nullable = false)
    private String problemQuestion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ProblemParameters", joinColumns = @JoinColumn(name = "problemId", referencedColumnName = "problemId"))
    private List<models.Parameters> parameters;

    public Problems() {
    }

    public static Finder<Long,Problems> find = new Finder<Long,Problems>(
            Long.class, Problems.class
    );

    public int getProblemId() {
        return this.problemId;
    }

    public String getProblemName() {
        return this.problemName;
    }

    public String getProblemQuestion() {
        return this.problemQuestion;
    }

    public List<models.Parameters> getParameters(){
        return this.parameters;
    }

}
