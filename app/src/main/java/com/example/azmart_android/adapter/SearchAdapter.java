package com.example.azmart_android.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.azmart_android.R;
import com.example.azmart_android.databinding.SearchItemBinding;
import com.example.azmart_android.data.model.SearchResponse;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    SearchResponse searchResponseList;

    public SearchAdapter(SearchResponse searchResponseList) {
        this.searchResponseList = searchResponseList;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchViewHolder(SearchItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.setData(searchResponseList.getDocs().get(position));
    }

    @Override
    public int getItemCount() {
        return searchResponseList != null ? searchResponseList.getDocs().size() : 0;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        private SearchItemBinding searchItemBinding;

        public SearchViewHolder(SearchItemBinding itemView) {
            super(itemView.getRoot());
            this.searchItemBinding = itemView;
        }

        void setData(SearchResponse.Docs docs) {
            try {
                searchItemBinding.tvTitle.setText(docs.getProductTitle());
                Glide.with(searchItemBinding.getRoot().getContext())
                        .load(docs.getProductMainImageUrl())
                        .placeholder(R.drawable.ic_image_placeholder)
                        .error(R.drawable.ic_image_error)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(searchItemBinding.ivProduct);
                searchItemBinding.tvPrice.setText(docs.getMetadata().getPrices().getSalePrice().getFormattedPrice());

            }catch (Exception e){
                Log.e("error :",e.toString());
            }
        }
    }

    public void updateSearchListItems(List<SearchResponse.Docs> searchResponseList) {
        final SearchDiffCallback diffCallback = new SearchDiffCallback(this.searchResponseList.getDocs(), searchResponseList);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.searchResponseList.getDocs().clear();
        this.searchResponseList.getDocs().addAll(searchResponseList);
        diffResult.dispatchUpdatesTo(this);
    }
}

class SearchDiffCallback extends DiffUtil.Callback {

    private final List<SearchResponse.Docs> mOldSearchList;
    private final List<SearchResponse.Docs> mNewSearchList;

    SearchDiffCallback(List<SearchResponse.Docs> mOldSearchList, List<SearchResponse.Docs> mNewSearchList) {
        this.mOldSearchList = mOldSearchList;
        this.mNewSearchList = mNewSearchList;
    }

    @Override
    public int getOldListSize() {
        return mOldSearchList != null ? mOldSearchList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return mNewSearchList != null ? mNewSearchList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        /*return mOldSearchList.get(oldItemPosition).get == mNewSearchList.get(
                newItemPosition).getDocs();*/
        return true;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final SearchResponse.Docs oldSearch = mOldSearchList.get(oldItemPosition);
        final SearchResponse.Docs newSearch = mNewSearchList.get(newItemPosition);

        return oldSearch.equals(newSearch);
    }
}


