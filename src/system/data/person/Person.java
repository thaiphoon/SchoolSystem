package system.data.person;

public abstract class Person {

    private int personId;
    private String name;
    protected String type;

    public Person(int personId, String name) {
        this.personId = personId;
        this.name = name;
    }
}
