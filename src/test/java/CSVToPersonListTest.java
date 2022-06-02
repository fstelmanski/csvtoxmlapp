import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CSVToPersonListTest {

    CSVToPersonList csvToPersonList;
    @BeforeAll
    public void setupAll(){
        System.out.println("Start Testing class");
    }
    @BeforeEach
    public void setup(){
        csvToPersonList = new CSVToPersonList();
        csvToPersonList.parseCSVToObjectList("src/cards.csv");
    }


    @Test
    public void shouldCreateNewPerson(){
        int startingSize = csvToPersonList.getAllPeople().size();
        csvToPersonList.addPerson("Andrew","Andree",12311231121L);
        Assertions.assertFalse(csvToPersonList.getAllPeople().isEmpty());
        Assertions.assertEquals(startingSize+1,csvToPersonList.getAllPeople().size());
        Assertions.assertTrue(csvToPersonList.getAllPeople().stream().anyMatch(person -> person.getName().equals("Andrew") &&
                person.getSurname().equals("Andree") && String.valueOf(person.getPhone()).equals("12311231121")));

    }

    @Test
    @DisplayName("Should not create person when name is NULL")
    public void shouldThrowRuntimeExceptionWhenNameIsNull() {
        Assertions.assertThrows(RuntimeException.class,()->{csvToPersonList.addPerson(null,"Andree",12311231121L);
        });
    }

    @Test
    @DisplayName("Should not create person when surname is NULL")
    public void shouldThrowRuntimeExceptionWhenSurnameIsNull() {
        Assertions.assertThrows(RuntimeException.class,()->{csvToPersonList.addPerson("Andrew",null,12311231121L);
        });
    }

    @Test
    @DisplayName("Should not create person when phone is NULL")
    public void shouldThrowRuntimeExceptionWhenPhoneIsNull() {
        Assertions.assertThrows(RuntimeException.class,()->{csvToPersonList.addPerson("Andrew","Andree",null);
        });
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Single Test Done");
    }
    @AfterAll
    public void tearDownAll(){
        System.out.println("End of testing");
    }
}


