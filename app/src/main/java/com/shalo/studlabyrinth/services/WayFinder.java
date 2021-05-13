package com.shalo.studlabyrinth.services;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.shalo.studlabyrinth.models.Map;
import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Way;

import java.util.List;

public class WayFinder {
    private ApiService apiService;

    public  WayFinder(){
        apiService = new ApiService();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Point> find(String mapName, String beginningPointName, String endPointName){
        Map currentMap = apiService.getMaps().stream().filter(map -> map.getName().equals(mapName)).findFirst().get();

        Way currentWay = currentMap.findWayByTwoPointNames(beginningPointName, endPointName);

        return currentWay.getPoints();
    }
}
