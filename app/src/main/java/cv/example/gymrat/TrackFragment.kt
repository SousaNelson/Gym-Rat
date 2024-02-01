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
        binding = FragmentTrackBinding.inflate(inflater, container, false)
        val rootView = binding.root

        // Encontrar id do webView
        val webView = binding.webView
        // em caso de haver javascript no site, abaixo é para habilita-lo
        webView.settings.javaScriptEnabled = true
        // Configurar o WebViewClient para tratar a navegação dentro do WebView
        webView.webViewClient = WebViewClient()
        // Carregar o website que se deseja
        webView.loadUrl("https://www.google.com/maps/@16.8818466,-24.9872705,15z?entry=ttu")


        return rootView
    }
}
