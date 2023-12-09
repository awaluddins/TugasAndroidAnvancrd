package tugas.android.andriodadvancetugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import tugas.android.andriodadvancetugas.Adapter.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tapLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Waifu"))
        tabLayout.addTab(tabLayout.newTab().setText("Husbu"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MyAdapter(this, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.Search -> {
                Toast.makeText(this, "Kamu mengetik search!", Toast.LENGTH_LONG).show()
                return true
            }R.id.Favorite -> {
                Toast.makeText(this, "Kamu mengetik favorite!", Toast.LENGTH_LONG).show()
                return true
            }R.id.Share -> {
                Toast.makeText(this, "Kamu mengetik share!", Toast.LENGTH_LONG).show()
                return true
            }R.id.Whatsapp -> {
                Toast.makeText(this, "Kamu mengetik whatsapp!", Toast.LENGTH_LONG).show()
                return true
            }R.id.Instagram -> {
                Toast.makeText(this, "Kamu mengetik instagram!", Toast.LENGTH_LONG).show()
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}