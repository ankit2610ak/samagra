package com.example.samagra.core.loader

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import com.example.samagra.R
import kotlinx.android.synthetic.main.widget_loader.view.*


class Loader @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_loader, this)
        loader.setActualImageResource(R.drawable.loader)
        orientation = VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL
        val animator = ObjectAnimator.ofFloat(loader, "rotationY", -180f, 180f)
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = -1
        animator.duration = 1000
        animator.start()
    }
}
