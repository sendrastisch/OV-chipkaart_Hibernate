package Main.domein;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "product" )
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private int product_nummer;

    private String naam;
    private String beschrijving;
    private int prijs;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OvProduct> ovChipkaarten = new ArrayList<>();

    public Product(int pN, String nm, String bs, int pr){
        product_nummer = pN;
        naam = nm;
        beschrijving = bs;
        prijs = pr;
    }

    public Product() {

    }

    //ov chipkaart methoden

    public List<OvProduct> getOv_chipkaart() {
        return ovChipkaarten;
    }

    public void setOv_chipkaart(List<OvProduct> ov_chipkaart) {
        this.ovChipkaarten = ov_chipkaart;
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
