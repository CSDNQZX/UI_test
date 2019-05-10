package com.mining.power.list.entity;

import java.io.Serializable;
import java.util.List;

public class DataSet2 {

    /**
     * message : 成功
     * state : 1
     * object : [{"tagInfoList":[{"id":"70344d5d7c1b4d2e968d3886d9d6813d","isNewRecord":false,"ctype":"16282","currency":"1","cperiod":"360","cprice":"137.78","cpower":"1","referenceYields":"35.66","dayYield":"0.0236","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"5000","state":"2","releaseTime":"2019-04-27 00:00:00","remark":"","remark1":""},{"id":"de70f526c4634405859833ca0928e87d","isNewRecord":false,"ctype":"16282","currency":"1","cperiod":"180","cprice":"83.5","cpower":"1","referenceYields":"23.99","dayYield":"0.0236","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"20","state":"1","releaseTime":"2019-04-09 00:00:00","remark":"","remark1":""}],"tagsId":"16282","tagsName":"GRIN"},{"tagInfoList":[{"id":"a42ff85d0f084c91b99c7fe8fbc2dad0","isNewRecord":false,"ctype":"16282","currency":"3","cperiod":"180","cprice":"83.5","cpower":"1","referenceYields":"100.13","dayYield":"0.0236","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"20","state":"2","releaseTime":"2019-04-27 00:00:00","remark":"","remark1":""},{"id":"c93276f2cd4c412eba1ab66c5bb1b4b9","isNewRecord":false,"ctype":"16282","currency":"3","cperiod":"540","cprice":"30","cpower":"1","referenceYields":"46.88","dayYield":"26.0783","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"30","state":"1","releaseTime":"2019-04-27 00:00:00","remark":"","remark1":""}],"tagsId":"16282","tagsName":"BEAM"}]
     */

    private String message;
    private int state;
    private List<ObjectBean> object;

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

    public List<ObjectBean> getObject() {
        return object;
    }

    public void setObject(List<ObjectBean> object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * tagInfoList : [{"id":"70344d5d7c1b4d2e968d3886d9d6813d","isNewRecord":false,"ctype":"16282","currency":"1","cperiod":"360","cprice":"137.78","cpower":"1","referenceYields":"35.66","dayYield":"0.0236","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"5000","state":"2","releaseTime":"2019-04-27 00:00:00","remark":"","remark1":""},{"id":"de70f526c4634405859833ca0928e87d","isNewRecord":false,"ctype":"16282","currency":"1","cperiod":"180","cprice":"83.5","cpower":"1","referenceYields":"23.99","dayYield":"0.0236","electricityfees":"0","seatfee":"0","boardingfee":"0","upkeep":"0","surplus":"20","state":"1","releaseTime":"2019-04-09 00:00:00","remark":"","remark1":""}]
         * tagsId : 16282
         * tagsName : GRIN
         */

        private String tagsId;
        private String tagsName;
        private List<TagInfoListBean> tagInfoList;

        public String getTagsId() {
            return tagsId;
        }

        public void setTagsId(String tagsId) {
            this.tagsId = tagsId;
        }

        public String getTagsName() {
            return tagsName;
        }

        public void setTagsName(String tagsName) {
            this.tagsName = tagsName;
        }

        public List<TagInfoListBean> getTagInfoList() {
            return tagInfoList;
        }

        public void setTagInfoList(List<TagInfoListBean> tagInfoList) {
            this.tagInfoList = tagInfoList;
        }

        public static class TagInfoListBean implements Serializable{

            /**
             * id : 70344d5d7c1b4d2e968d3886d9d6813d
             * isNewRecord : false
             * ctype : 16282
             * currency : 1
             * cperiod : 360
             * cprice : 137.78
             * cpower : 1
             * referenceYields : 35.66
             * dayYield : 0.0236
             * electricityfees : 0
             * seatfee : 0
             * boardingfee : 0
             * upkeep : 0
             * surplus : 5000
             * state : 2
             * releaseTime : 2019-04-27 00:00:00
             * remark :
             * remark1 :
             */

            private String id;
            private boolean isNewRecord;
            private String ctype;
            private String currency;
            private String cperiod;
            private String cprice;
            private String cpower;
            private String referenceYields;
            private String dayYield;
            private String electricityfees;
            private String seatfee;
            private String boardingfee;
            private String upkeep;
            private String surplus;
            private String state;
            private String releaseTime;
            private String minimum;
            private String maximum;

            private String remark;
            private String remark1;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getCtype() {
                return ctype;
            }

            public void setCtype(String ctype) {
                this.ctype = ctype;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getCperiod() {
                return cperiod;
            }

            public void setCperiod(String cperiod) {
                this.cperiod = cperiod;
            }

            public String getCprice() {
                return cprice;
            }

            public void setCprice(String cprice) {
                this.cprice = cprice;
            }

            public String getCpower() {
                return cpower;
            }

            public void setCpower(String cpower) {
                this.cpower = cpower;
            }

            public String getReferenceYields() {
                return referenceYields;
            }

            public void setReferenceYields(String referenceYields) {
                this.referenceYields = referenceYields;
            }

            public String getDayYield() {
                return dayYield;
            }

            public void setDayYield(String dayYield) {
                this.dayYield = dayYield;
            }

            public String getElectricityfees() {
                return electricityfees;
            }

            public void setElectricityfees(String electricityfees) {
                this.electricityfees = electricityfees;
            }

            public String getSeatfee() {
                return seatfee;
            }

            public void setSeatfee(String seatfee) {
                this.seatfee = seatfee;
            }

            public String getBoardingfee() {
                return boardingfee;
            }

            public void setBoardingfee(String boardingfee) {
                this.boardingfee = boardingfee;
            }

            public String getUpkeep() {
                return upkeep;
            }

            public void setUpkeep(String upkeep) {
                this.upkeep = upkeep;
            }

            public String getSurplus() {
                return surplus;
            }

            public void setSurplus(String surplus) {
                this.surplus = surplus;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getReleaseTime() {
                return releaseTime;
            }

            public void setReleaseTime(String releaseTime) {
                this.releaseTime = releaseTime;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getRemark1() {
                return remark1;
            }

            public void setRemark1(String remark1) {
                this.remark1 = remark1;
            }

            public String getMinimum() {
                return minimum;
            }

            public void setMinimum(String minimum) {
                this.minimum = minimum;
            }

            public String getMaximum() {
                return maximum;
            }

            public void setMaximum(String maximum) {
                this.maximum = maximum;
            }
        }
    }
}
