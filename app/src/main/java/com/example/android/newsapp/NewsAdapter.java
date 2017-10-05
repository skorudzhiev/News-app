package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.example.android.newsapp.NewsActivity.LOG_TAG;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitle());

        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        sectionView.setText(currentNews.getSection());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formatPublishTime(currentNews.getDate()));

        return listItemView;
    }

    // Format publish date
    private String formatPublishTime(final String Time) {
        // If not the correct base format
        String time = "N.A.";
        // Check time validation
        if ((Time != null) && (!Time.isEmpty())) {
            try {
                // Create current format
                SimpleDateFormat currentSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                // Create new format
                SimpleDateFormat newSDF = new SimpleDateFormat("yyyy.MM.dd / HH:mm");
                // Parse time
                time = newSDF.format(currentSDF.parse(Time));
            } catch (ParseException parseEx) {
                time = "N.A.";
                Log.e(LOG_TAG, "Error while parsing the published date", parseEx);
            }
        }

        return time;
    }
}
