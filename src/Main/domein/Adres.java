package Main.domein;


import javax.persistence.*;

@Entity
@Table( name = "adres" )
public class Adres {

    @Id
    @GeneratedValue
    private int adres_id;

    private String postcode;
    private String huisnummer;
    private String straat;
    private String woonplaats;

    @Column(insertable = false, updatable = false)
    private int reiziger_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger;

    public Adres(int ide, String pc, String hn, String st, String wp, int ri, Reiziger reiziger){
        adres_id = ide;
        postcode = pc;
        huisnummer = hn;
        straat = st;
        woonplaats = wp;
        reiziger_id = ri;
        this.reiziger = reiziger;
    }

    public Adres() {

    }

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public int getReiziger_id() {
        return reiziger_id;
    }

    void setReiziger_id(int reiziger_id) {
        this.reiziger_id = reiziger_id;
    }

    public String toString(){
        return("Adres: " + adres_id + " " + straat + " " + huisnummer + " " + postcode + " " + woonplaats);
    }
}
