package com.gfcomp.suslu.ParserApi

import com.gfcomp.suslu.interfaces.TabType
import org.jsoup.select.Elements
import rx.Observable

/**
 * Created by Gozde Kaval on 3/16/2018.
 */
class ParserLauncher {

    fun getElements(tabType: TabType) : Observable<Elements>{

        return Observable.create {
            subscriber ->
            val parserApi = Parser.instance
            val callResponse = getList(tabType,parserApi)
            subscriber.onNext(callResponse)
        }
    }

    private fun getList(tabType: TabType, parserApi : Parser) : Elements{
        when(tabType){
            TabType.SUSLU -> return parserApi.getSusluHighlighted()
            TabType.OFF_TOPIC -> return parserApi.getOffTopicHighlighted()
            TabType.QA -> return parserApi.getQAHighlighted()
            else -> return parserApi.getSusluHighlighted()
        }
    }

}

