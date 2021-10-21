package Main.domein;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "ov_chipkaart", schema = "public" )
public class Ov_Chipkaart implements Serializable {

    @Id
    @Column (name = "kaart_nummer")
    private int kaart_nummer;

    private Date geldig_tot;
    private int klasse;
    private int saldo;
    private int reiziger_id;

    @ManyToOne
    @JoinColumn(name = "reiziger_id", insertable = false, updatable = false)
    private Reiziger reiziger;

    @ManyToMany()
    @JoinTable(
            name = "ov_chipkaart_product",
            joinColumns = { @JoinColumn(name = "kaart_nummer") },
            inverseJoinColumns = { @JoinColumn(name = "product_nummer") }
    )
    private List<Product> producten = new ArrayList<>();

    public Ov_Chipkaart(int kNum, Date gT, int kL, int sdo, int rId){
        kaart_nummer = kNum;
        geldig_tot = gT;
        klasse = kL;
        saldo = sdo;
        reiziger_id = rId;
    }

    public Ov_Chipkaart() {

    }

    public Reiziger getReiziger(){return reiziger;}

    public void setReiziger(Reiziger reiziger1){this.reiziger = reiziger1;}

    public List<Product> getProducts() { return producten; }

    public int getKaart_nummer() {
        return kaart_nummer;
    }

    public void setKaart_nummer(int kaart_nummer) {
        this.kaart_nummer = kaart_nummer;
    }

    public Date getGeldig_tot() {
        return geldig_tot;
    }

    public void setGeldig_tot(Date geldig_tot) {
        this.geldig_tot = geldig_tot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getReiziger_id() {
        return reiziger_id;
    }

    public void setReiziger_id(int reiziger_id) {
        this.reiziger_id = reiziger_id;
    }

    public String toString(){
        String s = "OV Nummer: " + kaart_nummer + " is geldig tot: " + geldig_tot + " klasse: " + klasse + " saldo: " + saldo + " reizigers id: " +reiziger_id + " aantal producten: " + producten.size();
        return s;
    }
}
