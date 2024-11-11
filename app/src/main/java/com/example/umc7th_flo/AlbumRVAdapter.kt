package com.example.umc7th_flo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc7th_flo.databinding.ItemAlbumBinding
import java.util.ArrayList

class AlbumRVAdapter(private val albumList: ArrayList<Album>): RecyclerView.Adapter<AlbumRVAdapter.ViewHolder>() {

    interface MyItemClickListener{
        fun onItemClick(album: Album)
        fun onRemoveAlbum(position: Int)
    }

    private lateinit var myItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        myItemClickListener = itemClickListener
    }

    fun addItem(album: Album){
        albumList.add(album)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        albumList.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AlbumRVAdapter.ViewHolder {
        val binding: ItemAlbumBinding = ItemAlbumBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    // position 값을 갖고 있기에 OnClick 메서드는 여기서 처리
    override fun onBindViewHolder(holder: AlbumRVAdapter.ViewHolder, position: Int) {
        holder.bind(albumList[position])
        holder.itemView.setOnClickListener{myItemClickListener.onItemClick(albumList[position])}
//        holder.binding.itemAlbumTitleTv.setOnClickListener{myItemClickListener.onRemoveAlbum(position)}
    }

    override fun getItemCount(): Int = albumList.size

    inner class ViewHolder(val binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album){
            binding.itemAlbumTitleTv.text = album.title
            binding.itemAlbumSingerTv.text = album.singer
            binding.itemAlbumCoverImgIv.setImageResource(album.coverImg!!)
        }
    }
}