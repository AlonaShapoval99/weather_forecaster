package com.nix.shapoval.weather_forecaster.process;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherIntegration {
        private static final String END_POINT = "http://api.openweathermap.org/data/2.5/weather?q=";
        private static final String API_ID = "&appid=7726dc6c3808b7bb55f33d462311be29";
        private static final String GET_CELSIUS = "&units=metric";



        public double fetch(String location) {
            try {
                String apiUrl = END_POINT + location + API_ID + GET_CELSIUS;
                URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(
                        new InputStreamReader(conn.getInputStream(), "UTF-8"));
                conn.disconnect();
                return retrieveTemperature(jsonObject);


            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return 0.0;
        }

        private double retrieveTemperature(JSONObject jsonObject) {
            JSONObject jsonObject1 = (JSONObject) jsonObject.get("main");
            return Double.parseDouble
                    (jsonObject1.get("temp").toString());
        }


}
