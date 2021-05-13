package com.shalo.studlabyrinth.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.shalo.studlabyrinth.models.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteRepository {

    private SQLiteDatabase database;

    public RouteRepository(Context context) {
        this.database = new DbHelper(context).getWritableDatabase();
    }

    public List<Route> Select(){
        Cursor cursor = database.query(DbHelper.TABLE_NAME,null,null,null,null,null,null);

        List<Route> routes = new ArrayList<>();

        while (cursor.moveToNext())
            routes.add(GetRoute(cursor));

        cursor.close();

        return routes;
    }

    public Route Select(int id) {
        Cursor cursor = database.query(DbHelper.TABLE_NAME,null,null,null,null,null,null);

        while (cursor.moveToNext()) {
            int routeId = cursor.getInt(cursor.getColumnIndex(DbHelper.KEY_ID));
            if (routeId == id)
                return GetRoute(cursor);
        }

        return null;
    }

    private Route GetRoute(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(DbHelper.KEY_ID));
        String mapName = cursor.getString(cursor.getColumnIndex(DbHelper.KEY_MAP_NAME));
        String beginningPointName = cursor.getString(cursor.getColumnIndex(DbHelper.KEY_BEGINNING_POINT_NAME));
        String endPointName = cursor.getString(cursor.getColumnIndex(DbHelper.KEY_END_POINT_NAME));

        return new Route(id,mapName,beginningPointName,endPointName);
    }

    public void Insert(Route route) {
        ContentValues values = new ContentValues();

        values.put(DbHelper.KEY_MAP_NAME, route.getMapName());
        values.put(DbHelper.KEY_BEGINNING_POINT_NAME, route.getBeginningPointName());
        values.put(DbHelper.KEY_END_POINT_NAME, route.getEndPointName());

        database.insert(DbHelper.TABLE_NAME,null, values);
    }

    public void Delete(int id) {
        database.delete(DbHelper.TABLE_NAME,DbHelper.KEY_ID +" = ?",
                new String[]{String.valueOf(id)});
    }

    public void DeleteAll(){
        database.delete(DbHelper.TABLE_NAME,null,null);
    }
}
