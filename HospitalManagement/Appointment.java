public class Appointment {
    int appId;
    String patientName;
    String doctorName;

    public Appointment(int appId, String patientName, String doctorName) {
        this.appId = appId;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }

    public void display() {
        System.out.println("Appointment ID: " + appId + " | Patient: " + patientName + " | Doctor: " + doctorName);
    }
}