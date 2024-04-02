package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author andyleonardoserranosantos
 * @version 1.0
 */
public class Print {

    /**
     * Salida estandar
     * @param e -> dato generico
     */
    public  void std(Object e){
        System.out.printf(e.toString());
    }

    /**
     * Salida estandar con salto de linea
     * @param e -> dato generico
     */
    public void stdl(Object e){
        System.out.println(e.toString());
    }

    /**
     * Salida concatenada con salto de linea
     * @param args -> arreglo de genericos, considere el primer elemento como el mensaje o candena de salida, separe arumentos con ','
     */
    public  void format(Object... args){
        if (args.length == 0)
            System.out.println();
        else if (args.length==1) {
            stdl(args[0]);
        } else{
            String cadenaOriginal = (String) args[0];
            String[] valores = new String[args.length-1];
            int i = 0;
            for( ; i< args.length-1;i++){
                valores[i] = args[i+1].toString();
            }
            String nuevaCadena = reemplazarMarcadores(cadenaOriginal, valores);

            stdl(nuevaCadena);

        }
    }

    /**
     * Remplaza '{}' en el mensaje, por cada uno de los argumentos de tipo string
     * @param cadenaOriginal -> mensaje original
     * @param valores -> arreglo de argumentos
     * @return -> mensaje concatenado
     */
    public static String reemplazarMarcadores(String cadenaOriginal, String[] valores) {
        int x=0;
        if(valores.length==0)
            return null;

        // Clonar la cadena original para mantenerla intacta
        String nuevaCadena = new String(cadenaOriginal);

        // Iterar sobre los valores y reemplazar cada marcador de posición {}
        for (String valor : valores) {
            try{
                nuevaCadena = nuevaCadena.replaceFirst("\\{\\}", valor);
            }catch (Exception e){
                return "Error, aurgumentos faltantes o {} insuficientes";
            }
        }

        return nuevaCadena;
    }
}
