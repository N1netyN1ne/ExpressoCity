package servicos;

import sistema.Motorista;
import sistema.Passageiro;
import java.util.Scanner;
import sistema.Cadastro;
import java.text.DecimalFormat;

public class Corrida {
    //Atributos
    private Motorista motorista;
    private Passageiro passageiro;
    private String saida;
    private String destino;
    private double distancia;
    private double avaliacao;
    private String form_pag;
    private double valor;
    private double taxaKm;
    private String zona;
    private Scanner scan = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.##");

    //Construtores
    public Corrida() {}
    public Corrida(Motorista motorista, Passageiro passageiro, String saida, String destino, double distancia, String form_pag, String zona) {
        this.motorista = motorista;
        this.passageiro = passageiro;
        this.saida = saida;
        this.destino = destino;
        this.distancia = distancia;
        this.form_pag = form_pag;
        this.zona = zona;
    }
    
    //Getters
    public Motorista getMotorista() {
        return motorista;
    }
    public Passageiro getPassageiro() {
        return passageiro;
    }
    public String getSaida() {
        return saida;
    }
    public String getDestino() {
        return destino;
    }
    public double getDistancia() {
        return distancia;
    }
    public double getAvaliacao() {
        return avaliacao;
    }
    public String getForm_pag() {
        return form_pag;
    }
    public double getValor() {
        return valor;
    }
    public double getTaxaKm() {
        return taxaKm;
    }
    public String getZona() {
        return zona;
    }
    
    //Setters
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    public void setPassageiro(Passageiro passageiro) {    
        this.passageiro = passageiro;
    }
    public void setSaida(String saida) {
        this.saida = saida;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    public void setForm_pag(String form_pag) {
        this.form_pag = form_pag;
    }
    public void setTaxaKm(double taxaKm){
        this.taxaKm = taxaKm;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    public boolean setTaxaKm() {
        if(zona.equals("Norte") || zona.equals("norte")){
            taxaKm = 2.8;
            return true;
        }else if(zona.equals("Sul") || zona.equals("sul")){
            taxaKm = 3.2;
            return true;
        }else if(zona.equals("Oeste") || zona.equals("oeste")){
            taxaKm = 2.5;
            return true;
        }else if(zona.equals("Leste") || zona.equals("leste")){
            taxaKm = 3.5;
            return true;
        }else if(zona.equals("Centro") || zona.equals("centro")){
            taxaKm = 4;
            return true;
        }else{
            return false;
        }
    }
    public void setZona(String zona) {
        this.zona = zona;
    }
    
    //Metodos
    public void corrida(){
        if(setTaxaKm()){
            valorCorrida();
            System.out.println("\nValor da corrida R$" + df.format(valor));
            System.out.println("\nDeseja prosseguir ?\n1-Sim\n2-Nao");
            int resp = scan.nextInt();
            
            if(resp == 1){
               if(validarPagamento()){
                    motorista.setSaldo(valor);
                    do{
                       System.out.println("Qual sua avaliacao para esta corrida ? 1 a 5");
                       avaliacao = scan.nextDouble(); 
                    }while(avaliacao > 5);
                    motorista.setnViagens();
                    motorista.setAvaliacoes(avaliacao);
                    System.out.println("Obrigado pela preferencia, volte sempre!");
                }else{
                    System.out.println("Pagamento não confirmado");
                }
            }else{
                System.out.println("Corrida cancelada");
            }
        }else{
            System.out.println("Falha ao concluir a corrida, zona inválida");
        }
    }
    private void valorCorrida(){
        valor= distancia*taxaKm;
    }
    private boolean validarPagamento(){
        if(form_pag.equals("Dinheiro") || form_pag.equals("dinheiro")){
            return true;
        }else if(form_pag.equals("Cartao") || form_pag.equals("cartao")){
            int cartao = 0;
            
            System.out.println("Qual cartao deseja utilizar ?\nEx:1,2,3,4...");
            cartao = scan.nextInt();
            
            if(passageiro.getCartoes()[cartao-1] != null){
                if(passageiro.getCartoes()[cartao-1].getSaldo() >= valor){
                    passageiro.pagar(valor, passageiro.getCartoes()[cartao-1]);
                    return true;  
                }else{
                    return false;
                }
            }else{
                System.out.println("Cartao nao cadastrado");
                return false;
            }
        }else if(form_pag.equals("Saldo") || form_pag.equals("saldo")){
            if(passageiro.getSaldo() >= valor){
                passageiro.pagarSaldo(valor);
                return true;
            }else{
                System.out.println("Saldo insuficiente");
                return false;
            }
        }else{
            return false;
        }
    }
    @Override
    public String toString(){
        return "\n------------------\n"
             + "motorista: " + motorista.getNome() + " " + motorista.getSobrenome() + "\n"
             + "Passageiro: " + passageiro.getNome() + " " + passageiro.getSobrenome() + "\n"
             + "Saida: " + saida + "\n"
             + "Destino: " + destino + "\n"
             + "Distancia: " + distancia + "\n"
             + "Avaliacao: " + avaliacao + "\n"
             + "Forma de pagamento: " + form_pag + "\n"
             + "Valor: R$" + df.format(valor) + "\n"
             + "Zona: " + zona;
    }
}