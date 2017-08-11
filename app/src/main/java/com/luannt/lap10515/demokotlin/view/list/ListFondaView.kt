package com.luannt.lap10515.demokotlin.view.list

import com.luannt.lap10515.demokotlin.api.response.Paging
import com.luannt.lap10515.demokotlin.data.Fonda
import com.luannt.lap10515.demokotlin.view.base.BaseView

/**
 * Created by lap10515 on 04/08/2017.
 */
interface ListFondaView: BaseView {
    fun showList(data: Paging<Fonda>)

}