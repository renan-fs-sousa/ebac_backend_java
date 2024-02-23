package br.com.rsousa;

/**
 * @author renan.sousa
 */
public class Main {
    public static void main(String[] args) {

        Smartphone samsung = new Smartphone();
        samsung.setModelo("Galaxy S23");
        System.out.println("Modelo do Smartphone: " + samsung.getModelo());
        samsung.ligar();
        samsung.testeChamada("Chamada completada");
        samsung.testeSMS("Falha de envio");
        samsung.desligar();
        System.out.println("===================");

        Smartphone apple = new Smartphone();
        apple.setModelo("Iphone 15");
        System.out.println("Modelo do smartphone: " + apple.getModelo());
        apple.ligar();
        apple.testeChamada("Ocupado");
        apple.testeSMS("SMS Enviado");
        apple.desligar();
        System.out.println("===================");
    }
}
