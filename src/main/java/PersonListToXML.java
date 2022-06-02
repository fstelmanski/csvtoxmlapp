import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;

public class PersonListToXML {
    public static void parsePersonListToXML(ArrayList<Person>personList) {
        Cards allCards = new Cards(personList);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cards.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            File filePathXML = new File("src/cards.xml");
            marshaller.marshal(allCards, filePathXML);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
