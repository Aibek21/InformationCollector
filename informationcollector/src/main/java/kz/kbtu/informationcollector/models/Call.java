package kz.kbtu.informationcollector.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aibekkuralbaev on 20.12.2017.
 */

public class Call {

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("type")
    private String type;

    @SerializedName("date")
    private String date;

    @SerializedName("duration")
    private String duration;


    protected Call() {}

    private Call(String phoneNumber, String type, String date, String duration) {
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.date = date;
        this.duration = duration;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getType() {
        return type;
    }


    public String getDate() {
        return date;
    }


    public String getDuration() {
        return duration;
    }


    public static CallBuilder builder(){
        return new CallBuilder();
    }




    public static class CallBuilder{

        private String phoneNumber;
        private String type;
        private String date;
        private String duration;

        public CallBuilder setPhoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CallBuilder setType(final String type) {
            this.type = type;
            return this;
        }

        public CallBuilder setDate(final String date) {
            this.date = date;
            return this;
        }

        public CallBuilder setDuration(final String duration) {
            this.duration = duration;
            return this;
        }

        public Call build(){
            return new Call(phoneNumber, type, date, duration);
        }
    }


}
