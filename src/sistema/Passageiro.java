package sistema;

import java.util.Scanner;
import servicos.Corrida;

public class Passageiro extends Cliente {
    //Atributos
    private String enderecoCasa;
    private String enderecoTrabalho;
    private String enderecoSalvo[]= new String[10];
    private Cartao cartoes[] = new Cartao[10];
    private int cartoesCadastrados;
    private Scanner scan = new Scanner(System.in);
    
    //Construtores
    public Passageiro(){}
    public Passageiro(String nome, String sobrenome){
        super(nome, sobrenome);
    }
    public Passageiro(String nome, String sobrenome, String telefone, long cpf, String usuario, String senha) {
        super(nome, sobrenome, cpf, telefone, usuario, senha);
    }
    public Passageiro(String nome, String sobrenome, String enderecoCasa){
        super(nome, sobrenome);
        this.enderecoCasa = enderecoCasa;
    }
    public Passageiro(String nome, String sobrenome, String telefone, String enderecoCasa){
        super(nome, sobrenome, telefone);
        this.enderecoCasa = enderecoCasa;
    }   
    public Passageiro(String nome, String sobrenome, String telefone, String enderecoCasa, String enderecoTrabalho){
        super(nome, sobrenome,telefone);
        this.enderecoCasa = enderecoCasa;
        this.enderecoTrabalho = enderecoTrabalho;
    }

    //Getters
    public String getEnderecoCasa() {
        return enderecoCasa;
    }
    public String getEnderecoTrabalho() {
        return enderecoTrabalho;
    }
    public String[] getEnderecoSalvo() {
        return enderecoSalvo;
    }
    public Cartao[] getCartoes() {
        return cartoes;
    }
    public int getCartoesCadastrados() {
        return cartoesCadastrados;
    }
    
    //Setters
    public void setEnderecoCasa(String enderecoCasa) {
        this.enderecoCasa = enderecoCasa;
        System.out.println("Endereco cadastrado com sucesso");
    }
    public void setEnderecoTrabalho(String enderecoTrabalho) {
        this.enderecoTrabalho = enderecoTrabalho;
        System.out.println("Endereco cadastrado com sucesso");
    }
    public void setEnderecoSalvo(String[] enderecoSalvo) {
        this.enderecoSalvo = enderecoSalvo;
    }
    public void setCartoes(Cartao[] cartoes) {
        this.cartoes = cartoes;
    }
    public void setCartoesCadastrados(int cartoesCadastrados) {
        this.cartoesCadastrados = cartoesCadastrados;
    }
    
    //Metodos
    public void cadastrarCartao(){
        System.out.println("\nN do cartao: ");
        int num = scan.nextInt();
        scan.nextLine();
        
        System.out.println("Nome do titular: ");
        String titular = scan.nextLine();
        
        System.out.println("CVV: ");
        int cvv = scan.nextInt();
        scan.nextLine();
        
        System.out.println("Vencimento: ");
        String vencimento = scan.nextLine();
        
        System.out.println("Saldo: ");
        double saldo = scan.nextDouble();
        
        if(cartoesCadastrados < 10){
            cartoes[cartoesCadastrados] = new Cartao(num,titular,cvv,vencimento, saldo);
            cartoesCadastrados++;
            if(cartoesCadastrados > 9){
                cartoesCadastrados = 9;
            }
            System.out.println("Cartao cadastrado com sucesso");
        }else{
            System.out.println("Maximo de cartoes atingidos");
        }
    }
    public void removerCartao(){
        for(int i=0; i < cartoesCadastrados; i++){
            if(cartoes[i]!= null){
                System.out.println("\nCartao " + (i+1)+"\n"
                        + "Titular: " + cartoes[i].getTitular() +"\n"
                        + "Numero: " + cartoes[i].getNum() + "\n"
                        + "CVV: " + cartoes[i].getCvv() + "\n"
                        + "Vencimento: " + cartoes[i].getVencimento() + "\n"
                         + "Saldo: " + cartoes[i].getSaldo());
            }
        }
       System.out.println("\nQual cartao deseja remover ?");
        int n = scan.nextInt();
        
        for(int i=n-1; i < cartoes.length-1; i++){
            cartoes[i]=cartoes[i+1];
        }
        cartoes[cartoes.length-1]=null;
        System.out.println("\nCartao removido com sucesso");
    }
    public void pagar(double valor, Cartao cartao){
        cartao.pagar(valor);
    }
    public void cadastrarEndereco(){
        for(int i=0; i < enderecoSalvo.length; i++){
            if(enderecoSalvo[i] == null){
                System.out.println("Digite o endereco: ");
                enderecoSalvo[i]=scan.nextLine();
                break;
            }
        }
        System.out.println("Endereco cadastrado com sucesso!");
    }
    public void removerEndereco(){
        System.out.println("\nQual endereco deseja remover ?");
        for(int i=0; i < enderecoSalvo.length; i++){
            if(enderecoSalvo[i]!=null){
                System.out.println((i+1) + " " + enderecoSalvo[i] + "\n");
            }
        }
        int op = scan.nextInt();
        
        for(int i=op-1; i < enderecoSalvo.length-1; i++){
            enderecoSalvo[i] = enderecoSalvo[i+1];
        }
        enderecoSalvo[enderecoSalvo.length-1]=null;
        System.out.println("\nEndereco removido com sucesso!");
    }
    public void alterarEndereco(){
        for(int i=0; i < enderecoSalvo.length; i++){
            if(enderecoSalvo[i]!=null){
                System.out.println("\n" + (i+1) + " " + enderecoSalvo[i]);
            }
        }
        System.out.println("\nQual endereco deseja alterar ?");
        int op = scan.nextInt();
        scan.nextLine();
        System.out.println("\nNovo endereco: ");
        enderecoSalvo[op-1]=scan.nextLine();
        System.out.println("Endereco alterado com sucesso");
    }
    public void imprimirDados() {
        System.out.println(super.toString());
        if(enderecoCasa != null){
            System.out.println("Endereco Casa: " + enderecoCasa);
        }else{
            System.out.println("Endereco Casa: Vazio");
        }
        if(enderecoTrabalho != null){
            System.out.println("Endereco Trabalho: " + enderecoTrabalho);
        }else{
            System.out.println("Endereco Casa: Vazio");
        }
    }
    public boolean mostrarEnderecosSalvos() {
        boolean enderecoEncontrado = false;
        for(int i = 0; i < enderecoSalvo.length; i++){
            if(enderecoSalvo[i] != null){
                System.out.println("Endereco " + (i + 1) + ": " + enderecoSalvo[i]);
                enderecoEncontrado = true;
            }
        }
        if(enderecoEncontrado){
            return true;
        }else{
            System.out.println("Nao ha enderecos salvos");
            return false;
        }
    }
    public void mostrarCartoes(){
        boolean encontrado = false;
        for(int i=0; i < cartoes.length; i++){
            if(cartoes[i]!=null){
                System.out.println("\nCartao " + (i+1) + "\n"
                        +"Titular: "+ cartoes[i].getTitular() + "\n"
                        +"Numero: "+ cartoes[i].getNum() + "\n"
                        +"CVV: "+ cartoes[i].getCvv() + "\n"
                        +"Vencimento: "+ cartoes[i].getVencimento() + "\n"
                        +"Saldo: R$"+ cartoes[i].getSaldo());
                encontrado=true;
            }
        }
        if(!encontrado){
            System.out.println("Nao ha cartoes cadastrados");
        }
    }
    public void adicionarDinheiro(){
        System.out.println("Quanto deseja adicionar ?\n");
        this.setSaldo(scan.nextDouble());
        System.out.println("Valor adicionado com sucesso!");
    }
    public void mostrarHistorico(){
        boolean corridaEncontrada=false;
        for(int i=0; i < Cadastro.getCorridas().size(); i++){
            if(Cadastro.getCorridas().get(i).getPassageiro().getCpf() == Passageiro.this.getCpf()){
                Corrida c = Cadastro.getCorridas().get(i);
                System.out.println(c);
                corridaEncontrada=true;
            }
        }if(corridaEncontrada==false)System.out.println("Voce nao possui corridas");
    }
}