package br.com.rsousa;

public class Shelby extends Car {

    @Override
    public void showCar() {
        System.out.println(getClass().getSimpleName());
    }
}