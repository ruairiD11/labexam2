package ie.gmit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class EmployeeTest {
    Employee myEmployee;
    EmployeeList employeeList;

    @BeforeAll
    static void startingTests() { System.out.println("Starting Tests"); }

    @BeforeEach
    void printDisplayNames(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry(testInfo.getDisplayName());
    }

    @AfterAll
    static void testingComplete() { System.out.println("Testing Complete"); }

    @DisplayName("Testing constructor initialisation success")
    @Test
    void testConstructorSuccess() {
        myEmployee = new Employee("ruairi", "09879966", "12345", 23);
        assertEquals("ruairi", myEmployee.getName());
        assertEquals("09879966", myEmployee.getPhone());
        assertEquals("12345", myEmployee.getID());
        assertEquals(23, myEmployee.getAge());
    }

    @DisplayName("Testing invalid name entry (minimum)")
    @Test
    void testInvalidNameMinimum() {
        // Testing for a name entry < 3
        Exception e = assertThrows(IllegalArgumentException.class, () ->
            { myEmployee = new Employee("r", "09879966", "67888", 23); } );
        assertEquals("Name must have a minmium of 3 characters and a maximum of 25", e.getMessage());
    }

    @DisplayName("Testing invalid name entry (maximum)")
    @Test
    void testInvalidNameMaximum() {
        // Testing for a name entry > 25
        Exception e = assertThrows(IllegalArgumentException.class, () ->
        { myEmployee = new Employee("rrrrrrrrrrrrrrrrrrrrrrrrrrrrr", "09879966", "11111", 23); } );
        assertEquals("Name must have a minmium of 3 characters and a maximum of 25", e.getMessage());
    }

    @DisplayName("Testing invalid phone entry")
    @Test
    void testInvalidPhone() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
        { myEmployee = new Employee("ruairi", "0", "67888", 23); } );
        assertEquals("Phone number must be 8 digits", e.getMessage());
    }

    @DisplayName("Testing invalid ID entry")
    @Test
    void testInvalidID() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
        { myEmployee = new Employee("ruairi", "09879966", "888", 23); } );
        assertEquals("ID must be unique with 5 digits", e.getMessage());
    }

    @DisplayName("Testing invalid age entry")
    @Test
    void testInvalidAge() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
        { myEmployee = new Employee("ruairi", "09879966", "88866", 16); } );
        assertEquals("Employee must be over the age of 16", e.getMessage());
    }

    @DisplayName("Testing addEmployee method success")
    @Test
    void testAddEmployeeSuccess() {
        employeeList = new EmployeeList();
        myEmployee = new Employee("bob", "08999999", "76543", 30);
        employeeList.addEmployee(myEmployee);
    }

    /*@DisplayName("Testing addEmployee method failure")
    @Test
    void testAddEmployeeFailure() {
        employeeList = new EmployeeList();
        Employee e1 = new Employee("bob", "08999999", "76543", 30);
        Employee e2 = new Employee("bob", "08999999", "76543", 30);
        employeeList.addEmployee(e1);
        //employeeList.addEmployee(e2);


        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            //employeeList.addEmployee(e1);
            employeeList.addEmployee(e2); } );

        assertEquals("Employee already exists!", e.getMessage());
        //myEmployee = new Employee("bob", "08999999", "76543", 30);
    }*/

    @DisplayName("Testing getListSize method")
    @Test
    void testGetListSize() {
        employeeList = new EmployeeList();
        Employee e1 = new Employee("bob", "08999999", "76543", 30);
        Employee e2 = new Employee("rob", "77777999", "88843", 30);
        employeeList.addEmployee(e1);
        employeeList.addEmployee(e2);

        assertEquals(2, employeeList.getListSize());
    }
}
