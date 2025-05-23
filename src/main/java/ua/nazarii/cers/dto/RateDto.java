package ua.nazarii.cers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ua.nazarii.cers.utils.LocalDateTimeSerializer;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class RateDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "exchanger_id")
    private Integer exchangerId;

    @JsonProperty(value = "unit")
    private Integer unit;

    @JsonProperty(value = "unit_currency_alphabetic_code")
    private String unitCurrencyAlphabeticCode;

    @JsonProperty(value = "rate_currency_alphabetic_code")
    private String rateCurrencyAlphabeticCode;

    @JsonProperty(value = "buy_rate")
    private Double buyRate;

    @JsonProperty(value = "sale_rate")
    private Double saleRate;

    @JsonProperty(value = "created_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;

    public RateDto() {
        //
    }

    public RateDto(
            Integer exchangerId,
            Integer unit,
            String unitCurrencyAlphabeticCode,
            String rateCurrencyAlphabeticCode,
            Double buyRate,
            Double saleRate
    ) {
        this.exchangerId = exchangerId;
        this.unit = unit;
        this.unitCurrencyAlphabeticCode = unitCurrencyAlphabeticCode;
        this.rateCurrencyAlphabeticCode = rateCurrencyAlphabeticCode;
        this.buyRate = buyRate;
        this.saleRate = saleRate;

        LocalDateTime createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MICROS);

        this.createdAt = createdAt;
    }

    public RateDto(
            Integer exchangerId,
            Integer unit,
            String unitCurrencyAlphabeticCode,
            String rateCurrencyAlphabeticCode,
            Double buyRate,
            Double saleRate,
            LocalDateTime createdAt
    ) {
        this.exchangerId = exchangerId;
        this.unit = unit;
        this.unitCurrencyAlphabeticCode = unitCurrencyAlphabeticCode;
        this.rateCurrencyAlphabeticCode = rateCurrencyAlphabeticCode;
        this.buyRate = buyRate;
        this.saleRate = saleRate;
        this.createdAt = LocalDateTime.from(createdAt).truncatedTo(ChronoUnit.MICROS);
    }

    public Integer getExchangerId() {
        return this.exchangerId;
    }

    public Integer getUnit() {
        return this.unit;
    }

    public String getUnitCurrencyAlphabeticCode() {
        return this.unitCurrencyAlphabeticCode;
    }

    public String getRateCurrencyAlphabeticCode() {
        return this.rateCurrencyAlphabeticCode;
    }

    public Double getBuyRate() {
        return this.buyRate;
    }

    public Double getSaleRate() {
        return this.saleRate;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setExchangerId(Integer exchangerId) {
        this.exchangerId = exchangerId;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public void setUnitCurrencyAlphabeticCode(String unitCurrencyAlphabeticCode) {
        this.unitCurrencyAlphabeticCode = unitCurrencyAlphabeticCode;
    }

    public void setRateCurrencyAlphabeticCode(String rateCurrencyAlphabeticCode) {
        this.rateCurrencyAlphabeticCode = rateCurrencyAlphabeticCode;
    }

    public void setBuyRate(Double buyRate) {
        this.buyRate = buyRate;
    }

    public void setSaleRate(Double saleRate) {
        this.saleRate = saleRate;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = LocalDateTime.from(createdAt).truncatedTo(ChronoUnit.MICROS);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        RateDto rateDto = (RateDto) obj;

        return Objects.equals(this.exchangerId, rateDto.getExchangerId())
                && Objects.equals(this.unit, rateDto.getUnit())
                && Objects.equals(this.unitCurrencyAlphabeticCode, rateDto.getUnitCurrencyAlphabeticCode())
                && Objects.equals(this.rateCurrencyAlphabeticCode, rateDto.getRateCurrencyAlphabeticCode())
                && Objects.equals(this.buyRate, rateDto.getBuyRate())
                && Objects.equals(this.saleRate, rateDto.getSaleRate())
                && Objects.equals(this.createdAt, rateDto.getCreatedAt());
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + (this.exchangerId == null ? 0 : this.exchangerId.hashCode());
        result = 31 * result + (this.unit == null ? 0 : this.unit.hashCode());
        result = 31 * result + (this.unitCurrencyAlphabeticCode == null ? 0 : this.unitCurrencyAlphabeticCode.hashCode());
        result = 31 * result + (this.rateCurrencyAlphabeticCode == null ? 0 : this.rateCurrencyAlphabeticCode.hashCode());
        result = 31 * result + (this.buyRate == null ? 0 : this.buyRate.hashCode());
        result = 31 * result + (this.saleRate == null ? 0 : this.saleRate.hashCode());
        result = 31 * result + (this.createdAt == null ? 0 : this.createdAt.hashCode());

        return result;
    }
}