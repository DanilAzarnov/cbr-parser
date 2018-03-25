package parcer.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Metall")
public class Metall {

    private String fromDate;
    private String toDate;
    private String name;
    private List<Record> records = new ArrayList<>();

    @XmlAttribute(name = "FromDate")
    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    @XmlAttribute(name = "ToDate")
    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Record")
    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Metall{" +
                "fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
