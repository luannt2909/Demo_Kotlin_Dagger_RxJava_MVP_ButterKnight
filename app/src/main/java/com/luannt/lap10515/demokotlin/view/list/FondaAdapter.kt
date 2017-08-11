package com.luannt.lap10515.demokotlin.view.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.luannt.lap10515.demokotlin.R
import com.luannt.lap10515.demokotlin.data.Fonda
import javax.inject.Inject

/**
 * Created by lap10515 on 07/08/2017.
 */
class FondaAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private val LIST_VIEWTYPE: Int = 1;
    private val LOADING_VIEWTYPE: Int = 0;

    var mContext: Context

    var mList: MutableList<Fonda?>? = null

    @Inject
    constructor(context: Context) {
        mContext = context
    }

    override fun getItemCount(): Int = mList?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        when (mList?.get(position)) {
            null -> return LOADING_VIEWTYPE
            else -> return LIST_VIEWTYPE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (getItemViewType(position) == LIST_VIEWTYPE) {
            var fondaHolder: FondaViewHolder = holder as FondaViewHolder
            var fonda = mList?.get(position)
            fondaHolder.bindData(fonda)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            LIST_VIEWTYPE -> {
                var view: View = LayoutInflater.from(mContext).inflate(R.layout.item_fonda, null)
                view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
                return FondaViewHolder(view)
            }

            else -> {
                var view: View = LayoutInflater.from(mContext).inflate(R.layout.item_loading, null)
                view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
                return LoadingViewHolder(view)
            }
        }
    }

    fun binData(list: List<Fonda>?) {
        /*if (mList == null) mList = list.toMutableList()
        else mList?.addAll(list.toMutableList())*/
        when (mList) {
            null -> mList = list?.toMutableList()
            else -> list?.forEach { mList?.contains(it).apply { mList?.add(it) } }
        }
        notifyDataSetChanged()
    }

    fun refreshData() {
        mList?.clear()
    }

    inner class FondaViewHolder : RecyclerView.ViewHolder {

        constructor(itemView: View) : super(itemView) {
            ButterKnife.bind(this, itemView)
        }

        @BindView(R.id.img_fonda)
        lateinit var imgFonda: ImageView

        @BindView(R.id.tv_fonda_name)
        lateinit var tvFonda: TextView

        fun bindData(fonda: Fonda?) {
            tvFonda.text = fonda?.name
            Glide.with(mContext).load(fonda?.image?.url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgFonda)
        }

    }

    inner class LoadingViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View) : super(itemView) {
            ButterKnife.bind(this, itemView)
        }

        @BindView(R.id.pb_loading)
        lateinit var pb_loading: ProgressBar

    }
}