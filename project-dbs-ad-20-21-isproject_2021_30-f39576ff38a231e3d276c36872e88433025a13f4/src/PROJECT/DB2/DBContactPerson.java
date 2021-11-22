package PROJECT.DB2;




import PROJECT.LOGIC2.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContactPerson {



    /*
    public static void createTables() throws DBException {
        try {
            // dit maakt de tabellen aan, de relaties moeten nog wel gelegd
            // worden via phpmyadmin
            Connection con = DBConnector.getConnection();
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE contactperson ("
                    + "phoneNumber VARCHAR(15) NOT NULL"
                    + "email VARCHAR(45) NOT NULL, "
                    + "lastName VARCHAR(45) NOT NULL, "
                    + "firstName VARCHAR(45) NOT NULL, "
                    + "PRIMARY KEY (phoneNumber)" + ")";

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     */

    public static ContactPerson getContactPerson(String CPphoneNumber) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT phoneNumber, email, lastName, firstName "
                    + "FROM contactperson "
                    + "WHERE phoneNumber = " + CPphoneNumber;

            // let op de spatie na 'phoneNumber' en 'Persons' in voorgaande SQL
            ResultSet srs = stmt.executeQuery(sql);
            String firstName, lastName, email;
            String phoneNumber;

            if (srs.next()) {
                phoneNumber = srs.getString("phoneNumber");
                email = srs.getString("email");
                lastName = srs.getString("lastName");
                firstName = srs.getString("firstName");


            } else {// we verwachten slechts 1 rij...

                return null;
            }
            ContactPerson person = new ContactPerson(phoneNumber, firstName, lastName, email);

            return person;
        } catch (Exception ex) {
            ex.printStackTrace();
            //DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
    }
    public static void save(ContactPerson c) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT phoneNumber "
                    + "FROM contactperson "
                    + "WHERE phoneNumber = " + "'"+ c.getPhoneNumber() +"'";
            ResultSet srs = stmt.executeQuery(sql);
            if (srs.next()) {
                // UPDATE
                sql = "UPDATE contactperson "
                        + "SET email = '" + c.getEmail() + "'"
                        + ", lastName = '" + c.getLastName() + "'"
                        + ", firstName = '" + c.getFirstName() + "'"
                        + "WHERE phoneNumber = '" + c.getPhoneNumber() + "'";
                stmt.executeUpdate(sql);
            } else {
                // INSERT
                sql = "INSERT into contactperson "
                        + "(phoneNumber, email, lastName, firstName) "
                        + "VALUES (" + "'" +  c.getPhoneNumber() + "'"
                        + ", '" + c.getEmail() + "'"
                        + ", '" + c.getLastName() + "'"
                        + ", '" + c.getFirstName() + "')";
                //System.out.println(sql);
                stmt.executeUpdate(sql);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            //DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static ArrayList<ContactPerson> getContactPersons() throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT phoneNumber "
                    + "FROM contactperson";
            ResultSet srs = stmt.executeQuery(sql);
            ArrayList<ContactPerson> personen = new ArrayList<ContactPerson>();
            while (srs.next())
                personen.add(getContactPerson(srs.getString("phoneNumber")));

            return personen;
        } catch (DBException dbe) {
            dbe.printStackTrace();
            //DBConnector.closeConnection(con);
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            //DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
    }

    //    public static ArrayList<Student> getGraduates() throws DBException {
//        Connection con = null;
//        try {
//            con = DBConnector.getConnection();
//            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//            String sql = "SELECT number "
//                    + "FROM Students "
//                    + "WHERE graduate=" + true;
//            ResultSet srs = stmt.executeQuery(sql);
//
//            ArrayList<Student> studenten = new ArrayList<Student>();
//            while (srs.next())
//                studenten.add(getStudent(srs.getInt("number")));
//
//            return studenten;
//        } catch (DBException dbe) {
//            dbe.printStackTrace();
//            //DBConnector.closeConnection(con);
//            throw dbe;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            //DBConnector.closeConnection(con);
//            throw new DBException(ex);
//        }
//
//    }

    /*public static ContactPerson searchPerson(String firstName, String lastName){

<<<<<<< HEAD
    }*/




    public static void addLocation(long phoneNumber, long locationID) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "INSERT INTO personatplace"
                    + "VALUES (" + "'" + phoneNumber + "', " + locationID + ")" ;
            ResultSet srs = stmt.executeQuery(sql);
        } catch (DBException dbe) {
            dbe.printStackTrace();
            //DBConnector.closeConnection(con);
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            //DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void main(String[] args){
        try {
            DBContactPerson.save(new ContactPerson("0497874165", "Dylan", "Uyttersprot" , "dylan@hotmail.be"));
        } catch (DBException ex) {
            Logger.getLogger(DBContactPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Locations> getLocations(String phoneNumber) throws DBException {
        Connection con = null;  //con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT locationID "
                    + "FROM personatplace "
                    + "WHERE phoneNumber = " + "'" + phoneNumber + "'";
            ResultSet srs = stmt.executeQuery(sql);
            ArrayList<Locations> locations = new ArrayList<Locations>();
            while (srs.next())
                locations.add(DBLocation.getLocation(srs.getInt("locationID")));

            return locations;
        } catch (DBException dbe) {
            dbe.printStackTrace();

            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }

    }




    public static void deleteLocation(long phoneNumber, long locationID ) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "DELETE FROM personatplace" +
                    " WHERE locationID = " + "'" + locationID + "'"  ;//moet nog veranderd worden
            ResultSet srs = stmt.executeQuery(sql);
        } catch (DBException dbe) {
            dbe.printStackTrace();
            //DBConnector.closeConnection(con);
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            //DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
    }


    //aanpassen naar primary keys
    public static void deletePerson(String PhoneNumber) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "DELETE FROM contactperson " +
                    "WHERE phoneNumber = " + "'" + PhoneNumber + "'"  ;//moet nog veranderd worden
            int srs = stmt.executeUpdate(sql);
        } catch (DBException dbe) {
            dbe.printStackTrace();
            //DBConnector.closeConnection(con);
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            //DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static String getFirstName(ContactPerson person) throws DBException {
        return  getContactPerson(person.getPhoneNumber()).getFirstName();

    }

    public static String getLastName(ContactPerson person) throws DBException {
        return  getContactPerson(person.getPhoneNumber()).getLastName();

    }

    public static String getEmail(ContactPerson person) throws DBException {
        return  getContactPerson(person.getPhoneNumber()).getEmail();

    }

    public static String getPhoneNumber(ContactPerson person) throws DBException {

        return  getContactPerson(person.getPhoneNumber()).getPhoneNumber();
    }
    //deze moet wel person blijven

    /*
    public static void setFirstName(String firstName, ContactPerson person) throws DBException {
        getContactPerson(person.getPhoneNumber()).setFirstName(firstName);
    }

     */

    /*
    public static void setLastName(String lastName, ContactPerson person) throws DBException {
        getContactPerson(person.getPhoneNumber()).setLastName(lastName);
    }

     */

    /*
    public static void setEmail(String email, ContactPerson person) throws DBException {
         getContactPerson(person.getPhoneNumber()).setEmail(email);
    }

     */

    /*
    public static void setPhoneNumber(long oldphoneNumber, long newPhoneNumber) throws DBException {
         getContactPerson( oldphoneNumber).setPhoneNumber(newPhoneNumber);
    }

     */
    /*
    public static void setLocation(Locations location, ContactPerson person) throws DBException {
        //getContactPerson(person.getPhoneNumber()).setLocations(location); // niet helemaal zeker
    }

     */


}


