import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoringRecords {

    public static void main(String[] args) {
        //Scanner is used for collecting keyboard inputs
        Scanner scan = new Scanner(System.in);

        System.out.println("Filename:");
        String fileName = scan.nextLine();

        ArrayList<Person> records = readRecordsFromFile(fileName);
        System.out.println("Persons: " + records.size());
        System.out.println("Persons:");
        for (Person person : records) {
            System.out.println(person);

        }
    }

    public static ArrayList<Person> readRecordsFromFile(String fileName) {
        ArrayList<Person> persons = new ArrayList<>();

        File file = new File(fileName);

        try(BufferedReader br = new BufferedReader(new FileReader(file))){

            String line = br.readLine();

            while (line != null){

                String[] split = line.split(",");

                String name = split[0];
                int age = Integer.valueOf(split[1]);

                persons.add(new Person (name, age));

                line = br.readLine();

            }

        }

        catch(Exception e){

            System.out.println("Error: " + e.getMessage());

        }

        // Write here the code for reading from file
        // and printing the read records
        return persons;

    }
}
