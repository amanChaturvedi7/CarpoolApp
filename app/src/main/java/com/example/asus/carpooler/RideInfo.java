package com.example.asus.carpooler;

public class RideInfo {

    private String rideId, source, destination, rideDate, rideTime, rideVehicle;

    public  RideInfo(){

    }

    public RideInfo(String rideId, String source, String destination, String rideDate, String rideTime, String rideVehicle) {
        this.rideId = rideId;
        this.source = source;
        this.destination = destination;
        this.rideDate = rideDate;
        this.rideTime = rideTime;
        this.rideVehicle = rideVehicle;
    }

    public String getRideId() {
        return rideId;
    }

    public String getSrc() {
        return source;
    }

    public String getDest() {
        return destination;
    }

    public String getDate() {
        return rideDate;
    }

    public String getTime() {
        return rideTime;
    }

    public String getVeh() {
        return rideVehicle;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setRideDate(String rideDate) {
        this.rideDate = rideDate;
    }

    public void setRideTime(String rideTime) {
        this.rideTime = rideTime;
    }

    public void setRideVehicle(String rideVehicle) {
        this.rideVehicle = rideVehicle;
    }
}
