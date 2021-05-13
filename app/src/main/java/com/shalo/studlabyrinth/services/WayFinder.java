package com.shalo.studlabyrinth.services;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.shalo.studlabyrinth.models.Map;
import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.models.Way;

import java.util.List;

public class WayFinder {
    private ApiService apiService;

    public  WayFinder(){
        apiService = new ApiService();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Point> find(Route route){
        Map currentMap = apiService.getMaps().stream().filter(map -> map.getName().equals(route.getMapName())).findFirst().get();

        Way currentWay = currentMap.findWayByTwoPointNames(route.getBeginningPointName(), route.getEndPointName());

        return currentWay.getPoints();
    }
}
