package com.example.aparecido.viewmodelexample.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.aparecido.viewmodelexample.view.fragment.SignUpAccessFragment
import com.example.aparecido.viewmodelexample.view.ativity.SignUpActivity
import com.example.aparecido.viewmodelexample.view.fragment.SignUpPersonalFragment
import com.example.aparecido.viewmodelexample.view.fragment.SignUpTermsFragment

/**
 * Um [FragmentPagerAdapter] que retorna um fragment correspondente a
 * uma das seções/tabs/pages.
 */
class SectionsPagerAdapter(activity: SignUpActivity, fm: FragmentManager) :
        FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        /* getItem é invocado para instanciar o fragment da tab informada. */

        return when (position) {
            0 -> SignUpPersonalFragment()
            1 -> SignUpAccessFragment()
            else -> SignUpTermsFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}