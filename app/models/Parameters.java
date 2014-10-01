package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

/**
 * Created by marieclemessy on 23/09/2014.
 */

@Entity
@Table(name = "ProblemParameters")
public class Parameters {
    @Id
    @Column(name = "parameterId", nullable = false)
    private int parameterId;

    @Column(name = "problemId", nullable = false)
    private int problemId;

    @Column(name = "parameterName", nullable = false)
    private String parameterName;

    @Column(name = "parameterProperName", nullable = false)
    private String properName;

    @Column(name = "parameterDefaultValue", nullable = false)
    private Long defaultValue;

    public Parameters() {
    }

    public static Model.Finder<Long,Parameters> find = new Model.Finder<Long,Parameters>(
            Long.class, Parameters.class
    );

    public int getProblemId() {
        return this.problemId;
    }

    public String getParameterName() {
        return this.parameterName;
    }

    public void setParameterName(String pName) {
        this.parameterName = pName;
    }

    public String getProperName() {
        return this.properName;
    }

    public void setProperName(String properName) {
        this.properName = properName;
    }

    public Long getParameterDefaultValue() {
        return this.defaultValue;
    }

    public void setParameterDefaultValue(long defaultValue) {
        this.defaultValue = defaultValue;
    }

}
