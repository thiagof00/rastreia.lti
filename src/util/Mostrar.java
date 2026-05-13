package util;

public class Mostrar {

    private Mostrar() {
    }

    public static void sair() {
        Limpar.terminal();
        System.out.println("Saindo do sistema...");
    }

    public static void invalido() {
        System.out.println("Opção inválida! Tente novamente.");
    }

    public static void emConstrucao() {
        System.out.println("Funcionalidade em construção.");
        AguardarVoltar.Voltar();
    }
}
