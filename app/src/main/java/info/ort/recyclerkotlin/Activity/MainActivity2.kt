package info.ort.recyclerkotlin.Activity

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import info.ort.recyclerkotlin.R
import info.ort.recyclerkotlin.databinding.ActivityMain3Binding


class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,
            R.layout.activity_main3
        )
    val url=intent.getStringExtra("URL")
        if(url!=null){
            binding.detailwebview.settings.javaScriptEnabled=true
            binding.detailwebview.getSettings().setUserAgentString("Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3")
            binding.detailwebview.webViewClient=object: WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressBar.visibility=View.GONE
                    binding.detailwebview.visibility=View.VISIBLE
                }
            }
            binding.detailwebview.loadUrl(url)
        }

    }


}