package Main;

import Main.DAO.AdresHibernateDAO;
import Main.DAO.OvChipkaartHibernateDAO;
import Main.DAO.ProductHibernateDAO;
import Main.DAO.ReizigerHibernateDAO;
import Main.domein.Adres;
import Main.domein.Ov_Chipkaart;
import Main.domein.Product;
import Main.domein.Reiziger;
import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.SQLException;

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
        AdresHibernateDAO adao = new AdresHibernateDAO(session);
        ProductHibernateDAO pdao = new ProductHibernateDAO(session);
//
        Reiziger reizigerSan = new Reiziger(6, "SA", null, "Fernandes", java.sql.Date.valueOf("1998-10-06"));
        Ov_Chipkaart ovSan = new Ov_Chipkaart(12345, java.sql.Date.valueOf("2021-10-01"), 1, 20, 6);
        Adres adresSan = new Adres(6, "3031XG", "66", "Hugo de Grootstraat", "Rotterdam", 6, reizigerSan);
        Product product = new Product(7, "Sandra Product", "Alle sandra's mogen gratis reizen", 10);

        System.out.println("-------- REIZIGER TEST ---------");
        System.out.println("------ save reiziger en findall reizigers ------");
        System.out.println(rdao.findAll());
        System.out.println("wauw kijk sandra zit er niet in");
        rdao.save(reizigerSan);
        System.out.println(rdao.findAll());
        System.out.println("WOW SANDRA ZIT ER IN. Zou het nou zomaar zo zijn dat mijn code...werkt.....?!??");

        System.out.println("------- update de reiziger test en findbyid reiziger test --------");
        reizigerSan.setAchternaam("met de korte achternaam");
        System.out.println(rdao.findById(reizigerSan.getId()));
        System.out.println("Nu is mijn achternaam niet zo exotisch meer ^");

        System.out.println("\n");
        System.out.println("----------TEST ADRES----------");
        System.out.println("--------- save adres test en findall adressen test -------");
        System.out.println(adao.findAll());
        System.out.println("adres zit er niet in (komt omdat ik hem niet heb opgeslagen nog, niet doorvertellen)");
        adao.save(adresSan);
        System.out.println(adao.findAll());
        System.out.println("Drie keer raden wat er nu wel in deze lijst zit ^");

        System.out.println("--------- update adres test en findbyreiziger test ------");
        adresSan.setStraat("Sandra Straat");
        adao.update(adresSan);
        System.out.println(adao.findByReiziger(reizigerSan));
        System.out.println("Nu is mijn straat 300x leuker");

        System.out.println("\n");
        System.out.println("--------PRODUCT TEST--------");
        System.out.println("--------- save product test en findall producten test -----------");
        System.out.println(pdao.findAll());
        System.out.println("alle producten zonder mijn product ^");
        pdao.save(product);
        System.out.println(pdao.findAll());
        System.out.println("mijn product nu ineens wel erin ^ het is net magie");
        System.out.println("---------- update product test --------");
        product.setPrijs(20000);
        System.out.println(pdao.findAll());
        System.out.println("Nu is mijn product ineens vet duur want ik ben goud waard");

        System.out.println("\n");
        System.out.println("----OV CHIPKAART TEST---------");
        System.out.println("--- save ov chipkaart test en findbyreiziger test ---");
        odao.save(ovSan);
        System.out.println(odao.findByReiziger(reizigerSan));

        System.out.println("--- update ov test en findbyreiziger ov test en product toevoegen aan ov test ---");
        ovSan.setSaldo(2100000);
        ovSan.getProducts().add(product);
        odao.update(ovSan);
        System.out.println(odao.findByReiziger(reizigerSan));
        System.out.println("Nu heb ik vet veel geld op mijn ov omdat bitcoin ath heeft gehaald dus ben rich");

        System.out.println("\n");
        System.out.println("---------VERWIJDER UIT DATABASE------");

        adao.delete(adresSan);
        odao.delete(ovSan);
        pdao.delete(product);
        rdao.delete(reizigerSan);

        System.out.println(pdao.findAll());
        System.out.println("geen gratis reizen voor sandras meer ^");

        System.out.println(odao.findByReiziger(reizigerSan));
        System.out.println("Sandra heeft geen reisvergunning meer ^");

        System.out.println(rdao.findAll());
        System.out.println("Sandra bestaat niet meer :( ^");


    }
}