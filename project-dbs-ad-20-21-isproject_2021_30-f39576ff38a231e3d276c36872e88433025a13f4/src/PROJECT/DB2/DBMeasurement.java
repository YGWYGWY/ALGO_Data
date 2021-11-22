package PROJECT.DB2;





import PROJECT.LOGIC2.*;
import javafx.collections.ObservableList;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

public class DBMeasurement {


    public static ObservableList getmeasurement(Locations locations) {
        //methode om alle measurements gesorteerd op datum terug te krijgen uit de DB
        //van de eerste datum tot aan de huidige datum terug
        return null;
    }

    public static void save(Measurement c) throws DBException {
        Connection con = null;  //con = DBConnector.getConnection();con = DBConnector.getConnection();?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT measurement "
                    + "FROM measurement "
                    + "WHERE measurementID = " + c.getMeasurementID();
            ResultSet srs = stmt.executeQuery(sql);
            if (srs.next()) {
                // UPDATE
                sql = "UPDATE measurement "
                        + "SET date = " + c.getDatum()
                        + "average = " // + c.getAverage //
                        + "minimum = " // + c.getmin//
                        + "maximum = " // + c.getmax//
                        + "devicenumber = " +c.getDevice().getDeviceNumber()
                        + "WHERE measurementID = " + c.getMeasurementID();
                stmt.executeUpdate(sql);
            } else {
                // INSERT
                sql = "INSERT into measurement "
                        + "(measurementID, date, average, minimum, maximum) "
                        + "VALUES ('" + c.getMeasurementID() + "', "
                        + "'" + c.getDatum() + "'"
                        //+ c.getaverage() + "'"
                        //+ "'" + c.getmin() + "'"
                        //+ c.getmac() + "'"
                        ;
                //System.out.println(sql);
                stmt.executeUpdate(sql);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }
    }

    public static double getForecast(Date date, int i){
        //methode om van i dagen voor vandaag de CO2 waarde terug te krijgen
        // waarom enkel CO2??

        return 0;
    }

    public static double getAverageOfAllLocations(Date now, int i) {
        //methode om over alle locaties in de database het gemiddelde van die dag terug te krijgen
        //int i staat voor het aantal dagen voor vandaag, zodat we van elke dag van de week het gemiddelde krijgen van alle locaties
        //som van alle CO2 waardes van een bepaalde dag, van alle locaties, optellen en delen door het aantal locaties
        return 0;
    }

    public static double getCO2(Locations location) {
        return 0;
    } // nodig?


    public static void deleteMeasurement(long measurementID) throws DBException {
        Connection con = null;   // con = DBConnector.getConnection()?
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "DELETE FROM measurement" +
                    "WHERE measurementID=" + measurementID;

            ResultSet srs = stmt.executeQuery(sql);

        } catch (DBException dle) {
            dle.printStackTrace();

            throw dle;
        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }

    }
}
