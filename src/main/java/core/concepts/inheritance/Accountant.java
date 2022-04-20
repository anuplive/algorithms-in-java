package main.java.core.concepts.inheritance;

public class Accountant extends Employee{

    Accountant(String name, String degree){
        super(name, degree);
    }
    @Override
    String getJob() {
        return "Accountant";
    }
}
