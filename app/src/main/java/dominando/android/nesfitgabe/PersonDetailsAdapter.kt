package dominando.android.nesfitgabe

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonDetailsAdapter(private val personDetailsList:MutableList<PersonDetails>):RecyclerView.Adapter<PersonDetailsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var characterName: TextView = itemView.findViewById(R.id.nameText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int { return personDetailsList.size }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personDetails = personDetailsList[position]
        holder.characterName.text = personDetails.name

        val result = position
        val intent  = Intent()
        intent.putExtra("person", personDetailsList[position])
    }


}