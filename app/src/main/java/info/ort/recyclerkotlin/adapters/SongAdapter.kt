package info.ort.recyclerkotlin.adapters

import android.graphics.Color
import info.ort.recyclerkodtlin.Songs
import info.ort.recyclerkotlin.R
import info.ort.recyclerkotlin.databinding.SongLayoutBinding
import net.simplifiedcoding.androidrecyclerview.BaseRecyclerAdapter

class SongAdapter:BaseRecyclerAdapter<Songs,SongLayoutBinding>(){
    override fun getLayout()= R.layout.song_layout

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<SongLayoutBinding>,
        position: Int
    ) {
        holder.binding.txtTitle.text=items.get(position).title.trim()
        holder.binding.txtDescription.text=items.get(position).desc.trim()
        var color="#CCCCCC"
        if(position % 2==0){
            color="#EEEEEE"
        }
               holder.binding.container.setBackgroundColor(Color.parseColor(color))
    }

}