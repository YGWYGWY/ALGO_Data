package PROJECT.LOGIC2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Measurement {

    //instantievariabelen
    private Date datum;
    private Locations locations;
    private Device device;
    //private double CO2;
    //private double N2;
    //private double PM25;
    //private double PM5;
    //private double PM10;
    private ArrayList<GasNames> gasNames;
    private String measurementID;

    //constructor?

    public Measurement(Date datum, Locations locations, String measurementID) {
        this.datum = datum;
        this.locations = locations;
        this.device = device;
        /*this.CO2 = CO2;
        this.N2 = 0;
        this.PM25 = 0;
        this.PM5= 0;
        this.PM10 = 0;*/
        this.measurementID = measurementID;
    }

    /*public Measurement(Date datum, Locations locations, double CO2, double n2, long measurementID) {
        this.datum = datum;
        this.locations = locations;
        this.CO2 = CO2;
        this.N2 = n2;
        this.PM25 = 0;
        this.PM5= 0;
        this.PM10 = 0;
        this.measurementID = measurementID;
    }

    public Measurement(Date datum, Locations locations, double CO2, double n2, double PM25, double PM5, double PM10, long measurementID) {
        this.datum = datum;
        this.locations = locations;
        this.CO2 = CO2;
        this.N2 = n2;
        this.PM25 = PM25;
        this.PM5 = PM5;
        this.PM10 = PM10;
        this.measurementID = measurementID;
    }*/

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    /*public double getCO2() {
        return CO2;
    }

    public void setCO2(double CO2) {
        this.CO2 = CO2;
    }

    public double getN2() {
        return N2;
    }

    public void setN2(double n2) {
        N2 = n2;
    }

    public double getPM25() {
        return PM25;
    }

    public void setPM25(double PM25) {
        this.PM25 = PM25;
    }

    public double getPM5() {
        return PM5;
    }

    public void setPM5(double PM5) {
        this.PM5 = PM5;
    }

    public double getPM10() {
        return PM10;
    }

    public void setPM10(double PM10) {
        this.PM10 = PM10;
    }*/

    public ArrayList<GasNames> getGasNames() {
        return gasNames;
    }

    public void setGasNames(ArrayList<GasNames> gasNames) {
        this.gasNames = gasNames;
    }

    public String getMeasurementID() {
        return measurementID;
    }

    public void setMeasurementID(String measurementID) {
        this.measurementID = measurementID;
    }

    public void addGasName(GasNames gas) {
        gasNames.add(gas);
    }

    public double getAverage() {
        double sum = 0;
        int aantal = 0;
        for (int i = 0; i < getGasNames().size(); i++) {
            if (getGasNames().get(i).getName().equals("CO2")) {
                sum += this.getGasNames().get(i).getValue();
                aantal++;
            }
        }
        double average = sum / aantal;
        return average;

    }

    @Override
    public String toString() {
        String res = "";
        res += datum;
        for (int i = 0; i < getGasNames().size(); i++) {
            res += "\n" + getGasNames().get(i).getName() + " :" +
                    getGasNames().get(i).getValue();
        }
        return res;
    }
}
