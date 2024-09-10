
package openendedlab2;
import java.io.*;
import java.util.*;

abstract class Doctor {
    private String name;
    private String specialization;
    private String availability;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public abstract void displayAvailability();
}

class GeneralPractitioner extends Doctor {
    public GeneralPractitioner(String name) {
        super(name, "General Practitioner");
    }

    @Override
    public void displayAvailability() {
        System.out.println(getName() + " (" + getSpecialization() + ") is available for walk-in patients: " + getAvailability());
    }
}
class Specialist extends Doctor {
    public Specialist(String name) {
        super(name, "Specialist");
    }

    @Override
    public void displayAvailability() {
        System.out.println(getName() + " (" + getSpecialization() + ") is available for appointments only: " + getAvailability());
    }
}
class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public void saveAppointment() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("appointments.txt", true))) {
            writer.write("Patient: " + patient.getName() + ", Age: " + patient.getAge() + "\n");
            writer.write("Doctor: " + doctor.getName() + " (" + doctor.getSpecialization() + ")\n");
            writer.write("Date: " + date + ", Time: " + time + "\n");
            writer.write("---------------------------------\n");
            System.out.println("Appointment booked successfully!");
        } catch (IOException e) {
            System.out.println("Error saving appointment: " + e.getMessage());
        }
    }
}