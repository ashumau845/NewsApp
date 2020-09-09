package info.ort.recyclerkotlin.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import info.ort.recyclerkodtlin.Songs
import info.ort.recyclerkotlin.R

class MyAdapter(val songs:List<Songs>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.itemview,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt_title.text=songs.get(position).title.trim()
        holder.txt_subttile.text=songs.get(position).desc.trim()
        var color="#CCCCCC"
        if(position % 2==0){
            color="#EEEEEE"
        }

        holder.container.setBackgroundColor(Color.parseColor(color))


    }

}

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var txt_title =itemView.findViewById<TextView>(R.id.txt_title)
    var txt_subttile=itemView.findViewById<TextView>(R.id.txt_description)
    var container=itemView.findViewById<LinearLayout>(R.id.container)
}