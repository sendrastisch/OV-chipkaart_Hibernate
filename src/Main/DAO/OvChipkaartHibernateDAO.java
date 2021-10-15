package Main.DAO;

import Main.Interface.OvChipkaartDAO;
import Main.domein.Ov_Chipkaart;
import Main.domein.Reiziger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OvChipkaartHibernateDAO implements OvChipkaartDAO {

    private Session session;

    public OvChipkaartHibernateDAO(Session session){
        this.session = session;
    }

    @Override
    public boolean save(Ov_Chipkaart ov_chipkaart) {

        Transaction transaction = this.session.beginTransaction();
        session.save(ov_chipkaart);
        transaction.commit();

        return true;

    }

    @Override
    public boolean update(Ov_Chipkaart ov_chipkaart) {

        Transaction transaction = this.session.beginTransaction();
        session.update(ov_chipkaart);
        transaction.commit();

        return true;
    }

    @Override
    public boolean delete(Ov_Chipkaart ov_chipkaart) {

        Transaction transaction = this.session.beginTransaction();
        session.delete(ov_chipkaart);
        transaction.commit();

        return true;
    }

    @Override
    public List<Ov_Chipkaart> findByReiziger(Reiziger reiziger) {
        return session.createQuery("FROM Ov_Chipkaart WHERE reiziger_id = " + reiziger.getId(), Ov_Chipkaart.class).getResultList();
    }

    @Override
    public List<Ov_Chipkaart> findById(int id) {

        return session.createQuery("FROM Ov_Chipkaart WHERE kaart_nummer = ?1", Ov_Chipkaart.class).setParameter(1, id).getResultList();

    }
}
