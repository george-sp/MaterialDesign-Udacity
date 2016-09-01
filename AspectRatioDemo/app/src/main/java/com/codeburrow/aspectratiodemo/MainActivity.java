package com.codeburrow.aspectratiodemo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.BindDimen;
import butterknife.BindInt;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.image_grid)
    RecyclerView grid;
    @Bind(android.R.id.empty)
    ProgressBar empty;
    @BindInt(R.integer.photo_grid_columns)
    int columns;
    @BindDimen(R.dimen.grid_item_spacing)
    int gridSpacing;

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
}
