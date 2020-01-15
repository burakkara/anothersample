package com.example.myapplication.partners

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.architecture.AdapterDelegate
import com.example.myapplication.databinding.ListItemPartnerBinding

class PartnerItemAdapterDelegate(
    private val onClickListener: OnItemClickListener<PartnerViewModel>
) : AdapterDelegate<PartnerViewModel> {
    override fun isForModel(adapterModel: PartnerViewModel) = adapterModel is PartnerViewModel

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
/*        override val contentId: String
            get() = item?.offerId ?: ""
        override val contentType = "offer"*/

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