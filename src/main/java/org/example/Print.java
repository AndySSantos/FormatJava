package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author andyleonardoserranosantos 
 */
public class Print {

    public  void std(Object e){
        System.out.printf(e.toString());
    }

    public void stdl(Object e){
        System.out.println(e.toString());
    }

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
