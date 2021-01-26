package at.htl.restaurant.workloads.reservation;

import at.htl.restaurant.model.PersonDTO;

import java.util.*;

public interface IPersonService {
    public boolean addPerson(PersonDTO newPerson);
    public boolean removePerson(PersonDTO removePerson);
    public List<Person> getAllPeople();
}