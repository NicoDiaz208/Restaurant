package at.htl.restaurant.workloads.reservation;

import at.htl.restaurant.model.TableDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class TableService implements ITableService {
    private final IReservationRepository reservationRepository;

    public TableService(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public boolean addTable(TableDTO newTable) {
        var existingTable = reservationRepository.getTableById(newTable.getTableId());
        if(existingTable != null)
            return false;

        var table = new Table();
        table.setTableId(newTable.getTableId());
        table.setChairs(newTable.getCharis());
        reservationRepository.addTable(table);
        return true;
    }

    @Override
    public boolean removeTable(TableDTO removeTable) {
        var existingTable = reservationRepository.getTableById(removeTable.getTableId());
        if(existingTable == null)
            return false;

        var table = new Table();
        table.setTableId(removeTable.getTableId());
        table.setChairs(removeTable.getCharis());
        reservationRepository.removeTable(table);
        return true;
    }

    @Override
    public List<Table> getAllTables() {
        return reservationRepository.getAllTables();
    }
}
