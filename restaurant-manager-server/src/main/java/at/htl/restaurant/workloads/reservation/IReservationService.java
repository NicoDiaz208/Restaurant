package at.htl.restaurant.workloads.reservation;

import at.htl.restaurant.model.ReservationDTO;

import java.util.*;

public interface IReservationService {
    List<Reservation> getAllReservations();
    public boolean addReservation(ReservationDTO newReservation);
    public boolean removeReservation(ReservationDTO removeReservation);
}