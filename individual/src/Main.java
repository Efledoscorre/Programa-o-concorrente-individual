public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Sistema sistema = new Sistema(banco);
        sistema.executarTransacoes(2, 2);
        banco.exibirSaldos();
    }
}
