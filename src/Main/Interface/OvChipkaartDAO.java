package Main.Interface;

import Main.Main;
import Main.domein.Ov_Chipkaart;
import Main.domein.Reiziger;

import java.util.List;

public interface OvChipkaartDAO {

    boolean save(Ov_Chipkaart ov_chipkaart);
    boolean update(Ov_Chipkaart ov_chipkaart);
    boolean delete(Ov_Chipkaart ov_chipkaart);
    List<Ov_Chipkaart> findByReiziger(Reiziger reiziger);
    List<Ov_Chipkaart> findById(int id);
}
