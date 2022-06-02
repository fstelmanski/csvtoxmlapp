import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name", "surname", "phone"})
public class Person {
    private String name;
    private String surname;
    private Long phone;


    public Person(){

    }
    public Person(String name, String surname, Long phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void validateName() {
        if (this.name.isBlank())
            throw new RuntimeException("Name is null or empty! Fix this");
    }

    public void validateSurname() {
        if (this.surname.isBlank())
            throw new RuntimeException("Surname is null or empty! Fix this");
    }

    public void validatePhoneNumber() {
        if (String.valueOf(this.phone).isBlank()) {
            throw new RuntimeException("Phone is null or empty! Fix this");
        }

        if (String.valueOf(this.phone).length() != 11) {
            throw new RuntimeException("Phone number should be 11 digits long");
        }
        if (!String.valueOf(this.phone).matches("\\d+")) {
            throw new RuntimeException("Phone number can contain only digits");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "NAME='" + name + '\'' +
                ", SURNAME='" + surname + '\'' +
                ", PHONE=" + phone +
                '}';
    }
}
