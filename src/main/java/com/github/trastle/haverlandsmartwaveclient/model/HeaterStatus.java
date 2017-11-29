package com.github.trastle.haverlandsmartwaveclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeaterStatus {

    // 5 degrees C is the hard coded anti freeze temp.
    public static final int ANTI_FREEZE_TEMP_CELCIUS = 5;

    public enum SelectedTemp {
        @JsonProperty("ice")
        ICE,
        @JsonProperty("eco")
        ECO,
        @JsonProperty("comfort")
        COMFORT
    }

    public enum Mode {
        @JsonProperty("presence")
        PRESENCE,
        @JsonProperty("self_learn")
        SELF_LEARN,
        @JsonProperty("auto")
        AUTO,
        @JsonProperty("manual")
        MANUAL
    }

    @JsonProperty("sync_status")
    private String syncStatus;

    @JsonProperty("on")
    private boolean isOn;

    @JsonProperty("mode")
    private Mode mode;

    @JsonProperty("selected_temp")
    private SelectedTemp selectedTemp;

    @JsonProperty("units")
    private String units;

    @JsonProperty("comfort_temp")
    private long comfortTemp;

    @JsonProperty("eco_offset")
    private long ecoOffset;

    @JsonProperty("mtemp")
    private long measuredTemp;

    // Is the heater currently heating
    @JsonProperty("active")
    private boolean isActive;

    @JsonProperty("locked")
    private boolean isLocked;

    @JsonProperty("presence")
    private boolean hasPresence;

    @JsonProperty("unit_model")
    private String unitModel;

    @JsonProperty("unit_fw")
    private String unitFirmware;

    @JsonProperty("uart_error")
    private boolean uartError;

    public String getSyncStatus() {
        return syncStatus;
    }

    public boolean isOn() {
        return isOn;
    }

    public Mode getMode() {
        return mode;
    }

    public SelectedTemp getSelectedTemp() {
        return selectedTemp;
    }

    public String getUnits() {
        return units;
    }

    public long getComfortTemp() {
        return comfortTemp;
    }

    public long getEcoOffset() {
        return ecoOffset;
    }

    public long getMeasuredTemp() {
        return measuredTemp;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean isHasPresence() {
        return hasPresence;
    }

    public String getUnitModel() {
        return unitModel;
    }

    public String getUnitFirmware() {
        return unitFirmware;
    }

    public boolean isUartError() {
        return uartError;
    }

    public long calculateTargetTemperature() {

        if (SelectedTemp.COMFORT.equals(this.selectedTemp)) {
            return this.comfortTemp;
        }

        if (SelectedTemp.ECO.equals(this.selectedTemp)) {
            return this.comfortTemp - this.ecoOffset;
        }

        if (SelectedTemp.ICE.equals(this.selectedTemp)) {
            return ANTI_FREEZE_TEMP_CELCIUS;
        }

        return this.comfortTemp;
    }

    @Override
    public String toString() {
        return "HeaterStatus{" +
                "syncStatus='" + syncStatus + '\'' +
                ", isOn=" + isOn +
                ", mode='" + mode + '\'' +
                ", selectedTemp='" + selectedTemp + '\'' +
                ", units='" + units + '\'' +
                ", comfortTemp=" + comfortTemp +
                ", ecoOffset=" + ecoOffset +
                ", measuredTemp=" + measuredTemp +
                ", isActive=" + isActive +
                ", isLocked=" + isLocked +
                ", hasPresence=" + hasPresence +
                ", unitModel='" + unitModel + '\'' +
                ", unitFirmware='" + unitFirmware + '\'' +
                ", uartError=" + uartError +
                '}';
    }
}
