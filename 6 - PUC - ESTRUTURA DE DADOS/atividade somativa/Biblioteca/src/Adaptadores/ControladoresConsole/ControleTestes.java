package Adaptadores.ControladoresConsole;

import Testes.TestadorArvores;
import Testes.TestadorBuscas;
import Testes.TestadorListas;
import Testes.TestadorGrafos;
import Testes.TestadorOrdenacao;

public class ControleTestes {
    public void TestarListas() {

        new TestadorListas<>().Executar();
    }

    public void TestarGrafos() {

        new TestadorGrafos<>().Executar();
    }

    public void TestarArvores() {

        new TestadorArvores<>().Executar();
    }


    public void TestarOrdenacao() {

        new TestadorOrdenacao<>().Executar();
    }

    public void TestarBuscas() {
        new TestadorBuscas<>().Executar();

    }
}
