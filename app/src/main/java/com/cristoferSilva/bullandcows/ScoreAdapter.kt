package com.cristoferSilva.bullandcows

import android.os.Parcel
import android.os.Parcelable
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ScoreAdapter() : RecyclerView.Adapter<TextItemViewHolder>(), Parcelable {

    var data = listOf<String>()
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ScoreAdapter> {
        override fun createFromParcel(parcel: Parcel): ScoreAdapter {
            return ScoreAdapter(parcel)
        }

        override fun newArray(size: Int): Array<ScoreAdapter?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}