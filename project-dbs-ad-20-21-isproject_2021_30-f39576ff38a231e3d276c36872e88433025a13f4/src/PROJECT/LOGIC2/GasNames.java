package PROJECT.LOGIC2;

public class GasNames {
    private double value;
    private String name;

    public GasNames(double value, String name) {
        this.value = value;
        this.name = name;

    }

    public GasNames(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
