package at.htl.restaurant.workloads.reservation;

import at.htl.restaurant.model.TableDTO;

import java.util.*;

public interface ITableService {
    public boolean addTable(TableDTO newTable);
    public boolean removeTable(TableDTO removeTable);
    public List<Table> getAllTables();
}
