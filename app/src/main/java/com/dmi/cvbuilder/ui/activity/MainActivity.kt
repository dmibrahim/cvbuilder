package com.dmi.cvbuilder.ui.activity





import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dmi.cvbuilder.utils.AppUtils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import cvbuilder.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPref = AppUtils.setPref(this)
//        val theme = sharedPref.getString(getString(R.string.saved_theme), "")
//        if(theme!=null) decideTheme(theme)

        // specify adapter for viewpager
        val adapter = MyViewAdapter(supportFragmentManager,lifecycle)
        // Set the Adapter to your Viewpager UI
        viewPager.adapter = adapter
        tabs.tabGravity = TabLayout.GRAVITY_FILL
        /* Setting up Tab Layout with the ViewPageg2 is handled by the TabLayoutMediator
        * by passing your tablayout id and viewpager id*/
        TabLayoutMediator(tabs,viewPager){tab,position->
            when(position){
                0->{
                    tab.text="Home"
//                    tab.setIcon(R.drawable.home)
                }
                1->{
                    tab.text="About Me"
//                    tab.setIcon(R.drawable.help)
                }
                2->{
                    tab.text="Experience"
//                    tab.setIcon(R.drawable.work)
                }
                3->{
                    tab.text = "Contact"
//                    tab.setIcon(R.drawable.contact)
                }
            }
        }.attach()


    }



}