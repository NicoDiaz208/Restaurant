package at.htl.restaurant.model;

public class TableDTO {
    private Short tableId;
    private Short chairs;

    public Short getTableId() {
        return tableId;
    }

    public void setTableId(Short tableId) {
        this.tableId = tableId;
    }

    public TableDTO() {
    }

    public TableDTO(Short tableId, Short chairs) {
        this.tableId = tableId;
        this.chairs = chairs;
    }

    public Short getChairs() {
        return chairs;
    }

    public void setChairs(Short chairs) {
        this.chairs = chairs;
    }
}