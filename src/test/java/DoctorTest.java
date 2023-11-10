import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    Doctor doctor;
    @BeforeEach
    void setUp() {
        doctor = new Doctor("Вильгельм Шлоссенберг", "Терапевт" );
    }

    @Test
    void getName() {
        assertEquals("Вильгельм Шлоссенберг", doctor.getName());
    }

    @Test
    void getSpecialization() {
        assertEquals("Терапевт" , doctor.getSpecialization());
    }
}