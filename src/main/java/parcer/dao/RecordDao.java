package parcer.dao;

import org.hibernate.Session;
import parcer.dbutil.DbUtil;
import parcer.model.Record;

public class RecordDao {
    public static void saveRecord(Record record) {
        Session session = DbUtil.getSession();
        session.beginTransaction();
        session.save(record);
        session.getTransaction().commit();
    }
}
