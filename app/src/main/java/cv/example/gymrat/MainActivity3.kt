package cv.example.gymrat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity3 : AppCompatActivity() {
    lateinit var tab: TabLayout
    lateinit var viewpager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        tab = findViewById(R.id.tabLayout)
        viewpager= findViewById(R.id.viewpager)
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(TrainFragment(), "Train")
        adapter.addFragment(TrackFragment(), "Track")
        adapter.addFragment(LocationFragment(), "Location")
        viewpager.adapter = adapter
        tab.setupWithViewPager(viewpager)

    }
}

