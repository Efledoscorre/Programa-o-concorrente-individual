class Funcionario extends Thread {
    private final Loja loja;
    private final Banco banco;
    private final int numeroFuncionario;
    public final double salario;

    public Funcionario(Loja loja, Banco banco, int numeroFuncionario) {
        this.loja = loja;
        this.banco = banco;
        this.numeroFuncionario = numeroFuncionario;
        this.salario = 1400.0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                banco.receberSalario(loja, salario, numeroFuncionario);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void investir() {
        double investimento = salario * 0.2;
        banco.investir(this, investimento);
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }
}