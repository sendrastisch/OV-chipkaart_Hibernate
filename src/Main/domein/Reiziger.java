package Main.domein;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "reiziger", schema = "public" )
public class Reiziger {

    @Id
//    @GeneratedValue
    @Column (name = "reiziger_id")
    private int id;

    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;

    @OneToOne(
            mappedBy = "reiziger",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Adres adres;

    @OneToMany(mappedBy = "reiziger", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ov_Chipkaart> ov_chipkaart;

    public Reiziger(int ide, String vs, String tl, String am, Date gm){
        id = ide;
        voorletters = vs;
        tussenvoegsel = tl;
        achternaam = am;
        geboortedatum = gm;
    }

    public Reiziger() {

    }

    public void setAdres(Adres adres1) {
        this.adres = adres1;
    }

    public Adres getAdres() {
        return adres;
    }

    public List<Ov_Chipkaart> getOv_chipkaart() {
        return ov_chipkaart;
    }

    public void setOv_chipkaart(List<Ov_Chipkaart> ov_chipkaart) {
        this.ov_chipkaart = ov_chipkaart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String toString(){
        String s = "ID #" + id + " " + voorletters + ".";
        String a ;
//        String o;
//
//        if(ov_chipkaart == null){
//            o = " ov = null";
//        }
//        else{
//            for(Ov_Chipkaart ov : ov_chipkaart){
//                o += " OV Kaartnummer: " + ov.getKaart_nummer();
//            }
//        }

        if (adres  == null) {
             a = "adres = null";
        } else {
             a = "Adres: " + adres.getAdres_id() + " " + adres.getStraat() + " " + adres.getHuisnummer() + " " + adres.getPostcode() + " " + adres.getWoonplaats() ;
        }

        if(tussenvoegsel != null) {
            s += " " + tussenvoegsel + " " + achternaam + " " + "(" + geboortedatum +")" + " " + a + " aantal ov " + getOv_chipkaart().size() ; ;

        }
        else{
            s += " " + achternaam + " " + "(" + geboortedatum +")"  + " " + a + " aantal ov " + getOv_chipkaart().size();
        }

        return s;
    }


}
