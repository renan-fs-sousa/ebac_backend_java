package br.com.rsousa;

@ITabela(nome = "Reflections", marca = "Apple", modelo = "Iphone 15")

public class App {
    public static void main(String[] args) {
        Class<?> classe = App.class;
        ITabela anotacao = classe.getAnnotation(ITabela.class);
        try {
            if (classe.isAnnotationPresent(ITabela.class)) {
                String tabela = "Nome: " + anotacao.nome() + "\n Dados:\n " + anotacao.marca() + ", "
                        + anotacao.modelo();
                System.out.println("Tabela: " + tabela);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}