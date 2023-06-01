class BancoFuncoes {
    public final static int STATUS_CRIADO = 0;
    public final static int STATUS_INATIVO = -1;

    private String nome = "";
    private String numeroConta = "";
    double saldo = 0;
    int status = BancoFuncoes.STATUS_INATIVO;

    public BancoFuncoes(String nomeTitular, String numeroConta, double saldoInicial) {
        this.depositar(saldoInicial);
        this.definirNomeTitular(numeroConta);
        this.definirNumeroConta(nomeTitular);
        this.status = BancoFuncoes.STATUS_CRIADO;
    }
    public String depositar(double valor) {
        if(valor < 0) return "Não pode depositar um valor menor que 0";
        this.saldo += valor;
        return "Depósito de " + valor + " realizado com sucesso;";
    }
    public void definirNomeTitular(String nome) {
        this.nome = nome;
    }
    public void definirNumeroConta(String novoNumero) {
        this.numeroConta = novoNumero;
    }
    public int obterStatusConta() {
        return this.status;
    }
    public String sacar(double valor) {
        if(this.saldo < valor) return "Saldo insuficiente para realizar a operação.";
        if(valor > 5000) return "Valor do saque acima do permitido.";
        this.saldo -= valor;
        return "Saque de " + valor + "realizado com sucesso.";
    }
    public double obterSaldo() {
        return this.saldo;
    }

}