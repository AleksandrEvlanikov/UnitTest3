import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HospitalManagementSystemTest {
    Patient patient1;
    Patient patient2;
    Doctor doctor1;
    Doctor doctor2;

    Appointment appointment;
    Appointment appointment1;

    private HospitalManagementSystem hospitalManagementSystem;

    @BeforeEach
    void setUp() {
        patient1 = new Patient("Иван", "12345");
        patient2 = new Patient("Анна", "67890");

        doctor1 = new Doctor("Доктор Смит", "Кардиолог");
        doctor2 = new Doctor("Доктор Джонсон", "Хирург");
        appointment =  new Appointment(doctor1,patient1, LocalDate.now() );
        appointment1 =  new Appointment(doctor2,patient2, LocalDate.now() );

        // hospitalManagementSystem.addPatient(patient1);
        hospitalManagementSystem = new HospitalManagementSystem();

    }

    @Test
    void addPatient() {
        List<Patient> patientList = new ArrayList<>(Collections.singletonList(patient1));
        hospitalManagementSystem.addPatient(patient1);
        //assertEquals(patientList,hospitalManagementSystem.getPatients());//Смутило сравнение экземпляров ЛИСТОВ с одинаковыми экземплярами
        assertArrayEquals(patientList.toArray(), hospitalManagementSystem.getPatients().toArray());
    }

    @Test
    void removePatient() {
        hospitalManagementSystem.addPatient(patient1);
        hospitalManagementSystem.removePatient(patient1);
        assertFalse(hospitalManagementSystem.getPatients().contains(patient1));
    }

    @Test
    void getPatients() {
        List<Patient> patientList = new ArrayList<>(Arrays.asList(patient1, patient2));
        hospitalManagementSystem.addPatient(patient1);
        hospitalManagementSystem.addPatient(patient2);
        assertArrayEquals(patientList.toArray(), hospitalManagementSystem.getPatients().toArray());
    }

    @Test
    void addDoctor() {
        List<Doctor> doctorList = new ArrayList<>(Arrays.asList(doctor1));
        hospitalManagementSystem.addDoctor(doctor1);
        assertArrayEquals(doctorList.toArray(), hospitalManagementSystem.getDoctors().toArray());

    }

    @Test
    void removeDoctor() {
        hospitalManagementSystem.addDoctor(doctor1);
        hospitalManagementSystem.removeDoctor(doctor1);
        assertTrue(!hospitalManagementSystem.getDoctors().contains(doctor1));
    }

    @Test
    void getDoctors() {
        List<Doctor> doctorList = new ArrayList<>(Arrays.asList(doctor1,doctor2));
        hospitalManagementSystem.addDoctor(doctor1);
        hospitalManagementSystem.addDoctor(doctor2);
        assertArrayEquals(doctorList.toArray(), hospitalManagementSystem.getDoctors().toArray() );

    }


    @Test
    void scheduleAppointment() {
        List<Appointment> appointmentList = new ArrayList<>(Arrays.asList(appointment));
        hospitalManagementSystem.scheduleAppointment(doctor1,patient1, LocalDate.now());
        List<Appointment> actualAppointments = hospitalManagementSystem.getAppointments();
        assertThat(actualAppointments).usingFieldByFieldElementComparator().isEqualTo(appointmentList);
    }

    @Test
    void getAppointments() {

        List<Appointment> appointmentList = Arrays.asList(appointment, appointment1);
        hospitalManagementSystem.scheduleAppointment(doctor1,patient1, LocalDate.now());
        hospitalManagementSystem.scheduleAppointment(doctor2,patient2, LocalDate.now());
        List<Appointment> actualAppointments = hospitalManagementSystem.getAppointments();

        assertThat(actualAppointments).usingFieldByFieldElementComparator().isEqualTo(appointmentList);

    }


}
