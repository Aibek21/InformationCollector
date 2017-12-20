package kz.kbtu.informationcollector.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aibekkuralbaev on 20.12.2017.
 */

public class PhoneSettings {

    @SerializedName("locale")
    private String locale;

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("is_root")
    private boolean isRoot;

    @SerializedName("time")
    private String time;



    protected PhoneSettings() {}

    private PhoneSettings(String locale, String timezone, boolean isRoot, String time) {
        this.locale = locale;
        this.timezone = timezone;
        this.isRoot = isRoot;
        this.time = time;
    }

    public String getLocale() {
        return locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public boolean getIsRoot() {
        return isRoot;
    }

    public String getTime() {
        return time;
    }


    public static PhoneSettingsBuilder builder(){
        return new PhoneSettingsBuilder();
    }

    public static class PhoneSettingsBuilder{

        private String locale;
        private String timezone;
        private boolean isRoot;
        private String time;


        public PhoneSettingsBuilder setLocale(String locale) {
            this.locale = locale;
            return this;
        }

        public PhoneSettingsBuilder setTimezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public PhoneSettingsBuilder setIsRoot(boolean isRoot) {
            this.isRoot = isRoot;
            return this;
        }

        public PhoneSettingsBuilder setTime(String time) {
            this.time = time;
            return this;
        }


        public PhoneSettings build(){
            return new PhoneSettings(locale, timezone, isRoot, time);
        }
    }
}
