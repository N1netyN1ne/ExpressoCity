# Expresso City – Aplicativo de Corridas (Console em Java)

Este projeto é um **simulador de aplicativo de corridas estilo Uber/99**, implementado em **Java** para execução em **console**.  
Ele permite o cadastro e login de **passageiros** e **motoristas**, realização de corridas, histórico, gerenciamento de endereços, cartões e saldo.

---

## 🧰 Funcionalidades

### Para Passageiro

- Cadastro de passageiro com:
  - Nome, sobrenome, telefone, CPF, usuário e senha.
- Login de passageiro.
- Realização de corridas:
  - Escolha de endereço de saída:
    - Endereço de casa
    - Endereço de trabalho
    - Endereços salvos
    - Outro endereço informado na hora
  - Definição de destino
  - Distância do trajeto
  - Zona de destino (Norte, Sul, Leste, Oeste, Centro)
  - Forma de pagamento:
    - Dinheiro
    - Cartão
    - Saldo em conta
  - Somente motoristas **online** podem aceitar corridas.
- Perfil do passageiro:
  - Atualizar:
    - Nome
    - Sobrenome
    - Telefone
    - Endereço de casa
    - Endereço de trabalho
    - Endereços salvos (adicionar, remover, alterar)
  - Gerenciar cartões:
    - Cadastrar cartão (até 10)
    - Remover cartão
    - Listar cartões cadastrados
  - Informações da conta:
    - Dados pessoais
    - Saldo
    - Endereços
  - Adicionar dinheiro à conta
  - Histórico de corridas

### Para Motorista

- Cadastro de motorista com:
  - Nome, sobrenome, telefone, CPF, CNH, veículo, Renavam, usuário e senha.
- Login de motorista.
- Status Online/Offline:
  - Apenas motoristas online recebem solicitações de corrida.
- Aceitar ou recusar corridas:
  - Visualiza: saída, destino, distância e forma de pagamento.
- Perfil do motorista:
  - Atualizar:
    - Nome
    - Sobrenome
    - Telefone
    - Veículo
    - Renavam
  - Ver histórico de corridas
  - Ver informações da conta:
    - Dados pessoais
    - Nota média e número de viagens

### Corridas & Pagamentos

- Cálculo do valor da corrida baseado em:
  - Distância (em km)
  - Zona de destino:
    - Norte: R$ 2,80/km  
    - Sul: R$ 3,20/km  
    - Oeste: R$ 2,50/km  
    - Leste: R$ 3,50/km  
    - Centro: R$ 4,00/km
- Métodos de pagamento:
  - **Dinheiro**: aceito diretamente
  - **Cartão**:
    - Escolha de cartão cadastrado
    - Validação de saldo disponível
  - **Saldo em conta do passageiro**:
    - Validação de saldo
- Avaliação do motorista de 1 a 5 estrelas ao final da corrida.
- Atualização de:
  - Saldo do motorista
  - Número de viagens
  - Nota média do motorista

---

## 🗂 Estrutura do Projeto

```text
src/
├─ aplicativo/
│  └─ Main.java          # Ponto de entrada do sistema (menus e fluxo principal)
├─ sistema/
│  ├─ Cliente.java       # Classe abstrata base para Passageiro e Motorista
│  ├─ Motorista.java     # Dados e comportamento do motorista
│  ├─ Passageiro.java    # Dados e comportamento do passageiro
│  ├─ Cartao.java        # Representa um cartão de crédito/débito
│  └─ Cadastro.java      # Cadastro e login de usuários, listas globais
└─ servicos/
   └─ Corrida.java       # Lógica de corridas, pagamento e avaliação
