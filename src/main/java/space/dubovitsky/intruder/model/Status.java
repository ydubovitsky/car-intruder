package space.dubovitsky.intruder.model;

import javax.persistence.*;

@Entity
public enum  Status {

    ACCEPTED (0),
    COMPLETED (1),
    DECLINE (2);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int value;

    Status() {
    }

    Status(int value) {
        this.value = value;
    }
}
