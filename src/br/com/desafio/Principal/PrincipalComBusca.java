package br.com.desafio.Principal;

import br.com.desafio.Service.ConsumoAPI;

import java.util.Scanner;

public class PrincipalComBusca {
    private final Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private final String ENDERECO = "https://v6.exchangerate-api.com/v6/";
//    private final String API_KEY = "34359ce013cd534e3675d8e3/latest/BRL";
    private final String API_KEY = "34359ce013cd534e3675d8e3/pair/GBP/EUR"; //    -> This will return the exchange rate from your base code to the other currency you supplied

    public void exibeMenu() {
        System.out.println("Aqui estão as moedas disponíveis: ");

        var json = consumo.obterDados(ENDERECO + API_KEY);
        System.out.println(json);
    }
}
