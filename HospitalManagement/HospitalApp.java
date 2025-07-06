import java.util.*;

public class HospitalApp {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static int patientId = 1, doctorId = 1, appointmentId = 1;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;

            // Add default doctors for suggestion
            doctors.add(new Doctor(doctorId++, "Dr. Ramesh", "General Physician"));
            doctors.add(new Doctor(doctorId++, "Dr. Anitha", "Cardiologist"));
            doctors.add(new Doctor(doctorId++, "Dr. Srikanth", "Dermatologist"));

            do {
                System.out.println("\n===== Hospital Management System =====");
                System.out.println("1. Register Patient");
                System.out.println("2. Show Patients");
                System.out.println("3. Add Doctor");
                System.out.println("4. Show Doctors");
                System.out.println("5. Book Appointment");
                System.out.println("6. Show Appointments");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter disease: ");
                        String disease = sc.nextLine();

                        patients.add(new Patient(patientId++, name, age, disease));
                        System.out.println("Patient registered!");

                        String suggestedSpecialist = suggestSpecialist(disease);
                        Doctor matchedDoctor = findDoctorBySpecialization(suggestedSpecialist);

                        if (matchedDoctor != null) {
                            appointments.add(new Appointment(appointmentId++, name, matchedDoctor.name));
                            System.out.println(" Suggested Doctor: " + matchedDoctor.name + " (" + matchedDoctor.specialization + ")");
                            System.out.println("Appointment booked!");
                        } else {
                            System.out.println("No doctor available for specialization: " + suggestedSpecialist);
                        }
                    }
                    case 2 -> {
                        System.out.println("---- Patient List ----");
                        for (Patient p : patients) {
                            p.display();
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter doctor name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter specialization: ");
                        String spec = sc.nextLine();
                        doctors.add(new Doctor(doctorId++, name, spec));
                        System.out.println("Doctor added!");
                    }
                    case 4 -> {
                        System.out.println("---- Doctor List ----");
                        for (Doctor d : doctors) {
                            d.display();
                        }
                    }
                    case 5 -> {
                        System.out.print("Enter patient name: ");
                        String pName = sc.nextLine();
                        System.out.print("Enter doctor name: ");
                        String dName = sc.nextLine();
                        appointments.add(new Appointment(appointmentId++, pName, dName));
                        System.out.println("Appointment booked!");
                    }
                    case 6 -> {
                        System.out.println("---- Appointments ----");
                        for (Appointment a : appointments) {
                            a.display();
                        }
                    }
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 0);
        }
    }

    static String suggestSpecialist(String disease) {
        return switch (disease.toLowerCase()) {
            case "fever", "cold", "headache" -> "General Physician";
            case "heart", "bp", "cardiac" -> "Cardiologist";
            case "skin", "rash", "itching" -> "Dermatologist";
            default -> "General Physician";
        };
    }

    static Doctor findDoctorBySpecialization(String specialization) {
        for (Doctor d : doctors) {
            if (d.specialization.equalsIgnoreCase(specialization)) {
                return d;
            }
        }
        return null;
    }
}