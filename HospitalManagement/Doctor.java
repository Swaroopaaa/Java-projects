public class Doctor {
    int docId;
    String name;
    String specialization;

    public Doctor(int docId, String name, String specialization) {
        this.docId = docId;
        this.name = name;
        this.specialization = specialization;
    }

    public void display() {
        System.out.println("Doctor ID: " + docId + " | Name: " + name + " | Specialization: " + specialization);
    }
}