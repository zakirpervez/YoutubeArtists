package com.valuelabs.youtubeartists.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.valuelabs.youtubeartists.R
import com.valuelabs.youtubeartists.databinding.SearchItemBinding
import com.valuelabs.youtubeartists.models.VideoItem

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private val videoItems: MutableList<VideoItem?> = mutableListOf()
    private var searchItemClickListener: SearchItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            SearchItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val videoItem = videoItems[position]
        holder.binding.videoModel = videoItem
        holder.binding.idModel = videoItem?.id

        val thumbnailUrl = "http://img.youtube.com/vi/${videoItem?.id?.videoId}/0.jpg"
        Glide
            .with(holder.binding.root.context)
            .load(thumbnailUrl)
            .into(holder.binding.ytImageView)

        holder.binding.root.setOnClickListener {
            searchItemClickListener?.onSearchItemClick(videoItem!!)
        }
    }

    override fun getItemCount(): Int = videoItems.size

    fun populateList(list: List<VideoItem?>) {
        if (videoItems.isNotEmpty()) videoItems.clear()
        videoItems.addAll(list)
        notifyDataSetChanged()
    }

    fun setSearchItemClickListener(listener: SearchItemClickListener) {
        searchItemClickListener = listener
    }

    class SearchViewHolder(val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root)
    interface SearchItemClickListener {
        fun onSearchItemClick(videoItem: VideoItem)
    }
}