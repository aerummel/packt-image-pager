package android.example.imagepager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    PagerAdapter mAdapter;
    int[] mImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImages = new int[] {
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6
        };

        // Get a reference to the ViewPager in the layout
        mViewPager = (ViewPager) findViewById(R.id.pager);

        // Initialize our adapter
        mAdapter = new ImagePagerAdapter(this, mImages);

        // Binds the Adapter to the ViewPager
        mViewPager.setAdapter(mAdapter);
    }
}