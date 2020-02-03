import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    private Employee employee;
    private Nurse nurse;
    private Receptionist receptionist;
    private Janitor janitor;
    private Doctor doctor;

    @BeforeEach
    void setUp() {

        employee = new Employee("John", 234, 90000.00);
        doctor = new Doctor("John", 02, 90000, "Heart");
        nurse = new Nurse("Jane", 456, 50000, 10);
        receptionist = new Receptionist("Tracy", 05, 45000,true);
        janitor = new Janitor("Bob", 07, 30000,true);

    }


    @Test
    public void shouldBeAbleToAddAnEmployeeClass() {

    }

    @Test
    public void employeeShouldHaveName() {
        String result = employee.getName();
        assertEquals("John", result);
    }

    @Test
    public void employeeShouldHaveAnotherName() {
        employee = new Employee("Doe", 2, 90000.00);
        String result = employee.getName();
        assertEquals("Doe", result);
    }

    @Test
    public void employeeShouldHaveSalary() {
        double result = employee.getSalary();
        assertEquals(90000, result);
    }

    @Test
    public void employeeShouldHaveANumber() {
        int result = employee.getEmployeeNumber();
        assertEquals(234, result);

    }
    @Test
    public void employeeShouldNotBePaidUntilReceivingPay_NotPaidYet() {
        boolean result = employee.getIsPaid();
        assertFalse(result);
    }
    @Test
    public void employeeShouldNotBePaidUntilReceivingPay_HasRecievedPay() {
        employee.receivePay();
        boolean result = employee.getIsPaid();
        assertTrue(result);
    }

    @Test
    public void receptionistIsOnThePhone() {
        boolean result = receptionist.getIsOnThePhone();
        assertTrue(result);
    }

    @Test
    public void receptionistIsNotOnThePhone() {
        receptionist.noLongerOnThePhone();
        boolean result = receptionist.getIsOnThePhone();
        assertFalse(result);
    }

    @Test
    public void janitorIsSweeping() {
        boolean result = janitor.getIsSweeping();
        assertTrue(result);
    }

    @Test
    public void janitorIsNotSweeping() {
        janitor.isNoLongerSweeping();
        boolean result = janitor.getIsSweeping();
        assertFalse(result);
    }

    @Test
    public void doctorShouldHaveASpecialtyArea() {
        String result = doctor.getSpecialty();
        assertEquals("Heart", result);
    }

    @Test
    public void doctorShouldBeAbleToDrawBlood() {
        Patient pt = new Patient("Jeff",100,70);
        doctor.drawBlood(pt);
        assertEquals(97, pt.getBloodLevel());
    }

    @Test
    public void doctorShouldCareForPatient() {
        Patient pt = new Patient("Jeff",100,70);
        doctor.careForPatient(pt);
        assertEquals(80, pt.getHealthLevel());
    }

    @Test
    public void anotherDoctorShouldHaveASpecialtyArea() {
        doctor = new Doctor("John", 02, 90000, "Brain");
        String result = doctor.getSpecialty();
        assertEquals("Brain", result);
    }

    @Test
    public void nurseShouldHaveANumberOfPatients() {
        Nurse nurse = new Nurse("Jane", 02, 50000, 70);
        int result = nurse.getNumberOfPatients();
        assertEquals(70, result);
    }

    @Test
    public void nurseShouldHaveADifferentNumberOfPatients() {
        int result = nurse.getNumberOfPatients();
        assertEquals(10, result);
    }

    @Test
    public void nurseShouldBeAbleToDrawBlood() {
        Patient pt = new Patient("Jeff",100,70);
        nurse.drawBlood(pt);
        assertEquals(95, pt.getBloodLevel());

    }

    @Test
    public void nurseShouldCareForPatient() {
        Patient pt = new Patient("Jeff",100,70);
        nurse.careForPatient(pt);
        assertEquals(75, pt.getHealthLevel());

    }


}
