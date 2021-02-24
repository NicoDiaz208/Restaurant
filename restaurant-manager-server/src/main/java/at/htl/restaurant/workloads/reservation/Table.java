package at.htl.restaurant.workloads.reservation;

import at.htl.restaurant.workloads.reservation.Reservation;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name="\"table\"")
public class Table {
    @Id
    private Short tableId;
    private Short chairs;

    public Table() {
    }

    public Short getChairs() {
        return chairs;
    }

    public void setChairs(Short chairs) {
        this.chairs = chairs;
    }

    public Short getTableId() {
        return tableId;
    }

    public void setTableId(Short tableId) {
        this.tableId = tableId;
    }

}

