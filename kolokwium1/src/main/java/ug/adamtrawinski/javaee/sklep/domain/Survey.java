package ug.adamtrawinski.javaee.sklep.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Survey {
    private List<String> comments = new ArrayList<String>();
    private String frequency = "Często";
    private Date usedFrom = new Date();
    private Date usedTo = new Date();

    public Survey() {

    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getUsedFrom() {
        return usedFrom;
    }

    public void setUsedFrom(Date usedFrom) {
        this.usedFrom = usedFrom;
    }

    public Date getUsedTo() {
        return usedTo;
    }

    public void setUsedTo(Date usedTo) {
        this.usedTo = usedTo;
    }
}
