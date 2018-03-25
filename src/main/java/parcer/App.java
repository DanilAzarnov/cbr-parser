package parcer;

import parcer.converters.MetallConverter;
import parcer.model.Metall;
import parcer.model.Record;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
                .append("xml_metall.asp?date_req1=01/07/2001&date_req2=02/07/2001")
                .append("?date_req1=")
                .append(fromDate)
                .append("&date_req2=")
                .append(toDate);

        URL url = new URL(urlPath.toString());

        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new MetadataSources(ServiceDB.getRegistry())
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(ServiceDB.getRegistry());
            logger.error("cannot create sessionFactory", e);
            System.exit(1);
        }

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Metall metall = MetallConverter.unmarshallMetall(url);

            List<Record> records = metall.getRecords();

            for (Record record : records) {
                session.persist(record);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            logger.error("cannot commit transaction", e);
        } finally {
            session.close();
        }

        sessionFactory.close();
    }
}