package ecnu.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lynn_ on 2018/1/25.
 */

public class Forecast {
    @SerializedName("date")
    public String data;
    @SerializedName("tmp")
    public Temperature temperature;
    @SerializedName("cond")
    public More more;

    public class Temperature{
        public String min;
        public String max;
    }
    public class More{
        @SerializedName("txt_d")
        public String info;
    }
}
