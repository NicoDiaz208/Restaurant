package at.htl.restaurant.model;

import java.time.LocalDateTime;

public class ReservationDTO {
    private TableDTO table;
    private LocalDateTime time;
    private PersonDTO person;
    private Short reservationNo;

    public TableDTO getTable() {
        return table;
    }

    public void setTable(TableDTO table) {
        this.table = table;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public Short getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(Short reservationNo) {
        this.reservationNo = reservationNo;
    }
}