package space.dubovitsky.intruder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "declaration")
@Getter @Setter
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @Column(name = "car_number")
    private String carNumber;

    private String description;

    public Declaration() {
    }

    public Declaration(String name, String address, String carNumber, String description) {
        this.name = name;
        this.address = address;
        this.carNumber = carNumber;
        this.description = description;
    }
}