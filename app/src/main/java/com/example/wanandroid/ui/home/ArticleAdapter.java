package com.example.wanandroid.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wanandroid.R;
import com.example.wanandroid.bean.ArticleBean;
import com.example.wanandroid.databinding.ItemArticleBinding;

/**
 * Created by Miracle on 2020/7/20
 * Email: zhaoqirong96@gmail.com
 * Describe:
 */
public class ArticleAdapter extends ListAdapter<ArticleBean, ArticleAdapter.ArticleViewHolder> {
    protected ArticleAdapter() {
        super(new ArticleDiffCallback());
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemArticleBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_article, parent, false);
        return new ArticleViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        ArticleBean bean = getItem(position);
        holder.bind(bean);
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        private ItemArticleBinding binding;

        public ArticleViewHolder(ItemArticleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(ArticleBean bean) {
            binding.setArticle(bean);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            binding.cbCollection.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                }
            });
        }
    }

    private static class ArticleDiffCallback extends DiffUtil.ItemCallback<ArticleBean> {

        @Override
        public boolean areItemsTheSame(@NonNull ArticleBean oldItem, @NonNull ArticleBean newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ArticleBean oldItem, @NonNull ArticleBean newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }

    }
}
