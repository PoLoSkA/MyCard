package ru.polosatuk.mycard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

public class ThirdPartyIntentUtils {
    private static final String PHONE_NUMBER = "+79653811975";
    private static final String SMS_TYPE = "smsto:";
    private static final String SMS_BODY_EXTRA = "sms_body";

    private ThirdPartyIntentUtils() {
    }

    public static Intent getSmsIntent(@NonNull Context context,
                                      @NonNull String message) {

        Uri smsInfo = Uri.parse(SMS_TYPE + PHONE_NUMBER);
        Intent intent = new Intent(Intent.ACTION_VIEW, smsInfo);
        intent.putExtra(SMS_BODY_EXTRA, message);
        if (intent.resolveActivity(context.getPackageManager()) != null)
            return intent;
        else {
            return null;
        }
    }

    public static Intent getGoToBrowser(@NonNull Context context,
                                        @NonNull String link) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        } else {
            return null;
        }
    }

}