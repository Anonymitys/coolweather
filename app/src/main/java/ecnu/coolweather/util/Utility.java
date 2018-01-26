package ecnu.coolweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ecnu.coolweather.db.City;
import ecnu.coolweather.db.County;
import ecnu.coolweather.db.Province;
import ecnu.coolweather.gson.Weather;

/**
 * Created by lynn_ on 2018/1/25.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces=new JSONArray(response);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObjrct=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObjrct.getString("name"));
                    province.setProvinceCode((provinceObjrct.getInt("id")));
                    province.save();
                }
                return true;
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String resppnse,int provinceId){
        if(!TextUtils.isEmpty(resppnse)){
            try{
                JSONArray allCitys=new JSONArray(resppnse);
                for(int i=0;i<allCitys.length();i++){
                    JSONObject cityObject=allCitys.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties=new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject countyObect=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObect.getString("name"));
                    county.setWeatherId(countyObect.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
