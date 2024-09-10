
package openendedlab2;
import java.util.*;
public class AppoinmentManagementSystem {
    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new GeneralPractitioner("Dr. Sajal"));
        doctors.add(new Specialist("Dr. Santu"));

        for (Doctor doctor : doctors) {
            doctor.setAvailability("9:00 AM - 5:00 PM");

        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View Available Doctors");
            System.out.println("2. Book an Appointment");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    for (Doctor doctor : doctors) {
                        doctor.displayAvailability();
                    }
                    break;

                case 2:
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Select Doctor:");
                    for (int i = 0; i < doctors.size(); i++) {
                        System.out.println((i + 1) + ". " + doctors.get(i).getName() + " (" + doctors.get(i).getSpecialization() + ")");
                    }
                   
                    int doctorChoice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Appointment Date (e.g., 2024-09-09): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Appointment Time (e.g., 10:30 AM): ");
                    String time = scanner.nextLine();

                    Patient patient = new Patient(patientName, patientAge);
                    Doctor selectedDoctor = doctors.get(doctorChoice - 1);
                    Appointment appointment = new Appointment(patient, selectedDoctor, date, time);
                    appointment.saveAppointment();
                    break;

                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
                    
        }
    }
}
