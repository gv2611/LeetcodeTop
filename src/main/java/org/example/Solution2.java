package org.example;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import static java.util.stream.Collectors.joining;

import java.net.*;

import com.google.gson.*;


class Result {

    /*
     * Complete the 'weatherStation' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING keyword as parameter.
     * API URL:  https://jsonmock.hackerrank.com/api/weather/search?name={keyword}
     */

    public static List<String> weatherStation(String keyword) throws IOException {
        List<String> listOfCities = new ArrayList<>();
        JsonObject data = fetchJsonData(getUrl(keyword, 1));
        int total_pages = data.get("total_pages").getAsInt();
        System.out.println("Total pages : " + total_pages);
        ExecutorService executorService = Executors.newFixedThreadPool(total_pages);
        // Create a list to store the futures
        List<Future<JsonObject>> futures = new ArrayList<>();

        // Submit tasks for each page
        for (int page = 1; page < total_pages; page++) {
            final String currentPage = "https://jsonmock.hackerrank.com/api/weather/search?name=" + keyword + "&page=" + page;
            Callable<JsonObject> callableTask = () -> fetchJsonData(currentPage);
            futures.add(executorService.submit(callableTask));
        }

        // Process the completed tasks and retrieve the JSON objects
        for (Future<JsonObject> future : futures) {
            try {
                JsonObject jsonData = future.get();
                System.out.println("JSON Data: " + jsonData);
                listOfCities = getStringFromData(jsonData, listOfCities);

                // Process the JSON data as needed
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        // Shutdown the executor service
        executorService.shutdown();
        List<String> pageDataList = new ArrayList<>();
        return listOfCities;
    }

    public static List<String> getStringFromData(JsonObject jsonObject, List<String> listOfCities) {
        // Your JSON data as a JsonObject
        JsonArray dataArray = jsonObject.getAsJsonArray("data");
        StringBuilder resultBuilder = new StringBuilder();

        for (JsonElement element : dataArray) {
            JsonObject cityData = element.getAsJsonObject();
            String cityName = cityData.get("name").getAsString().split(" ")[0];
            String weather = cityData.get("weather").getAsString().split(" ")[0];
            String wind = cityData.get("status").getAsJsonArray().get(0).getAsString().split(": ")[1].replaceAll("\\D+", "");
            String humidity = cityData.get("status").getAsJsonArray().get(1).getAsString().split(": ")[1].replaceAll("\\D+", "");
            String cityDetails = cityName + " " + weather + " " + wind + " " + humidity;
            resultBuilder.append(cityDetails).append("\n");
            listOfCities.add(cityDetails);
        }

        String result = resultBuilder.toString().trim();
        return listOfCities;
    }

    public static String getUrl(String keyword, int page) {
        String url = "https://jsonmock.hackerrank.com/api/weather/search?name=" + keyword + "&page=" + page;
        return url;
    }

    public static JsonObject fetchJsonData(String apiUrl) throws IOException {
        // Create a URL object from the API URL string
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            Gson gson = new Gson();
            return gson.fromJson(response.toString(), JsonObject.class);
        } else {
            throw new IOException("Request failed with response code: " + responseCode);
        }
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String keyword = bufferedReader.readLine();
        String keyword = "a";
        List<String> result = Result.weatherStation(keyword);
        System.out.println(result);
//
//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
