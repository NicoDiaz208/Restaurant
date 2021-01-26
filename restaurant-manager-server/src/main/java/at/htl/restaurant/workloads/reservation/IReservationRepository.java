package at.htl.restaurant.workloads.reservation;

import java.util.List;

public interface IReservationRepository {
    public List<Table> getAllTables();
    public List<Reservation> getAllReservations();
    public List<Person> getAllPeople();
    public void addReservation(Reservation reservation);
    public void addPerson(Person person);
    public void addTable(Table table);
    public void removeReservation(Reservation reservation);
    public void removePerson(Person person);
    public void removeTable(Table table);
    public Reservation getReservationById(ReservationId id);
    public Table getTableById(Short id);
    public Person getPersonById(String ssn);
}