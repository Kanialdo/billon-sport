package pl.krystiankaniowski.billonsport.ui.adapter;

import android.view.ViewGroup;

public interface UniversalDelegatedAdapter<Type extends ViewElement> {

    UniversalViewHolder<Type> onCreateViewHolder(ViewGroup viewGroup);

    void onBindViewHolder(UniversalViewHolder<Type> viewHolder, Type item);

    boolean isForViewType(Type item);

}