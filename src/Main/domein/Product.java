package Main.domein;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private int prijs;
    private List<Ov_Chipkaart> ov_chipkaarts = new ArrayList<>();

    public Product(int pN, String nm, String bs, int pr){
        product_nummer = pN;
        naam = nm;
        beschrijving = bs;
        prijs = pr;
    }

    //ov chipkaart methoden

    public List<Ov_Chipkaart> getOv_chipkaart() {
        return ov_chipkaarts;
    }

    public void setOv_chipkaart(List<Ov_Chipkaart> ov_chipkaart) {
        this.ov_chipkaarts = ov_chipkaart;
    }

    public void removeOv_Chipkaart(Ov_Chipkaart ov) {
        ov.removeProductVanProductenEnOv(this);
    }

    public void addOv_ChipkaartMetProduct(Ov_Chipkaart ov) {ov.addProductAanOv(this);}

    // einde ov chipkaart methoden

    public int getProduct_nummer() {
        return product_nummer;
    }

    public void setProduct_nummer(int product_nummer) {
        this.product_nummer = product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public String toString(){
        String s = "Productnummer: " + product_nummer + " productnaam: " + naam + " beschrijving product: " + beschrijving;

        return s;
    }
}
