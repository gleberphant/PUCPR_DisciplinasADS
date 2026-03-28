# Sistema de Controle de Restaurante

Um restaurante contratou você para realizar a criação de um software de controle que deverá gerenciar todas as etapas e processos do estabelecimento. Este sistema deverá controlar a entrada/saída de visitantes, os clientes do restaurante, os salários dos cozinheiros e outros funcionários, o sistema financeiro e o estoque de comida. Além disso, também deverá prever a chegada de novos recursos que serão entregues pelos fornecedores. 

Com esta breve descrição do sistema, já conseguimos citar pelo menos alguns dos atores que o sistema possuirá.

Podemos dizer que teríamos os seguintes atores:

- Funcionário
- Visitante
- Cliente
- Fornecedor
- Cozinheiro

Agora a sua missão: descreva brevemente um caso de uso para cada ator.

Utilize o seguinte exemplo:

- Funcionário UC1 → Efetuar Login: O funcionário deve efetuar login no sistema para acessar as opções de gerar nota fiscal e cadastrar as vendas de almoços.

Tente evitar a descrição de casos de uso de formas repetida para os atores, expresse casos de uso que seriam exclusivos do ator informado.

# Casos de Uso

**Funcionário UC1** → Registrar Ponto: O funcionário utiliza o sistema para registrar o início e o fim de sua jornada de trabalho, garantindo o cálculo correto de seu salário e horas extras.

**Visitante UC2** → Agendar Visita: O visitante (ex: um profissional de manutenção ou um candidato a uma vaga) utiliza uma interface do sistema para agendar um horário de visita ao estabelecimento, que será aprovado por um funcionário.

**Cliente UC3** → Fazer Reserva de Mesa: O cliente acessa o sistema para verificar a disponibilidade e realizar a reserva de uma mesa para uma data e horário específicos, informando o número de pessoas.

**Fornecedor UC4** → Consultar Previsão de Pedidos: O fornecedor acessa o sistema para visualizar as previsões de compra de insumos do restaurante, permitindo um melhor planejamento de sua própria produção e logística de entrega.

**Cozinheiro UC5** → Dar Baixa em Ingredientes: Ao preparar um prato, o cozinheiro informa no sistema os ingredientes e as quantidades utilizadas, para que o controle de estoque seja atualizado em tempo real.