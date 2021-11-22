package PROJECT.LOGIC2;

import PROJECT.DB2.DBDevice;
import PROJECT.DB2.DBException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Device{

    //instantievariabelen
    //private ArrayList<MeasurementType> measurementTypes = new ArrayList<>();
    private long deviceNumber; //uniek nummer van een device => hashCode
    private ArrayList<MeasurementType> measurementType;
    private Locations location;
    private ArrayList<GasTypes> gasTypes = new ArrayList<>();

    Scanner keyboard = new Scanner(System.in);


    //constructor
    /*public Device() {
        boolean done = false;
        int count = 0;
        boolean toegevoegd = true;
        while(!done){
            System.out.println("What does it measure?");
            String waarde = keyboard.nextLine();
            switch (waarde){
                case "CO2":
                    measurementTypes.add(MeasurementType.CO2);
                    count++;
                    break;
                case "N2":
                    measurementTypes.add(MeasurementType.N2);
                    count++;
                    break;
                case "PM2.5":
                    measurementTypes.add(MeasurementType.PM25);
                    count++;
                    break;
                case "PM5":
                    measurementTypes.add(MeasurementType.PM5);
                    count++;
                    break;
                case "PM10":
                    measurementTypes.add(MeasurementType.PM10);
                    count++;
                    break;
                default:
                    System.out.println("You have entered an illegal value!");
                    System.exit(0); //Hier misschien ook met een exception werken
            }
            if(count == 5) {
                done = true;
            }
            if(!done){
                System.out.println("Does it measure anything else?");
                String answer = keyboard.nextLine();
                if(answer.equalsIgnoreCase("yes") ){
                    done = false;
                }
                else{
                    done = true;
                }
            }
        }
        if(!measurementTypes.contains(MeasurementType.CO2)) {
            System.out.println("This is an illegal action!");
            toegevoegd = false;
            System.exit(0);
        }
        if(measurementTypes.contains(MeasurementType.N2)) {
            if (!measurementTypes.contains(MeasurementType.CO2)) {
                System.out.println("This is an illegal action!");
                toegevoegd = false;
                System.exit(0); //kunnen hier met een exception werken
            }
        }
        if(measurementTypes.contains(MeasurementType.PM25)||measurementTypes.contains(MeasurementType.PM5)||measurementTypes.contains(MeasurementType.PM10)){
            if(!(measurementTypes.contains(MeasurementType.PM25)&&measurementTypes.contains(MeasurementType.PM5)&&measurementTypes.contains(MeasurementType.PM10))){
                System.out.println("This is an illegal action!");
                toegevoegd = false;
                System.exit(0);
            }
            if(!(measurementTypes.contains(MeasurementType.CO2) && measurementTypes.contains(MeasurementType.N2))){
                System.out.println("This is an illegal action!");
                toegevoegd = false;
                System.exit(0);
            }
        }

        if(toegevoegd){
            System.out.println("This device has been added to the list!");
        }
        //nog toevoegen aan de database
    }*/

    //constructor

    //getter and setter
    /*public void setDeviceNumber(){
        System.out.println("Which serial number do you want to give this device?(ONLY NUMBERS)!");
        this.deviceNumber = keyboard.nextLong(); //gebruik maken van hashcode?
    }*/

    public Device(){
        System.out.println("What is the device number?");
        this.deviceNumber = keyboard.nextLong();
    }

    public Device(long deviceNumber, ArrayList<MeasurementType> type){
        this.deviceNumber = deviceNumber;
        if(type.size() > 1){
            measurementType.add(MeasurementType.Average);
            measurementType.add(MeasurementType.Minimum);
            measurementType.add(MeasurementType.Maximum);
        }else {
            measurementType.add(MeasurementType.Average);
        }
    }




    public ArrayList<MeasurementType> getMeasurementType() throws DBException {
        return this.measurementType;
    }

    public void setMeasurementType(ArrayList<MeasurementType> measurementType) {
        this.measurementType = measurementType;
    }

    /*public Locations getLocation(Device device) throws DBException {
        return DBDevice.getLocations(device.getDeviceNumber(device));
    }*/


    public Locations getLocation(){
    return this.location;
    }

    public void setLocation(Locations location){
        this.location = location;
    }

    public double getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(long deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public ArrayList<GasTypes> getGasTypes() {
        return gasTypes;
    }

    public void setGasTypes(ArrayList<GasTypes> gasTypes) {
        this.gasTypes = gasTypes;
    }

    public void addGasType(GasTypes gasTypes1){
        gasTypes.add(gasTypes1);

    }

       //we hebben deze momenteel nog nodig voor de DBDevice getAverage methode
    /*
    public double getAverage(){
        LocalDate startDate = (LocalDate)location.getInstallationDate();
        LocalDate endDate = LocalDate.now();
        double sum = 0;

        List<LocalDate> listOfDates = startDate.datesUntil(endDate).collect(Collectors.toList());
        for(int i = 0; i < listOfDates.size(); i++){
            sum += DBDevice.getAverage(listOfDates.get(i));
        }
        double average = (sum/listOfDates.size());
        return average;
    }*/




}


