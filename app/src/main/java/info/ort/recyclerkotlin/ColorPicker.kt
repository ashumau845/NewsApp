package info.ort.recyclerkotlin

import android.util.Log

object ColorPicker {
    val colors=
        arrayOf("#C0C0C0","#808080","#000000","#FF0000","#800000","#FFFF00","#808000","#00FF00","#008000","#00FFFF","#008080","#0000FF","#000080","#FF00FF","#800080")


        var colorIndex=1
        fun getColor():String{
            Log.i("TAG",colors[colorIndex++ % colors.size]+" "+(colorIndex++ % colors.size))
            return colors[colorIndex++ % colors.size]
        }
}