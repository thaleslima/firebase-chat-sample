/*
 * ******************************************************************************
 * Copyright (c) 2014 Gabriele Mariotti.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License. *****************************************************************************
 */
package com.gdgcampinas.chat_firebase.animation;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/**
 * 
 * @see android.support.v7.widget.RecyclerView#setItemAnimator(android.support.v7.widget.RecyclerView.ItemAnimator)
 */
public class SlideInOutLeftItemAnimator extends BaseItemAnimator {

    public SlideInOutLeftItemAnimator(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    protected void animateRemoveImpl(final ViewHolder holder) {
        final View view = holder.itemView;
        ViewCompat.animate(view).cancel();
        ViewCompat.animate(view).setDuration(getRemoveDuration())
                .translationX(-mRecyclerView.getWidth()).setListener(new VpaListenerAdapter() {
                    @Override
                    public void onAnimationEnd(View view) {
                        ViewCompat.setTranslationX(view, -mRecyclerView.getWidth());
                        dispatchRemoveFinished(holder);
                        mRemoveAnimations.remove(holder);
                        dispatchFinishedWhenDone();
                    }
                }).start();
        mRemoveAnimations.add(holder);
    }

    @Override
    protected void prepareAnimateAdd(ViewHolder holder) {
        ViewCompat.setTranslationX(holder.itemView, -mRecyclerView.getWidth());
    }

    @Override
    protected void animateAddImpl(final ViewHolder holder) {
        final View view = holder.itemView;

        ViewCompat.animate(view).cancel();
        ViewCompat.animate(view).translationX(0).setDuration(getAddDuration())
                .setListener(new VpaListenerAdapter() {
                    @Override
                    public void onAnimationCancel(View view) {
                        ViewCompat.setTranslationX(view, 0);
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        dispatchAddFinished(holder);
                        mAddAnimations.remove(holder);
                        dispatchFinishedWhenDone();
                    }
                }).start();
        mAddAnimations.add(holder);
    }

    @Override
    public boolean animateChange(ViewHolder arg0, ViewHolder arg1, int arg2, int arg3, int arg4,
            int arg5) {
        // TODO Auto-generated method stub
        return false;
    }

}
