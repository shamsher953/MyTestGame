package com.bng.mygametest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.unity3d.player.UnityPlayer
import com.unity3d.player.UnityPlayerActivity


class PlayerFragment : Fragment() {

    private var mUnityPlayer: UnityPlayer? = null
    var frameLayoutForUnity: FrameLayout? = null


    companion object {
        lateinit var updateText: TextView

        fun updateTextt(svores: String){
            updateText.setText(svores)

        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mUnityPlayer = UnityPlayer(activity)
        val view: View = inflater.inflate(R.layout.fragment_player, container, false)

        updateText = view.findViewById(R.id.frameLayoutForUnityText)
        frameLayoutForUnity = view.findViewById<View>(R.id.frameLayoutForUnity) as FrameLayout
        frameLayoutForUnity!!.addView(
            mUnityPlayer!!.view,
            FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT
        )

        mUnityPlayer!!.requestFocus()
        mUnityPlayer!!.windowFocusChanged(true)


        return view
    }

    override fun onDestroy() {
        mUnityPlayer!!.quit()
        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
        mUnityPlayer!!.pause()
    }

    override fun onResume() {
        super.onResume()
        mUnityPlayer!!.resume()
    }
}
