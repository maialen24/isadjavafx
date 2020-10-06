package ehu.isad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.Gson;

public class Txanpona {

    int trade_id;
    float price;
    float size;
    String time;
    float bid;
    float ask;
    float volume;

    @Override
    public String toString() {
        return "Txanpona{" +
                "trade_id=" + trade_id +
                ", price=" + price +
                ", size=" + size +
                ", time='" + time + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", volume=" + volume +
                '}';
    }

}
