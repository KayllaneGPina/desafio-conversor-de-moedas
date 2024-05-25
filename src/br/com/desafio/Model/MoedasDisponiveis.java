package br.com.desafio.Model;

import java.util.Map;

public class MoedasDisponiveis {
    private String baseCode;
    private String targetCode;
    private Double conversionRate;
    private Map<String, Double> rates;
    private Double valor;

    public MoedasDisponiveis() {}

    public MoedasDisponiveis(Moedas moedas) {
        this.baseCode = moedas.base_code();
        this.targetCode = moedas.target_code();
        this.conversionRate = moedas.conversion_rate();
        this.rates = moedas.conversion_rates();
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "moeda1= " + baseCode + "\n"
                + "moeda2= " + targetCode + "\n"
                + "conversao= " + conversionRate + "\n"
                + "lista de moedas= " + rates + "\n"
                + "valor= " + valor;
    }
}
