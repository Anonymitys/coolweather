package ecnu.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lynn_ on 2018/1/25.
 */

public class AQI {
    @SerializedName("city")
    public AQICity aqiCity;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
