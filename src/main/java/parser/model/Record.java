package parser.model;

import parser.model.adapters.BigDecimalAdapter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

@Entity
@Table(name = "record")
@XmlType(propOrder = {"buy", "sell"})
public class Record {

    @Id
    @GeneratedValue
    private Long id;

    private String date;
    private String code;
    private BigDecimal buy;
    private BigDecimal sell;

    public Long getId() {
        return id;
    }

    @XmlAttribute(name = "Date")
    public String getDate() {
        return date;
    }

    @XmlElement(name = "Buy")
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    public BigDecimal getBuy() {
        return buy;
    }

    @XmlAttribute(name = "Code")
    public String getCode() {
        return code;
    }

    @XmlElement(name = "Sell")
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    public BigDecimal getSell() {
        return sell;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return String.format("Record{date=%s, code=%s, buy=%s, sell=%s}", date, code, buy, sell);
    }
}
