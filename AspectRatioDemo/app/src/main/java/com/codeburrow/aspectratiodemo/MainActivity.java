package com.codeburrow.aspectratiodemo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.codeburrow.aspectratiodemo.data.UnsplashService;
import com.codeburrow.aspectratiodemo.data.model.Photo;
import com.codeburrow.aspectratiodemo.ui.ForegroundImageView;
import com.codeburrow.aspectratiodemo.ui.ItemClickSupport;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.BindDimen;
import butterknife.BindInt;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int PHOTO_COUNT = 12;
    @Bind(R.id.image_grid)
    RecyclerView grid;
    @Bind(android.R.id.empty)
    ProgressBar empty;
    @BindInt(R.integer.photo_grid_columns)
    int columns;
    @BindDimen(R.dimen.grid_item_spacing)
    int gridSpacing;
    private PhotoAdapter adapter;
    private String photoUrlBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        /*
         * GridLayoutManager is a RecyclerView.LayoutManager implementation
         * that lays out items in a grid.
         *
         * By default, each item occupies 1 span.
         * You can change it by providing a custom GridLayoutManager.SpanSizeLookup
         * instance via setSpanSizeLookup(SpanSizeLookup).
         *
         * GridLayoutManager(Context context, int spanCount) constructor, creates
         * a vertical GridLayoutManager.
         *
         * =========================================================================
         *
         * GridLayoutManager.SpanSizeLookUp is a helper class
         * to provide the number of spans each item occupies.
         * (Default implementation sets each item to occupy exactly 1 span.)
         */
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, columns);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                /* emulating
                 * https://material-design.storage.googleapis.com/publish/material_v_4/material_ext_publish/0B6Okdz75tqQsck9lUkgxNVZza1U/style_imagery_integration_scale1.png
                 */
                switch (position % 6) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                        return 1;
                    case 3:
                        return 2;
                    default:
                        return 3;
                }
            }
        });
        grid.setLayoutManager(gridLayoutManager);
        grid.addItemDecoration(new GridMarginDecoration(gridSpacing));
        grid.setHasFixedSize(true);

        photoUrlBase = "https://unsplash.it/"
                + getResources().getDisplayMetrics().widthPixels
                + "?image=";

        ItemClickSupport.addTo(grid).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View view) {

                    }
                });

        UnsplashService unsplashService = new RestAdapter.Builder()
                .setEndpoint(UnsplashService.ENDPOINT)
                .build()
                .create(UnsplashService.class);

        unsplashService.getFeed(new Callback<List<Photo>>() {
            @Override
            public void success(List<Photo> photos, Response response) {
                //grid.setAdapter(new PhotoAdapter(photos));
                // the first items are really boring, get the last <n>
                adapter = new PhotoAdapter(photos.subList(photos.size() - PHOTO_COUNT, photos
                        .size()));
                grid.setAdapter(adapter);
                empty.setVisibility(View.GONE);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(LOG_TAG, "Error retrieving Unsplash feed: " + error);
            }
        });
    }

    /**
     * An ItemDecoration allows the application to add a special drawing and layout offset
     * to specific item views from the adapter's data set.
     * This can be useful for drawing dividers between items, highlights, visual grouping boundaries and more.
     * All ItemDecorations are drawn in the order they were added,
     * before the item views (in onDraw() and after the items in onDrawOver(Canvas, RecyclerView, RecyclerView.State)).
     */
    private static class GridMarginDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public GridMarginDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.top = space;
            outRect.right = space;
            outRect.bottom = space;
        }
    }

    protected static class PhotoViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.photo)
        ForegroundImageView imageView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

        private final List<Photo> photos;

        public PhotoAdapter(List<Photo> photos) {
            this.photos = photos;
        }

        @Override
        public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PhotoViewHolder(LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.photo_item, parent, false));
        }

        @Override
        public void onBindViewHolder(final PhotoViewHolder holder, final int position) {
            final Photo photo = photos.get(position);
            String url = photoUrlBase + photo.id;
            Picasso.with(MainActivity.this)
                    .load(url)
                    .placeholder(R.color.placeholder)
                    .into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return photos.size();
        }

        @Override
        public long getItemId(int position) {
            return photos.get(position).id;
        }

        public Photo getItem(int position) {
            return photos.get(position);
        }
    }
}
