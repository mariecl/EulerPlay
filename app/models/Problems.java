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

}
