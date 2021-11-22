package PROJECT.LOGIC2;


import PROJECT.DB2.DBContactPerson;
import PROJECT.DB2.DBException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Systeem {

    private static ArrayList<ContactPerson> contactPersons = new ArrayList<>();
    private static Systeem systeem = new Systeem();


    public Systeem(){
        try{
            contactPersons = DBContactPerson.getContactPersons();
        }catch(DBException ex){
            Logger.getLogger(Systeem.class.getName()).log(Level.SEVERE, null, ex); //geen idee
        }

    }

    public static Systeem getInstance(){
        return systeem;
    }

    public static ArrayList<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public static void addContactPerson(ContactPerson contactPerson) {
        try {
            contactPersons.add(contactPerson);
            DBContactPerson.save(contactPerson);
        }catch(DBException ex) {
            Logger.getLogger(Systeem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void deleteContactPerson(String phoneNumber){
        try {
            ContactPerson person = DBContactPerson.getContactPerson(phoneNumber);
            contactPersons.remove(person);
        }catch(Exception ex) {
            Logger.getLogger(Systeem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
