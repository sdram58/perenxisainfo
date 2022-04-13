package com.catata.perenxisainfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.catata.perenxisainfo.databinding.FragmentTabbed1Binding
import com.google.android.material.tabs.TabLayoutMediator


class Tabbed1Fragment : Fragment() {
    private lateinit var binding:FragmentTabbed1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentTabbed1Binding.inflate(inflater,container,false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = PagerAdapter(this)

/*        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "TAB A"
                1 -> tab.text = "TAB B"
                2 -> tab.text = "TAB C"
                else -> tab.text = "TAB A"
            }
        }.attach()*/

    }

    class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 6

        override fun createFragment(position: Int): Fragment {
            // Return a NEW fragment instance in createFragment(int)
            return when (position) {
                0 -> HomeFragment()
                1 -> FPBFragment()
                2 -> SMXFragment()
                3 -> ASIXFragment()
                4 -> DAMFragment()
                5 -> DAWFragment()
                6 -> DAMsFragment()
                else -> HomeFragment()
            }
        }
    }
}