class Cliente {
    private final String nome;
    private double saldo;
    private double totalComprasLoja1;
    private double totalComprasLoja2;

    public Cliente(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
    }

    public void comprar(Loja loja, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            loja.receberPagamento(valor);
            adicionarCompraLoja(loja.getNome(), valor);
            System.out.printf("o cliente %s comprou um item na %s por r$ %.2f. saldo disponível: r$ %.2f%n", nome, loja.getNome(), valor, saldo);
        } else {
            System.out.printf("o cliente %s tentou realizar uma compra na %s, mas não tem saldo suficiente. saldo atual: r$ %.2f%n", nome, loja.getNome(), saldo);
        }
    }

    private void adicionarCompraLoja(String nomeLoja, double valor) {
        if (nomeLoja.equals("loja 1")) {
            totalComprasLoja1 += valor;
        } else {
            totalComprasLoja2 += valor;
        }
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTotalComprasLoja(Loja loja) {
        double total = (loja.getNome().equals("loja 1")) ? totalComprasLoja1 : totalComprasLoja2;
        return total;
    }
}