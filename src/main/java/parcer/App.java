package parcer;

import org.apache.log4j.Logger;
import parcer.converters.MetallConverter;
import parcer.dao.RecordDao;
import parcer.model.Metall;
import parcer.model.Record;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws MalformedURLException {
        StringBuilder urlPath = new StringBuilder();

        String fromDate = "01/07/2001";
        String toDate = "02/07/2001";

        urlPath
                .append("http://")
                .append("www.cbr.ru/scripts/")
                .append("xml_metall.asp")
                .append("?date_req1=")
                .append(fromDate)
                .append("&date_req2=")
                .append(toDate);

        URL url = new URL(urlPath.toString());

        try {
            Metall metall = MetallConverter.unmarshallMetall(url);

            List<Record> records = metall.getRecords();

            for (Record record : records) {
                RecordDao.saveRecord(record);
            }
        } catch (Exception e) {
            logger.error("cannot commit transaction", e);
        }
    }
}