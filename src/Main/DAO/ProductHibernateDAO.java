package Main.DAO;

import Main.Interface.ProductDAO;
import Main.domein.Adres;
import Main.domein.Ov_Chipkaart;
import Main.domein.Product;
import Main.domein.Reiziger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
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

        Transaction transaction = this.session.beginTransaction();
        List<Product> alleProducten = session.createQuery("FROM Product", Product.class).getResultList();
        List<Product> ovChipkaartProducten = new ArrayList<>();
        for (Product product : alleProducten) {
            if (product.getOv_chipkaart().contains(ov)) {
                ovChipkaartProducten.add(product);
            }
        }

        transaction.commit();
        return ovChipkaartProducten;

    }

    @Override
    public List<Product> findById(int id) {

        return session.createQuery("FROM Product WHERE product_nummer = ?1", Product.class).setParameter(1, id).getResultList();

    }

    @Override
    public List<Product> findAll() {

        return session.createQuery("FROM Product", Product.class).getResultList();

    }
}
