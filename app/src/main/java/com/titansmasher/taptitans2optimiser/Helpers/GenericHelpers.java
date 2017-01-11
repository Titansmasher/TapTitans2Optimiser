package com.titansmasher.taptitans2optimiser.Helpers;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.titansmasher.taptitans2optimiser.OptimiserApp;
import com.titansmasher.taptitans2optimiser.R;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Danny on 15/11/2016.
 */

public class GenericHelpers {
    public static InputStreamReader getAssetReader(String asset) {
        try {
            return new InputStreamReader(OptimiserApp.application.getAssets().open(asset), "UTF-8");
        } catch (IOException ex) {
            return new InputStreamReader(new ByteArrayInputStream("".getBytes()));
        }
    }

    public static List<CSVRecord> parseCSV(Reader data) {
        try {
            return CSVFormat.RFC4180.withFirstRecordAsHeader().parse(data).getRecords();
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }

    public static boolean areAllTheSame(int[] array) {
        for (int item :
                array) {
            if (item != array[0]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInteger(String s) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), 10) < 0) return false;
        }
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static Drawable drawableFromAttr(int attrId, Resources.Theme theme, Resources resources) {
        TypedArray a = theme.obtainStyledAttributes(R.style.AppTheme, new int[]{attrId});
        int attributeResourceId = a.getResourceId(0, 0);
        return resources.getDrawable(attributeResourceId);
    }

    public static String secondsToTime(int seconds) {
        int hours = (int) Math.floor(seconds / 3600);
        int minutes = (int) Math.floor((seconds % 3600) / 60);
        int absseconds = seconds % 60;
        return hours + ":" + padString(Integer.toString(minutes), '0', 2) + ":" + padString(Integer.toString(absseconds), '0', 2);
    }

    public static String padString(String text, char padder, int length) {
        for (int i = text.length(); i < length; i++) {
            text = padder + text;
        }

        return text;
    }

    public static String boolToYesNoString(boolean bool) {
        return bool ? "Yes" : "No";
    }

    public static String formatDate(String format, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date parseDateSafe(String format, String value) {
        try {
            return new SimpleDateFormat(format).parse(value);
        } catch (ParseException ex) {
            return new Date(0);
        } catch (NullPointerException ex) {
            return new Date(0);
        }
    }

    public static String beautify(double value) {
        int magnitude = (int) Math.floor(Math.log10(value));
        String[] suffixes = new String[]{"", "K", "M", "B", "T", "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"};
        String returnString;
        DecimalFormat format = new DecimalFormat("#.###");
        int index = (int) Math.floor(magnitude / 3);
        if (suffixes.length > index && index >= 1) {
            returnString = format.format(value / Math.pow(10, index * 3));
            returnString = returnString + suffixes[index];
        } else if (index >= 1) {
            returnString = Double.toString(value);
            returnString = format.format(Double.parseDouble(returnString.substring(0, returnString.indexOf('E')))) + returnString.substring(returnString.indexOf('E'));
        } else {
            return "0";
        }

        return returnString;
    }

    public static int min(Collection<Integer> col) {
        int min = (int) col.toArray()[0];
        for (int i :
                col) {
            if (i < min)
                min = i;
        }
        return min;
    }

    public static int sum(Collection<Integer> vals) {
        int returnval = 0;
        for (Integer val
                : vals) {
            returnval += val;
        }

        return returnval;
    }

    public static UUID parseUUIDSafe(String text) {
        try {
            return UUID.fromString(text);
        } catch (Exception ex) {
            return new UUID(0, 0);
        }
    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth() + 6, view.getHeight() + 6, Bitmap.Config.ARGB_8888);
        returnedBitmap.eraseColor(Color.BLACK);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.translate(3, 3);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        view.draw(canvas);

        return returnedBitmap;
    }

    public static Bitmap getBitmapFromView(View view, float scaleFactor) {
        Bitmap bitmap = getBitmapFromView(view);
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * scaleFactor), (int) (bitmap.getHeight() * scaleFactor), true);
    }

    public static Bitmap getBitmapFromView(View view, int width, int height) {
        Bitmap bitmap = getBitmapFromView(view);
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    public static int parseIntDefault(String text, int defaultVal) {
        try {
            return Integer.parseInt(text);
        } catch (Exception ex) {
            return defaultVal;
        }
    }
}
