package kimia.data;

public class Error{
    private int idR1;
    private int idR2;
    private int idR3;
    private int totalCountId;

    public int getTotalCountId() {
        return totalCountId;
    }

    public void setTotalCountId(int totalCountId) {
        this.totalCountId = totalCountId;
    }
    
    private double error;

    public int getIdR1() {
        return idR1;
    }

    public void setIdR1(int idR1) {
        this.idR1 = idR1;
    }

    public int getIdR2() {
        return idR2;
    }

    public void setIdR2(int idR2) {
        this.idR2 = idR2;
    }

    public int getIdR3() {
        return idR3;
    }

    public void setIdR3(int idR3) {
        this.idR3 = idR3;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }
}
