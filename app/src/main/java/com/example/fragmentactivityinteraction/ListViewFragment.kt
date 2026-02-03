package com.example.fragmentactivityinteraction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Carousel
import com.example.fragmentactivityinteraction.databinding.FragmentListViewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
public class ListViewFragment : Fragment() {
   val binding by lazy {
        FragmentListViewBinding.inflate(layoutInflater)
    }

    lateinit var arrayadapterView: ArrayAdapter<String>
    var studentlist = arrayListOf("Rajneesh","Mukesh","Abhishek","Rajat")
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arrayadapterView = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,studentlist)
        binding.listView.adapter = arrayadapterView
        binding.btn.setOnClickListener {
            studentlist.add("Coder Roots")
            arrayadapterView.notifyDataSetChanged()
        }
        binding.listView.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { parent, view, position, id ->
                studentlist.removeAt(position)
                arrayadapterView.notifyDataSetChanged()
                true
            }
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                studentlist[position] = "Coder Roots"
                arrayadapterView.notifyDataSetChanged()
                true
            }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}