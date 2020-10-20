package com.entre.infokita

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.entre.infokita.fragments.AddFragment
import com.entre.infokita.fragments.HistoryFragment
import com.entre.infokita.fragments.HomeFragment
import com.entre.infokita.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener,
    AddFragment.OnFragmentInteractionListener,
    ProfileFragment.OnFragmentInteractionListener,
    HistoryFragment.OnFragmentInteractionListener
{

    fun loadFragment(f : Fragment?){
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment,f!!).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())

        btm_nav.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var fragment : Fragment? = null

                if(item.itemId == R.id.home_nav){
                    fragment = HomeFragment()
                }else if (item.itemId == R.id.history_nav){
                    fragment = HistoryFragment()
                }
                loadFragment(fragment)
                return true
            }
        })

    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("Not yet implemented")
    }
}
