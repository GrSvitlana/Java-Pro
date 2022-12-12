package model_school;


public abstract class Human {
    private String name;
    private int id;

    public Human(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract void introduceYourself();

    public abstract void teach(Student student, Subject subject);
}
