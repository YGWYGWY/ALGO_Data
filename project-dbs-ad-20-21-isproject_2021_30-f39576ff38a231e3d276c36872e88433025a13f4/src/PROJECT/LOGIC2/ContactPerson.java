package PROJECT.LOGIC2;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactPerson {

    //instantievariabelen
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    //public gezet voor toegang in PROJECT.LOGIC2.Administration
    private  ArrayList<Locations> locations;
    Scanner keyboard = new Scanner(System.in);


    //constructor: gebruiken we volgens mij in ons programma niet echt, voor volledigheid
    public ContactPerson() {
        boolean toegevoegd = false;

        System.out.println("What is his/ her first name?");
        String voorNaam = keyboard.nextLine();
        System.out.println("What is his/her last name?");
        String familieNaam = keyboard.nextLine();
        System.out.println("What is his/her e-mail?");
        String email = keyboard.nextLine();
        System.out.println("What is his/her phone number? (NO SPACES BETWEEN THE NUMBERS!)");
        String telnummer = keyboard.nextLine();
        ContactPerson persoon = new ContactPerson(voorNaam, familieNaam, email, telnummer);

        if(Systeem.getContactPersons().contains(persoon)){
            System.out.println("This person is already on the list!");
            System.exit(0);
        }
        else{
            Systeem.addContactPerson(persoon);
        }

    }

    public ContactPerson(String phoneNumber, String email, String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        // we kunnen hier beslissen om de methode addPerson eraan toe te voegen zodat hij automatisch aan de Hashmap wordt toegevoegd,
        // dan moet de methode setPerson wel nog aangepast worden
    }

    //getter and setters
    /*public String getFirstName(ContactPerson person) throws DBException {
        return DBContactPerson.getFirstName(person);
    }

    public String getLastName(ContactPerson person) throws DBException {
        return DBContactPerson.getLastName(person);
    }

    public String getEmail(ContactPerson person) throws DBException {
        return DBContactPerson.getEmail(person);
    }

    public long getPhoneNumber(ContactPerson person) throws DBException {
       return DBContactPerson.getPhoneNumber(person);
    }

    public void setFirstName(String firstName, ContactPerson person) throws DBException {
        DBContactPerson.setFirstName(firstName, person);
    }

    public void setLastName(String lastName, ContactPerson person) throws DBException {
        DBContactPerson.setLastName(lastName, person);
    }

    public void setEmail(String email, ContactPerson person) throws DBException {
        DBContactPerson.setEmail(email,person);
    }

    public void setPhoneNumber(long phoneNumber, ContactPerson person) throws DBException { DBContactPerson.setPhoneNumber(phoneNumber, person.getPhoneNumber(person));
    }

    public ArrayList<Locations> getLocations(ContactPerson person) throws DBException {
        return DBContactPerson.getLocations(person.getPhoneNumber(person));
    }

    public void setLocations(Locations locations, ContactPerson person) throws DBException {
        DBContactPerson.setLocation(locations, person);
    }*/





    //methodes
    /*public void addPerson(){//addPerson moet ook in PROJECT.LOGIC2.ContactPerson blijven voor de constructor
        boolean toegevoegd = false;

        System.out.println("What is his/ her first name?");
        String voorNaam = keyboard.nextLine();
        System.out.println("What is his/her last name?");
        String familieNaam = keyboard.nextLine();
        System.out.println("What is his/her e-mail?");
        String email = keyboard.nextLine();
        System.out.println("What is his/her phone number? (NO SPACES BETWEEN THE NUMBERS!)");
        long telnummer = keyboard.nextLong();
        ContactPerson persoon = new ContactPerson(voorNaam, familieNaam, email, telnummer);

        if(Systeem.getContactPersons().contains(persoon)){
            System.out.println("This person is already on the list!");
            System.exit(0);
        }
        else{
            Systeem.addContactPerson(persoon);
        }
    }*/

    //deze ook nodig voor constructor
    /*public void addLocation(){
        System.out.println("What is the street name?");
        String streetName = keyboard.nextLine();
        System.out.println("What is the street number?");
        short streetNumber = keyboard.nextShort();
        System.out.println("What is the city?");
        String city = keyboard.nextLine();
        System.out.println("What is the zip code?");
        short zip = keyboard.nextShort();
        System.out.println("What is the province?");
        String province = keyboard.nextLine();
        System.out.println("Which type of building is it?");
        String locationType = keyboard.nextLine();

        Locations locations = new Locations(streetName,streetNumber,city,zip,province,locationType);
        if(!this.getLocations().contains(locations)){
                this.locations.add(locations);
            }
        }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public  ArrayList<Locations> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Locations> location) {
        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).getLocationID() == (locations.get(i).getLocationID())){
                locations.set(i,locations.get(i));
                //hoe gaan we dit doen als een persoon een locatieID verandert?
            }
        }

    }

    @Override
    public String toString() {
        String res = "";
        res += "\nfirst name : " + this.firstName;
        res += "\nlast name : " + this.lastName;
        res += "\ne-mail : " + this.email;
        res += "\nPhone number : " + this.phoneNumber;
        return res;
    }
    }
