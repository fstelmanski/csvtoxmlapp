
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;



import java.util.ArrayList;

@XmlRootElement
public class Cards {

    private ArrayList<Person>personList;

    public Cards(){

    }

    public Cards(ArrayList<Person> personList) {
        this.personList = personList;
    }

    @XmlElement(name = "card")
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
}
