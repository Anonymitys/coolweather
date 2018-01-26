package ecnu.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lynn_ on 2018/1/25.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;

    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
