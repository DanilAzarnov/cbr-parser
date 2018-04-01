package parcer.services;

import org.springframework.stereotype.Service;
import parcer.converters.MetallConverter;
import parcer.dao.RecordDao;
import parcer.model.Metall;
import parcer.model.Record;

import java.net.URL;
import java.util.List;

@Service
public class MetallService {

    private static final StringBuilder urlPath = new StringBuilder();

    public List<Record> getListMetallRecord(String fromDate, String toDate) {

        urlPath
                .append("http://")
                .append("www.cbr.ru/scripts/")
                .append("xml_metall.asp")
                .append("?date_req1=")
                .append(fromDate)
                .append("&date_req2=")
                .append(toDate);

        try {
            URL url = new URL(urlPath.toString());

            Metall metall = MetallConverter.unmarshallMetall(url);

            List<Record> records = metall.getRecords();

            records.forEach(RecordDao::saveRecord);

            return records;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
