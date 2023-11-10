import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
    Appointment appointment;
    Doctor doctor; //? dependency
    Patient patient;//? dependency

    LocalDate appointmentDate;

    @BeforeEach
    void setUp() {
        doctor = new Doctor("Вильгельм Шлоссенберг", "Терапевт" );
        patient = new Patient("Вася", "1");
        appointmentDate = LocalDate.now();
        appointment = new Appointment(doctor, patient, appointmentDate );
    }

    @Test
    @DisplayName("Проверка получения доктора из приема")
    void getDoctor() {
        assertEquals( doctor, appointment.getDoctor());
    }
    //TODO проверки на NPE,

    @Test
    @DisplayName("Проверка получения пациента из приема")
    void getPatient() {
        assertEquals(patient, appointment.getPatient());
    }

    @Test
    @DisplayName("Проверка дату")
    void getDate() {
        assertEquals(appointmentDate, appointment.getDate());
    }
}