package com.example.myapplication.partners

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.architecture.AdapterDelegateManager
import com.example.myapplication.architecture.DelegateRecyclerViewAdapter
import com.example.myapplication.architecture.Injector
import com.example.myapplication.architecture.Resource
import com.example.myapplication.databinding.FragmentPartnersBinding
import com.example.myapplication.util.onChange
import javax.inject.Inject

class PartnersFragment : Fragment(), OnItemClickListener<PartnerViewModel> {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: PartnersViewModel
    lateinit var binding: FragmentPartnersBinding

    private val adapter: DelegateRecyclerViewAdapter<PartnerViewModel> by lazy {
        DelegateRecyclerViewAdapter(
            AdapterDelegateManager(
                PartnerItemAdapterDelegate(this)
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.get().inject(this)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory)[PartnersViewModel::class.java]
        viewModel.updatePartnersList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPartnersBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initView() {
        binding.partnersList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@PartnersFragment.adapter
        }

        onChange(viewModel.state) {
            when (it) {
                is Resource.LoadedResource -> {
                    it.data.let(adapter::submitList)
                }
                is Resource.ErrorResource -> {

                }
                is Resource.LoadingResource -> {

                }
            }
        }
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

    override fun onItemClick(model: PartnerViewModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}