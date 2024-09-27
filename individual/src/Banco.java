import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Banco {
    private final Lock lock = new ReentrantLock();
    private double saldoTotal;

    public void processarPagamento(Loja loja, double valor) {
        lock.lock();
        try {
            saldoTotal += valor;
            System.out.printf("transferência: r$ %.2f recebida na %s\n", valor, loja.getNome());
        } finally {
            lock.unlock();
        }
    }

    public void pagarFuncionario(Funcionario funcionario) {
        lock.lock();
        try {
            funcionario.investir();
            System.out.printf("investido: r$ %.2f pelo funcionário %d\n", funcionario.salario * 0.2, funcionario.getNumeroFuncionario());
        } finally {
            lock.unlock();
        }
    }

    public void receberSalario(Loja loja, double salario, int numeroFuncionario) {
        lock.lock();
        try {
            if (loja.getSaldo() >= salario) {
                loja.receberPagamento(-salario);
                System.out.printf("salário: r$ %.2f pago ao funcionário %d da %s\n", salario, numeroFuncionario, loja.getNome());
            }
        } finally {
            lock.unlock();
        }
    }

    public void investir(Funcionario funcionario, double valor) {
        lock.lock();
        try {
            System.out.printf("investido: r$ %.2f pelo funcionário %d\n", valor, funcionario.getNumeroFuncionario());
        } finally {
            lock.unlock();
        }
    }

    public void exibirSaldos() {
        System.out.printf("saldo total do banco: R$ %.2f\n", saldoTotal);

        for (Loja loja : new Loja[]{new Loja("loja 1", this), new Loja("loja 2", this)}) {
            System.out.printf("saldo da %s: R$ %.2f\n", loja.getNome(), loja.getSaldo());
            for (Funcionario funcionario : loja.getFuncionarios()) {
                System.out.printf("saldo do funcionário %d: R$ %.2f\n", funcionario.getNumeroFuncionario(), 1400.0 * 0.2);
            }
        }
    }
}