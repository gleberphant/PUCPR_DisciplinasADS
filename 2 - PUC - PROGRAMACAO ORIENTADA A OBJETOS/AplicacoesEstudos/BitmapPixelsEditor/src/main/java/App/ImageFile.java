/**
 * Classe que representa uma imagem.
 */


package App;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageFile {
    /**
     * Constantes de configuração
     */
    final static int MAX_BUFFER_SIZE = 10000000;
    final static int HEADER_SIZE = 54;
    final static int PIXEL_SIZE = 4;

    // buffers da imagem.
    byte[] headerBuffer;
    PixelStruct[] pixelsBuffer;

    // tamanho da imagem, do header e dos pixeis.
    private int headerSize = 0;
    private int pixelBufferSize = 0 ;

    // path file
    private final String pathFileString;

    /**
     * Construtor. Inicializa os buffers da imagem;
     */
    ImageFile(String pathFileString){
        this.headerBuffer = new byte[HEADER_SIZE];
        this.pixelsBuffer = new PixelStruct[MAX_BUFFER_SIZE];
        this.pathFileString = pathFileString;
    }

    /**
     * Method para leitura do arquivo
     */
    void readFileBMP(){

        // leitura do arquivo
        try (BufferedInputStream inputFile = new BufferedInputStream( Files.newInputStream(Paths.get(pathFileString)))){

            //ler do cabeçalho da imagem(54 bytes)
            System.out.println(" > lendo header imagem (54 bytes)");
            headerSize = inputFile.read(headerBuffer, 0, HEADER_SIZE);

            // loop para ler os pixels. cada pixel composto por 4 bytes
            System.out.println(" > lendo pixels da imagem");

            // contador de pixels
            int pixelCount = 0;

            // um pixel composto por 4 bytes.
            byte[] pixelBytes = new byte[PIXEL_SIZE];

            while(inputFile.read(pixelBytes, 0, PIXEL_SIZE) != -1 && pixelBufferSize < MAX_BUFFER_SIZE){

                pixelsBuffer[pixelCount] = new PixelStruct( pixelBytes[0] , pixelBytes[1] , pixelBytes[2] , pixelBytes[3] );
                pixelCount++;
            }

            pixelBufferSize = pixelCount;
        }
        catch (IOException e) {
            System.out.printf("\n> Erro inesperado durante a leitura do arquivo %s \n", e.getMessage());
        }
    }
    void grayScale(){


        System.out.println(" > aplicando gray effect nos pixels");

        // variáveis para armazenar os valores das cores para realizar manipulações
        int red, green, blue, gray;

        // buffer temporário para editar os pixels.
        PixelStruct[] tempBuffer = new PixelStruct[pixelBufferSize];

        // loop para escrever os pixels no arquivo
        for(int byteCount = 0; byteCount < pixelBufferSize; byteCount++) {

            //ler o pixel do buffer e converte o byte para um valor unsigned ( de 0 a 255).
            blue = (pixelsBuffer[byteCount].blue()   & 0xFF) ;
            green= (pixelsBuffer[byteCount].green()  & 0xFF);
            red =  (pixelsBuffer[byteCount].red()    & 0xFF);

            // Cálculo do tom de cinza
            gray = Math.round((blue + green + red )/3.0f) ;

            // Define o novo valor do valor do pixel do pixel
            tempBuffer[byteCount] = new PixelStruct((byte) gray,(byte) gray,(byte) gray,(byte) gray);

        }
        // Copia o buffer temporário para o buffer da imagem. O GC do java coleta o lixo do buffer anterior.
        pixelsBuffer = tempBuffer;

    }
    /**
     * Method para escrita do arquivo
     */
    void writeFileBMP(){

        System.out.println(" > Copiando o arquivo: "+ pathFileString);

        try(BufferedOutputStream outputFile = new BufferedOutputStream ( Files.newOutputStream(Paths.get(".\\assets\\image1copy.bmp")))){

            byte[] bytePixel = new byte[PIXEL_SIZE];

            // escreve header
            System.out.println(" > escrevendo header file");
            outputFile.write( headerBuffer, 0, headerSize);

            // escreve pixels
            System.out.println(" > escrevendo pixels");

            // loop de escrita.
            for(int byteCount=0 ; byteCount < pixelBufferSize; byteCount++) {

                // Define os valores do pixel no formato RGBA
                bytePixel[0] = pixelsBuffer[byteCount].blue() ; // Blue
                bytePixel[1] = pixelsBuffer[byteCount].green() ; // Green
                bytePixel[2] = pixelsBuffer[byteCount].red() ; // Red
                bytePixel[3] = pixelsBuffer[byteCount].alpha(); // Alpha

                // Escreve no arquivo de 4 em 4 bytes (um pixel) .
                outputFile.write(bytePixel, 0, PIXEL_SIZE );

            }

        }catch(IOException e){
            System.out.printf("\n> Erro inesperado durante a escrita do arquivo  %s \n", e.getMessage());


        }
    }

}
