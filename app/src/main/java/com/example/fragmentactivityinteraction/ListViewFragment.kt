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

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

public class ListViewFragment : Fragment() {

   val binding by lazy {
        FragmentListViewBinding.inflate(layoutInflater)
    }

    lateinit var arrayadapterView: ArrayAdapter<String>
    val list = arrayListOf("Abhishek","Mukesh","Rajat","Rajneesh")
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
        arrayadapterView = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,list)
        binding.listView.adapter = arrayadapterView


        //list.add(StudentModel("Coder Roots",123))
        binding.btn.setOnClickListener {
            list.add("Coder Roots")
            arrayadapterView.notifyDataSetChanged()
        }
        binding.listView.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { parent, view, position, id ->
                list.removeAt(position)
                arrayadapterView.notifyDataSetChanged()
                true
            }
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
               list[position] = "Coder Roots"
                arrayadapterView.notifyDataSetChanged()
            }
        return binding.root
    }

    companion object {
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