package com.example.canvas_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Base64
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import java.io.ByteArrayOutputStream

class CanvasView(context: Context, attrs: AttributeSet? = null): View(context, attrs) {

    private var mPaint: Paint
    private var mPath = Path()
    private var pathList = mutableListOf<Path>()

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.background_canvas))
        mPaint = Paint().apply {
            isAntiAlias = true
            isDither = true
            color = Color.WHITE
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            strokeCap = Paint.Cap.ROUND
            strokeWidth = 24f
        }
    }

    override fun onDraw(canvas: Canvas) {
        for (path in pathList) {
            canvas.drawPath(path, mPaint)
            invalidate()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event?.x
        val y = event?.y

        if (x == null || y == null) return false

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mPath.moveTo(x, y)
            }
            MotionEvent.ACTION_MOVE -> {
                mPath.lineTo(x ,y)
                pathList.add(mPath)
            }
        }
        postInvalidate()
        return true
    }

    fun clear() {
        pathList.clear()
        mPath.reset()
        invalidate()
    }

    fun getBase64(): String {
        val bitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.RGB_565)
        val canvas = Canvas(bitmap)
        draw(canvas)
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return Base64.encodeToString(stream.toByteArray(), Base64.DEFAULT)
    }
}