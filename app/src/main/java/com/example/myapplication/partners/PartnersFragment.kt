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
import com.example.myapplication.R
import com.example.myapplication.architecture.Resource
import com.example.myapplication.architecture.adapter.AdapterDelegateManager
import com.example.myapplication.architecture.adapter.DelegateRecyclerViewAdapter
import com.example.myapplication.architecture.di.Injector
import com.example.myapplication.databinding.FragmentPartnersBinding
import com.example.myapplication.partners.adapter.OnItemClickListener
import com.example.myapplication.partners.adapter.PartnerItemAdapterDelegate
import com.example.myapplication.util.onChange
import javax.inject.Inject

class PartnersFragment : Fragment(),
    OnItemClickListener<PartnerViewModel> {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: PartnersViewModel
    lateinit var binding: FragmentPartnersBinding

    private val adapter: DelegateRecyclerViewAdapter<PartnerViewModel> by lazy {
        DelegateRecyclerViewAdapter(
            AdapterDelegateManager(
                PartnerItemAdapterDelegate(
                    this
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.get().inject(this)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory)[PartnersViewModel::class.java]
        getShelfContent()
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
        setupPullToRefresh()

        onChange(viewModel.state) {
            when (it) {
                is Resource.LoadedResource -> {
                    it.data.let(adapter::submitList)
                    binding.partnersPullToRefresh.isRefreshing = false
                }
                is Resource.ErrorResource -> {
                    binding.partnersPullToRefresh.isRefreshing = false
                }
                is Resource.LoadingResource -> {
                    binding.partnersPullToRefresh.isRefreshing = true
                }
            }
        }
    }

    private fun setupPullToRefresh() {
        binding.partnersPullToRefresh.apply {
            setColorSchemeResources(
                R.color.refresh_4,
                R.color.refresh_3,
                R.color.refresh_2,
                R.color.refresh_1
            )
            setOnRefreshListener {
                getShelfContent()
                isRefreshing = true
            }
        }
    }

    private fun getShelfContent() {
        viewModel.updatePartnersList()
    }

    companion object {
        @JvmStatic
        fun newInstance(): PartnersFragment {
            return PartnersFragment()
        }
    }

    override fun onItemClick(model: PartnerViewModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}