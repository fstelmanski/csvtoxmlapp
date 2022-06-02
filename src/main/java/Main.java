import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //File path to CSV generated in Google Sheets
        String filePathCSV = "src/cards.csv";

        //Getting list of cards as a result of parseCSVToObjectList() method
        CSVToPersonList csvToPersonList = new CSVToPersonList();
        ArrayList<Person>cardList = csvToPersonList.parseCSVToObjectList(filePathCSV);

        //Parsing list of cards to XML File
        PersonListToXML.parsePersonListToXML(cardList);


    }
}
