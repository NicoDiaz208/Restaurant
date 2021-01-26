package at.htl.restaurant.workloads.reservation;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    private String ssn;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "id.person", cascade = {CascadeType.PERSIST})
    private List<Reservation> reservations;

    public Person() {
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
