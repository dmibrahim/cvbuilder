package com.dmi.cvbuilder.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dmi.cvbuilder.ui.fragments.AboutFragment
import com.dmi.cvbuilder.ui.fragments.HomeFragment
import com.dmi.cvbuilder.ui.fragments.WorkFragment
import edu.miu.cvbuilder.ui.fragments.ContactFragment


class MyViewAdapter(fm:FragmentManager,lc:Lifecycle) : FragmentStateAdapter(fm,lc) {
    // How many Fragments - Returns the total number of items in the data set held by the adapter.
    override fun getItemCount(): Int = 4
    // Provide a new Fragment associated with the specified position.
    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0-> HomeFragment()
            1-> AboutFragment()
            2-> WorkFragment()
            3-> ContactFragment()
            else-> Fragment()
        }
    }
}

