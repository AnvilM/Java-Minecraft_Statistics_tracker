package anvilm.minecraft.stats.stats.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class http {
    public static void get(String url) {
        String stuff;
        stuff = "";
        try {
            URL url1 = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(url1.openStream()));
            String str = in.readLine();
            in.close();
            if (str != null) {
                stuff = str;
            }
        }
        catch (java.io.IOException e1) {
            stuff = e1.getMessage();
        }
    }
}
