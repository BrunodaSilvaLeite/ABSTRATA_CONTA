// Classe abstrata ContaBancaria
abstract class ContaBancaria {
    protected double saldo;

    //metodo construtor ContaBancaria
    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }
    // metodos abstratos
    public abstract boolean saque(double valor);
    public abstract void deposito(double valor);
    public abstract double consulta();
}

// Classe que extend ContaBancaria
class ContaCorrente extends ContaBancaria {
    private double limite;
    private final double taxaSaque = 0.05;      // 3% de taxa para saque
    private final double taxaDeposito = 0.02;    // 2% de taxa para depósito
    private final double taxaConsulta = 0.01;     // 1% de taxa para consulta

    public ContaCorrente(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }
    // Utilizando Override para indicar que estou sobrescrevendo um método da classe pai
    @Override
    public double consulta() {
        double saldoComTaxa = saldo - (saldo * taxaConsulta);
        System.out.println("Seu Saldo é: R$" + saldoComTaxa);
        return saldoComTaxa;
    }
    // Utilizando Override para indicar que estou sobrescrevendo um método da classe pai
    @Override
    public boolean saque(double valor) {
        //validação se valor é maior que o saldo
        if (valor >  saldo ) {
            double addAoLimite = valor - saldo;

            System.out.println("Saque não de " + valor + "onde:" + addAoLimite +" esta sendo descontado do limite de:" +limite+ ".");
            double limiteAtual = addAoLimite - limite;
            System.out.println("limite atual:" + limiteAtual  );
            return false;
        }
        saldo -= valor + (valor * taxaSaque);
        return true;
    }

    // Utilizando Override para indicar que estou sobrescrevendo um método da classe pai
    @Override
    public void deposito(double valor) {
        saldo += valor - (valor * taxaDeposito);
    }

}

// Classe que extend ContaBancaria
class ContaPoupanca extends ContaBancaria {
    private final double taxaSaque = 0.03;      // 1% de taxa para saque
    private final double taxaDeposito = 0.01;    // 2% de taxa para depósito
    private final double taxaConsulta = 0.005;    // 3% de taxa para consulta

    public ContaPoupanca(double saldo) {
        super(saldo);
    }
    // Utilizando Override para indicar que estou sobrescrevendo um método da classe pai
    @Override
    public boolean saque(double valor) {
        if (valor > saldo) {
            System.out.println("Saque não permitido: valor maior que o saldo.");
            return false;
        }
        saldo -= valor + (valor * taxaSaque);
        return true;
    }
    // Utilizando Override para indicar que estou sobrescrevendo um método da classe pai
    @Override
    public void deposito(double valor) {
        saldo += valor - (valor * taxaDeposito);
    }
    // Utilizando Override para indicar que estou sobrescrevendo um método da classe pai
    @Override
    public double consulta() {
        double saldoComTaxa = saldo - (saldo * taxaConsulta);
        System.out.println("Saldo atual: R$" + saldoComTaxa);
        return saldoComTaxa;
    }
}