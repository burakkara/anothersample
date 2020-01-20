package com.example.myapplication.addpartner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.State
import com.example.myapplication.architecture.di.Injector
import com.example.myapplication.databinding.FragmentAddPartnerBinding
import com.example.myapplication.util.onChange
import javax.inject.Inject

class AddPartnerFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AddPartnerViewModel
    lateinit var binding: FragmentAddPartnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.get().inject(this)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory)[AddPartnerViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPartnerBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.submit.apply {
            setOnClickListener {
                viewModel.submit(
                    binding.nameEditText.text.toString(),
                    binding.descriptionEditText.text.toString()
                )
            }
        }

        onChange(viewModel.state) {
            when (it) {
                State.SUCCESS -> {
                    Toast.makeText(
                        requireActivity(),
                        getString(R.string.add_partner_success_message),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                State.FAILURE -> {
                    Toast.makeText(
                        requireActivity(),
                        getString(R.string.add_partner_failure_message),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): AddPartnerFragment {
            return AddPartnerFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}