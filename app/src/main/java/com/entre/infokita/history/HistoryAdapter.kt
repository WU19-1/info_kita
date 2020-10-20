package com.entre.infokita.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.entre.infokita.R
import com.entre.infokita.model.History
import java.util.*

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    var list : Vector<History>

    constructor(){
        list = Vector<History>()
        list.add(History("Berita 1","05 - 10 - 2020"))
        list.add(History("Berita 2","06 - 10 - 2020"))
        list.add(History("Berita 3","07 - 10 - 2020"))
        list.add(History("Berita 1","05 - 10 - 2020"))
        list.add(History("Berita 2","06 - 10 - 2020"))
        list.add(History("Berita 3","07 - 10 - 2020"))
        list.add(History("Berita 1","05 - 10 - 2020"))
        list.add(History("Berita 2","06 - 10 - 2020"))
        list.add(History("Berita 3","07 - 10 - 2020"))
    }

    class HistoryViewHolder : RecyclerView.ViewHolder {
        var historyTitle : TextView
        var historyDate : TextView

        constructor(v : View) : super(v) {
            historyTitle = v.findViewById(R.id.history_title)
            historyDate = v.findViewById(R.id.history_date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent,false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.historyTitle.text = list.get(position).title
        holder.historyDate.text = list.get(position).date
    }
}