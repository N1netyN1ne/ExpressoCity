package sistema;

import java.util.ArrayList;
import servicos.Corrida;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Motorista extends Cliente{
    //Atributos
    Scanner scan = new Scanner(System.in);
    private long CNH;
    private String veiculo;
    private long renavam;
    private ArrayList<Double> avaliacoes = new ArrayList<Double>();
    private double nota;
    private long nViagens;
    private boolean online;
    
    //Construtores
    public Motorista(){}
    public Motorista(String nome, String sobrenome,long CNH, String veiculo, long renavam){
        super(nome, sobrenome);
        this.CNH = CNH;
        this.veiculo = veiculo;
        this.renavam = renavam;
    }
    public Motorista(String nome, String sobrenome, String telefone, long CNH, String veiculo, long renavam){
        super(nome, sobrenome, telefone);
        this.CNH = CNH;
        this.veiculo = veiculo;
        this.renavam = renavam;
    }
    public Motorista(String nome, String sobrenome, String telefone, long CNH, String veiculo, long renavam, String usuario, String senha) {
        super(nome, sobrenome, telefone, usuario, senha);
        this.CNH = CNH;
        this.veiculo = veiculo;
        this.renavam = renavam;
    }
    public Motorista(String nome, String sobrenome, long cpf, String telefone, long CNH, String veiculo, long renavam,String usuario, String senha) {
        super(nome, sobrenome, cpf, telefone, usuario, senha);
        this.CNH = CNH;
        this.veiculo = veiculo;
        this.renavam = renavam;
    }

    //Getters
    public long getCNH() {
        return CNH;
    }
    public String getVeiculo() {
        return veiculo;
    }
    public long getRenavam() {
        return renavam;
    }
    public ArrayList<Double> getAvaliacoes() {
        return avaliacoes;
    }
    public double getNota() {
        return nota;
    }
    public long getnViagens() {
        return nViagens;
    }
    public boolean getOnline() {
        return online;
    }

    //Setters
    public void setCNH(long CNH) {
        this.CNH = CNH;
        System.out.println("CNH cadastrada com sucesso");
    }
    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
        System.out.println("Veiculo cadastrado com sucesso");
    }
    public void setRenavam(long renavam) {
        this.renavam = renavam;
        System.out.println("Renavam cadastrado com sucesso");
    }
    public void setAvaliacoes(double avaliacao) {
        avaliacoes.add(avaliacao);
        double avaliacoesTotais=0;
        
        for(int i=0; i < avaliacoes.size(); i++){
            if(avaliacoes.get(i)!= null){
                avaliacoesTotais+=avaliacoes.get(i); 
            }
        }
        nota=(avaliacoesTotais/nViagens);
    }
    public void setnViagens() {
        this.nViagens+=1;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
    
    //Metodos
    public void online(){
        if(online == true){
            online = false;
            System.out.println("Voce esta offline");
        }else{
            online = true;
            System.out.println("Voce esta online");
        }
    }
    public void mostrarHistorico(){
        boolean corridaEncontrada = false;
        for(int i=0; i < Cadastro.getCorridas().size(); i++){
            if(Cadastro.getCorridas().get(i).getMotorista().getCpf() == Motorista.this.getCpf()){
                Corrida c = Cadastro.getCorridas().get(i);
                System.out.println(c);
                corridaEncontrada = true;
            }
        }if(corridaEncontrada == false)System.out.println("Voce nao possui corridas");
    }
    public boolean aceitarCorrida(String saida, String destino, double distancia, String form_pag){
        int resp=0;
        System.out.println("\nSaida: " + saida + "\n"
                         + "Destino: " + destino + "\n"
                         + "Distancia: " + distancia + "\n"
                         + "Forma de pagamento: " + form_pag);
        System.out.println("Deseja aceitar ?\n"
                + "1-Sim" + "\n"
                + "2-Nao");
        resp = scan.nextInt();
        if(resp == 1){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        return super.toString() + "\n"
                + "CNH: " + CNH + "\n"
                + "veiculo: " + veiculo + "\n"
                + "renavam: " + renavam + "\n"
                + "nota: " + df.format(nota) + "\n"
                + "Viagens: " + nViagens;
    }
}
