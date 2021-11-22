package PROJECT.LOGIC2;

import PROJECT.DB2.DBException;
import PROJECT.DB2.DBLocation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class  Locations  {

    //instantievariabelen
    private String streetName;
    private short streetNumber;
    private String city;
    private short zip;
    private String locationType;
    private String installationDate;
    private Device device;
    private short roomNumber;
    private int locationID;
    private Measurement measurement;
    private SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
    Scanner keyboard = new Scanner(System.in);

    //constructor
    public Locations() { //deze constructor werkt nog niet helemaal perfect
        System.out.println("What is the street name?");
        this.streetName = keyboard.nextLine();
        System.out.println("What is the street number?");
        this.streetNumber = keyboard.nextShort();
        System.out.println("What is the city?");
        this.city = keyboard.next();
        System.out.println("What is the zip code?");
        this.zip = keyboard.nextShort();
        System.out.println("Which type of building is it?");
        this.locationType = keyboard.next();
        System.out.println("What is the room number?");
        this.roomNumber = keyboard.nextShort();
        System.out.println("What is the locationID?");
        this.locationID = keyboard.nextInt();
        System.out.println("What is the installation date");
        this.installationDate = keyboard.nextLine();
    }


    public Locations(int locationID, String locationType, String streetName, short streetNumber, short roomNumber,short zip,String city,  String installationDate) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zip = zip;
        this.locationType = locationType;
        this.roomNumber = roomNumber;
        this.locationID = locationID;
        this.installationDate = installationDate;
    }

    //getter and setters
    /*
    public String getStreetName(Locations location) throws DBException {
        return DBLocation.getStreetname(location.getLocationID(location));
    }

    public short getStreetNumber(Locations location) throws DBException {
        return DBLocation.getStreetNumber(location.getLocationID(location));
    }

    public String getCity(Locations location) throws DBException {
        return DBLocation.getCity(location.getLocationID(location));
    }

    public short getZip(Locations location) throws DBException {
        return DBLocation.getZip(location.getLocationID(location));
    }

       // Locations locations = new Locations(this.locationID, this.locationType, this.streetName, this.streetNumber, this.roomNumber, this.city, this.zip);


    public void setStreetName(Locations location, String streetName) throws DBException {
        DBLocation.setStreetName(location.getLocationID(location), streetName);
    }

    public void setStreetNumber(Locations location, short streetNumber) throws DBException {
        DBLocation.setStreetNumber(location.getLocationID(location), streetNumber);
    }

    public void setCity(Locations location, String city) throws DBException {
        DBLocation.setCity(location.getLocationID(location), city);
    }

    public void setZip(Locations location, short zip) throws DBException {
        DBLocation.setZip(location.getLocationID(location), zip);
    }



    public LocalDate getInstallationDate(Locations location) throws DBException {
        return DBLocation.getInstallationDate(location.getLocationID(location));
    }

    public Device getDevice(Locations location) throws DBException {
        return DBLocation.getDevice(location.getLocationID(location));
    }

    public String getLocationType(Locations location) {
        return locationType;
    }

    public void setLocationType(Locations location, String locationType) throws DBException {
        DBLocation.setLocationType(location.getLocationID(location), locationType);
    }

    public void setInstallationDate(Locations location, LocalDate installationDate) throws DBException {
        DBLocation.setInstallationDate(location.getLocationID(location), installationDate);
    }

    public void setDevice(Locations location ,Device device) throws DBException {
        DBLocation.setDevice(location.getLocationID(location), device);
    }

    public short getRoomNumber(Locations location) throws DBException {
        return (short) DBLocation.getRoomNumber(location.getLocationID(location));
    }

    public void setRoomNumber(Locations location, short roomNumber) throws DBException {
        DBLocation.setRoomNumber(location.getLocationID(location), roomNumber);
    }

    public int getLocationID(Locations location) {
        return DBLocation.getLocationID(location);
    }

    public void setLocationID(Locations location, int locationID) throws DBException {
        DBLocation.setLocationID(location.getLocationID(location), locationID);
    }

    //methodes
    public void addDevice(Locations location, Device device) throws DBException {
        DBLocation.addDeviceToLocation(location.getLocationID(location), device);
    }

    public void deleteDevice(Locations location, Device device) throws DBException {
        DBLocation.deleteDeviceFromLocation(location.getLocationID(location), device);
    }

    public Measurement getMeasurement(Locations location) throws DBException {
        return DBLocation.getMeasurement(location.getLocationID(location));
        
    }

    public void setMeasurement(Locations location, Measurement measurement) throws DBException {
        DBLocation.setMeasurement(location.getLocationID(location), measurement);
    }
*/
    public int getLocationID() {
        return this.locationID;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public short getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(short streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public short getZip() {
        return zip;
    }

    public void setZip(short zip) {
        this.zip = zip;
    }


    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(String installationDate) {
        this.installationDate = installationDate;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public short getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(short roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public String toString(){
        String res = "";
        res += "\nStreet name : " + this.streetName;
        res += "\nStreet number : " + this.streetNumber;
        res += "\nZip : " + this.zip;
        res += "\nCity : " + this.city;
        res += "\nLocation type : " + this.locationType;
        res += "\nRoom number : " + this.roomNumber;
        res += "\nInstallation date : " + this.installationDate;
        res += "\nLocation ID : " + this.locationID;
        return res;
    }
}





