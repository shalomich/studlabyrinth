package com.shalo.studlabyrinth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.shalo.studlabyrinth.models.Route;

import java.util.List;

public class RouteAdapter extends ArrayAdapter<Route> {
    private LayoutInflater inflater;
    private int layout;
    private List<Route> routes;

    public RouteAdapter(Context context, int layout, List<Route> routes) {
        super(context, layout, routes);
        this.layout = layout;
        this.routes = routes;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.layout, parent, false);

        Button routeButton = convertView.findViewById(R.id.route_button);

        Route route = routes.get(position);
        String routeName = String.format("%s %s %s",
                route.getMapName(),
                route.getBeginningPointName(),
                route.getEndPointName());

        routeButton.setText(routeName);

        return convertView;
    }
}
