package com.catata.perenxisainfo

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.catata.perenxisainfo.databinding.FragmentTabbed1Binding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.*


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

        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P){
            GlobalScope.launch(Dispatchers.IO) {
                val decodedAnimation = ImageDecoder.decodeDrawable(
                    // create ImageDecoder.Source object
                    ImageDecoder.createSource(resources, R.drawable.swipe))
                // set the drawble as image source of ImageView
                binding.imgGif.setImageDrawable(decodedAnimation)
                // play the animation
                (decodedAnimation as? AnimatedImageDrawable)?.start()
            }


        }else{
            binding.imgGif.background = resources.getDrawable(R.drawable.swipe_static, null )
        }
        GlobalScope.launch(Dispatchers.Main) {
            delay(2500)
            binding.imgGif.visibility = View.GONE
        }

    }

    class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 6

        override fun createFragment(position: Int): Fragment {
            // Return a NEW fragment instance in createFragment(int)
            return when (position) {
                0 -> FPBFragment()
                1 -> SMXFragment()
                2 -> ASIXFragment()
                3 -> DAMFragment()
                4 -> DAWFragment()
                5 -> DAMsFragment()
                else -> HomeFragment()
            }
        }
    }
}