package PROJECT.DB2;


import PROJECT.LOGIC2.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class DBLocation {


    /*
    public static void createTables() throws DBException {
        try {
            // dit maakt de tabellen aan, de relaties moeten nog wel gelegd
            // worden via phpmyadmin
            Connection con = DBConnector.getConnection();
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE location ("
                    + "locationID INT NOT NULL, "
                    + "locationType VARCHAR(45) NOT NULL, "
                    + "streetName VARCHAR(45) NOT NULL, "
                    + "streetNumber INT NOT NULL, "
                    + "roomnr INT NOT NULL, "
                    + "zip INT NOT NULL, "
                    + "city VARCHAR(45)"
                    + "installationDate VARCHAR(45)"
                    + "PRIMARY KEY (locationID)"
                    + ")";


            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     */

    public static Locations getLocation(int LocationID) throws DBException {
        Connection con = null;  // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM location "
                    + "WHERE locationID = " + LocationID;
            // let op de spatie na 'locationID ' en 'location ' in voorgaande SQL


            ResultSet srs = stmt.executeQuery(sql);
            String locationType, streetName, city, installationDate ;
            Short streetNumber, roomnr, zip;
            int locationID;


            if (srs.next()) {
                locationID= srs.getInt("locationID");

                locationType = srs.getString("locationType");
                streetName = srs.getString("streetName");
                streetNumber = srs.getShort("streetNumber");
                roomnr = srs.getShort("roomnr");
                zip = srs.getShort("zip");
                city = srs.getString("city");
                installationDate = srs.getString("installationDate");




            } else {// we verwachten slechts 1 rij...

                return null;
            }
//            ContactPerson person = new ContactPerson(firstName, lastName, email, phoneNumber);
            Locations location = new Locations(locationID, locationType, streetName, streetNumber, roomnr,zip, city, installationDate);

            return location;
        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }
    }

    public static void save(Locations c) throws DBException {
        Connection con = null;   // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM location "
                    + "WHERE locationID = " + c.getLocationID();
            ResultSet srs = stmt.executeQuery(sql);
            if (srs.next()) {
                // UPDATE
                sql = "UPDATE location "
                        + "SET locationType = " + "'" +  c.getLocationType() + "'"
                        + ", streetName = " + "'" +c.getStreetName() + "'"
                        + ", streetNumber = " + c.getStreetNumber()
                        + ", roomNumber = " + c.getRoomNumber()
                        + ", zip = " + c.getZip()
                        + ", city = " + "'" + c.getCity() + "'"
                        + ", installationDate = " + "'" + c.getInstallationDate() + "'"
                        + "WHERE locationID = " + c.getLocationID();
                stmt.executeUpdate(sql);
            } else {
                // INSERT
                sql = "INSERT INTO location "
                        + "(locationID, locationType, streetname, streetnumber, roomnr, zip, city) "
                        + "VALUES ("
                        + c.getLocationID()
                        + ", " + c.getLocationType() + "'"
                        + ", '" + c.getStreetName() + "'"
                        + ", " + c.getStreetNumber()
                        + ", " + c.getZip()
                        + ", " + c.getRoomNumber()
                        + ", '" + c.getCity() + "'"
                        + ")";
                //System.out.println(sql);
                stmt.executeUpdate(sql);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }
    }

    public static ArrayList<Locations> getLocations(String CPphoneNumber) throws DBException {
        Connection con = null;  //con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT locationID "
                    + "FROM personatplace "
                    + "WHERE phoneNumber = " + "'" + CPphoneNumber + "'" ;
            ResultSet srs = stmt.executeQuery(sql);
            ArrayList<Locations> locations = new ArrayList<Locations>();
            while (srs.next())
                locations.add(getLocation(srs.getInt("locationID")));

            return locations;
        } catch (DBException dbe) {
            dbe.printStackTrace();

            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }
    }




    public static void addDeviceToLocation(long locationID, long deviceNr, LocalDate now) throws DBException {
        Connection con = null;  // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT INTO device "
                    + "(deviceNumber, installationDate, locationID)" +
                    "VALUES(" + deviceNr + ", " + getInstallationDate(locationID )+  "," + locationID + ")";

            ResultSet srs = stmt.executeQuery(sql);
        } catch (DBException dbe) {
            dbe.printStackTrace();

            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }
    }


    public static void deleteDeviceFromLocation(long locationID) throws DBException {
        Connection con = null;  // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "DELETE FROM device WHERE locationID = " + locationID;

            ResultSet srs = stmt.executeQuery(sql);
        } catch (DBException dbe) {
            dbe.printStackTrace();

            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }
    }


    public static void setDeviceAtLocation(long locationID, Device deviceNr) throws DBException {
        Connection con = null;  // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "UPDATE device SET (deviceNumber) = " + deviceNr
                    + "WHERE locationID = " + locationID;

            ResultSet srs = stmt.executeQuery(sql);
        } catch (DBException dbe) {
            dbe.printStackTrace();

            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }
    }



    public static Device getDevice(long locationID) throws DBException {
        // Hoe kan ik een Device object returnen via database?
        Device dev = getLocation((int) locationID).getDevice();
        return dev;
    }

    public static void enterMeasurement(double deviceNr, Measurement measurementID ) throws DBException {
        Connection con = null;  // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql ="INSERT INTO measurement (measurementID, date, deviceNumber) VALUES "
                    + "(" + measurementID +", "
                    + /* datum meting (meegeven als argument?)
                    + */ ", " + deviceNr + ")";

            ResultSet srs = stmt.executeQuery(sql);
        } catch (DBException dbe) {
            dbe.printStackTrace();

            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }
    }



    public static void main(String[] args){

    }


    public static String getStreetname(int locationID) throws DBException {
        return getLocation(locationID).getStreetName();
    }

    public static int getLocationID(Locations location) {
        return location.getLocationID();
    }

    public static short getStreetNumber(int locationID) throws DBException {
        return getLocation(locationID).getStreetNumber();
    }

    public static String getCity(int locationID) throws DBException {
        return getLocation(locationID).getCity();
    }

    public static short getZip(int locationID) throws DBException {
        return getLocation(locationID).getZip();
    }





/*
    public static void setStreetName(long locationID, String streetName) throws DBException {
        getLocation((int) locationID).setStreetName(streetName);
        //save(getLocation((int) locationID));
    }

    public static void setStreetNumber(long locationID, short streetNumber) throws DBException {
        getLocation((int) locationID).setStreetNumber(streetNumber);

    }

    public static void setCity(long locationID, String city) throws DBException {
        getLocation((int) locationID).setCity(city);
    }

    public static void setZip(long locationID, short zip) throws DBException {
        getLocation((int) locationID).setZip(zip);
    }

 */





    public static String getInstallationDate(long locationID) throws DBException {
        return getLocation((int) locationID).getInstallationDate();
    }

    /*
    public static void setLocationType(long locationID, String locationType) throws DBException {
        getLocation((int) locationID).setLocationType(locationType);
    }

    public static void setInstallationDate(long locationID, Date installationDate) throws DBException {
        getLocation((int) locationID).setInstallationDate(installationDate);
    }

    public static void setDevice(long locationID, Device device) throws DBException {
        getLocation((int) locationID).setDevice(device);
    }

     */

    public static int getRoomNumber(long locationID) throws DBException {
        return getLocation((int) locationID).getRoomNumber();
    }

    /*
    public static void setRoomNumber(long locationID, short roomNumber) throws DBException {
        getLocation((int) locationID).setRoomNumber(roomNumber);
    }

    public static void setLocationID(long oldLocationID, long newLocationID) throws DBException {
        getLocation((int) oldLocationID).setLocationID((int) newLocationID);
    }

     */

    public static Measurement getMeasurement(long locationID) throws DBException {
        return getLocation((int) locationID).getMeasurement();
    }

    /*

    public static void setMeasurement(long locationID, Measurement measurement) throws DBException {
        getLocation((int) locationID).setMeasurement(measurement);
    }


    // ??? methodes werken niet hier
    public static void setCO2(int locationID, double parseDouble) throws DBException {
        getLocation(locationID).getMeasurement().setCO2(parseDouble);
    }

    public static void setN2(int locationID, double parseDouble) throws DBException {
        getLocation(locationID).getMeasurement().setN2(parseDouble);
    }

    public static void setPM25(int locationID, double parseDouble) throws DBException {
        getLocation(locationID).getMeasurement().setPM25(parseDouble);
    }

    public static void setPM5(int locationID, double parseDouble) throws DBException {
        getLocation(locationID).getMeasurement().setPM5(parseDouble);
    }

    public static void setPM10(int locationID, double parseDouble) throws DBException {
        getLocation(locationID).getMeasurement().setPM10(parseDouble);
    }

     */

    public static Object searchForDate(Date date, Locations location) {
        //kijken of deze dag al een measurement bestaat op de gegeven locatie
        return null;
    }
}


