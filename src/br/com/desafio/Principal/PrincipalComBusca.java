package br.com.desafio.Principal;

import br.com.desafio.Moedas;
import br.com.desafio.MoedasDisponiveis;
import br.com.desafio.Service.ConsumoAPI;
import com.google.gson.Gson;


import java.util.Scanner;

public class PrincipalComBusca {
    private final Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private MoedasDisponiveis moedasDisponiveis = new MoedasDisponiveis();
    private final String ENDERECO = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "34359ce013cd534e3675d8e3";
    private final String API_INFO = "/latest/BRL";
    private final String CONVERSION_RATE = "/pair/"; // This will return the exchange rate from your base code to the other currency you supplied

    public void exibeMenu() {
        var json = consumo.obterDados(ENDERECO + API_KEY + API_INFO);
        System.out.println(json);
        Gson gson = new Gson();
        Moedas moedas = gson.fromJson(json, Moedas.class);
        System.out.println("Moedas disponíveis: ");
        moedas.conversion_rates().forEach((key, value) -> System.out.println(key));

        System.out.println();

        System.out.println("Digite a primeira moeda: ");
        String primeiraMoeda = leitura.nextLine();
        System.out.println("Digite a segunda moeda: ");
        String segundaMoeda = leitura.nextLine();

        var taxaDeConversao = consumo.obterDados(ENDERECO + API_KEY + CONVERSION_RATE + primeiraMoeda + "/" + segundaMoeda);

        moedas = gson.fromJson(taxaDeConversao, Moedas.class);
        var valores = new MoedasDisponiveis(moedas);
        System.out.println("Taxa de conversão: " + primeiraMoeda + " -> " + segundaMoeda + " (" + valores.getConversionRate() + ")");

    }
}
