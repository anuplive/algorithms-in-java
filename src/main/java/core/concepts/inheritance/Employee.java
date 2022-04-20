package main.java.core.concepts.inheritance;

public abstract class Employee {
    private String name;
    private String degree;

    Employee(String name_, String degree_){
        this.name = name_;
        this.degree = degree_;
    }
    abstract String getJob();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
