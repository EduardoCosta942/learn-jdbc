package Models;

public class Department {
    // Declare attributes
    private final int deptno;
    private String dname;
    private String dloc;

    // Method builder
    public Department(int deptno, String dname, String dloc){
        this.deptno = deptno;
        this.dname = dname;
        this.dloc = dloc;
    }

    // Getters Methods
    public int getDeptno() {
        return deptno;
    }

    public String getDname() {
        return dname;
    }

    public String getDloc() {
        return dloc;
    }

    // Setters Methods
    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setDloc(String dloc) {
        this.dloc = dloc;
    }

    // Method toString()
    @Override
    public String toString() {
        return "Department{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", dloc='" + dloc + '\'' +
                '}';
    }
}
