package kz.kbtu.informationcollector.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aibekkuralbaev on 20.12.2017.
 */

public class Sms {

    @SerializedName("body")
    private String body;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("type")
    private String type;

    @SerializedName("date")
    private String date;


    protected Sms() {}

    private Sms(String body, String phoneNumber, String type, String date) {
        this.body = body;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.date = date;
    }

    public String getBody() {
        return body;
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


    public static SmsBuilder builder(){
        return new SmsBuilder();
    }


    public static class SmsBuilder{

        private String body;
        private String phoneNumber;
        private String type;
        private String date;


        public SmsBuilder setBody(final String body) {
            this.body = body;
            return this;
        }

        public SmsBuilder setPhoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public SmsBuilder setType(final String type) {
            this.type = type;
            return this;
        }

        public SmsBuilder setDate(final String date) {
            this.date = date;
            return this;
        }

        public Sms build(){
            return new Sms(body, phoneNumber, type, date);
        }
    }
}
