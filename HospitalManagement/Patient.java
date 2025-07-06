public class Patient {
    int id;
    String name;
    int age;
    String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Disease: " + disease);
    }
}