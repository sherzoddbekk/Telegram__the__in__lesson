package com.example.telegramthelesson.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramthelesson.R
import com.example.telegramthelesson.model.Chat
import com.google.android.material.imageview.ShapeableImageView

data class ChatAdapter(var context: Context, var items: ArrayList<Chat>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val view  =  LayoutInflater.from(parent.context).inflate(R.layout.item_chat_layout,parent,false)
        return MessageViewHplder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if (holder is MessageViewHplder){
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            var tv_message = holder.tv_message

            iv_profile.setImageResource(chat.profile)
            tv_fullname.text = chat.fullname
            tv_message.text = chat.message
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class MessageViewHplder(var view: View):RecyclerView.ViewHolder(view){
        var iv_profile:ShapeableImageView
        var  tv_fullname:TextView
        var tv_message:TextView

        init {
            iv_profile = view.findViewById(R.id.profile)
            tv_fullname = view.findViewById(R.id.fullname)
            tv_message = view.findViewById(R.id.tv_message)
        }
    }
}