package com.collinsmallegan.brickcalc

import android.app.Fragment
import android.app.FragmentManager


class PagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm){


    override fun getItem(position: Int): Fragment {
        return when (position){

            0 -> {
                Tab1_Landscape()
            }

            1 -> {
                Tab2_Paver()
            }

            else -> {
                return  Tab3_Wall()
            }

        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position){
            0 -> "LandScape"
            1-> "Pavers"
            else -> {
                return "Structural"
            }

        }
    }
}