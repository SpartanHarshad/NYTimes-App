package com.example.nytimes.fragments.article_view_fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.nytimes.databinding.FragmentArticelViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleViewFragment : Fragment() {

    private var _binding: FragmentArticelViewBinding? = null
    private val binding get() = _binding!!

    val args: ArticleViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticelViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                webViewClient = webViewClient
            }
            loadUrl(args.url)
        }
    }
}