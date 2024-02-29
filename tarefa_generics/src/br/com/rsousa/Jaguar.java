package br.com.rsousa;

public class Jaguar extends Car {

    @Override
    public void showCar() {
        System.out.println(getClass().getSimpleName());
    }

}