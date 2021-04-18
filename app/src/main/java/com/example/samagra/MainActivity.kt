package com.example.samagra

import android.os.Bundle
import com.example.samagra.core.BaseActivity
import com.example.samagra.ui.MainFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransactions = supportFragmentManager.beginTransaction()
        fragmentTransactions.add(
                R.id.fragmentParent,
                MainFragment.newInstance()
        ).setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransactions.commitAllowingStateLoss()
    }
}