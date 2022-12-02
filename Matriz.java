public class Matriz {

    public boolean isInDanger(String[] mensaje){
        String[] liPrueba = mensaje;
        int aux = 0;
        int suma = 0;
        while(liPrueba.length > 1){
            aux += this.peligroHorizontal(liPrueba);
            liPrueba = this.eliminarFila(liPrueba);
        }
        suma = suma +aux;
        aux = 0;
        liPrueba = mensaje;
        while(liPrueba[0].length() > 1){
            aux += this.peligroVertical(liPrueba);
            liPrueba = this.eliminarColumna(liPrueba);
        }
        suma = suma + aux;
        aux = 0;
        liPrueba = mensaje;
        while(liPrueba.length > 4){
            aux += this.peligroDiagonalAbajo(liPrueba);
            liPrueba = this.eliminarFila(liPrueba);
        }
        suma = suma + aux;
        aux = 0;
        liPrueba = mensaje;

        while(liPrueba[0].length() > 4){
            aux += this.peligroDiagonalDerecha(liPrueba);
            liPrueba = this.eliminarColumna(liPrueba);
        }
        suma = suma + aux;

        if (suma >= 2){
            return true;
        }else {
            return false;
        }

    }
    // metodo que se encarga de eliminar una colomnua matriz
    public String[] eliminarColumna (String[] arr){
        String[] aux = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            aux[i] = arr[i].substring(1,arr[i].length());
        }
        return aux;
    }
    // metodo que se encarga de eliminar un flia de la matriz
    public String[] eliminarFila(String[] arr){
        String[] aux = new String[arr.length-1];
        for (int i = 0; i < arr.length-1; i++) {
            aux[i] = arr[i+1];
        }
        return aux;
    }
    // metodo que se encarga de decir si en la primera columna
    // de la matriz esta el mensaje de peligro
    public int peligroVertical(String[] arr){
        int count = 1;
        int peligro = 0;
        for (int i = 0; i < arr.length-1; i++) {
            String aux = arr[i].substring(0,1);
            count = 1;
            for (int j = i+1; j < arr.length; j++) {
                String aux2 = arr[j].substring(0,1);
                if(aux.equals(aux2)){
                    count += 1;
                    if(count == 4){
                        peligro += 1;
                    }
                }
            }
        }
        return peligro;
    }
    // metodo que se encarga de decir si en la primera fila
    // de la matriz esta el mensaje de peligro
    public int peligroHorizontal(String[] arr){
        int count = 1;
        int peligro = 0;
        // busqueda de peligro horizontal
        for (int i = 0; i < arr[0].length(); i++) {
            String aux = arr[0].substring(i,i+1);
            count = 1;
            for (int j = i+1; j < arr[0].length(); j++) {
                String aux2 = arr[0].substring(j,j+1);
                if(aux.equals(aux2)){
                    count += 1;
                    if(count == 4){
                        peligro += 1;
                    }
                }else{
                    count = 1;
                }
            }
        }
        return peligro;
    }
    // metodo que se encarga de decir si en la diagonal Principal
    // al eliminar nua fila de la matriz esta el mensaje de peligro
    public int peligroDiagonalAbajo(String[] arr){
        int count = 1;
        int peligro = 0;
        for (int i = 0; i < arr.length; i++) {
            String aux = arr[i].substring(i,i+1);
            count = 1;
            for (int j = i+1; j < arr.length; j++) {
                String aux2 = arr[j].substring(j,j+1);
                if(aux.equals(aux2)){
                    count += 1;
                    if (count >= 4){
                        peligro += 1;
                    }
                }else {
                    count = 1;
                }
            }
        }
        return peligro;
    }
    // metodo que se encarga de decir si en la Diagonal principal
    // eliminando una columna de la matriz esta el mensaje de peligro
    public int peligroDiagonalDerecha(String[] arr){
        arr = this.eliminarColumna(arr);
        int count = 1;
        int peligro = 0;
        for (int i = 0; i < arr[0].length(); i++) {
            String aux = arr[i].substring(i,i+1);
            count = 1;
            for (int j = i+1; j < arr[0].length(); j++) {
                String aux2 = arr[j].substring(j,j+1);
                if(aux.equals(aux2)){
                    count += 1;
                    if (count == 4){
                        peligro += 1;
                    }
                }else {
                    count = 1;
                }
            }
        }
        return peligro;
    }
}
