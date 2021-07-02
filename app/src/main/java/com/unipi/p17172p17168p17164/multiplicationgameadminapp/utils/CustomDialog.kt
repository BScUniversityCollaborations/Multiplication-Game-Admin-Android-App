package com.unipi.p17172p17168p17164.multiplicationgameadminapp.utils

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import com.unipi.p17172p17168p17164.multiplicationgameadminapp.R

class CustomDialog {

    /*fun showSkipConfirmation(activity: Activity) {
        val dialog = Dialog(activity)
        val binding = DialogSkipBinding.inflate(LayoutInflater.from(activity))

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.window?.setWindowAnimations(R.style.DialogAnimation)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        dialog.window?.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
        )

        dialog.setContentView(binding.root)

        binding.apply {
            btnDismiss.setOnClickListener { dialog.dismiss() }
        }

        dialog.show()
    }*/

}
