package sistema;

public class Cartao {
    //Atributos
    private int num;
    private String titular;
    private int cvv;
    private String vencimento;
    private double saldo;

    //Construtor
    public Cartao(){}
    public Cartao(int num, String titular, int cvv, String vencimento) {
        this.num = num;
        this.titular = titular;
        this.cvv = cvv;
        this.vencimento = vencimento;
    } 
    public Cartao(int num, String titular, int cvv, String vencimento, double saldo){
        this.num = num;
        this.titular = titular;
        this.cvv = cvv;
        this.vencimento = vencimento;
        this.saldo = saldo;
    }
    
    //Getters
    public int getNum() {
        return num;
    }
    public String getTitular() {
        return titular;
    }
    public int getCvv() {
        return cvv;
    }
    public String getVencimento() {
        return vencimento;
    }
    public double getSaldo() {
        return saldo;
    }

    //Setters
    public void setNum(int num) {
        this.num = num;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //Metodos
    public void pagar(double valor){
        this.saldo -= valor;
    }
}
