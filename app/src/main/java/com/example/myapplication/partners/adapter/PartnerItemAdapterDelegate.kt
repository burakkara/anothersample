package com.example.myapplication.partners.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.architecture.adapter.AdapterDelegate
import com.example.myapplication.databinding.ListItemPartnerBinding
import com.example.myapplication.partners.PartnerViewModel

class PartnerItemAdapterDelegate(
    private val onClickListener: OnItemClickListener<PartnerViewModel>
) : AdapterDelegate<PartnerViewModel> {
    override fun isForModel(model: PartnerViewModel) = model is PartnerViewModel // theoretically there should be more than single item type in the list

    override fun getModelForViewHolder(viewHolder: RecyclerView.ViewHolder): PartnerViewModel? {
        return (viewHolder as? ViewHolder)?.item
    }

    override fun createViewHolder(parent: ViewGroup): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            binding = ListItemPartnerBinding.inflate(inflater, parent, false),
            onClickListener = onClickListener
        )
    }

    override fun bindViewHolder(
        viewHolder: RecyclerView.ViewHolder,
        model: PartnerViewModel,
        payloads: List<Any>
    ) {
        require(viewHolder is ViewHolder)
        viewHolder.item = model
    }

    class ViewHolder(
        private val binding: ListItemPartnerBinding,
        private val onClickListener: OnItemClickListener<PartnerViewModel>
    )  : RecyclerView.ViewHolder(binding.root) {
        var item: PartnerViewModel? = null
            set(value) {
                field = value
                if (value != null) {
                    binding.item = field
                }
            }

        init {
            binding.root.setOnClickListener {
                item?.let(onClickListener::onItemClick)
            }
        }
    }
}