# Atividade

Autor HANDERSON GLEBER DE LIMA CAVALCANTI
Grupo 199

## 1ª parte - descrição

### Visão

Vídeo com a explicação da Etapa 3 – Detecção de ataque negação de serviço. Faça um vídeo de até 3 minutos de duração.

### Requisitos

* cadastre uma regra para monitoramento de ataque do tipo DDoS no Snort, e aplique o monitoramento da interface de rede.
* No sistema operacional Kali realize um ataque de DDoS para o IP da VM Snort.
* Produza um vídeo de captura de tela, de no máximo três minutos, apresentando:
  * Nome dos integrantes da equipe;
  * Configuração do snort para detectar ataque de negação de serviço;
  * Descrição do ataque e a respectiva detecção de intrusão, narrando detalhes de cada execução.

## 2ª parte - RESPOSTA

## Endereço do vídeo

[Detecção de Ataque de Negação de Serviço - PUCPR - YouTube](https://youtu.be/kfrsWSacYYg)

## Regras para detectar DOS (Snort)

```bash
#./etc/snort/rules/local/rules
alert tcp any any -> $HOME_NET any (msg:"POSSIVEL ATAQUE DE FLOOD"; flags:S; flow:stateless; threshold:type limit, track by_src, count 100, seconds 1; sid:2000001; rev:001;) 
```

## Comandos do Ataque DOS

```bash
#!/bash/bin
sudo hping3 -c 10000 -d 120 -S -p 80 --flood -rand-source
```
