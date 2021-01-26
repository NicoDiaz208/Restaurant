package at.htl.restaurant.workloads.reservation;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.*;

@RequestScoped
public class ReservationRepository implements IReservationRepository{
    private final EntityManager entityManager;

    public ReservationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Table> getAllTables(){
        var query = entityManager.createQuery("select  t from Table t");
        return query.getResultList();
    }

    @Override
    public List<Reservation> getAllReservations(){
        var query = entityManager.createQuery("select  r from Reservation r");
        return query.getResultList();
    }

    @Override
    public List<Person> getAllPeople() {
        var query = entityManager.createQuery("select p from Person p");
        return query.getResultList();
    }


    @Override
    public void addReservation(Reservation reservation){
        entityManager.persist(reservation);

    }

    @Override
    public void addPerson(Person person){
        entityManager.persist(person);

    }

    @Override
    public void addTable(Table table){
        entityManager.persist(table);
    }

    @Override
    public void removeReservation(Reservation reservation){
        entityManager.remove(reservation);
    }


    @Override
    public void removePerson(Person person){
        entityManager.remove(person);
    }


    @Override
    public void removeTable(Table table){
        entityManager.remove(table);
    }

    @Override
    public Reservation getReservationById(ReservationId id) {
        var query = entityManager.createQuery("select r from Reservation r where r.id.person.ssn = :ssn and r.id.reservationNo = :reservationNo", Reservation.class);
        query.setParameter("ssn", id.getPerson().getSsn());
        query.setParameter("reservationNo", id.getReservationNo());
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public Table getTableById(Short id) {
        var query = entityManager.createQuery("select t from Table t where t.tableId = :id", Table.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public Person getPersonById(String ssn) {
        var query = entityManager.createQuery("select  p from Person p where p.ssn = :ssn", Person.class);
        query.setParameter("ssn", ssn);
        return query.getResultStream().findFirst().orElse(null);
    }
}