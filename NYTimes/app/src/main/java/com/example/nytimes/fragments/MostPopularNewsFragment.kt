package com.example.nytimes.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.os.StrictMode
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.adapters.NewsAdapter
import com.example.nytimes.clickListeners.OnClickOfNews
import com.example.nytimes.local.entity.ArticleItemEntity
import com.example.nytimes.util.Resource
import com.example.nytimes.viewmodels.NewsViewModel
import com.example.nytimes.viewmodels.MostPopularNewsviewModel
import com.robertsimoes.shareable.Shareable
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_most_popular_news.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


@AndroidEntryPoint
class MostPopularNewsFragment : Fragment(), OnClickOfNews {

    lateinit var newsAdapter: NewsAdapter
    val newsViewModel: NewsViewModel by viewModels()
    var news = mutableListOf<ArticleItemEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val builder: StrictMode.VmPolicy.Builder =       StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_most_popular_news, container, false)
    }

    companion object {
        fun newInstance(): MostPopularNewsFragment {
            return MostPopularNewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerData()
        observNews()
        ivBackToSections.setOnClickListener {
            launchSections()
        }
    }

    private fun setRecyclerData() {
        newsAdapter = NewsAdapter(news, this)
        rvMostPopularNews.layoutManager = LinearLayoutManager(context)
        rvMostPopularNews.adapter = newsAdapter
    }

    private fun observNews() {
        newsViewModel.getMostPopularNews("mostpopular").observe(
            viewLifecycleOwner,
            Observer { result ->
                news.clear()
                news.addAll(result.data!!)
                newsAdapter.notifyDataSetChanged()

                result is Resource.Loading && result.data.isNullOrEmpty()


            })
    }

    private fun launchSections() {

        val action =
            MostPopularNewsFragmentDirections.actionMostPopularNewsFragmentToSectionFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun getNews(result: ArticleItemEntity) {
        val action =
            MostPopularNewsFragmentDirections.actionMostPopularNewsFragmentToArticleViewFragment(
                result.url!!
            )
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun forwardNews(url: String, image: Bitmap?) {
        forwardNewsOnSocialMedia(url, image)
    }

    fun forwardNewsOnSocialMedia(url: String, image: Bitmap?) {

        try {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_STREAM, getBitmapFromView(image))
            startActivity(Intent.createChooser(intent, "Share Image"))

        } catch (e: Exception) {
            e.printStackTrace()
        }

    fun forwardNewsOnSocialMedia(url: String) {

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, url)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Forward")
        /*startActivity(shareIntent)*/
    }


    private fun getBitmapFromView(bmp: Bitmap?): Uri? {
        var bmpUri: Uri? = null
        try {
            val file = File(activity?.externalCacheDir, System.currentTimeMillis().toString() + ".jpg")

            val out = FileOutputStream(file)
            bmp?.compress(Bitmap.CompressFormat.JPEG, 90, out)
            out.close()
            bmpUri = Uri.fromFile(file)

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bmpUri
    }


}