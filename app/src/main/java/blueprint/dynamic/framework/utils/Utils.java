package blueprint.dynamic.framework.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.View;

import com.dynamic.framework.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

import blueprint.dynamic.framework.model.cms_model.RootCms;

/**
 * Created by Techjini on 10/6/2016.
 */
public class Utils {

    private static AtomicInteger counter = new AtomicInteger();

    public static int getNextUniqueIndex() {
        return counter.getAndIncrement();
    }

    /**
     * Method to fetch the gradient drawable from a view, modify them and return the gradient drawable.
     *
     * @param context         context
     * @param backgroundColor background color to set to the gradient
     * @param borderColor     border color to set to the gradient
     * @param view
     * @return gradient drawable in which the background and border color has been set.
     */
    public static GradientDrawable getGradientDrawable(Context context, int backgroundColor, int borderColor, View view) {
        GradientDrawable drawable1 = (GradientDrawable) ((LayerDrawable) view.getBackground()).findDrawableByLayerId(R.id.shape_id);
        drawable1.setColor(backgroundColor);
        drawable1.setCornerRadius(context.getResources().getDimension(R.dimen.dimen_2_dp));
        drawable1.setStroke((int) context.getResources().getDimension(R.dimen.dimen_2_dp), borderColor);
        return drawable1;
    }

    /**
     * Method to read the file from assets folder
     *
     * @param fileName Name of the file to fetch
     * @param context  context
     * @return file content in string format.
     */
    public static String readJsonFromAssets(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_PRIVATE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }

    public static RootCms stringToCMSJSON(String string) {
        RootCms response = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readValue(string, RootCms.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static int getIdFromString(Context context, String sId) {
        if(sId != null && sId.isEmpty() == false) {
            return context.getResources().getIdentifier(sId,  "id", context.getPackageName());
        } else {
            return 0;
        }
    }

    private static ProgressDialog sProgressDialog = null;
    public static void showProgressDialog(final Context context, String msg) {
        removeProgressDialog();
        sProgressDialog = new ProgressDialog(context);

        if (!msg.isEmpty()) {
            SpannableString s = new SpannableString(msg);
            sProgressDialog.setMessage(s);
        }

        sProgressDialog.setCancelable(false);

        if (!((Activity) context).isFinishing()) {
            if (!sProgressDialog.isShowing()) {
                try {
                    sProgressDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Removes the progress dialog that is alreading being displayed.
     */
    public static void removeProgressDialog() {
        try {
            if (null != sProgressDialog && sProgressDialog.isShowing()) {
                sProgressDialog.dismiss();
            }
            sProgressDialog = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to convert dp to pixels.
     *
     * @param context Actvitiy context
     * @param dp      DP value that has to be converted to pixels
     * @return pixel values from the dp value
     */
    public static int pxTodp(Activity context, int px) {
        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float logicalDensity = metrics.density;
        return ((int) Math.ceil(px * logicalDensity));
    }

    /**
     * Method to convert dp to pixels.
     *
     * @param context Actvitiy context
     * @param sp      SP value that has to be converted to pixels
     * @return pixel values from the dp value
     */
    public static int spToPx(Context context, int sp) {
        /*DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, metrics);*/

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((sp * displayMetrics.density) + 0.5);

        /*DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(sp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;*/
    }
}
