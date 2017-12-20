package kz.kbtu.informationcollector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.CallLog;
import android.provider.Telephony;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import kz.kbtu.informationcollector.models.Call;
import kz.kbtu.informationcollector.models.HardwareInfo;
import kz.kbtu.informationcollector.models.PhoneInfo;
import kz.kbtu.informationcollector.models.PhoneSettings;
import kz.kbtu.informationcollector.models.Sms;


/**
 * Created by aibekkuralbaev on 20.12.2017.
 */

public class InformationCollector {

    static Context sContext;
    static Activity sActivity;

    public static PhoneInfo getInfo(Context context){
        sContext = context;
        sActivity = (Activity) context;


        return PhoneInfo.builder()
                .setHardwareInfo(getHardwareInfo())
                .setPhoneSettings(getPhoneSettings())
                .setAppList(getAppList())
                .setCallList(getCallList())
                .setSmsList(getSmsList())
                .build();
    }



    private static PhoneSettings getPhoneSettings() {
        String locale = Locale.getDefault().getLanguage();
        String timeZone = TimeZone.getDefault().getID();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        return PhoneSettings.builder()
                .setIsRoot(RootUtil.isDeviceRooted())
                .setLocale(locale).setTimezone(timeZone)
                .setTime(dateFormat.format(date))
                .build();
    }

    private static List<String> getAppList() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pkgAppsList = sContext.getPackageManager().queryIntentActivities(mainIntent, 0);

        Log.e("Size", pkgAppsList.size() + "");

        List<String> appList = new ArrayList<>();
        for (ResolveInfo info : pkgAppsList) {
            appList.add(info.activityInfo.packageName);
        }

        return appList;
    }

    private static HardwareInfo getHardwareInfo() {
        return HardwareInfo.builder()
                .setSerialNumber(Build.SERIAL)
                .setModel(Build.MODEL)
                .setId(Build.ID)
                .setManufacturer(Build.MANUFACTURER)
                .setBrand(Build.BRAND)
                .setType(Build.TYPE)
                .setUser(Build.USER)
                .setCodeBase(Build.VERSION_CODES.BASE)
                .setVersionIncremental(Build.VERSION.INCREMENTAL)
                .setVersionSdk(Build.VERSION.SDK)
                .setBoard(Build.BOARD)
                .setHost(Build.HOST)
                .setFingerprint(Build.FINGERPRINT)
                .setVersionRelease(Build.VERSION.RELEASE)
                .build();
    }

    private static List<Sms> getSmsList() {


        String[] smsTypes = {"inbox", "sent", "draft", "failed", "outbox"};
        List<Sms> smsList = new ArrayList<>();
        for (String smsType : smsTypes) {
            Cursor cur = sContext.getContentResolver().query(Uri.parse("content://sms/" + smsType), null, null, null, null);

            if (cur.moveToFirst()) { /* false = no sms */
                do {
                    String body = cur.getString(cur.getColumnIndexOrThrow(Telephony.Sms.BODY));
                    String phoneNumber = cur.getString(cur.getColumnIndexOrThrow(Telephony.Sms.ADDRESS));
                    String smsDate = cur.getString(cur.getColumnIndexOrThrow(Telephony.Sms.DATE));
                    String type = cur.getString(cur.getColumnIndexOrThrow(Telephony.Sms.TYPE));

                    Date callDayTime = new Date(Long.valueOf(smsDate));
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


                    int dircode = Integer.parseInt(type);
                    String dir = "";

                    switch (dircode) {
                        case Telephony.Sms.MESSAGE_TYPE_INBOX:
                            dir = "INBOX";
                            break;

                        case Telephony.Sms.MESSAGE_TYPE_SENT:
                            dir = "SENT";
                            break;

                        case Telephony.Sms.MESSAGE_TYPE_DRAFT:
                            dir = "DRAFT";
                            break;

                        case Telephony.Sms.MESSAGE_TYPE_FAILED:
                            dir = "FAILED";
                            break;

                        case Telephony.Sms.MESSAGE_TYPE_OUTBOX:
                            dir = "OUTBOX";
                            break;

                    }

                    Sms sms = Sms.builder()
                            .setPhoneNumber(phoneNumber)
                            .setDate(sdf.format(callDayTime))
                            .setBody(body)
                            .setType(dir)
                            .build();

                    smsList.add(sms);
                } while (cur.moveToNext());
            }
            cur.close();
        }

        return smsList;
    }

    private static List<Call> getCallList() {

        Cursor managedCursor = sActivity.managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);

        List<Call> callList = new ArrayList<>();
        while (managedCursor.moveToNext()) {
            String phNumber = managedCursor.getString(number);
            String callType = managedCursor.getString(type);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


            String callDuration = managedCursor.getString(duration);
            String dir = null;
            int dircode = Integer.parseInt(callType);


            switch (dircode) {
                case CallLog.Calls.OUTGOING_TYPE:
                    dir = "OUTGOING";
                    break;

                case CallLog.Calls.INCOMING_TYPE:
                    dir = "INCOMING";
                    break;

                case CallLog.Calls.MISSED_TYPE:
                    dir = "MISSED";
                    break;

                case CallLog.Calls.REJECTED_TYPE:
                    dir = "REJECTED";
                    break;

                case CallLog.Calls.BLOCKED_TYPE:
                    dir = "BLOCKED";
                    break;

                case CallLog.Calls.VOICEMAIL_TYPE:
                    dir = "VOICEMAIL";
                    break;

                case CallLog.Calls.ANSWERED_EXTERNALLY_TYPE:
                    dir = "ANSWERED_EXTERNALLY";
                    break;
            }

            Call call = Call.builder()
                    .setPhoneNumber(phNumber)
                    .setDate(sdf.format(callDayTime))
                    .setDuration(callDuration)
                    .setType(dir)
                    .build();


            callList.add(call);
        }
        managedCursor.close();
        return callList;
    }
}
