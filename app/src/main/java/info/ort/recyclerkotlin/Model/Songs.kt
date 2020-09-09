package info.ort.recyclerkodtlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Songs(val title:String="",val desc:String="") : Parcelable