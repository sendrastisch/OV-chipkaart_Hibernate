package Main.domein;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "ov_chipkaart", schema = "public" )
public class Ov_Chipkaart implements Serializable {

    @Id
    @GeneratedValue
    @Column (name = "kaart_nummer")
    private int kaart_nummer;

    private String geldig_tot;
    private int klasse;
    private int saldo;

    @Column(insertable = false, updatable = false)
    private int reiziger_id;

    @ManyToOne
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger;

    @OneToMany(
            mappedBy = "ov",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OvProduct> producten = new ArrayList<>();


    public Ov_Chipkaart(int kNum, String gT, int kL, int sdo, int rId){
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

    //product methods

    public List<OvProduct> getProducts() { return producten; }

    public void setProducts(List<OvProduct> product) { this.producten = product; }

    public void removeProduct(OvProduct product) {
        producten.remove(product);
    }

    public void addProduct(OvProduct product) {
        producten.add(product);

    }

    public void addProductAanOv(Product product) {
        OvProduct ovProduct = new OvProduct( this, product );
        producten.add( ovProduct );
        product.getOv_chipkaart().add( ovProduct );
    }

    public void removeProductVanProductenEnOv(Product product){
        OvProduct ovProduct = new OvProduct( this, product );
        product.getOv_chipkaart().remove( ovProduct );
        producten.remove( ovProduct );
        ovProduct.setProduct( null );
        ovProduct.setOv( null );
    }

    /////// eind product

    public int getKaart_nummer() {
        return kaart_nummer;
    }

    public void setKaart_nummer(int kaart_nummer) {
        this.kaart_nummer = kaart_nummer;
    }

    public String getGeldig_tot() {
        return geldig_tot;
    }

    public void setGeldig_tot(String geldig_tot) {
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
        String s = "OV Nummer: " + kaart_nummer + " is geldig tot: " + geldig_tot + " klasse: " + klasse + " saldo: " + saldo + " reizigers id: " +reiziger_id + "aantal producten" + producten.size();
        return s;
    }
}
