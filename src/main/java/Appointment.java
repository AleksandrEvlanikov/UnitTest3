import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

class Appointment {
    private Doctor doctor;
    private Patient patient;
    private LocalDate date;

    public Appointment(Doctor doctor, Patient patient, LocalDate date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }


    public Doctor getDoctor() {
        return this.doctor;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}