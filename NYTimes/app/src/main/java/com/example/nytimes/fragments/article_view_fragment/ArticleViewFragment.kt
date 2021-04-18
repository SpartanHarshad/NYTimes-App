package com.example.nytimes.fragments.article_view_fragment

import android.app.DownloadManager
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.nytimes.databinding.FragmentArticelViewBinding
import dagger.hilt.android.AndroidEntryPoint
import im.delight.android.webview.AdvancedWebView


@AndroidEntryPoint
class ArticleViewFragment : Fragment(), AdvancedWebView.Listener {

    private var _binding: FragmentArticelViewBinding? = null
    private val binding get() = _binding!!
    val args: ArticleViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentArticelViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.webView.getSettings().setAppCacheEnabled(true)

        binding.webView.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                webViewClient = webViewClient
            }
            loadUrl(args.url)
        }*/

        binding.webView.getSettings().setJavaScriptEnabled(false)
        binding.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false)
        binding.webView.setCookiesEnabled(false)
        binding.webView.setThirdPartyCookiesEnabled(false)
        binding.webView.setListener(activity, this)
        binding.webView.setMixedContentAllowed(true)
        binding.webView.loadUrl(args.url, false)

    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
        binding.webView.setVisibility(View.INVISIBLE)
    }

    var shouldDownload = true
    override fun onPageFinished(url: String?) {
        binding.webView.setVisibility(View.VISIBLE)

        val arry = args.url.split("/")

        if (shouldDownload) {
            download(args.url, arry[arry.size - 1])
        }
        Log.d("taggg", arry[arry.size - 1])
    }

    private fun download(fromUrl: String, toFilename: String) {

        if (Build.VERSION.SDK_INT < 9) {
            throw RuntimeException("Method requires API level 9 or above")
        }

        val request = DownloadManager.Request(Uri.parse(fromUrl))
        if (Build.VERSION.SDK_INT >= 11) {
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        }
        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            "/nycTimes/$toFilename"
        )

        val dm = requireContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        try {
            try {
                dm.enqueue(request)
            } catch (e: SecurityException) {
                if (Build.VERSION.SDK_INT >= 11) {
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                }
                dm.enqueue(request)
            }
        } catch (e: IllegalArgumentException) {
            //   return false;
        }
    }

    var something = true
    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
        binding.webView.getSettings().setAllowFileAccess(true)
        val arry = args.url.split("/")
        shouldDownload = false
        if (something) {
            something = false;
            binding.webView.loadUrl(
                Environment.DIRECTORY_DOWNLOADS + "/nycTimes/${arry[arry.size - 1]}"
            )

            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                binding.webView.getSettings().setAllowFileAccess(true);
                binding.webView.loadUrl("file:///sdcard/" + Environment.DIRECTORY_DOWNLOADS + "/nycTimes/${arry[arry.size - 1]}");
            }


        }

        Log.d(
            "taggg",
            Environment.getExternalStorageDirectory()
                .path + Environment.DIRECTORY_DOWNLOADS + "/nycTimes/${arry[arry.size - 1]}" + description
        )

    }

    override fun onDownloadRequested(url: String?, suggestedFilename: String?, mimeType: String?, contentLength: Long,
        contentDisposition: String?, userAgent: String?) {

    }

    override fun onExternalPageRequest(url: String?) {
        TODO("Not yet implemented")
    }
}