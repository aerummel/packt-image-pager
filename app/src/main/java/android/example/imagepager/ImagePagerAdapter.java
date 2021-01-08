package android.example.imagepager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImagePagerAdapter extends PagerAdapter {

    Context mContext;

    int[] mImages;
    LayoutInflater mInflater;

    public ImagePagerAdapter(Context context, int[] images) {
        mContext = context;
        mImages = images;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView image;

        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mInflater.inflate(R.layout.pager_item, container, false);

        // get reference to imageView in pager_item layout
        image = (ImageView) itemView.findViewById(R.id.imageView);

        // Set an image to the ImageView
        image.setImageResource(mImages[position]);

        // Add pager_item layout as the current page to the ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // Remove pager_item layout from ViewPager
        ((ViewPager) container).removeView((ConstraintLayout) object);
    }
}
