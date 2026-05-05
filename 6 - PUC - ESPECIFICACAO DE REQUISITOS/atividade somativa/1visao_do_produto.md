# DESCRIÇÃO GERAL DO SISTEMA

novo sistema de matrícula *on-line* para a universidade. O sistema deverá apresentar três áreas:

1. **Uma área pública**, com duas etapas, acessível sem a necessidade de *login*, em que qualquer pessoa pode realizar um cadastro básico com seus dados pessoais e criar o seu *login* com senha. Esse cadastro básico é necessário como etapa 1, antes da geração da matrícula, que será a etapa 2, ao qual a pessoa selecionará o curso que deseja fazer, incluindo informações como o nome do curso, o valor, a carga horária, a grade curricular, entre outras. Essa estrutura permite a esse cadastro básico ser utilizado para diversas matrículas.
2. **Uma área restrita para estudantes**, acessível mediante *login*, em que eles podem tanto fazer uma nova matrícula quanto verificar suas matrículas existentes, realizar pagamentos via PIX ou cartão de crédito, acompanhar o *status* do pagamento e consultar informações sobre o curso, como data de início, documentos necessários, entre outras. Caso o estudante inicie o processo de matrícula, mas o pagamento via PIX não seja concluído ou o cartão de crédito não seja aprovado, ele poderá refazer a matrícula utilizando o mesmo cadastro já existente.
3. **Uma área restrita administrativa destinada aos colaboradores da universidade**, responsáveis pela gestão das matrículas. Quando uma matrícula estiver em conformidade, o colaborador pode marcar um *checkbox* (caixinha de seleção) ao lado da matrícula e, em seguida, clicar no botão "Confirmar". É possível selecionar e confirmar várias matrículas de uma só vez. Após a confirmação, o sistema realiza a integração dessa matrícula tanto com o sistema acadêmico – para gerar a sala de aula do estudante e outros itens relacionados – quanto com o sistema financeiro – para confirmar o pagamento e gerar o contrato financeiro com as parcelas do curso.

Esse sistema precisa funcionar 24 horas por dia, tanto na *web* quanto em dispositivos móveis. A expectativa é melhorar a experiência dos novos usuários, com um processo mais rápido, simples e intuitivo, como manter o histórico de matrículas e pagamentos. Esse desenvolvimento acontecerá em decorrência de vários relatos relacionados ao sistema anterior, que era complexo e apresentava lentidão em momentos críticos, como em vestibulares. A ideia, aqui, é implementar esse novo sistema até novembro, ou seja, temos alguns meses pela frente.



# REQUISITOS

## Requisitos funcionais

|COD|ATOR|REQUISITO|REGRAS E CRITÉRIOS|DATA CRIAÇÃO/ATUALIZAÇÃO|SITUAÇÃO|
|-|-|-|-|-|-|
|RF-01|qualquer pessoa|acessar área pública|área acessível sem a necessidade de cadastro ou login|criado em 20.04.26|em aberto|
|RF-02|qualquer pessoa|realizar cadastro|qualquer pessoa pode realizar um cadastro básico com seus dados pessoais e criar o seu login com senha|criado em 20.04.26|em aberto|
|RF-03|qualquer pessoa|pesquisar cursos|poderá pesquisar qualquer curso disponível|criado em 20.04.26|em aberto|
|RF-04|qualquer pessoa|visualizar cursos|visualizar detalhes como o nome do curso, o valor, a carga horária, a grade curricular, entre outras.|criado em 20.04.26|em aberto|
|RF-05|estudante|fazer login em  área restrita aos estudantes|área acessível somente após cadastrado conforme RF-02|criado em 20.04.26|em aberto|
|RF-05-Rev-1|estudante|solicitar anonimização dos dados|o estudante que cancelar ou não estiver com uma matrícula efetuada (apenas fez o cadastro e não pagou), poderá pedir a anonimização dos seus dados pela sua área restrita com login.  O sistema precisa pegar seus dados pessoais e embaralhar os caracteres ou, ainda, fazer algo que não identifique mais o estudante – para cumprir a lei da LGPD.|atualizado em 21.04.26|em aberto|
|RF-06|estudante|fazer uma nova matrícula||criado em 20.04.26|em aberto|
|RF-06-Rev-1|estudante|fazer matrícula somente dentro de uma data estipulada|\*O estudante somente poderá efetuar a matrícula e pagá-la dentro da data estipulada, conforme RF-15-Rev-1. <br />\*Caso ultrapasse, ele poderá entrar no sistema somente para conferir seus dados|atualizado em 21.04.26|em aberto|
|RF-07|estudante|listar suas matrículas|listar todas às suas matrículas iniciadas , inclusive as canceladas, com opções para filtrar a listagem por situação, data etc.|criado em 20.04.26|em aberto|
|RF-08|estudante|cancelar uma matrícula||criado em 20.04.26|em aberto|
|RF-08-Rev1|estudante|cancelar uma matrícula|caso o estudante tenha efetuado a matrícula, ele poderá cancelá-la, após encerrar o prazo final (de acordo com a mudança 1), dentro de até 7 dias, o que lhe dá o direito de ressarcimento dos valores pagos. Se pagou no *pix*, receberá o valor em conta, mas, se pagou no cartão, receberá um crédito no cartão para abater o valor pago. \*(atualizado em 20.04.26)|atualizado em 21.04.26|em aberto|
|RF-09|estudante|pagar matrícula via PIX||criado em 20.04.26|em aberto|
|RF-10|estudante|pagar matrícula via CARTÃO DE CRÉDITO||criado em 20.04.26|em aberto|
|RF-11|estudante|acompanhar status de pagamento||criado em 20.04.26|em aberto|
|RF-12|estudante|consultar informações sobre curso||criado em 20.04.26|em aberto|
|||||||
|RF-13|estudante|refazer matrícula quando processo não for concluído|Caso o estudante inicie o processo de matrícula, mas o pagamento via PIX não seja concluído ou o cartão de crédito não seja aprovado, ele poderá refazer a matrícula utilizando o mesmo cadastro já existente.<br />|criado em 20.04.26|em aberto|
|RF-14|colaborador|fazer login em área restrita aos colaboradores|área acessível somente após cadastrado conforme RF-19|criado em 20.04.26|em aberto|
|RF-15|colaborador|confirmar uma matrícula|É possível selecionar e confirmar várias matrículas de uma só vez.|criado em 20.04.26|em aberto|
|RF-15-Rev1|colaborador|estipular data para matrícula em curso|o sistema permitia sempre o cadastro e a matrícula com pagamento, mas, agora, esse processo terá uma data de início e fim.(conforme RF-06-Rev-1|atualizado em 21.04.26|em aberto|
|RF-16|colaborador|visualizar relatório de matrículas|listar todas as matrículas iniciadas por todos alunos com opções para filtrar a listagem por aluno, situação, data, curso etc.|criado em 20.04.26|em aberto|
|RF-17|colaborador|visualizar relatório de pagamentos|listar todos os pagamentos iniciados por todos alunos com opções para filtrar a listagem por aluno, situação, data, curso etc.|criado em 20.04.26|em aberto|
|RF-18|administrador|fazer login em área restrita aos administradores|área acessível somente após cadastrado conforme RF-19|criado em 20.04.26|em aberto|
|RF-19|administrador|cadastrar colaborador|cadastrar dados pessoais básicos e dados do contrato de trabalho|criado em 20.04.26|em aberto|
|RF-20|administrador|manter permissões de acesso|poderá dar permissões de acesso para colaboradores cadastrados conforme RF-19 , tanto para área restrita dos colaboradores quanto  à dos administradores|criado em 20.04.26|em aberto|
|RF-21|sistema|integração com sistema acadêmico|Após a confirmação da matrícula, realizar a integração com o sistema acadêmico para gerar a sala de aula do estudante e outros itens relacionados|criado em 20.04.26|em aberto|
|RF-22|sistema|integração com sistema financeiro|Após a confirmação da matrícula, realizar a integração com o sistema financeiro para confirmar o pagamento e gerar o contrato financeiro com as parcelas do curso.|criado em 20.04.26|em aberto|



## Requisitos não funcionais

|COD|ATOR|REQUISITO|REGRAS E CRITÉRIOS|DATA CRIAÇÃO/ATUALIZAÇÃO|SITUAÇÃO|
|-|-|-|-|-|-|
|RNF01|sistema|funcionar 24 horas por dia,||criado em 20.04.26|em aberto|
|RNF02|sistema|interface web e mobile|a interface deverá se adequar tanto a dispositivos web desktop quanto mobile|criado em 20.04.26|em aberto|
|RNF03|sistema|integração com sistemas acadêmico e financeiro|realizar requisições as API's do sistema acadêmico para gerar sala de aula e do sistema financeiro para gerar contratos financeiros|criado em 20.04.26|em aberto|
|RNF04|sistema|processo mais rápido, simples e intuitivo||criado em 20.04.26|em aberto|



## Requisitos organizacionais

|COD|ATOR|REQUISITO|REGRAS E CRITÉRIOS|DATA CRIAÇÃO/ATUALIZAÇÃO|SITUAÇÃO|
|-|-|-|-|-|-|
|RO01|gerente do produto|implementar esse novo sistema até novembro||criado em 20.04.26|em aberto|
|RO02|gerente do produto|melhorar a experiência dos novos usuário|realizar pesquisa de experiência com usuários para verificação do requisito.|criado em 20.04.26|em aberto|



# Pedidos de mudanças

**Mudança 1:** o sistema permitia sempre o cadastro e a matrícula com pagamento, mas, agora, esse processo terá uma data de início e fim. O estudante somente poderá efetuar a matrícula e pagá-la dentro da data estipulada. Caso ultrapasse, ele poderá entrar no sistema somente para conferir seus dados.

**Mudança 2:** caso o estudante tenha efetuado a matrícula, ele poderá cancelá-la, após encerrar o prazo final (de acordo com a mudança 1), dentro de até 7 dias, o que lhe dá o direito de ressarcimento dos valores pagos. Se pagou no *pix*, receberá o valor em conta, mas, se pagou no cartão, receberá um crédito no cartão para abater o valor pago.

**Mudança 3:** o estudante que cancelar ou não estiver com uma matrícula efetuada (apenas fez o cadastro e não pagou), poderá pedir a anonimização dos seus dados pela sua área restrita com *login*. Para isso, basta logar e solicitar a anonimização. O sistema precisa pegar seus dados pessoais e embaralhar os caracteres ou, ainda, fazer algo que não identifique mais o estudante – para cumprir a lei da LGPD.

