package com.example.android.tourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_SIGHT = "sight";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight_details);

        // toolbar setup
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.back));

        // add back arrow to toolbar, back arrow is a default icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Sight sight = getIntent().getExtras().getParcelable(EXTRA_SIGHT);
        assert sight != null;

        ((TextView)findViewById(R.id.name_text_view_details))
                .setText(sight.getName());
        if (sight.getAddress() != null) {
        ((TextView)findViewById(R.id.address_text_view_details))
                .setText(sight.getAddress());
        } else {
            TextView address = (TextView) findViewById(R.id.address_text_view_details);
            TextView address_address = (TextView) findViewById(R.id.address_address_tv);
            address.setVisibility(View.GONE);
            address_address.setVisibility(View.GONE);
        }
        ImageView imageView = (ImageView)findViewById(R.id.image_details);
        imageView.setImageResource(sight.getImageResourceId());

        ((TextView)findViewById(R.id.description_tv_details)).setText(sight.getDescription());
    }

    // this method contains logic behind clicking on toolbar home button (Back button in this case)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
