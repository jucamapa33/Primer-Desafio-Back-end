import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    static double cantidad = 0;
    static double resultado = 0;
    static int opcion = 0;
    static String divisa = "USD";
    public static void main(String[] args) throws IOException {


       ConsultaDeMonedas objTipoMoneda = new ConsultaDeMonedas();
      Plata money = objTipoMoneda.consulta(divisa);

        var df = new DecimalFormat("#.00");

        Scanner scan = new Scanner(System.in);

        while (opcion != 7){
            System.out.println("*************************************************");
            System.out.println("**** Bienvanidos(as) al Conversor de monedas ****");
            System.out.println("""
                    1** dolar --> pesos Brgentino
                    2** pesos argentino --> dolar
                    3** dolar --> real Brasileño
                    4** real Brasileño --> dolar
                    5** dolar --> pesos Colombiano
                    6** pesos Colombiano --> dolar
                    7** salir""");
            System.out.println(" elige la operacion a realizar");
            System.out.println("*************************************************");

            opcion = scan.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("ingrese la cantidad a convertir");
                    cantidad = scan.nextDouble();
                    resultado = cantidad * money.ARS();
                    System.out.println("la cantidad de :"+cantidad+" USD equivale a :"+df.format(resultado)+" ARS");
                    System.out.println("operacion exitosa");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("ingrese la cantidad a convertir");
                    cantidad = scan.nextDouble();
                    resultado = cantidad / money.ARS();
                    System.out.println("la cantidad de :"+cantidad+" ARS equivale a :"+df.format(resultado)+" USD");
                    System.out.println("operacion exitosa");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("ingrese la cantidad a convertir");
                    cantidad = scan.nextDouble();
                    resultado = cantidad * money.BRL();
                    System.out.println("la cantidad de :"+cantidad+" USD equivale a :"+df.format(resultado)+" BRL");
                    System.out.println("operacion exitosa");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("ingrese la cantidad a convertir");
                    cantidad = scan.nextDouble();
                    resultado = cantidad / money.BRL();
                    System.out.println("la cantidad de :"+cantidad+" BRL equivale a :"+df.format(resultado)+" USD");
                    System.out.println("operacion exitosa");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("ingrese la cantidad a convertir");
                    cantidad = scan.nextDouble();
                    resultado = cantidad * money.COP();
                    System.out.println("la cantidad de :"+cantidad+" USD equivale a :"+df.format(resultado)+" COP");
                    System.out.println("operacion exitosa");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("ingrese la cantidad a convertir");
                    cantidad = scan.nextDouble();
                    resultado = cantidad / money.COP();
                    System.out.println("la cantidad de :"+cantidad+" COP equivale a :"+df.format(resultado)+" USD");
                    System.out.println("operacion exitosa");
                    System.out.println();
                    break;
                default:

            }

        }

        System.out.println("gracias por utilizar nuestros servicios");
    }

}
