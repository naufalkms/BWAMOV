package com.bagicode.bwamov.home.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bagicode.bwamov.R
import com.bagicode.bwamov.model.Plays
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PlaysAdaptor(private var data: List<Plays>,
                   private val Listener:(Plays) -> Unit)
    : RecyclerView.Adapter<PlaysAdaptor.ViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaysAdaptor.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_play, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PlaysAdaptor.ViewHolder, position: Int) {
      holder.bindItem(data[position], Listener, contextAdapter)
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val tvTitle:TextView = view.findViewById(R.id.tv_kursi)

        private val tvImage:ImageView = view.findViewById(R.id.iv_poster_image)

        fun bindItem(data:Plays, Listener: (Plays) -> Unit, context: Context) {
            tvTitle.setText(data.nama)

            Glide.with(context)
                .load(data.url)
                .apply(RequestOptions.circleCropTransform())
                .into(tvImage)

            itemView.setOnClickListener {
                Listener(data)
            }
        }
    }

}
