package br.com.rsousa;

public class NoContractFactory extends Factory {
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Audi(100, "full", "black");
        } else {
            return new Honda(110, "full", "silver");
        }
    }
}
