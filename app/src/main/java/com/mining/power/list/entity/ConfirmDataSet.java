package com.mining.power.list.entity;

import java.util.List;

public class ConfirmDataSet {

    /**
     * message : 成功
     * state : 1
     * object : [{"tagInfoList":[{"id":"70344d5d7c1b4d2e968d3886d9d6813d","isNewRecord":false,"ctype":"16282","currency":"1","cperiod":"360","cprice":"137.78","cpower":"1","referenceYields":"35.66","dayYield":"0.0236","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"5000","state":"2","releaseTime":"2019-04-27 00:00:00","remark":"","remark1":""},{"id":"de70f526c4634405859833ca0928e87d","isNewRecord":false,"ctype":"16282","currency":"1","cperiod":"180","cprice":"83.5","cpower":"1","referenceYields":"23.99","dayYield":"0.0236","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"20","state":"1","releaseTime":"2019-04-09 00:00:00","remark":"","remark1":""}],"tagsId":"16282","tagsName":"GRIN"},{"tagInfoList":[{"id":"a42ff85d0f084c91b99c7fe8fbc2dad0","isNewRecord":false,"ctype":"16282","currency":"3","cperiod":"180","cprice":"83.5","cpower":"1","referenceYields":"100.13","dayYield":"0.0236","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"20","state":"2","releaseTime":"2019-04-27 00:00:00","remark":"","remark1":""},{"id":"c93276f2cd4c412eba1ab66c5bb1b4b9","isNewRecord":false,"ctype":"16282","currency":"3","cperiod":"540","cprice":"30","cpower":"1","referenceYields":"46.88","dayYield":"26.0783","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"30","state":"1","releaseTime":"2019-04-27 00:00:00","remark":"","remark1":""}],"tagsId":"16282","tagsName":"BEAM"}]
     */
    private String message;
    private int state;
    private List<Purchasingpower> object;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<Purchasingpower> getObject() {
        return object;
    }

    public void setObject(List<Purchasingpower> object) {
        this.object = object;
    }
}
