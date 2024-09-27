class Conta {
    private double saldo;

    public Conta() {
        this.saldo = 0;
    }

    public synchronized void adicionar(double valor) {
        saldo += valor;
    }

    public synchronized void debitar(double valor) {
        saldo -= valor;
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}