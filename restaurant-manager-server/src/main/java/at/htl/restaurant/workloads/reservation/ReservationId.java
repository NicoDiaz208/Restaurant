package at.htl.restaurant.workloads.reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservationId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ssn")
    private Person person;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short reservationNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationId reservationId = (ReservationId) o;
        return Objects.equals(person.getSsn(), reservationId.person.getSsn()) &&
                Objects.equals(person, reservationId.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(person.getSsn(), reservationNo);
    }

    public ReservationId() {
    }

    public ReservationId(Person person,  Short reservationNo) {
        this.person = person;
        this.reservationNo = reservationNo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Short getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(Short reservationNo) {
        this.reservationNo = reservationNo;
    }

}
