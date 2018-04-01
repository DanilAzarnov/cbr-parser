package parcer.dao;

import org.hibernate.Session;
import parcer.dbutil.DbUtil;
import parcer.model.Record;

import java.util.List;

public class RecordDao {
    public static void saveRecord(Record record) {
        Session session = DbUtil.getSession();
        session.beginTransaction();
        session.save(record);
        session.getTransaction().commit();
    }

    public static Record getRecordById(Long id) {
        Session session = DbUtil.getSession();
        List result = session.createQuery("from Record where id =:id")
                .setParameter("id", id)
                .list();
        if (result.size() == 0) {
            return null;
        }
        return (Record) result.get(0);
    }
}
