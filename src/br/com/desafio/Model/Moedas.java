package br.com.desafio.Model;

import java.util.Map;

public record Moedas(Map<String, Double> conversion_rates, String base_code, String target_code, Double conversion_rate) {
}
