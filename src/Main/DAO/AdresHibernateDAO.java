package Main.DAO;

import Main.Interface.AdresDAO;
import Main.domein.Adres;
import Main.domein.Reiziger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdresHibernateDAO implements AdresDAO {

    private Session session;

    public AdresHibernateDAO(Session session){
        this.session = session;
    }

    @Override
    public boolean save(Adres adres) {

        Transaction transaction = this.session.beginTransaction();
        session.save(adres);
        transaction.commit();


        return true;
    }

    @Override
    public boolean update(Adres adres) {

        Transaction transaction = this.session.beginTransaction();
        session.update(adres);
        transaction.commit();

        return true;
    }

    @Override
    public boolean delete(Adres adres) {

        Transaction transaction = this.session.beginTransaction();
        session.delete(adres);
        transaction.commit();

        return true;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {

        return session.createQuery("FROM Adres WHERE reiziger_id = " + reiziger.getId(), Adres.class).getSingleResult();

    }

    @Override
    public Adres findByIdAdres(int ide) {

        return session.createQuery("FROM Adres WHERE adres_id = ?1", Adres.class).setParameter(1, ide).getSingleResult();

    }

    @Override
    public List<Adres> findAll() {

        return session.createQuery("FROM Adres", Adres.class).getResultList();

    }
}
