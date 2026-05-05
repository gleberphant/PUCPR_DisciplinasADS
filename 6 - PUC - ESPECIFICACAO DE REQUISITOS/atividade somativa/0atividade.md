# Atividade

Nesta atividade, nossa missão é  desenvolver um novo sistema de matrícula *on-line* para a universidade. Esse sistema precisa funcionar 24 horas por dia, tanto na *web* quanto em dispositivos móveis. A expectativa é melhorar a experiência dos novos usuários, com um processo mais rápido, simples e intuitivo, como manter o histórico de matrículas e pagamentos. Esse desenvolvimento acontecerá em decorrência de vários relatos relacionados ao sistema anterior, que era complexo e apresentava lentidão em momentos críticos, como em vestibulares. A ideia, aqui, é implementar esse novo sistema até novembro, ou seja, temos alguns meses pela frente.

* Com base nessas informações, como você organizaria sua especificação?
* Qual a sua linha de raciocínio?
* Tudo o que você precisa para começar a especificar está claro?
* Vamos que vamos!

# Módulos

Com base nessa ideia, o sistema deverá apresentar três áreas:

1. **Uma área pública**, com duas etapas, acessível sem a necessidade de *login*, em que qualquer pessoa pode realizar um cadastro básico com seus dados pessoais e criar o seu *login* com senha. Esse cadastro básico é necessário como etapa 1, antes da geração da matrícula, que será a etapa 2, ao qual a pessoa selecionará o curso que deseja fazer, incluindo informações como o nome do curso, o valor, a carga horária, a grade curricular, entre outras. Essa estrutura permite a esse cadastro básico ser utilizado para diversas matrículas.
2. **Uma área restrita para estudantes**, acessível mediante *login*, em que eles podem tanto fazer uma nova matrícula quanto verificar suas matrículas existentes, realizar pagamentos via PIX ou cartão de crédito, acompanhar o *status* do pagamento e consultar informações sobre o curso, como data de início, documentos necessários, entre outras. Caso o estudante inicie o processo de matrícula, mas o pagamento via PIX não seja concluído ou o cartão de crédito não seja aprovado, ele poderá refazer a matrícula utilizando o mesmo cadastro já existente.
3. **Uma área restrita administrativa destinada aos colaboradores da universidade**, responsáveis pela gestão das matrículas. Quando uma matrícula estiver em conformidade, o colaborador pode marcar um *checkbox* (caixinha de seleção) ao lado da matrícula e, em seguida, clicar no botão "Confirmar". É possível selecionar e confirmar várias matrículas de uma só vez. Após a confirmação, o sistema realiza a integração dessa matrícula tanto com o sistema acadêmico – para gerar a sala de aula do estudante e outros itens relacionados – quanto com o sistema financeiro – para confirmar o pagamento e gerar o contrato financeiro com as parcelas do curso.



# **Mudança de escopo**

A especificação do sistema estava fluindo superbem. No entanto, em certo momento, um dos gestores responsáveis por essa área de matrículas apresentou mais algumas informações. Acompanhe!

**Mudança 1:** o sistema permitia sempre o cadastro e a matrícula com pagamento, mas, agora, esse processo terá uma data de início e fim. O estudante somente poderá efetuar a matrícula e pagá-la dentro da data estipulada. Caso ultrapasse, ele poderá entrar no sistema somente para conferir seus dados.

**Mudança 2:** caso o estudante tenha efetuado a matrícula, ele poderá cancelá-la, após encerrar o prazo final (de acordo com a mudança 1), dentro de até 7 dias, o que lhe dá o direito de ressarcimento dos valores pagos. Se pagou no *pix*, receberá o valor em conta, mas, se pagou no cartão, receberá um crédito no cartão para abater o valor pago.

**Mudança 3:** o estudante que cancelar ou não estiver com uma matrícula efetuada (apenas fez o cadastro e não pagou), poderá pedir a anonimização dos seus dados pela sua área restrita com *login*. Para isso, basta logar e solicitar a anonimização. O sistema precisa pegar seus dados pessoais e embaralhar os caracteres ou, ainda, fazer algo que não identifique mais o estudante – para cumprir a lei da LGPD.

Agora, com essas novas informações, como ficaria a especificação do sistema?

# Modelo de Resposta

Como resposta para esta atividade, esperamos que você:

1. Descreva o raciocínio e os passos que pensou para iniciar e finalizar a especificação.
2. Elabore o fluxo macro do sistema, considerando as informações iniciais e mudanças.
3. Considerando as mudanças de escopo que surgiram após o início da especificação, explique quais novos requisitos você inseriu na especificação. Como isso foi registrado no versionamento e nos demais artefatos e diagramas?
4. Apresente os requisitos e as regras de negócios.
5. Elabore um diagrama de caso de uso geral (com atores e vínculos entre os casos de uso, como o include, com base nos requisitos e no fluxo macro).
6. Elabore um diagrama de classes com separação de classes, vínculos entre as classes e atributos, e métodos.
7. Apresente a documentação de rastreabilidade. Elabore uma matriz de rastreabilidade com as informações dos requisitos, alinhados aos diagramas de caso de uso.
8. Apresente os artefatos criados para explicar a especificação.
9. Apresente os protótipos criados para validar os requisitos e em que momento os utilizou.
10. Explique a conexão entre o fluxo macro, os requisitos, os diagramas de casos de uso e de classes, e a matriz de rastreabilidade.

Agora, sim! Bora fazer a atividade e mostrar tudo o que aprendeu na disciplina. A seguir, deixamos um *template* para que possar organizar as informações solicitadas.

