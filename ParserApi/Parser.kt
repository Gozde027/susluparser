package com.gfcomp.suslu.ParserApi

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

/**
 * Created by Gozde Kaval on 3/12/2018.
 */
class Parser private constructor() {

    private object Holder { val INSTANCE = Parser() }
    var document : Document? = null

    companion object {
        const val BASE_URL = "https://www.suslusozluk.com/"
        val instance: Parser by lazy { Holder.INSTANCE }
    }

    init {
        document = getDoc()
    }

    fun getDoc() : Document{
        return Jsoup.connect(BASE_URL).get()
    }

    fun getSusluHighlighted() : Elements{
        //todo buraya daha generic bir yapi
        val div = document?.select("div#highlightsmenucontainer")
        val subDiv = div?.select("div#highlights_suslu")
        val links = subDiv?.select("a[href]")
        return links!!
    }

    fun getOffTopicHighlighted() : Elements{
        val div = document?.select("div#highlightsmenucontainer")
        val subDiv = div?.select("div#highlights_offtopic")
        val links = subDiv?.select("a[href]")
        return links!!
    }

    fun getQAHighlighted() : Elements{

        val div = document?.select("div#highlightsmenucontainer")
        val subDiv = div?.select("div#highlights_qa")
        val links = subDiv?.select("a[href]")
        return links!!
    }
}
