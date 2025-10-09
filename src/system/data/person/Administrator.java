package system.data.person;

public class Administrator extends Person{
    public Administrator(int personId, String name) {
        super(personId, name);
        this.type = "administrator";
    }
}
