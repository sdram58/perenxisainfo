package com.catata.perenxisainfo

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.*

class MapsFragment : Fragment(), OnMarkerClickListener {
    lateinit var gMap:GoogleMap
    private val callback = OnMapReadyCallback { googleMap ->
        gMap = googleMap

        val iesSerra = LatLng(39.4295152, -0.4664156)
        gMap.addMarker(MarkerOptions().position(iesSerra).title(getString(R.string.name)).snippet(getString(R.string.here_we_are)))
        moveToCurrentLocation(iesSerra)

        //gMap.setOnMarkerClickListener(this)

        gMap.mapType = GoogleMap.MAP_TYPE_HYBRID

    }

    private fun moveToCurrentLocation(currentLocation: LatLng) {
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 9f))

        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            // Zoom in, animating the camera.
            gMap.animateCamera(CameraUpdateFactory.zoomIn())
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            gMap.animateCamera(CameraUpdateFactory.zoomTo(17f), 2500, null)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        Toast.makeText(requireActivity(), getString(R.string.here_we_are), Toast.LENGTH_SHORT).show()
        return true
    }




}