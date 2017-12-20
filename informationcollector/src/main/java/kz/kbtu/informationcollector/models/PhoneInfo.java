package kz.kbtu.informationcollector.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aibekkuralbaev on 20.12.2017.
 */

public class PhoneInfo {

    @SerializedName("hardware_info")
    private HardwareInfo mHardwareInfo;

    @SerializedName("phone_settings")
    private PhoneSettings mPhoneSettings;

    @SerializedName("sms_list")
    private List<Sms> mSmsList;

    @SerializedName("call_list")
    private List<Call> mCallList;

    @SerializedName("app_list")
    private List<String> mAppList;


    protected PhoneInfo() {}

    private PhoneInfo(HardwareInfo hardwareInfo, PhoneSettings phoneSettings, List<Sms> smsList, List<Call> callList, List<String> appList) {
        mHardwareInfo = hardwareInfo;
        mPhoneSettings = phoneSettings;
        mSmsList = smsList;
        mCallList = callList;
        mAppList = appList;
    }

    public HardwareInfo getHardwareInfo() {
        return mHardwareInfo;
    }

    public PhoneSettings getPhoneSettings() {
        return mPhoneSettings;
    }

    public List<Sms> getSmsList() {
        return mSmsList;
    }

    public List<Call> getCallList() {
        return mCallList;
    }

    public List<String> getAppList() {
        return mAppList;
    }


    public static PhoneInfoBuilder builder(){
        return new PhoneInfoBuilder();
    }

    public static class PhoneInfoBuilder{

        private HardwareInfo mHardwareInfo;
        private PhoneSettings mPhoneSettings;
        private List<Sms> mSmsList;
        private List<Call> mCallList;
        private List<String> mAppList;


        public PhoneInfoBuilder setHardwareInfo(HardwareInfo hardwareInfo) {
            mHardwareInfo = hardwareInfo;
            return this;
        }

        public PhoneInfoBuilder setPhoneSettings(PhoneSettings phoneSettings) {
            mPhoneSettings = phoneSettings;
            return this;
        }

        public PhoneInfoBuilder setSmsList(List<Sms> smsList) {
            mSmsList = smsList;
            return this;
        }

        public PhoneInfoBuilder setCallList(List<Call> callList) {
            mCallList = callList;
            return this;
        }

        public PhoneInfoBuilder setAppList(List<String> appList) {
            mAppList = appList;
            return this;
        }

        public PhoneInfo build(){
            return new PhoneInfo(mHardwareInfo, mPhoneSettings, mSmsList, mCallList, mAppList);
        }
    }
}
