package AlgoritmosYEstructurasDeDatos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromoEvaluador {
    public static String palindromoBuilder(String param) {
        param = param.toLowerCase();
        param = param.replaceAll(" ", "");
        Map<Character, Integer> freqMap = new HashMap<>();

        // Contar frecuencia de cada carácter
        for (char c : param.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int cuentaImpares = 0;
        Character charMediana = null;
        StringBuilder mitadSecuencia = new StringBuilder();

        // Verificar posibilidad y construir mitad del palíndromo
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            int frecuencia = entry.getValue();

            if (frecuencia % 2 != 0) {
                cuentaImpares++;
                if (cuentaImpares > 1) return "Not Possible";
                charMediana = ch;
            }

            // Agregar la primera mitad de los caracteres
            for (int i = 0; i < frecuencia / 2; i++) {
                mitadSecuencia.append(ch);
            }
        }

        // Agregar la segunda mitad de los caracteres y construir palíndromo completo
        StringBuilder palindrome = new StringBuilder(mitadSecuencia);
        if (charMediana != null) palindrome.append(charMediana);
        palindrome.append(new StringBuilder(mitadSecuencia).reverse());

        return palindrome.toString();
    }


    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingresa una línea con caracteres alfanuméricos: ");
            String stringEntrada = sc.nextLine();
            System.out.println(palindromoBuilder(stringEntrada));
        }
    }
}
