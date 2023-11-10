import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient patient;

    @BeforeEach
    void setUp(){
        String name = "Вася";
        String patientId = "1";
        patient = new Patient(name,patientId);
    }
    @Test
    @DisplayName("Тест создания клиента")
    void setPatientTest(){
        assertEquals("Вася",patient.getName() );
        assertEquals("1", patient.getPatientId());
    }
    @Test
    void getName() {
        String name = "Вася";
        assertTrue(name.equals(patient.getName()));
    }

    @Test
    void getPatientId() {
        assertEquals("1", patient.getPatientId());
    }
}