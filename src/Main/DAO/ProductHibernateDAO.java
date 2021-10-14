package Main.DAO;

import Main.Interface.ProductDAO;
import Main.domein.Ov_Chipkaart;
import Main.domein.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductHibernateDAO implements ProductDAO {

    private Session session;

    public ProductHibernateDAO(Session session){
        this.session = session;
    }

    @Override
    public boolean save(Product product) {

        Transaction transaction = this.session.beginTransaction();
        session.save(product);
        transaction.commit();

        return true;
    }

    @Override
    public boolean update(Product product) {

        Transaction transaction = this.session.beginTransaction();
        session.update(product);
        transaction.commit();

        return true;
    }

    @Override
    public boolean delete(Product product) {

        Transaction transaction = this.session.beginTransaction();
        session.delete(product);
        transaction.commit();

        return true;
    }

    @Override
    public List<Product> findByOvChipkaart(Ov_Chipkaart ov) {
        return null;
    }

    @Override
    public List<Product> findById(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
