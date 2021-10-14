package Main.Interface;

import Main.Main;
import Main.domein.Adres;
import Main.domein.Reiziger;

import java.util.List;

public interface AdresDAO {

    boolean save(Adres adres);
    boolean update(Adres adres);
    boolean delete(Adres adres);
    Adres findByReiziger(Reiziger reiziger);
    Adres findByIdAdres(int ide);
    List<Adres> findAll();

}
