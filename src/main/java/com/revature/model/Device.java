package com.revature.model;

import java.util.Objects;

public class Device {
    private int deviceId;
    private String deviceType;

    public Device(int deviceId, String deviceType) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return deviceId == device.deviceId && Objects.equals(deviceType, device.deviceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceType);
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }
}
