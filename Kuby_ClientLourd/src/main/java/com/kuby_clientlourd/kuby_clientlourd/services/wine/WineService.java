package com.kuby_clientlourd.kuby_clientlourd.services.wine;

import com.kuby_clientlourd.kuby_clientlourd.api.Api;
import com.kuby_clientlourd.kuby_clientlourd.api.Endpoints;
import com.kuby_clientlourd.kuby_clientlourd.interfaces.wine.Wine;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WineService {

    public List<Wine> getAllWines() throws IOException {
        String jsonResponse = Api.get(Endpoints.GET_ALL_WINES.getPath());
        JSONArray jsonArray = new JSONArray(jsonResponse);
        List<Wine> wines = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            Wine wine = new Wine();
            wine.setId(obj.getInt("id"));

            wines.add(wine);
        }

        return wines;
    }

}
