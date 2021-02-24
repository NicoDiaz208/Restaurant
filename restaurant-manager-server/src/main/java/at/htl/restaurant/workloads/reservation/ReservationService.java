package at.htl.restaurant.workloads.reservation;

import at.htl.restaurant.model.PersonDTO;
import at.htl.restaurant.model.ReservationDTO;
import at.htl.restaurant.model.TableDTO;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ReservationService implements IReservationService{
    private final IReservationRepository reservationRepository;

    public ReservationService(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<ReservationDTO> getAllReservations() {

        var result = new ArrayList<ReservationDTO>();

        reservationRepository.getAllReservations().forEach(i  -> {
            var table = reservationRepository.getTableById(i.getTable().getTableId());
            var person = reservationRepository.getPersonById(i.getId().getPerson().getSsn());
            result.add(new ReservationDTO(new TableDTO(table.getTableId(), table.getChairs()), i.getTime(),
                    new PersonDTO(person.getSsn(), person.getPhone(), person.getEmail()),i.getId().getReservationNo()));
        });
        return  result;
    }

    @Override
    public boolean addReservation(ReservationDTO newReservation) {
        var existingTable = reservationRepository.getTableById(newReservation.getTable().getTableId());
        var existingPerson = reservationRepository.getPersonById(newReservation.getPerson().getSsn());
        if(existingPerson == null || existingPerson == null)
            return false;

        var existingReservation = reservationRepository.getReservationById(new ReservationId(existingPerson, newReservation.getReservationNo()));
        if(existingReservation != null)
            return false;

        var reservation = new Reservation();
        reservation.setId(new ReservationId(existingPerson, newReservation.getReservationNo()));
        reservation.setTable(existingTable);
        reservation.setTime(newReservation.getTime());
        reservationRepository.addReservation(reservation);
        return true;
    }

    @Override
    public boolean removeReservation(ReservationDTO removeReservation) {
        var existingTable = reservationRepository.getTableById(removeReservation.getTable().getTableId());
        var existingPerson = reservationRepository.getPersonById(removeReservation.getPerson().getSsn());

        var existingReservation = reservationRepository.getReservationById(new ReservationId(existingPerson, removeReservation.getReservationNo()));
        if(existingReservation == null)
            return false;

        var reservation = new Reservation();
        reservation.setId(new ReservationId(existingPerson, removeReservation.getReservationNo()));
        reservation.setTime(removeReservation.getTime());
        reservation.setTable(existingTable);
        reservationRepository.addReservation(reservation);
        return true;
    }
}
