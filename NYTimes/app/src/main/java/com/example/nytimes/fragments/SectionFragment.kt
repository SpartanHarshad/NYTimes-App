package com.example.nytimes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.adapters.SectionAdapter
import com.example.nytimes.clickListeners.OnClickListener
import com.example.nytimes.model.Sections
import com.example.nytimes.repository.SectionRepository
import com.example.nytimes.viewmodels.AllSectionsViewModel
import com.example.nytimes.viewmodels.AllSectionsViewModelFactory
import kotlinx.android.synthetic.main.fragment_section.*


class SectionFragment : Fragment(), OnClickListener {

    lateinit var sectionAdapter: SectionAdapter
    lateinit var sectionsViewModel: AllSectionsViewModel
    var lists: List<Sections> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_section, container, false)
    }

    companion object {
        fun newInstance(): SectionFragment {
            return SectionFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repo = SectionRepository()
        val viewmodelFactory = AllSectionsViewModelFactory(repo)
        sectionsViewModel =
            ViewModelProviders.of(this, viewmodelFactory).get(AllSectionsViewModel::class.java)
        lists = sectionsViewModel.allSectionsModel()
        setRecyclerData()
    }

    private fun setRecyclerData() {
        sectionAdapter = SectionAdapter(lists, this)
        rvSection.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvSection.adapter = sectionAdapter
    }

    override fun getSectionName(sections: Sections) {
        var sectionName = sections.name.replace("\\s".toRegex(), "")
        when (sectionName) {
            "MostPopular" -> {
                launchMostPopular()
            }
            "World" -> {
                launchWorld()
            }
            "U.S." -> {
                launchUS()
            }
            "Politics" -> {
                launchPolitics()
            }
            "Business" -> {
                launchBusiness()
            }
            "Sports" -> {
                launchSports()
            }
            "Arts" -> {
                launchArts()
            }
            "Magazine" -> {
                launchMagazine()
            }
            "ReaderCenter" -> {
                launchReaderCenter()
            }
            "Photos" -> {
                launchPhotos()
            }
            "Technology" -> {
                launchTechnology()
            }
            "Health" -> {
                launchHealth()
            }
        }
        //Toast.makeText(context, "${sectionName} Section Clicked", Toast.LENGTH_SHORT).show()
    }

    private fun launchMostPopular() {
        val action = SectionFragmentDirections.actionSectionFragmentToHiltMostPopularNewsFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchWorld() {
        val action = SectionFragmentDirections.actionSectionFragmentToWorldNewsFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchUS() {
        val action = SectionFragmentDirections.actionSectionFragmentToUSNewsFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchPolitics() {
        val action = SectionFragmentDirections.actionSectionFragmentToPoliticsNewsFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchBusiness() {
        val action = SectionFragmentDirections.actionSectionFragmentToBusinessNewsFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchSports() {
        val action = SectionFragmentDirections.actionSectionFragmentToSportsFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchArts() {
        val action = SectionFragmentDirections.actionSectionFragmentToArtsNewsFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchMagazine() {
        val action = SectionFragmentDirections.actionSectionFragmentToMagazineFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchReaderCenter() {
        val action = SectionFragmentDirections.actionSectionFragmentToReaderCenterFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchPhotos() {
        val action = SectionFragmentDirections.actionSectionFragmentToPhotosFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchTechnology() {
        val action = SectionFragmentDirections.actionSectionFragmentToTechnologyFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchHealth() {
        val action = SectionFragmentDirections.actionSectionFragmentToHealthFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }
}