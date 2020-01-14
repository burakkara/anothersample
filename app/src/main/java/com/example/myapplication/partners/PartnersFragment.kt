package com.example.myapplication.partners

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.architecture.Injector
import javax.inject.Inject

class PartnersFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var partnersViewModel : PartnersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.get().inject(this)
        partnersViewModel = ViewModelProviders.of(this, viewModelFactory)[PartnersViewModel::class.java]
        partnersViewModel.updatePartnersList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_partners, container, false)
        partnersViewModel.state.observe(this, Observer { Log.i("tag", "tag") })
        return root
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PartnersFragment {
            return PartnersFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}