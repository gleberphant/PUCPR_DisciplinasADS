# Atividade formativa

## Caso

O banco de Tóquio está tendo problemas com segurança da informação. Alguém internamente no banco executou uma rotina de software malicioso, este malware rapidamente foi replicado aos dispositivos que estavam conectados na rede, inúmeros computadores foram contaminados, inclusive alguns servidores de aplicação que possuem acesso externos. Ao realizar um diagnóstico em um dos computadores contaminados foram identificados alguns dos comportamentos deste malware, entre os quais: insere informações no registro do computador, libera determinadas portas no firewall e ainda escala privilégios de administrador na máquina.
O malware, ao conseguir acesso a um usuário com privilégios de administrador, altera a senha de todos os usuários. Este malware permite que o atacante explore vulnerabilidades, causando danos e obtendo acesso indevido às informações restritas. Porém, um dos maiores problemas está relacionado às portas que foram liberadas no servidor de aplicação que, por sua vez, tem acesso externo. Após o servidor ter sido contaminado e as portas no firewall terem sido abertas, inúmeras tentativas de intrusão ao sistema foram realizadas. Ao observar a origem dos pacotes do tráfego de rede, foram identificados endereços IP de diferentes partes do mundo. Este servidor não pode ficar fora do ar, seria um prejuízo imensurável para o banco. O backup do servidor está sendo restaurado, porém pode levar algumas horas para que o servidor esteja pronto.
Os diretores do banco de Tóquio convocam imediatamente uma reunião, você como mais novo membro da equipe de segurança foi designado como responsável para liderar a equipe de segurança para resolver o problema. A princípio você se sente um pouco ansioso e intimidado, você tem pouco contato com os diretores. Mas, logo lembra que uma oportunidade pode estar surgindo: é a hora de aproveitar! 
Sua missão é utilizar todo o conhecimento para conter o incidente e colocar o novo servidor em produção, para isso é necessário observar todos os aspectos e requisitos de segurança da informação. Esta é uma grande oportunidade de mostrar seu desempenho e comunicação com a equipe de segurança, os diretores do banco estão muito apreensivos e querem resultados. Então, é hora de colocar a "mão na massa", desenvolver as atividades propostas e restabelecer os sistemas do Banco de Tóquio!

## Perguntas

### a) Tipificação criminal: crimes cibernéticos que podem estar associados ao estudo de caso

- Invasão de dispositivo informático (Art. 154-A do Código Penal): O malware inseriu informações no registro, liberou portas no firewall e escalou privilégios de administrador, obtendo acesso não autorizado e causando danos.
- Dano (Art. 163 do Código Penal): O malware causou danos aos sistemas ao contaminar computadores e servidores, alterar senhas e permitir acesso indevido.
- Interrupção ou perturbação de serviço telegráfico, telefônico, informático ou de utilidade pública (Art. 266 do Código Penal): A contaminação dos servidores e a alteração de senhas de todos os usuários podem ter levado à interrupção dos serviços bancários, causando um "prejuízo imensurável".
- Furto (Art. 155 do Código Penal): Se o "acesso indevido às informações restritas" resultou na subtração de dados, pode configurar furto de dados.
- Associação Criminosa (Art. 288 do Código Penal): Se for comprovado que o atacante agiu em conjunto com outras pessoas para cometer os crimes.

### b) Vulnerabilidades e ameaças que podem estar relacionadas ao incidente

#### Vulnerabilidades (fraquezas no sistema ou processo)

- Falta de controle de acesso e privilégios: Um usuário interno conseguiu executar software malicioso, e o malware conseguiu escalar privilégios de administrador.
- Falta de segmentação de rede: O malware se replicou rapidamente a todos os dispositivos conectados na rede, incluindo servidores.
- Firewall mal configurado ou ausente: O malware conseguiu liberar portas no firewall, especialmente em servidores com acesso externo.
- Antimalware/EDR ineficaz ou ausente: O software malicioso não foi detectado ou contido a tempo.
- Falta de monitoramento de logs e eventos: Ações críticas como inserção no registro, liberação de portas, escalada de privilégios e alteração de senhas não foram detectadas proativamente.
- Vulnerabilidades em sistemas operacionais/aplicações: O malware explorou falhas para se propagar e causar danos.
- Falta de conscientização e treinamento dos usuários: Um usuário interno executou o software malicioso.
- Políticas de senha inadequadas: O malware conseguiu alterar as senhas de todos os usuários.

#### Ameaças (agentes ou eventos que podem causar dano)

- Malware: O software malicioso em si, com suas capacidades de replicação, alteração de sistema e escalada de privilégios.
- Ataque interno (Insider Threat): A ação inicial de um indivíduo dentro do banco que executou o malware.
- Ataques externos/Intrusão: As inúmeras tentativas de intrusão ao sistema após as portas do firewall terem sido abertas.
- Perda de confidencialidade: Acesso indevido a informações restritas.
- Perda de integridade: Alteração de dados (senhas), configurações de sistema (registro, firewall).
- Perda de disponibilidade: Servidores fora do ar, causando prejuízo imensurável.
- Ataques de negação de serviço (DoS/DDoS): Possível objetivo das tentativas - de intrusão.

### c) Políticas e procedimentos de segurança da informação que foram ignorados ou não foram previstos.

- Política de Uso Aceitável (PUA): O usuário interno que executou o malware provavelmente violou esta política, que define o uso permitido dos recursos de TI.
- Política de Controle de Acesso e Gerenciamento de Privilégios: Falha em restringir o que usuários podem executar e em gerenciar e monitorar privilégios de administrador.
- Política de Segurança de Rede: Falha na segmentação da rede, na configuração e monitoramento de firewalls e na detecção de tráfego anômalo.
- Política de Proteção contra Malware (Antimalware/EDR): Os sistemas de proteção de endpoint falharam em detectar e conter o malware.
- Política de Gerenciamento de Patches e Vulnerabilidades: A exploração de vulnerabilidades pelo malware sugere que os sistemas não estavam devidamente atualizados ou "hardenizados".
- Política de Monitoramento e Auditoria: A falta de detecção proativa das ações do malware (alterações no registro, firewall, privilégios, senhas) indica falhas nesta política.
- Política de Resposta a Incidentes: A convocação da equipe de segurança após o incidente já estar em estágio avançado e a ansiedade do novo líder sugerem que o plano de resposta a incidentes pode ser inexistente, desatualizado ou não testado.
- Política de Backup e Recuperação de Desastres (DRP/BCP): Embora o backup esteja sendo restaurado, o tempo de recuperação de "algumas horas" para um servidor crítico de um banco pode indicar que os objetivos de tempo de recuperação (RTO) não foram adequadamente definidos ou não estão sendo cumpridos.
- Política de Conscientização e Treinamento em Segurança da Informação: A execução do malware por um usuário interno aponta para a necessidade de melhor treinamento e conscientização sobre ameaças cibernéticas.
- Política de Gerenciamento de Configurações Seguras (Hardening): Os sistemas não estavam configurados de forma robusta para prevenir a escalada de privilégios ou a manipulação do firewall.
