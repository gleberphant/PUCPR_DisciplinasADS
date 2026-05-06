package Main;

import Infraestrutura.Configuracao.ConfiguradorRoteadorConsole;
import Infraestrutura.ConsoleUI.ConsoleMain;


public class App {
    public static void main(String[] args) {

        // Inicia a UI (Infraestrutura de Saída)
        ConsoleMain uiConsole = new ConsoleMain( ConfiguradorRoteadorConsole.configurarRoteadorConsole());
        uiConsole.executar();
    }
}
