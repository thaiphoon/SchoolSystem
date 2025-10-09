package system.data.person;

public abstract class Person {

    private int personId;
    private String name;

    public Person(int personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    public int getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }
}
