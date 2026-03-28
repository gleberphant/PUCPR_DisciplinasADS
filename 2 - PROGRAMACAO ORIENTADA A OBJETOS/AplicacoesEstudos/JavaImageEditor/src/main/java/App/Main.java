package App;

/**
 * Classe principal do programa image editor
 */
class Main {

    public static void main(String[] args){

        String pathFile = ".\\App\\assets\\image1.bmp";

        ImageFile image = new ImageFile(pathFile);

        System.out.println("\nLendo o arquivo: " + pathFile);
        image.readFileBMP();

        System.out.println("\nAplicando efeito de grayscale: " + pathFile);
        image.grayScale();

        System.out.println("\nSalvando o arquivo novo: " + pathFile);
        image.writeFileBMP();
    }
}