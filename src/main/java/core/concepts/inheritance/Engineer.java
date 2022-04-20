package main.java.core.concepts.inheritance;

public class Engineer extends Employee{

    Engineer(String name, String degree){
        super(name, degree);
    }
    @Override
    String getJob() {
        return "Engineer";
    }
}
