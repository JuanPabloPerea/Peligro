public class Main {

    public static void main(String[] args) {
        // la matris del mensaje se debe guardar en la variable libre
        String[] libre = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        // para llamar a los metodos se instancia la clase matriz
        Matriz prueba = new Matriz();
        // el metodo para saber si esta en peligro o no se llama isInDanger
        System.out.println(prueba.isInDanger(libre));

    }
}


