package parcer.model.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    @Override
    public String marshal(BigDecimal value) throws Exception {
        return value != null ? value.toString() : null;
    }

    @Override
    public BigDecimal unmarshal(String s) throws Exception {

        //FIXME use formatter
        return new BigDecimal(s.replace(",", "."));
    }
}
