# VISÃO DO PROJETO
## **Autenticação Multifator**
Esta atividade consiste em explorar os principais fundamentos dos mecanismos de autenticação, que são os primeiros passos para uma autenticação multifator. O propósito desta atividade é apresentar as vantagens de utilizar uma autenticação multifator. Observar que é possível combinar diferentes técnicas de autenticação. Dessa forma, se o adversário (hacker) comprometer uma única técnica, ele não compromete todo o sistema de autenticação. Para que você compreenda a importância de combinar diferentes técnicas de autenticação reduzindo a probabilidade de o sistema ser comprometido, você será desafiado a implementar uma autenticação multifator para o banco de Tóquio. Nesta atividade, será implementado uma autenticação de dois fatores em Python, adicionando mais um nível de segurança no processo de autenticação do banco.
**Descrição da atividade:** Esta atividade será realizada em três etapas. A primeira etapa consiste em utilizar o mecanismo de autenticação do Firebase no Python. Na segunda etapa você deverá implementar em Python as rotinas para realizar envio de email realizando autenticação via Gmail, onde será utilizado o protocolo SMTP. A terceira etapa propõe um desafio, implementar uma autenticação multifator para o banco de Tóquio. Para alcançar este objetivo você deverá integrar os conhecimentos das etapas 1  e 2.
**Especificação Etapa 1 –** Firebase: O Firebase é uma plataforma de desenvolvimento Web que possui diversos recursos, em específico vamos utilizar o mecanismo de autenticação, este será integrado com o Python. Para orientar você nesta jornada esta sendo fornecido o “Roteiro de Atividade Prática 1” e o código em Python “firebase.txt”.
**Especificação Etapa 2 –** Autenticação Gmail: Esta atividade consiste em demostrar como é possível enviar email em Python utilizando a autenticação do Gmail, iremos utilizar o protocolo SMTP. A proposta desta atividade é fornecer base para implementação de um segundo fator de autenticação, atividade que será desenvolvida na etapa 3.  Para orientar você na segunda etapa está sendo fornecido o “Roteiro de Atividade Prática 2” e o código em Python “email.txt”.
**Especificação Etapa 3 -** Desafio Autenticação Multifator para o banco de Tóquio: Esta atividade consiste em propor um mecanismo de autenticação multifator baseado nos conhecimentos adquiridos na prática 1 e prática 2. 

## REQUISITOS FUNCIONAIS
Você deve implementar um programa em Python que deve conter as seguintes funcionalidades:
- Criar um menu para interagir com o usuário - (cadastrar e-mail, enviar confirmação e-mail e - autenticar email);
- Cadastrar o usuário no Firebase;
- Autenticar o usuário no Firebase;
- Antes de autenticar o usuário deve estar com o - e-mail obrigatoriamente verificado;
- Caso o email não esteja verificado não realizar - a autenticação;
- Quando o email já estiver verificado, autenticar - o usuário no Firebase;
- Após autenticar no Firebase vamos criar uma - segunda autenticação;
- Gerar um número aleatório em Python;
- Não mostrar o número aleatório gerado no Python;
- Este número deverá ser enviado por email, - utilizando o SMTP;
- Efetuar a leitura de um número do teclado;
- O usuário deve fornecer como entrada o número - que foi enviado por e-mail;
- Verificar se o número fornecido pelo usuário é - igual ao número  que foi gerado aleatoriamente;
- Quando o número for igual apresentar uma - mensagem que o usuário foi autenticado.
- Entregar a resolução em .txt. Após ser lançado o - status “Concluído” você terá acesso ao gabarito - com uma das possíveis soluções.