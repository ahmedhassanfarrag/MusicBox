package com.example.android.musicbox;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
* SongsAdaptor is an  ArrayAdapter that can provide the layout for each list
* based on a data source, which is a list of arabic and en songs objects.
* */
public class SongsAdaptor extends ArrayAdapter<Songs> {

    public SongsAdaptor(Activity context, ArrayList<Songs> arabicSongs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, arabicSongs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Songs object located at this position in the list
        Songs listenSongs = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID song name.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.song_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(listenSongs.getSonName());

        // Find the TextView in the list_item.xml layout with the ID artist name.
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(listenSongs.getArtistName());

        // Find the ImageView in the list_item.xml layout with the ID artist icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.artist_icon);
        // Get the image resource ID from the current Songs object and
        // set the image to iconView
        iconView.setImageResource(listenSongs.ImageArtist());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
