package Main.domein;

import java.util.List;

public class Reiziger {
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private String geboortedatum;
    private Adres adres;
    private List<Ov_Chipkaart> ov_chipkaart;

    public Reiziger(int ide, String vs, String tl, String am, String gm){
        id = ide;
        voorletters = vs;
        tussenvoegsel = tl;
        achternaam = am;
        geboortedatum = gm;
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

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String toString(){
        String s = "ID #" + id + " " + voorletters + ".";
        String a ;
//        String o;

//        if(ov_chipkaart == null){
//            o = " ov = null";
//        }else{
//            o = " OV Kaartnummer: " + ov_chipkaart.getKaart_nummer();
//        }

        if (adres  == null) {
             a = "adres = null";
        } else {
             a = "Adres: " + adres.getAdres_id() + " " + adres.getStraat() + " " + adres.getHuisnummer() + " " + adres.getPostcode() + " " + adres.getWoonplaats() ;
        }

        if(tussenvoegsel != null) {
            s += " " + tussenvoegsel + " " + achternaam + " " + "(" + geboortedatum +")" + " " + a ; ;

        }
        else{
            s += " " + achternaam + " " + "(" + geboortedatum +")"  + " " + a ;
        }

        return s;
    }


}
