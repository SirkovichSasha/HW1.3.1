package com.example.helthmonitor;

import java.util.Date;

public class PressureClass {
    private int upperPressure;
    private int lowPressure;
    private int puls;
    private boolean tachicardia;
    private String datePicker;

    public PressureClass(int upperPressure, int lowPressure, int puls, boolean tachicardia, String datePicker) {
        this.upperPressure = upperPressure;
        this.lowPressure = lowPressure;
        this.puls = puls;
        this.tachicardia = tachicardia;
        this.datePicker = datePicker;
    }

    public int getUpperPressure() {
        return upperPressure;
    }

    public void setUpperPressure(int upperPressure) {
        this.upperPressure = upperPressure;
    }

    public int getLowPressure() {
        return lowPressure;
    }

    public void setLowPressure(int lowPressure) {
        this.lowPressure = lowPressure;
    }

    public int getPuls() {
        return puls;
    }

    public void setPuls(int puls) {
        this.puls = puls;
    }

    public boolean isTachicardia() {
        return tachicardia;
    }

    public void setTachicardia(boolean tachicardia) {
        this.tachicardia = tachicardia;
    }

    public String getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(String datePicker) {
        this.datePicker = datePicker;
    }
}
