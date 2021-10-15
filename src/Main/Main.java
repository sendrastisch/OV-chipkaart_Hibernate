package Main;

import Main.DAO.OvChipkaartHibernateDAO;
import Main.DAO.ReizigerHibernateDAO;
import Main.domein.Ov_Chipkaart;
import Main.domein.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Testklasse - deze klasse test alle andere klassen in deze package.
 *
 * System.out.println() is alleen in deze klasse toegestaan (behalve voor exceptions).
 *
 * @author tijmen.muller@hu.nl
 */
public class Main {
    // Creëer een factory voor Hibernate sessions.
    private static final SessionFactory factory;

    static {
        try {
            // Create a Hibernate session factory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retouneer een Hibernate session.
     *
     * @return Hibernate session
     * @throws HibernateException
     */
    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
//        testFetchAll();
        testDao();
    }

    /**
     * P6. Haal alle (geannoteerde) entiteiten uit de database.
     */
    private static void testFetchAll() {
        Session session = getSession();
        try {
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                Query query = session.createQuery("from " + entityType.getName());

                System.out.println("[Test] Alle objecten van type " + entityType.getName() + " uit database:");
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    private static void testDao(){
        Session session = getSession();

        ReizigerHibernateDAO rdao = new ReizigerHibernateDAO(session);
        OvChipkaartHibernateDAO odao = new OvChipkaartHibernateDAO(session);

        Reiziger reizigerSan = new Reiziger(6, "SA", null, "Fernandes", java.sql.Date.valueOf("1998-10-06"));
        Ov_Chipkaart ovSan = new Ov_Chipkaart(12345, java.sql.Date.valueOf("2021-10-01"), 1, 20, 6);
        List<Ov_Chipkaart> ovList = new ArrayList<>();
        ovList.add(ovSan);
        reizigerSan.setOv_chipkaart(ovList);

        System.out.println("----------REIZIGER TEST----------");
        System.out.println("TEST DE REIZIGERS FIND ALL!");
        System.out.println(rdao.findAll());

        System.out.println("TEST DE SAVE EN DE FINDBYID!");
//        rdao.save(reizigerSan);
//        odao.save(ovSan);
        System.out.println(rdao.findById(reizigerSan.getId()));

        System.out.println("TEST DE FIND BY GB");
        System.out.println(rdao.findByGbdatum("1998-10-06"));

        //DELETES DOEN T FOR SOME REASON NIET IK BEN ER KLAAR MEE IK DELETE WEL HANDMATIG DOEI
//        delete OV
//        odao.delete(ovSan);

        //delete reiziger
//        rdao.delete(reizigerSan);




    }
}