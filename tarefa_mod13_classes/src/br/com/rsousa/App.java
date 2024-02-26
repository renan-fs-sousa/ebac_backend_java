package br.com.rsousa;

public class App {
    public static void main(String[] args) {

        Pf pf = new Pf();
        pf.setNome("Renan Sousa");
        pf.setCpf("999.999.999-99");

        Pj pj = new Pj();
        pj.setNome("MasterCodes Ltda.");
        pj.setCnpj("99.999.999/0001-02");

        System.out.println("Dados PF: \n" + pf.getNome() + "\n" + pf.getCpf());
        System.out.println("====================");
        System.out.println("Dados PJ: \n" + pj.getNome() + "\n" + pj.getCnpj());

    }
}
