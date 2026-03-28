O que eu preciso desenvolver? Você deve elaborar um diagrama de classes, com base no cenário descrito na semana 1. Você deve identificar as classes, atributos, métodos e relacionamentos entre as classes que representam o cenário do Sistema Academia.

O que eu preciso entregar? Você deverá entregar o diagrama de classes produzido. Gere uma imagem dele e insira na seção 4 – Diagrama de classes, do seu arquivo do Word. Garanta uma imagem nítida e legível.

Para ajudá-lo na especificação, produzimos um checklist de verificação.

Classes válidas e apropriadas

- [x] Você adicionou todas as classes necessárias a partir dos requisitos (a maioria aparece como substantivos)? Faça o cruzamento com as estórias de usuários apresentadas no cenário da etapa 1.

- [x] Todos os nomes de classe estão escritos no singular e começam com uma letra maiúscula?

- [x] Você nomeou cada classe para que seu significado possa ser entendido com precisão?

- [x] Você já considerou casos em que há dois ou mais nomes para a mesma coisa e criou apenas uma única classe?

- [x] Você incluiu apenas classes para as quais os dados realmente precisam ser armazenados ou manipulados? 

Associações válidas e apropriadas

- [x] Você adicionou todas as associações necessárias a partir dos requisitos (estórias de usuários)? Risque frases nos requisitos quando as tiver utilizado para identificar relacionamento; por exemplo: Como aluno, quero: ser capaz de consultar meus treinos diários (ou seja, o aluno consulta treino, havendo uma relação entre a classe Aluno e a classe Treino).

- [x] Todas as associações têm multiplicidade nos dois extremos? Exemplo: um aluno pode consultar um ou mais treinos (conjunto de exercícios), mas um treino é referente a apenas um aluno.

- [x] Você leu as associações nas duas direções e pensou na correção?

- [x] Você tem alguma associação 1:1? Estes casos são extremamente raros e geralmente incorretos. Para uma associação 1:1, sempre deve haver o mesmo número de instâncias de cada classe e elas devem ser organizadas em pares.

- [x] Os nomes dos métodos começam com letras minúsculas, são verbos de ação e significativos para uma ação do sistema?

- [x] Você tem uma classe representando os usuários finais do sistema? Se sim, está realmente armazenando dados sobre os usuários? Caso contrário, exclua essas classes.

Atributos válidos e apropriados

- [x] Você adicionou todos os atributos necessários?

- [x] Os atributos representam dados simples que cada instância deve ter (string, int, double, date, boolean etc.)?

- [x] Você evitou escrever os atributos no plural na maioria dos casos? 

- [x] Generalização e herança válidas e apropriadas

- [x] Você usou o símbolo do triângulo aberto adequado, apontando para a superclasse?

- [x] Tudo em cada superclasse também se aplica a cada uma de suas subclasses?

- [x] Você evitou situações em que existem várias subclasses que não seriam significativamente diferentes, ou seja, que não possuem atributos/métodos diferentes entre elas?

- [x] Você pesquisou situações em que existem classes semelhantes e criou uma superclasse para os elementos comuns?

Avaliação geral

- [x] Você tem alguma classe com um grande número de atributos (mais de 10) ou associações (mais de 5)? Se sim, considere dividir essas classes em uma superclasse e uma subclasse; verifique se isso é possível.

- [x] Você consegue ver alguma maneira de simplificar seu modelo?


