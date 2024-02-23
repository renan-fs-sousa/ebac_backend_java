package br.com.rsousa;

/**
 * @author renan.sousa
 */
public class Smartphone {

    private String modelo;

    public void ligar() {
        System.out.println("Smartphone ligado");
    }

    public void desligar() {
        System.out.println("Smartphone desligado");
    }

    public void testeChamada(String args) {
        System.out.println("Teste de Chamada: " + args);
    }

    public void testeSMS(String args)  {
        System.out.println("Teste de SMS: " + args);
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

}
