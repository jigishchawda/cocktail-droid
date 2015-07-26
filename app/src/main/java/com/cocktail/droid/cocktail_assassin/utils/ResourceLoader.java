package com.cocktail.droid.cocktail_assassin.utils;

import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class ResourceLoader {
    public static String loadRawResourceAsString(Resources resources, int resourceId) {
        InputStream inputStream = resources.openRawResource(resourceId);
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return writer.toString();
    }
}
