package com.kismiwati.homospecies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kismiwati.homospecies.databinding.FragmentHomoBinding

private const val ARG_HOMO_ID = "homo_id"

class HomoFragment : Fragment() {
    private lateinit var binding : FragmentHomoBinding
    private var homoId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            homoId = it.getInt(ARG_HOMO_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // pada bagian ini digunakan untuk Mengembang tata letak untuk fragmen ini dengan tema fragment_homo
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homo, container, false)
        // Layout tampilan untuk fragment
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    // Method ini dipanggil sesaat setelah onCreateView().
    // Semua pembacaan view dan penambahan listener dilakukan disini (atau
    // bisa juga didalam onCreateView)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homo = homos.singleOrNull{ it.id == homoId}
        homo.let {
            binding.homo = it
        }
    }
    //class yang dipanggil tanpa melalui objek
    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            HomoFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_HOMO_ID, param1)
                }
            }
    }
}