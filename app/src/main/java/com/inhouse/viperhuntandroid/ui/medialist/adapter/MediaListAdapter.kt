package com.inhouse.viperhuntandroid.ui.medialist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.inhouse.viperhuntandroid.R
import com.inhouse.viperhuntandroid.app.models.Media
import com.inhouse.viperhuntandroid.databinding.MediaListItemBinding

class MediaListAdapter(private val itemClickListener: ItemClickListener) :
    ListAdapter<Media, MediaListAdapter.ViewHolder>(MediaItemDiffCallback()) {
    class ViewHolder(private val binding: MediaListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(media: Media) {
            binding.tvArtistName.text = media.artistName
            binding.tvTrackName.text = media.trackName
            Glide.with(binding.ivArtistThumbnail.context)
                .load(media.artworkUrl100).apply {
                    RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image)
                }
                .into(binding.ivArtistThumbnail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            MediaListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val media: Media = getItem(position)
        holder.itemView.setOnClickListener { itemClickListener.onItemClicked(media) }
        holder.bind(media)
    }

    interface ItemClickListener {
        fun onItemClicked(media: Media)
    }
}

class MediaItemDiffCallback : DiffUtil.ItemCallback<Media>() {
    override fun areItemsTheSame(oldItem: Media, newItem: Media): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Media, newItem: Media): Boolean =
        oldItem.artistId == newItem.artistId && oldItem.trackId == newItem.trackId
}
