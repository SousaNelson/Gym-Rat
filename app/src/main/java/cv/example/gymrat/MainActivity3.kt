package cv.example.gymrat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import cv.example.gymrat.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private lateinit var tab: TabLayout
    private lateinit var viewpager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        tab = binding.tabLayout
        viewpager = binding.viewpager

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TrainFragment(), "Train")
        adapter.addFragment(TrackFragment(), "Track")
        adapter.addFragment(LocationFragment(), "Location")
        viewpager.adapter = adapter
        tab.setupWithViewPager(viewpager)
    }
}
