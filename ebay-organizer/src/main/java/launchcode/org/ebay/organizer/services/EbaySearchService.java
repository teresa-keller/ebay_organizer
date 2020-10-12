package launchcode.org.ebay.organizer.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class EbaySearchService {

        public Query getQuery() throws IOException {
            URL url = new URL("https://svcs.ebay.com/services/search/FindingService/v1?OPERATION-NAME=findItemsByKeywords&SERVICE-VERSION=1.0.0&SECURITY-APPNAME=TeresaKe-OnlineSe-SBX-ee6527e18-912e5ec6&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&keywords=harry%20potter%20phoenix");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                content.append(inputLine);
            }

            reader.close();
            connection.disconnect();

            String queryJson = content.toString();

            Gson gson = new Gson();
            Query query = gson.fromJson(queryJson, Query.class);

            return query;
        }

        public QuerySearch searchQuery(String searchString) throws IOException {
            URL url = new URL("https://icanhazdadjoke.com/search?term=" + searchString);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                content.append(inputLine);
            }

            String queryJson = content.toString();

            reader.close();
            connection.disconnect();

            Gson gson = new Gson();
         QuerySearch searchResults = gson.fromJson(queryJson, QuerySearch.class);

            return searchResults;
        }
    }

