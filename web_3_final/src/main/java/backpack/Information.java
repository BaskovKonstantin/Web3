package backpack;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import javax.persistence.*;
@Entity
public class Information implements Serializable {

    @Id
    @SequenceGenerator(name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    private int id;

    private Double coordinateX;
    private Double coordinateY;
    private Double valueR;
    private String result;

    public Information() {
        this(0.0, 0.0, 0.0, "");
    }

    public Information(Double coordinateX, Double coordinateY, Double valueR, String result) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.valueR = valueR;
        this.result = result;
    }

    public Double getCoordinateX() {
        return coordinateX;
    }

    public Double getCoordinateY() {
        return coordinateY;
    }

    public Double getValueR() {
        return valueR;
    }

    public String getResult() {
        return result;
    }

    public void setCoordinateX(Double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(Double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setValueR(Double valueR) {
        this.valueR = valueR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}