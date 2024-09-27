import java.util.Random;

class Sistema {
    private final Loja loja1;
    private final Loja loja2;
    private Cliente[] clientes;

    public Sistema(Banco banco) {
        loja1 = criarLoja("loja 1", banco);
        loja2 = criarLoja("loja 2", banco);
        clientes = criarClientes(10, 2000.0);
    }

    private Loja criarLoja(String nome, Banco banco) {
        return new Loja(nome, banco);
    }

    private Cliente[] criarClientes(int quantidade, double saldoInicial) {
        Cliente[] clientes = new Cliente[quantidade];
        for (int i = 0; i < quantidade; i++) {
            clientes[i] = new Cliente("cliente " + (i + 1), saldoInicial);
        }
        return clientes;
    }

    public void executarTransacoes(int quantidadeComprasLoja1, int quantidadeComprasLoja2) {
        for (Cliente cliente : clientes) {
            realizarCompra(cliente, loja1, quantidadeComprasLoja1);
            realizarCompra(cliente, loja2, quantidadeComprasLoja2);
            exibirRelatorio(cliente);
        }
    }

    public void realizarCompra(Cliente cliente, Loja loja, int quantidade) {
        Random random = new Random();
        for (int i = 0; i < quantidade; i++) {
            double valorCompra = 100 + (400 * random.nextDouble());
            cliente.comprar(loja, valorCompra);
        }
    }

    public void exibirRelatorio(Cliente cliente) {
        double totalLoja1 = cliente.getTotalComprasLoja(loja1);
        double totalLoja2 = cliente.getTotalComprasLoja(loja2);
        System.out.printf("%s:\n", cliente.getNome());
        System.out.printf("compra na %s: r$ %.2f\n", loja1.getNome(), totalLoja1);
        System.out.printf("compra na %s: r$ %.2f\n", loja2.getNome(), totalLoja2);
        System.out.printf("saldo atual do %s: r$ %.2f\n", cliente.getNome(), cliente.getSaldo());
        System.out.printf("saldo atual da %s: r$ %.2f\n", loja1.getNome(), loja1.getSaldo());
        System.out.printf("saldo atual da %s: r$ %.2f\n\n", loja2.getNome(), loja2.getSaldo());
    }
}