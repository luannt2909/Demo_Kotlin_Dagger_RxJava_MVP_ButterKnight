package com.luannt.lap10515.demokotlin.view.list

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import com.luannt.lap10515.demokotlin.R
import com.luannt.lap10515.demokotlin.api.response.Paging
import com.luannt.lap10515.demokotlin.application.component.ControllerComponent
import com.luannt.lap10515.demokotlin.data.Fonda
import com.luannt.lap10515.demokotlin.presenter.list.ListFondaPresenter
import com.luannt.lap10515.demokotlin.view.base.BaseActivity
import javax.inject.Inject

/**
 * Created by lap10515 on 04/08/2017.
 */
class ListFondaActivity : BaseActivity<ListFondaPresenter>(), ListFondaView, ListFondaNavigator, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rcv_list)
    lateinit var rcv_list: RecyclerView

    @BindView(R.id.swipRefreshLayout)
    lateinit var swipe_layout: SwipeRefreshLayout

    @Inject lateinit var mAdapter: FondaAdapter

    lateinit var mOnloadmoreRecyclerView: EndlessRecyclerViewScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.setView(this)
        mPresenter.setNavigator(this)
        initView()
        mPresenter.getListFonda(0)
    }

    private fun initView() {
        swipe_layout.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_green_dark),
                getResources().getColor(android.R.color.holo_red_dark),
                getResources().getColor(android.R.color.holo_blue_dark),
                getResources().getColor(android.R.color.holo_orange_dark)
        )
        swipe_layout.setOnRefreshListener(this)

        //LayoutManager
        var layoutManager = LinearLayoutManager(this)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
        rcv_list.setLayoutManager(layoutManager)
        rcv_list.setItemAnimator(DefaultItemAnimator())
        setOnLoadmore(layoutManager)
        rcv_list.setOnScrollListener(mOnloadmoreRecyclerView)
        rcv_list.adapter = mAdapter

    }

    private fun setOnLoadmore(layoutManager: LinearLayoutManager) {
        mOnloadmoreRecyclerView = object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                mPresenter.getListFonda(page)
            }
        }
    }

    override fun onRefresh() {
        mAdapter.refreshData()
        mPresenter.getListFonda(0)
        mOnloadmoreRecyclerView.resetState()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun showList(data: Paging<Fonda>) {
        disableRefreshLayout()
        mAdapter.binData(data.data)
    }

    fun disableRefreshLayout() {
        if (swipe_layout.isRefreshing) swipe_layout.isRefreshing = false
    }

    override fun getLayoutId(): Int = R.layout.activity_list

    override fun inject(controllerComponent: ControllerComponent) = controllerComponent.inject(this)
}