import java.time.LocalDate;
import java.util.*;

public class HospitalManagementSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    public HospitalManagementSystem() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void scheduleAppointment(Doctor doctor, Patient patient, LocalDate date) {
        Appointment appointment = new Appointment(doctor, patient, date);
        appointments.add(appointment);
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }

    public static void main(String[] args) {
        HospitalManagementSystem hospital = new HospitalManagementSystem();

        Patient patient1 = new Patient("Иван", "12345");
        Patient patient2 = new Patient("Анна", "67890");

        Doctor doctor1 = new Doctor("Доктор Смит", "Кардиолог");
        Doctor doctor2 = new Doctor("Доктор Джонсон", "Хирург");

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        LocalDate appointmentDate1 = LocalDate.now();
        LocalDate appointmentDate2 = LocalDate.now();

        hospital.scheduleAppointment(doctor1, patient1, appointmentDate1);
        hospital.scheduleAppointment(doctor2, patient2, appointmentDate2);

        System.out.println("Список пациентов:");
        for (Patient patient : hospital.getPatients()) {
            System.out.println(patient.getName() + " (ID: " + patient.getPatientId() + ")");
        }

        System.out.println("\nСписок врачей:");
        for (Doctor doctor : hospital.getDoctors()) {
            System.out.println(doctor.getName() + " (Специализация: " + doctor.getSpecialization() + ")");
        }

        System.out.println("\nСписок назначений:");
        for (Appointment appointment : hospital.getAppointments()) {
            System.out.println(appointment.getDoctor().getName() + " назначил встречу для " +
                    appointment.getPatient().getName() + " на " + appointment.getDate());
        }
    }
}