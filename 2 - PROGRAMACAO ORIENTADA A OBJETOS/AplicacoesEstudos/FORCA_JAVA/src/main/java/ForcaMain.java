//┌────────────────────────────────────────────────────────────────────────┐
//│            ╔════╗           ╔═════        ╔════╗  ╔═══╗                │
//│            ╠════╝  ║    ║   ║             ╠════╝  ╠═══╩╗               │
//│            ║       ╚════╝   ╚═════        ║       ║    ║               │
//└────────────────────────────────────────────────────────────────────────┘
//┌────────────────────────────────────────────────────────────────────────┐
//│  Fundamentos da Programação Orientada a Objetos (11100010550_20242_20) │
//│  CURSO: Análise e Desenvolvimento de Sistemas                          │
//│  ALUNO: HANDERSON GLEBER DE LIMA CAVALCANTI (Gr4v4t1nh4)               │
//│  MATRÍCULA: 1112024201103                                              │
//└────────────────────────────────────────────────────────────────────────┘
//┌────────────────────────────────────────────────────────────────────────┐
//│   IMPLEMENTAÇÃO DE JOGO DA FORCA EM JAVA                               │
//└────────────────────────────────────────────────────────────────────────┘

package exercicios;


import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Random;
import java.util.Scanner;

public class ForcaMain {

    private int rodadas_max = 5;
    private boolean running = true;
    private int num_tentativas, num_acertos, tamanho_palavra;
    private char[] array_acertos;
    private String palavra_secreta;

    private Scanner input;

    public void loading_game()
    {

        // mensagem de abertura
        System.out.println("Seja bem vindo ao Jogo da Forca feito por gravatinha");

        // define palavra
        palavra_secreta = create_segredo();

        setDificuldade(5);

        // inicializa variáveis
        num_tentativas = 0;

        tamanho_palavra = palavra_secreta.length();
        array_acertos = new char[tamanho_palavra];
        num_acertos = 0;

        // zera array de acertos
        for(int i = 0; i < tamanho_palavra; i++)
        {
            array_acertos[i] = '_';
        }

        input = new Scanner(System.in);
    }
    String create_segredo(){

        System.out.println("CONECTANDO AO SERVIDOR DE PALAVRAS");
        System.out.println("......");

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.dicionario-aberto.net/random"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());



            JSONObject json = new JSONObject(response.body());
            System.out.println("PALAVRA SECRETA SELECIONADA DO SERVIDOR COM SUCESSO");

            return json.getString("word").toUpperCase();


        }catch (Exception e) {

            System.out.println("Servidor de palavras inacessível, utilizando dicionário interno");

        }

        String[] lista_palavras = {"CASA",
                "PALAVRA",
                "CORREDOR",
                "TELHADO",
                "COMPUTADOR",
                "INTELIGENCIA"};

        return lista_palavras[new Random().nextInt(lista_palavras.length)].toUpperCase();



    }


    public void setDificuldade(int dificuldade){
        rodadas_max = dificuldade;
    }


    private boolean check_acerto(char letra)
    {

        boolean acerto = false;

        for(int i = 0; i < tamanho_palavra ; i++)
        {
            if(palavra_secreta.charAt(i) == letra && array_acertos[i] != letra  )
            {
                array_acertos[i] = letra;
                num_acertos++;
                acerto = true;
            }

        }


        return acerto;
    }
    private boolean check_vitoria(){
        for(int i = 0 ; i < tamanho_palavra; i++){
            if(array_acertos[i] != palavra_secreta.charAt(i)){
                return false;

            }
        }
        return true;
    }

    private boolean check_derrota(){
        return num_tentativas > rodadas_max;
    }

    private char input_handle (){
        String input_string;

        while (true) {
            System.out.print("Digite uma letra: ");
            input_string = input.nextLine().toUpperCase();

            if(!input_string.isEmpty()) {
                return input_string.charAt(0);
            }

        }
    }


    public void game_loop()
    {
        char tentativa;
        int rodada = 0;

        while(running) {

            rodada++;

            System.out.println(" ");
            System.out.println("------ RODADA Nº " + rodada + " -------------------------");
            System.out.println("Nº tentativas restantes: " + (rodadas_max - num_tentativas) + " | Letras encontradas: " + num_acertos);
            System.out.println(" ");
            System.out.println("PALAVRA DESCOBERTA >>> " + new String(array_acertos));
            System.out.println(" ");

            tentativa = input_handle();

            if (check_acerto(tentativa)) {
                System.out.println("[ encontrou uma letra ] ");
            } else {
                System.out.println("[ errou a letra, tente novamente ]");
                num_tentativas++;
            }

            System.out.println("---------------------------------------------");

            // condição de vitória
            if (check_vitoria()) {
                System.out.println("PARABENS! Você venceu");
                running = false;

            }


            //condição de derrota
            if (check_derrota()) {
                System.out.println("Você perdeu! TENTE NOVAMENTE");

                running = false;

            }

        }
        System.out.println("---------------------------------------------");
        System.out.println("A Palavra era: " + palavra_secreta);
        System.out.println("---------------------------------------------");

    }


    public static void main(String[] args)
    {
        ForcaMain app = new ForcaMain();

        app.loading_game();


        app.game_loop();


    }



}
