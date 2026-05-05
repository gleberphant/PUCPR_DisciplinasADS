# UC01: consultar treino

## ATORES:

- **PRINCIPAL**: aluno
- **SECUNDÁRIO**: professor

## CONDIÇÕES PRELIMINARES:

1. O aluno está logado no sistema
2. está com pagamento em dia
3. existe um professor atribuido para o aluno
3. existe pelo menos um treino cadastrado para o Aluno 

## FLUXO BASICO

1. Aluno seleciona opção "meus treinos"

2. Sistema apresenta a lista de treinos cadastrados pelo professor, contendo, em cada treino:
    - nome do treino, 
    - comentários gerais 
    - opção para visualizar detalhes

3. Aluno seleciona para visualizar um treino

4. Sistema exibe detalhes do treino selecionado, contendo:
    - lista de exercícios contendo nome, descrição, series,repetições e observações
    - comentários gerais do professor 
    - opção de visualizar um video em cada exercício

## FLUXOS ALTERNATIVOS:

2.A1 - CASO não haja treinos cadastrado, o sistema exibe "treino não cadastrado. procure o professor "nome do professor"

2.A2 - CASO não haja professor atribuido ao aluno exibir "nenhum professor atribuido procure a coordenação."

4.A1 - (Vídeo Indisponível): Se o vídeo para o exercício selecionado não estiver disponível, o Sistema informa o Aluno. O fluxo retorna ao passo 4.

## CONDIÇÕES FINAIS:

**Sucesso**: O Aluno visualiza as informações do seu treino (exercícios, séries, repetições, etc.).

**Falha**: O treino não é exibido. O sistema permanece no estado anterior ao início do caso de uso.

