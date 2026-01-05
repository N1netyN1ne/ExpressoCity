package sistema;

import java.util.Scanner;
import java.util.ArrayList;
import servicos.Corrida;

public abstract class Cadastro {
    //Atributos
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Motorista> motoristas = new ArrayList<Motorista>();
    private static ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
    private static ArrayList<Corrida> corridas = new ArrayList<Corrida>();
    private static int motoristasCadastrados = motoristas.size();
    private static int passageirosCadastrados = passageiros.size();
    
    //Getters
    public static Scanner getScan() {
        return scan;
    }
    public static ArrayList<Motorista> getMotoristas() {
        return motoristas;
    }
    public static ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }
    public static ArrayList<Corrida> getCorridas() {
        return corridas;
    }
    public static int getMotoristasCadastrados() {
        return motoristasCadastrados;
    }
    public static int getPassageirosCadastrados() {
        return passageirosCadastrados;
    }
    
    //Setters
    public static void setScan(Scanner scan) {
        Cadastro.scan = scan;
    }
    public static void setMotoristas(ArrayList<Motorista> motoristas) {
        Cadastro.motoristas = motoristas;
    }
    public static void setPassageiros(ArrayList<Passageiro> passageiros) {
        Cadastro.passageiros = passageiros;
    }
    public static void setCorridas(ArrayList<Corrida> corridas) {
        Cadastro.corridas = corridas;
    }
    
    //Metodos
    public static boolean cadastrarMotorista(){
            boolean aprovado=true;
            System.out.println("\nQual seu nome ?");
            String nome = scan.nextLine();
            
            System.out.println("Qual seu sobrenome ?");
            String sobrenome = scan.nextLine();
            
            System.out.println("Qual seu telefone ?");
            String telefone = scan.nextLine();
            
            long CPF;
            do{
                System.out.println("Qual seu CPF ?");
                CPF=scan.nextLong();
                for(int i=0; i < Cadastro.getMotoristas().size(); i++){
                    if(CPF == Cadastro.getMotoristas().get(i).getCpf()){
                        System.out.println("CPF ja cadastrado, tente novamente");
                        aprovado=false;
                        break;
                    }else{
                        aprovado=true;
                    }
                }
            }while(!aprovado);
            
            System.out.println("Numero da CNH");
            long CNH = scan.nextLong();
            scan.nextLine();
            
            System.out.println("Qual o modelo do veiculo ?");
            String veiculo = scan.nextLine();
            
            System.out.println("Renavam ?");
            long renavam = scan.nextLong();
            scan.nextLine();
            
            String usuario;
            do{
                System.out.println("\nCadastro quase pronto\nDefina um usuario");
                usuario = scan.nextLine();
                for(int i=0; i < Cadastro.getMotoristas().size(); i++){
                    if(usuario.equals(Cadastro.getMotoristas().get(i).getUsuario())){
                        System.out.println("Usuario ja cadastrado, tente novamente");
                        aprovado=false;
                        break;
                    }else{
                        aprovado=true;
                    }
                }
            }while(!aprovado);
            
            System.out.println("Defina uma senha");
            String senha = scan.nextLine();
            
            motoristas.add(new Motorista(nome,sobrenome,CPF,telefone,CNH,veiculo,renavam,usuario,senha));
            return true;
    }
    public static boolean cadastrarPassageiro(){
            boolean aprovado=true;
            System.out.println("\nQual seu nome ?");
            String nome = scan.nextLine();
            
            System.out.println("Qual seu sobrenome ?");
            String sobrenome = scan.nextLine();
            
            System.out.println("Qual seu telefone ?");
            String telefone = scan.nextLine();

            long CPF;
            do{
                System.out.println("Qual seu CPF ?");
                CPF=scan.nextLong();
                for(int i=0; i < Cadastro.getPassageiros().size(); i++){
                    if(CPF == Cadastro.getPassageiros().get(i).getCpf()){
                        System.out.println("CPF ja cadastrado, tente novamente");
                        aprovado=false;
                        break;
                    }else{
                        aprovado=true;
                    }
                }   
            }while(!aprovado);
            scan.nextLine();
            
            String usuario;
            do{
                System.out.println("\nCadastro quase pronto\nDefina um usuario");
                usuario = scan.nextLine();
                for(int i=0; i < Cadastro.getPassageiros().size(); i++){
                    if(usuario.equals(Cadastro.getPassageiros().get(i).getUsuario())){
                        System.out.println("Usuario ja cadastrado, tente novamente");
                        aprovado=false;
                        break;
                    }else{
                        aprovado=true;
                    }
                }
            }while(!aprovado);
            System.out.println("Defina uma senha");
            String senha = scan.nextLine();
            
            passageiros.add(new Passageiro(nome,sobrenome,telefone,CPF,usuario,senha));
            return true;
       
    }
    public static Motorista loginMotorista(String usuario, String senha){
        for(int i=0; i < motoristas.size(); i++){
            if((motoristas.get(i)!= null) && (usuario.equals(motoristas.get(i).getUsuario()) && senha.equals(motoristas.get(i).getSenha()))){
                System.out.println("Login feito com sucesso");
                return motoristas.get(i);
            }
        }
        return null;   
    }
    public static Passageiro loginPassageiro(String usuario, String senha){
        for(int i=0; i < passageiros.size(); i++){
            if((passageiros.get(i)!= null) && (usuario.equals(passageiros.get(i).getUsuario()) && senha.equals(passageiros.get(i).getSenha()))){
                System.out.println("Login feito com sucesso");
                return passageiros.get(i);
            }
        }
        return null;
    }
}
