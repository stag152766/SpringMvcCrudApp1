package ru.alishev.springcourse.config.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.config.models.Person;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@,mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",52,"bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 18,"mike@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Kate",34,"kate@mail.ru"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
