package main.java.core.concepts.inheritance;

public class Staff extends Employee{

    Staff(String name, String degree){
        super(name, degree);
    }

    @Override
    String getJob() {
        return "Staff";
    }
}
