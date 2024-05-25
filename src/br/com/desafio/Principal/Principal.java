package br.com.desafio.Principal;

import br.com.desafio.Model.Moedas;
import br.com.desafio.Model.MoedasDisponiveis;
import br.com.desafio.Service.ConsumoAPI;
import com.google.gson.Gson;

import java.util.Scanner;

public class Principal {
    private final Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private Moedas moedas;
    private MoedasDisponiveis moedasDisponiveis;
    private final String ENDERECO = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "34359ce013cd534e3675d8e3";
    private final String API_INFO = "/latest/BRL";
    private final String CONVERSION_RATE = "/pair/"; // This will return the exchange rate from your base code to the other currency you supplied

    public void exibeMenu() {
        var json = consumo.obterDados(ENDERECO + API_KEY + API_INFO);
        Gson gson = new Gson();
        moedas = gson.fromJson(json, Moedas.class);
        System.out.println("Moedas disponíveis: ");
        moedas.conversion_rates().forEach((key, value) -> System.out.println(key));

        System.out.println();

        System.out.println("Digite a primeira moeda: ");
        String primeiraMoeda = leitura.nextLine();
        System.out.println("Digite a segunda moeda: ");
        String segundaMoeda = leitura.nextLine();

        var taxaDeConversaoJson = consumo.obterDados(ENDERECO + API_KEY + CONVERSION_RATE + primeiraMoeda + "/" + segundaMoeda);
        Moedas taxaDeConversao = gson.fromJson(taxaDeConversaoJson, Moedas.class);

        moedasDisponiveis = new MoedasDisponiveis(taxaDeConversao);

        System.out.println("Digite o valor a ser convertido: ");
        double valor = leitura.nextDouble();

        double valorConvertido = converterMoeda(valor, moedasDisponiveis.getConversionRate());

        System.out.println("Taxa de conversão: " + primeiraMoeda + " -> " + segundaMoeda + " (" + moedasDisponiveis.getConversionRate() + ")");
        System.out.printf("Valor convertido: %.2f %s = %.2f %s%n", valor, primeiraMoeda, valorConvertido, segundaMoeda);
    }

    public double converterMoeda(double valor, double taxaDeConversao) {
        return valor * taxaDeConversao;
    }
}
