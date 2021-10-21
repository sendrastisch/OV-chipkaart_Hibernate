package Main.domein;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "product" )
public class Product implements Serializable {

    @Id
    private int product_nummer;

    private String naam;
    private String beschrijving;
    private int prijs;

    @ManyToMany(mappedBy = "producten", targetEntity = Ov_Chipkaart.class)
    private List<Ov_Chipkaart> ovChipkaarten = new ArrayList<>();

    public Product(int pN, String nm, String bs, int pr){
        product_nummer = pN;
        naam = nm;
        beschrijving = bs;
        prijs = pr;
    }

    public Product() {

    }


    public List<Ov_Chipkaart> getOv_chipkaart() {
        return ovChipkaarten;
    }

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
