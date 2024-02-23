package br.com.rsousa;

public class Wrapper {

    //Primitivo Long
    private long numero = 99999999999l;

    public static void main(String[] args) {

        Wrapper wrapper = new Wrapper();

        //Convertendo para Wrapper Long
        Long wrapperLong = wrapper.numero;

        System.out.println("Primitivo Long: " + wrapper.numero);
        System.out.println("=======================");
        System.out.println("Wrapper Long: " + wrapperLong);
    }
}
