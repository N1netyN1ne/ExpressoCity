package aplicativo;
import sistema.Motorista;
import sistema.Passageiro;
import sistema.Cadastro;
import servicos.Corrida;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int op=0,op7;
        boolean successfullLogin = false; 
        do{
            System.out.println("\nBem-vindo a Expresso City\n\n1-Cadastrar\n2-Logar\n3-Sair");
            op = scan.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("\nVoce e\n1-Passageiro\n2-Motorista\n3-Voltar");
                    int op6=scan.nextInt();
                    switch(op6){
                        case 1:
                            if(Cadastro.cadastrarPassageiro()){
                                System.out.println("\nCadastro concluido com sucesso");
                            }else{
                                System.out.println("\nFalha ao realizar o cadastro");
                            }
                            break;
                        case 2:
                            if(Cadastro.cadastrarMotorista()){
                                System.out.println("\nCadastro concluido com sucesso");
                            }else{
                                System.out.println("\nFalha ao realizar o cadastro");
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao invalida");
                    }
                    break;
                case 2:
                    System.out.println("\n1-Logar como Passageiro\n2-Logar como Motorista\n3-Voltar");
                    int op5=scan.nextInt();
                    switch(op5){
                        case 1:{
                            scan.nextLine();
                            System.out.println("\nDigite seu usuario: ");
                            String usuario = scan.nextLine();
                            
                            System.out.println("Digite sua senha");
                            String senha = scan.nextLine();
                            
                            Passageiro sessao = Cadastro.loginPassageiro(usuario, senha);
                            if(sessao != null){
                               successfullLogin = true; 
                            }else{
                                System.out.println("Falha ao logar");
                            }
                            while(successfullLogin == true){
                                System.out.println("\nBem-vindo " + sessao.getNome() + "\n"
                                        + "1-Fazer uma corrida\n"
                                        + "2-Perfil");
                                op7=scan.nextInt();
                                switch(op7){
                                    case 1:
                                        if(Cadastro.getMotoristas().size() != 0){
                                            for(int i=0; i < Cadastro.getMotoristas().size(); i++){
                                                if((Cadastro.getMotoristas().get(i)!=null) && (Cadastro.getMotoristas().get(i).getOnline() == true)){
                                                    scan.nextLine();
                                                    String saida=null;
                                                    do{
                                                        System.out.println("\nQual o endereco de saida ?\n"
                                                                + "1-Endereco Casa\n"
                                                                + "2-Endereco Trabalho\n"
                                                                + "3-Endereco Salvo\n"
                                                                + "4-Outro endereco");
                                                        int op2 = scan.nextInt();
                                                        scan.nextLine();
                                                        switch(op2){
                                                        case 1:
                                                            if(sessao.getEnderecoCasa()!= null){
                                                                saida = sessao.getEnderecoCasa();
                                                            }else{
                                                                System.out.println("Endereco Casa nao cadastrado!");
                                                            }
                                                            break;
                                                        case 2:
                                                            if(sessao.getEnderecoTrabalho()!=null){
                                                                saida = sessao.getEnderecoTrabalho();
                                                            }else{
                                                                System.out.println("Endereco Trabalho nao cadastrado!");
                                                            }
                                                            break;
                                                        case 3:
                                                            if(sessao.mostrarEnderecosSalvos()){
                                                                boolean enderecoValido = false;
                                                                do {
                                                                    System.out.println("\nQual endereço deseja usar ?");
                                                                    int end = scan.nextInt();

                                                                    if(end >= 1 && end <= sessao.getEnderecoSalvo().length){
                                                                        enderecoValido = true;
                                                                        saida = sessao.getEnderecoSalvo()[end - 1];
                                                                    }else{
                                                                        System.out.println("Endereço inválido. Por favor, tente novamente.");
                                                                    }
                                                                } while (!enderecoValido);
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("\nQual o endereco de saida ?");
                                                            saida=scan.nextLine();
                                                            break;
                                                        default:
                                                            System.out.println("Opcao invalida!");
                                                        }
                                                    }while(saida == null);

                                                    System.out.println("Qual o endereco de destino ?");
                                                    String destino = scan.nextLine();

                                                    System.out.println("Qual a distancia do trajeto ?");
                                                    double distancia = scan.nextDouble();
                                                    scan.nextLine();

                                                    System.out.println("Qual a zona de destino ?\n"
                                                            + "Ex: Norte, Sul, Leste, Oeste, Centro");
                                                    String zona = scan.nextLine();

                                                    System.out.println("Qual a forma de pagamento ?\n"
                                                            + "Ex dinheiro, cartao, saldo");
                                                    String form_pag = scan.nextLine();

                                                    if(Cadastro.getMotoristas().get(i).aceitarCorrida(saida, destino, distancia, form_pag)){
                                                        Cadastro.getCorridas().add(new Corrida(Cadastro.getMotoristas().get(i),sessao,saida,destino,distancia,form_pag,zona));
                                                        Cadastro.getCorridas().get(Cadastro.getCorridas().size()-1).corrida();
                                                        break;
                                                    }else{
                                                        System.out.println("\nCorrida recusada");
                                                    }
                                                }else{
                                                    System.out.println("Sem motoristas disponiveis no momento");
                                                }
                                            }
                                        }else{
                                           System.out.println("Sem motoristas disponiveis no momento"); 
                                        }
                                        break;
                                    case 2:
                                        int opcao=0;
                                        System.out.println("\n"
                                                + "1-Atualizar informacoes\n"
                                                + "2-Cadastrar cartao\n"
                                                + "3-Remover Cartao\n"
                                                + "4-Informacaoes da conta\n"
                                                + "5-Adicionar dinheiro a conta\n"
                                                + "6-Historico de corridas\n"
                                                + "7-voltar\n"
                                                + "8-Sair da conta\n");
                                        opcao=scan.nextInt();
                                        switch(opcao){
                                            case 1:
                                                int opcao2=0;
                                                System.out.println("\n"
                                                        + "1-Nome\n"
                                                        + "2-Sobrenome\n"
                                                        + "3-Telefone\n"
                                                        + "4-Endereco Casa\n"
                                                        + "5-Endereco Trabalho\n"
                                                        + "6-Enderecos salvos\n"
                                                        + "7-Voltar");
                                                opcao2 = scan.nextInt();
                                                switch(opcao2){
                                                    case 1:
                                                        scan.nextLine();
                                                        System.out.println("\nNovo nome: ");
                                                        sessao.setNome(scan.nextLine());
                                                        break;
                                                    case 2:
                                                        scan.nextLine();
                                                        System.out.println("\nNovo sobrenome: ");
                                                        sessao.setSobrenome(scan.nextLine());
                                                        break;
                                                    case 3:
                                                        scan.nextLine();
                                                        System.out.println("\nNovo telefone: ");
                                                        sessao.setTelefone(scan.nextLine());
                                                        break;
                                                    case 4:
                                                        scan.nextLine();
                                                        System.out.println("\nEndereco de Casa: ");
                                                        sessao.setEnderecoCasa(scan.nextLine());
                                                        break;
                                                    case 5:
                                                        scan.nextLine();
                                                        System.out.println("\nEndereco de Trabalho: ");
                                                        sessao.setEnderecoTrabalho(scan.nextLine());
                                                        break;
                                                    case 6:
                                                        scan.nextLine();
                                                        System.out.println("\n"
                                                                + "1-Adicionar endereco novo\n"
                                                                + "2-Remover endereco\n"
                                                                + "3-Alterar endereco");
                                                        int opcao3=scan.nextInt();
                                                        switch(opcao3){
                                                            case 1:
                                                                sessao.cadastrarEndereco();
                                                                break;
                                                            case 2:
                                                                sessao.removerEndereco();
                                                                break;
                                                            case 3:
                                                                sessao.alterarEndereco();
                                                                break;
                                                            default:
                                                                System.out.println("\nOpcao invalida!");
                                                        }
                                                        break;
                                                    case 7:
                                                        break;
                                                    default:
                                                        System.out.println("\nOpcao invalida");
                                                }
                                                break;
                                            case 2:
                                                sessao.cadastrarCartao();
                                                break;
                                            case 3:
                                                sessao.removerCartao();
                                                break;
                                            case 4:
                                                sessao.imprimirDados();
                                                sessao.mostrarEnderecosSalvos();
                                                sessao.mostrarCartoes();
                                                break;
                                            case 5:
                                                sessao.adicionarDinheiro();
                                                break;
                                            case 6:
                                                sessao.mostrarHistorico();
                                                break;
                                            case 7:
                                                break;
                                            case 8:
                                                successfullLogin = false;
                                            default:
                                                System.out.println("\nOpcao invalida");
                                        }
                                        break;
                                    default:
                                        System.out.println("\nOpcao invalida!");
                                }
                            }
                            break;}
                        case 2:{
                            scan.nextLine();
                            System.out.println("\nDigite seu usuario: ");
                            String usuario = scan.nextLine();
                            
                            System.out.println("Digite sua senha");
                            String senha = scan.nextLine();
                            
                            Motorista sessao = Cadastro.loginMotorista(usuario, senha);
                            if(sessao != null){
                                successfullLogin = true;
                            }else{
                                System.out.println("Falha ao logar");
                            }
                            while(successfullLogin == true){
                                System.out.println("\nBem-vindo " + sessao.getNome() + "\n"
                                        + "1-Ficar Online\n"
                                        + "2-Perfil\n");
                                int op2 = scan.nextInt();
                                
                                switch(op2){
                                    case 1:
                                        sessao.online();
                                        break;
                                    case 2:
                                        System.out.println("\n"
                                                + "1-Atualizar informacoes\n"
                                                + "2-Historico de corridas\n"
                                                + "3-Informacoes da conta\n"
                                                + "4-Voltar\n"
                                                + "5-Sair da conta");
                                        int op3 = scan.nextInt();
                                        switch(op3){
                                            case 1:
                                                System.out.println("\n"
                                                        + "1-Nome\n"
                                                        + "2-Sobrenome\n"
                                                        + "3-Telefone\n"
                                                        + "4-Veiculo\n"
                                                        + "5-Renavam\n"
                                                        + "6-Voltar");
                                                int op4 = scan.nextInt();
                                                switch(op4){
                                                    case 1:
                                                        scan.nextLine();
                                                        System.out.println("\nNovo nome: ");
                                                        if(sessao.setNome(scan.nextLine())){
                                                            System.out.println("Nome alterado com sucesso");
                                                        }
                                                        break;
                                                    case 2:
                                                        scan.nextLine();
                                                        System.out.println("\nNovo sobrenome: ");
                                                        if(sessao.setSobrenome(scan.nextLine())){
                                                            System.out.println("Sobrenome alterado com sucesso");
                                                        }
                                                        break;
                                                    case 3:
                                                        scan.nextLine();
                                                        System.out.println("\nNovo telefone: ");
                                                        if(sessao.setTelefone(scan.nextLine())){
                                                            System.out.println("Telefone alterado com sucesso");
                                                        }
                                                        break;
                                                    case 4:
                                                        scan.nextLine();
                                                        System.out.println("\nNovo veiculo: ");
                                                        sessao.setVeiculo(scan.nextLine());
                                                        break;
                                                    case 5:
                                                        scan.nextLine();
                                                        System.out.println("\nNovo renavam: ");
                                                        sessao.setRenavam(scan.nextInt());
                                                        break;
                                                    case 6:
                                                        break;
                                                    default:
                                                        System.out.println("\nOpcao invalida");
                                                }
                                                break;
                                            case 2:
                                                sessao.mostrarHistorico();
                                                break;
                                            case 3:
                                                System.out.println(sessao.toString());
                                                break;
                                            case 4:
                                                break;
                                            case 5:
                                                successfullLogin = false;
                                                break;
                                            default:
                                                System.out.println("\nOpcao invalida!");
                                        }
                                        break;
                                    default:
                                        System.out.println("\nOpcao invalida!");
                                }
                            }
                        break;}
                        case 3:
                            break;
                        default:
                            System.out.println("\nOpcao Inválida");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\nOpcao invalida!");
            }
        }while(op < 3);
        scan.close();
    }
}