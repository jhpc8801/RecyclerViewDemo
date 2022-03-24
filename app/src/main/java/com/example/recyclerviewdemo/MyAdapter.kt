package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val studentList : List<Student>,
                private val listener: OnItemClickListener)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder> () {

    inner class MyViewHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvId: TextView = view.findViewById(R.id.tvId)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvProgramme: TextView = view.findViewById(R.id.tvProgramme)
        val imgPhoto : ImageView = view.findViewById(R.id.imgPhoto)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            // to ensure the position click by the user, is having an item
            val position = bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.itemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun itemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentStudent = studentList[position]
        holder.tvId. text = currentStudent.id
        holder.tvName.text = currentStudent.name
        holder.tvProgramme.text = currentStudent.programme

        if (currentStudent.gender == "F") {
            holder.imgPhoto.setImageResource(R.drawable.ic_female)
        } else {
            holder.imgPhoto.setImageResource(R.drawable.ic_male)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

}