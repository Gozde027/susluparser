package com.gfcomp.suslu.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gfcomp.suslu.ParserApi.ParserLauncher
import com.gfcomp.suslu.R
import com.gfcomp.suslu.adapters.NavigationMainAdapter
import com.gfcomp.suslu.inflate
import com.gfcomp.suslu.interfaces.TabType
import com.gfcomp.suslu.model.ListItem
import kotlinx.android.synthetic.main.navigation_list.*
import org.jsoup.nodes.Element
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Gozde Kaval on 3/12/2018.
 */
class TabListFragment : Fragment() {

    companion object{

        private var tabType = TabType.NONE

        fun newInstance(tabType: TabType) : TabListFragment{
            this.tabType = tabType;
            val fragment = TabListFragment()
            return fragment
        }
    }

    private val navListAdapter = NavigationMainAdapter()

    private val navigationList by lazy {
        navigation_rec_list
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_rec_list.setHasFixedSize(true)
        navigation_rec_list.layoutManager = LinearLayoutManager(context)
        navigation_rec_list.addItemDecoration(DividerItemDecoration(context))

        navigationList.adapter = navListAdapter

        updateList()

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.navigation_list)
    }

    fun updateList(){
        ParserLauncher().getElements(tabType)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({

                val listItem = ArrayList<ListItem>()
                //todo map filter?
                for (item: Element in it) {
                    listItem.add(ListItem(item.text()))
                }
                navListAdapter.addListItem(listItem)

            },{


            })
    }

}