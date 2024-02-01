package cv.example.gymrat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import cv.example.gymrat.databinding.FragmentTrackBinding

class TrackFragment : Fragment() {

    private lateinit var binding: FragmentTrackBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_track, container, false)

        //val webView: WebView = rootView.findViewById(R.id.webView)
        //webView.webViewClient = WebViewClient()
        //webView.loadUrl("https://www.uta.cv") // Substitua pela URL desejada

        return rootView
    }
}
