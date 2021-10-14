package Main.DAO;

import Main.Interface.ReizigerDAO;
import Main.domein.Reiziger;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

        Transaction transaction = this.session.beginTransaction();
        Reiziger reiziger = (Reiziger) session.createQuery(" FROM Reiziger where reiziger_id = " + id).getSingleResult();
        transaction.commit();

        return reiziger;

    }

    @Override
    public List<Reiziger> findByGbdatum(String datum) {

        Transaction transaction = this.session.beginTransaction();
        List<Reiziger> reizigers = (List<Reiziger>) session.createQuery("FROM Reiziger WHERE geboortedatum = " + datum).getResultList();
        transaction.commit();

        return reizigers;

    }

    @Override
    public List<Reiziger> findAll() {

        Transaction transaction = this.session.beginTransaction();
        List<Reiziger> reizigers = (List<Reiziger>) session.createQuery("FROM Reiziger").getResultList();
        transaction.commit();

        return reizigers;

    }

}
