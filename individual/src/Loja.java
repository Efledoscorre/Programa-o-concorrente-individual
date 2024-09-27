class Loja {
    private final String nome;
    private double saldo;
    private final Banco banco;
    private final Funcionario[] funcionarios;

    public Loja(String nome, Banco banco) {
        this.nome = nome;
        this.banco = banco;
        this.saldo = 0.0;
        this.funcionarios = new Funcionario[2];
        criarFuncionarios();
    }

    private void criarFuncionarios() {
        for (int i = 0; i < funcionarios.length; i++) {
            funcionarios[i] = new Funcionario(this, banco, i + 1);
        }

        for (Funcionario funcionario : funcionarios) {
            new Thread(funcionario).start();
        }
    }

    public void receberPagamento(double valor) {
        saldo += valor;
        banco.processarPagamento(this, valor);
        pagarFuncionarios();
    }

    private void pagarFuncionarios() {
        if (saldo >= 1400) {
            saldo -= 1400;
            pagarFuncionarios();
        }
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }
}