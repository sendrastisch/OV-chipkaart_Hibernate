package Main.Interface;

import Main.domein.Ov_Chipkaart;
import Main.domein.Product;

import java.util.List;

public interface ProductDAO {

    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Product product);
    List<Product> findByOvChipkaart(Ov_Chipkaart ov);
    List<Product> findById(int id);
    List<Product> findAll();


}
