package ug.adamtrawinski.javaee.sklep.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Survey {
    private List<String> comments = new ArrayList<String>();
    private String frequency = "Codzinnie";
    private Date usedFrom = new Date();
    private Date usedTo = new Date();

    public Survey() {

    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
        String comments = "";
        for(String comment: this.comments) {
            comments += comment + "<br>";
        }
        return "Data użytkowania (od): " + df.format(usedFrom) + "<br>" +
                "Data użytkowania (do): " + df.format(usedTo) + "<br>" +
                "Częstotliwość: " + frequency + "<br>" +
                "Uwagi: " + comments;
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

    public boolean ifCommentSelected(String comment) {
        for(String element: this.comments) {
            if(element.equals(comment)) {
                return true;
            }
        }
        return false;
    }
}
