package com.example.desplegable4.ui.home

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.desplegable4.DespleActivity
import com.example.desplegable4.R
import com.example.desplegable4.databinding.FragmentHomeBinding
import com.example.desplegable4.ui.gallery.GalleryFragment
import com.example.desplegable4.ui.gallery.GalleryViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val view2 = inflater.inflate(R.layout.fragment_home, container, false)

        binding.imageGroup1.setOnClickListener { view2.context.startActivity(Intent(view2.context, GalleryViewModel::class.java)) }
        val root: View = binding.root

        val textView: TextView = binding.txtCalendario

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        }
        )

        val textView2: TextView = binding.txtAadirEvento

        homeViewModel.text2.observe(viewLifecycleOwner, Observer {
            textView2.text = it
        }
        )

        return root
    }

    public fun setUpClicks(): Unit {


        /* binding.imageMenu.setOnClickListener {
           val destIntent = DesplegableActivity.
           startActivity(destIntent)
         }*/



       /* binding.viewRectangle9.setOnClickListener {
            val destIntent = EventosActivity.getIntent(this, null)
            startActivity(destIntent)
        }*/
        /*binding.imageGroup2.setOnClickListener {
            val destIntent = CalendarioActivity.getIntent(this, null)
            startActivity(destIntent)
        }
        binding.imageGroup.setOnClickListener {
            val destIntent = CalendarioActivity.getIntent(this, null)
            startActivity(destIntent)
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}