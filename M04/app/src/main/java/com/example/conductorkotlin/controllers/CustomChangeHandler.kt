package com.example.conductorkotlin.controllers

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.changehandler.AnimatorChangeHandler

class CustomChangeHandler : AnimatorChangeHandler(){
    override fun getAnimator(
        container: ViewGroup,
        from: View?,
        to: View?,
        isPush: Boolean,
        toAddedToContainer: Boolean
    ): Animator {
        //todo 6 adding a custom animator
        val animator = AnimatorSet()
        to?.let {
            animator.play(ObjectAnimator.ofFloat(to, View.SCALE_X, 0f, 1f))
            animator.play(ObjectAnimator.ofFloat(to, View.SCALE_Y, 0f, 1f))
        }
        return animator
    }

    override fun resetFromView(from: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}