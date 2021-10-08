package Main.domein;

import java.util.ArrayList;
import java.util.List;

public class Ov_Chipkaart {
    private int kaart_nummer;
    private String geldig_tot;
    private int klasse;
    private int saldo;
    private int reiziger_id;
    private Reiziger reiziger;
    private List<Product> products = new ArrayList<>();


    public Ov_Chipkaart(int kNum, String gT, int kL, int sdo, int rId){
        kaart_nummer = kNum;
        geldig_tot = gT;
        klasse = kL;
        saldo = sdo;
        reiziger_id = rId;
    }

    public Reiziger getReiziger(){return reiziger;}

    public void setReiziger(Reiziger reiziger1){this.reiziger = reiziger1;}

    //product methods

    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> product) { this.products = product; }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addProduct(Product product) {
        products.add(product);

    }

    public void addProductAanOv(Product product) {
        products.add(product);
        List<Ov_Chipkaart> ov_chipkaarts = product.getOv_chipkaart();
        ov_chipkaarts.add(this);
        product.setOv_chipkaart(ov_chipkaarts);
    }

    public void removeProductVanProductenEnOv(Product product){
        products.remove(product);
        List<Ov_Chipkaart> ov_chipkaarts = product.getOv_chipkaart();
        ov_chipkaarts.remove(this);
        product.setOv_chipkaart(ov_chipkaarts);
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
        String s = "OV Nummer: " + kaart_nummer + " is geldig tot: " + geldig_tot + " klasse: " + klasse + " saldo: " + saldo + "reizigers id: " +reiziger_id;
        return s;
    }
}
