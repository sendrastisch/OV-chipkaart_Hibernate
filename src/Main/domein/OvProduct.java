package Main.domein;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table( name = "ov_chipkaart_product", schema = "public" )
public class OvProduct implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "kaart_nummer")
    private Ov_Chipkaart ov;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_nummer")
    private Product product;

    public OvProduct(Ov_Chipkaart ov_chipkaart, Product product) {
    }

    public OvProduct() {

    }

    void setOv(Ov_Chipkaart ov) {
        this.ov = ov;
    }

    void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OvProduct{" +
                "ov=" + ov +
                ", product=" + product +
                '}';
    }
}
