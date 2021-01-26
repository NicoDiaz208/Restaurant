package at.htl.restaurant.workloads.reservation;

import at.htl.restaurant.model.PersonDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class PersonService implements IPersonService {
    private final IReservationRepository reservationRepository;

    public PersonService(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public boolean addPerson(PersonDTO newPerson) {
        var existingPerson = reservationRepository.getPersonById(newPerson.getSsn());
        if (existingPerson != null)
            return false;

        var person = new Person();
        person.setPhone(newPerson.getPhone());
        person.setSsn(newPerson.getSsn());
        person.setEmail(newPerson.getEmail());
        reservationRepository.addPerson(person);
        return true;
    }

    @Override
    public boolean removePerson(PersonDTO removePerson) {
        var existingPerson = reservationRepository.getPersonById(removePerson.getSsn());
        if (existingPerson == null)
            return false;

        var person = new Person();
        person.setPhone(removePerson.getPhone());
        person.setSsn(removePerson.getSsn());
        person.setEmail(removePerson.getEmail());
        reservationRepository.removePerson(person);
        return true;
    }

    @Override
    public List<Person> getAllPeople() {
        return reservationRepository.getAllPeople();
    }
}
