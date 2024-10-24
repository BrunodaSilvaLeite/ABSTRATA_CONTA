//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(1000, 500);
        ContaPoupanca contaPoupanca = new ContaPoupanca(2000);

        contaCorrente.deposito(200);
        contaCorrente.saque(150);
        contaCorrente.consulta();

        contaPoupanca.deposito(100);
        contaPoupanca.saque(50);
        contaPoupanca.consulta();
    }
}