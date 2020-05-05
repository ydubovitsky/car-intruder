package space.dubovitsky.intruder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "declaration")
@Getter @Setter
public class Declaration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @Column(name = "car_number")
    private String carNumber;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String photo;

    public Declaration() {
    }

    public Declaration(String name, String address, String carNumber, String description, Status status, User user) {
        this.name = name;
        this.address = address;
        this.carNumber = carNumber;
        this.description = description;
        this.status = status;
        this.user = user;
    }
}
