package br.com.rsousa;

public class Maverick extends Car {

    @Override
    public void showCar() {
        System.out.println(getClass().getSimpleName());
    }
}