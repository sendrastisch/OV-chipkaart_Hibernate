package Main.DAO;

import Main.Interface.ReizigerDAO;
import Main.domein.Reiziger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class ReizigerHibernateDAO implements ReizigerDAO {

    private Session session;

    public ReizigerHibernateDAO(Session session){
        this.session = session;
    }

    @Override
    public boolean save(Reiziger reiziger) {

        Transaction transaction = this.session.beginTransaction();
        session.save(reiziger);
        transaction.commit();

        return true;

    }

    @Override
    public boolean update(Reiziger reiziger) {

        Transaction transaction = this.session.beginTransaction();
        session.update(reiziger);
        transaction.commit();

        return true;

    }

    @Override
    public boolean delete(Reiziger reiziger) {

        Transaction transaction = this.session.beginTransaction();
        session.delete(reiziger);
        transaction.commit();

        return true;

    }

    @Override
    public Reiziger findById(int id) {

        return session.createQuery("FROM Reiziger WHERE reiziger_id = ?1", Reiziger.class).setParameter(1, id).getSingleResult();

    }

    @Override
    public List<Reiziger> findByGbdatum(String datum) {
        return session.createQuery("FROM Reiziger WHERE geboortedatum = ?1", Reiziger.class).setParameter(1, Date.valueOf(datum)).getResultList();
    }

    @Override
    public List<Reiziger> findAll() {

        return session.createQuery("FROM Reiziger", Reiziger.class).getResultList();

    }

}
