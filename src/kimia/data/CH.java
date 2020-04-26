package kimia.data;

/**
 * POJO CH Class to initialize data from csv file
 * @author BAYU IRFAN
 */
public class CH {
    private int id;
    private double data;
    private String r;

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }
}
