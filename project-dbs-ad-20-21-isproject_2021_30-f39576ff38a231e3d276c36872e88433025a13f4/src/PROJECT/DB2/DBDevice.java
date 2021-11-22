package PROJECT.DB2;


import PROJECT.LOGIC2.*;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBDevice {

    /*public static void createTables() throws DBException {
        try {
            // dit maakt de tabellen aan, de relaties moeten nog wel gelegd
            // worden via phpmyadmin

            Connection con = DBConnector.getConnection();
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE device ("
                    + "locationID int NOT NULL, "
                    + "deviceNumber int NOT NULL, "
                    + "PRIMARY KEY (deviceNumber)" + ")";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/


    public static Device getDevices(long deviceNumber) throws DBException {
        Connection con = null;  // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM device "
                    + "WHERE deviceNumber = " + deviceNumber;


            ResultSet srs = stmt.executeQuery(sql);
            String location, measurementTypes;
            double measurement;


            if (srs.next()) {
                location = srs.getString("location");
                measurementTypes = srs.getString("measurement_types");
                measurement = srs.getDouble("measurements");

                deviceNumber = srs.getLong("deviceNumber");


            } else {// we verwachten slechts 1 rij...

                return null;
            }

            //we hebben nog geen constructor voor device klasse
            //Device device = new Device(location, measurementTypes, deviceNumber);
            //Measurement measurement = new Measurement(

            return null; //moet return device worden
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }
    }

    public static void save(Device d) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT deviceNumber "
                    + "FROM device "
                    + "WHERE deviceNumber = " + d.getDeviceNumber();
            ResultSet srs = stmt.executeQuery(sql);

            if (srs.next()) {
                // UPDATE
                sql = "UPDATE device "
                        + "SET locationID = '" + getLocationID((long) d.getDeviceNumber()) + "'"
                        + "WHERE deviceNumber = " + d.getDeviceNumber();
                stmt.executeUpdate(sql);

            } else {
                // INSERT
                sql = "INSERT into device "
                        + "(deviceNumber, locationID) "
                        + "VALUES ('" + d.getDeviceNumber() + "'," + "'" + getLocationID((long) d.getDeviceNumber())
                        + "')";

                //System.out.println(sql);
                stmt.executeUpdate(sql);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }
    }

    public static ArrayList<Device> getDevices() throws DBException {
        Connection con = null;  // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT deviceNumber "
                    + "FROM device";

            ResultSet srs = stmt.executeQuery(sql);
            ArrayList<Device> devices = new ArrayList<Device>();
            while (srs.next())
                devices.add(getDevices(srs.getLong("deviceNumber")));

            return devices;
        } catch (DBException dbe) {
            dbe.printStackTrace();
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }
    }




    public static int getLocationID(long deviceNumber) throws DBException{
        Connection con = null;   // con = DBConnector.getConnection()?
        int locationID= 0;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT locationID "
                    + "FROM device" +
                    "WHERE deviceNumber = " + deviceNumber;

            ResultSet srs = stmt.executeQuery(sql);

            if (srs.next()) {
                locationID = srs.getInt("locationID");


            }
        } catch (DBException dle) {
            dle.printStackTrace();
            throw dle;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }
        return locationID;
    }




    public static Locations getLocations(long deviceNumber) throws DBException {
        int id = getLocationID(deviceNumber);
        return DBLocation.getLocation((id));

    }



    public static void deleteDevice(long deviceNumber) throws DBException{
        Connection con = null;   // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "DELETE FROM device" +
                    "WHERE deviceNumber=" + deviceNumber;

            ResultSet srs = stmt.executeQuery(sql);

        } catch (DBException dle) {
            dle.printStackTrace();
            throw dle;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }

    }


    public static long getDeviceNumber(long locationID) throws DBException {
        return (long) getDevices(getDeviceNumber(locationID)).getDeviceNumber();
    }

    public static void enterMeasurement(Device deviceNumber, Measurement measurementID) throws DBException{
        Connection con = null;  // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql ="INSERT INTO measurement (measurementID, date, deviceNumber) VALUES "
                    + "(" + measurementID +", "
                    + /* datum meting (meegeven als argument?)
                    + */ ", " + deviceNumber + ")";

            ResultSet srs = stmt.executeQuery(sql);
        } catch (DBException dbe) {
            dbe.printStackTrace();
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }


    }

    /*
     public static void setDevice(long deviceNumber, long newNumber) throws DBException {
        getDevices(deviceNumber).setDeviceNumber(newNumber);

     }
*/

    public static long getDeviceNumber(Device device) throws DBException {
        return (long) getDevices(getDeviceNumber(device)).getDeviceNumber();

    }


     public static void main(String[] args){

    }

    public static ArrayList<MeasurementType> getMeasurementType(long deviceNumber) throws DBException {
        return getDevices(deviceNumber).getMeasurementType();

    }
/*
    public static void setLocation(long deviceNumber, Locations location) throws DBException {
        getDevices((long)deviceNumber).setLocation(location);

    }
*/

    public static Locations getLocation(long deviceNumber) throws DBException {
        return getDevices(deviceNumber).getLocation();

    }


     public static void addLocation(long locationID, long measurementTypes,long deviceNumber) throws DBException {
         Connection con = null; // con = DBConnector.getConnection()?
         try {
             con = DBConnector.getConnection();
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

             String sql = "INSERT INTO device (locationID, measurementTypes, deviceNumber) VALUES "
                     + "(" + locationID + "," + measurementTypes + "," + deviceNumber + ")";

             ResultSet srs = stmt.executeQuery(sql);

         } catch (DBException dle) {
             dle.printStackTrace();
             throw dle;
         } catch (Exception ex) {
             ex.printStackTrace();
             throw new DBException(ex);
         }
     }



     public static double getAverage1(long deviceNumber) throws DBException {
         Connection con = null;  // con = DBConnector.getConnection()?
         double average = 0;
         try {
             con = DBConnector.getConnection();
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

             String sql = "SELECT average FROM measurement" +
                     "WHERE deviceNumber = " + deviceNumber;

             ResultSet srs = stmt.executeQuery(sql);

             if (srs.next()) {
                 average = srs.getDouble("average");
             }

         } catch (DBException dle) {
             dle.printStackTrace();
             throw dle;
         } catch (Exception ex) {
             ex.printStackTrace();
             throw new DBException(ex);
         }
         return average;

     }


     /*
    public static double getAverage(long deviceNumber) throws DBException {
        return getDevices(deviceNumber).getAverage(); // de getAverage staat momenteel in comment

    }

      */



}
