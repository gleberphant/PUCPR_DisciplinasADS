package semana08arquivos.main;

import semana08arquivos.builders.ApartBuilder;
import semana08arquivos.builders.HouseBuilder;
import semana08arquivos.builders.LandBuilder;
import semana08arquivos.builders.LoanBuilder;
import semana08arquivos.model.Loan;
import semana08arquivos.ui.UserInterface;
import semana08arquivos.utils.exceptions.InterfaceException;
import semana08arquivos.utils.exceptions.InvalidInputException;
import semana08arquivos.utils.exceptions.LoanException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class App {
    // Declaração e inicialização das variáveis.
    Path pathLogFile;
    Path pathDatafile;

    char loanType;
    boolean running = true;
    double totalPriceProperty, totalPriceLoan;
    LoanBuilder builderLoan;
    UserInterface appInterface;
    LinkedList<Loan> listLoans;

    /**
     * INICIALIZA AS VARIÁVEIS DA APLICAÇÃO
     * */
    void init(){

        System.out.println("Iniciando aplicação. ");
        // Declaração e inicialização de array de financiamentos
        listLoans = new LinkedList<>();

        // Declaração e inicialização da interface
        appInterface = UserInterface.getInstance().initialize();

        // Mensagem de abertura
        appInterface.viewOpening();

        // Path do log do sistema
        pathLogFile = Paths.get("logFile.txt");
        checkFile(pathLogFile);

        // Path do banco de dados
        pathDatafile = Paths.get("loanDatabase.dat");
        checkFile(pathDatafile);

        writeLog("APLICAÇÃO INICIADA. ");
    }

    /**
     * Verifica a existência dos arquivos do sistema.
     * */
    void checkFile(Path pathParam){
        // Verifica se o arquivo de banco de dados existe.
        if(!Files.exists(pathParam)){
            System.out.println(" Criando arquivo " + pathParam.getFileName());

            try {
                // Cria o arquivo de banco de dados.
                Files.createFile(pathParam);
                System.out.println(" Arquivo criado " + pathParam.getFileName());

            } catch (IOException e) {
                // exibe mensagem de erro para o usuário.
                appInterface.viewException("Falha catastrófico ao criar arquivo " + pathParam.getFileName() );
                // encerramento da aplicação
                appInterface.viewCloseMsg();
                return;
            }

            writeLog("Arquivo criado > " + pathParam.getFileName());
        }
    }

    /**
     * carregar a database
     * */
    void loadDatabase(){

        System.out.printf("\nCarregando Banco de Dados %s ...   ", pathDatafile);

        // abrir a base de dados serializada
        try (ObjectInputStream inputFile = new ObjectInputStream( Files.newInputStream(pathDatafile) ) )
        {
            listLoans = (LinkedList<Loan>) inputFile.readObject();
            System.out.print(" [ ok ] \n");

        }catch(EOFException e){
            // exibe mensagem de erro para o usuário.
            System.out.println("\nBanco de dados vazio");

            // registra o evento no log.
            writeLog("Banco dados vazio ");

        }catch(IOException | ClassNotFoundException e){
            // exibe mensagem de erro para o usuário.
            appInterface.viewException("Falha catastrófico ao abrir Bando de dados.");

            // registra o evento no log.
            writeLog(String.format("Error na abertura do arquivo DB > %s",e.getMessage()));

            // encerramento da aplicação
            appInterface.viewCloseMsg();
        }
    }

    /**
     * salva a database
     * */
    void saveDatabase(){

        // Abrir arquivo de database.
        try (ObjectOutputStream outputFile = new ObjectOutputStream(Files.newOutputStream(pathDatafile) ) ) {

            // serializa e escreve o objeto o financiamento.
            System.out.print("\n SALVANDO DADOS EM ARQUIVO > ");
            outputFile.writeObject(listLoans);
            System.out.print("[ok] \n");

            this.writeLog("Arquivo de base de dados salvo com sucesso .");

        }catch(IOException e){

            // exibe mensagem de erro para o usuário.
            appInterface.viewException(e.getMessage());  // Exibe Exception.

            // registra o evento no log.
            this.writeLog(String.format("Falha > %s",e.getMessage()));

            // encerramento da aplicação
            this.appInterface.viewCloseMsg();

        }
    }

    /**
     * Exibe a lista completa dos financiamentos
     **/
    void showLoans(){
        System.out.println("----  LISTA DE FINANCIAMENTOS ----");
        for (Loan item : listLoans) {
            appInterface.viewLoan(item);
        }
        System.out.println("-----------------------------------");
        appInterface.pressEnterToContinue();

    }
    /**
     * Soma e exibir o total dos financiamentos.
     * */
    void showTotal(){

        totalPriceProperty = 0f;
        totalPriceLoan = 0f;

        for (Loan item : listLoans) {
            //  Soma os valores totais do financiamento.
            totalPriceLoan += item.getPaymentValueTotal();
            totalPriceProperty += item.getPrice();
        }

        appInterface.viewTotals(totalPriceProperty, totalPriceLoan);
    }

    /**
     * Cria um novo financiamento.
     * */
    boolean addLoan(){

        // Bloco try para captar exceções de tipo entrada inválida ou de valor inválido.
        try {
            // Leitura dos dados do financiamento.
            loanType = appInterface.promptType();

            // define o item de financiamento
            builderLoan = switch (loanType) {
                case '1' -> new HouseBuilder()
                        .LandArea(appInterface.promptLandArea())
                        .BuildArea(appInterface.promptBuildArea());
                case '2' -> new ApartBuilder()
                        .FloorNumber(appInterface.promptFloor())
                        .GaragesCount(appInterface.promptGarages());
                case '3' -> new LandBuilder()
                        .Zone(appInterface.promptZone());
                default -> throw new InterfaceException("OPÇÃO INVÁLIDA ");
            };

            // Conclui a criação do financiamento e adiciona na lista.
            Loan newLoan = builderLoan
                    .Price(appInterface.promptPrice())
                    .Term(appInterface.promptTerm())
                    .Fee(appInterface.promptFee())
                    .build();

            listLoans.add(newLoan);

            // registra o evento no log.
            writeLog(String.format("Financiamento criado: p%f / t%d / f%f", newLoan.getPrice(), newLoan.getTerm(), newLoan.getFee()));
            return true;

        } catch (LoanException | InterfaceException | InputMismatchException | IllegalArgumentException e) {

            // exibe a exception para o usuário.
            appInterface.viewException(e.getMessage());
            // registra o evento no log.
            writeLog(String.format("> %s",e.getMessage()));

            // reinicia o loop
            return false;
        }
    }
    /**
     * Loop principal do programa
     * */
    void run() {

        // Loop principal da aplicação. termina somente quando usuário pedir para sair
        do {

            // menu principal
            try {
                switch (appInterface.promptMenu()) {
                    case '1': // adicionar financiamento.
                        while (!addLoan()) {
                            System.out.println(" [ Informe os dados do financiamento ] ");
                        }
                        break;
                    case '2': // exibir financiamentos
                        showLoans();
                        break;

                    case '3': // sair
                        running = false;
                        return;
                    case '4': // debug - mostrar arquivo de log
                        showLog();
                        break;

                    default:
                        continue;
                }
                showTotal();

            }catch(InvalidInputException e){
                // exibe a exception para o usuário.
                appInterface.viewException(e.getMessage());


            }

        } while (running);
    }

    /**
     * Exibe o LOG do sistema.
     * */
    void showLog(){

        // abre o  arquivo de  log
        try (BufferedReader log = Files.newBufferedReader(pathLogFile)) {

            // exibe todos os registros do log.
            for (String logString = ""; logString != null; logString = log.readLine()) {
                System.out.printf("\n > %s", logString);
            }

        } catch (IOException e) {
            // exibe mensagem de erro para o usuário.
            appInterface.viewException(e.getMessage());  // Exibe Exception.

            // registra o evento no log.
            this.writeLog(String.format("Falha > %s",e.getMessage()));

            // encerramento da aplicação
            this.appInterface.viewCloseMsg();
        }

        appInterface.pressEnterToContinue();
    }

    /**
     * Registrar LOG do sistema.
     * */
    void writeLog(String textParam){

        //System.out.println("LOG : " + textParam);

        try {
            Files.writeString(
                    pathLogFile,
                    String.format("[%s] %s \n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-M-yy H:m")), textParam ),
                    StandardOpenOption.APPEND
            );
        }
        catch (IOException e) {

            // exibe mensagem de erro para o usuário.
            appInterface.viewException("Erro ao registrar LOG " + e.getMessage());  // Exibe Exception.

            // encerramento da aplicação
            closeApp();
        }
    }
    /**
     * Encerra aplicação
     * */
    void closeApp(){
        appInterface.viewCloseMsg();
        System.exit(1);
    }
}
