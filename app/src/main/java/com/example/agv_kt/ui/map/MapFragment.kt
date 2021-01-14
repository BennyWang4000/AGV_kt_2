package com.example.agv_kt.ui.map

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agv_kt.R
import com.example.agv_kt.base.BaseFragment
import com.example.agv_kt.databinding.FragmentMapBinding
import com.example.agv_kt.network.ApiResult
import com.example.agv_kt.ui.map.adapter.MapPagingAdapter
import com.example.agv_kt.utils.Constant
import com.example.agv_kt.utils.cmd.Command
import kotlinx.android.synthetic.main.fragment_map.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class MapFragment: BaseFragment<FragmentMapBinding>() {

    private val viewModel by viewModel<MapViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.statusData.observe(viewLifecycleOwner, {
//            when (it) {
////                is ApiResult.Loading -> progressHUD?.show()
////                is ApiResult.Loaded -> progressHUD?.dismiss()
//                is ApiResult.Success -> {
////                    binding.textMapTest.text= it.result.statusCode.toString()
//                }
//                is Error -> Timber.e("Error: $it")
//                else -> { }
//            }
//        })

        val mapAdapter= MapPagingAdapter(viewModel)

        recyclerMap.apply {
            layoutManager = GridLayoutManager(context, 7).apply {
                orientation= RecyclerView.VERTICAL
            }
            adapter = mapAdapter
        }

        viewModel.statusData.observe(viewLifecycleOwner, {
            when(it){
                is ApiResult.Success -> {
                    viewModel.refreshMap()
                    viewModel.vehicleYaw= it.result.config.attitude.yaw
                    mapAdapter.notifyDataSetChanged()
                }
                is Error -> Timber.e("Error: $it")
                else -> { }
            }
        })

        viewModel.doCommand(Constant.AGV_NAME, Command.GETTING_ATTRIBUTE)
    }


    override fun setViewModelToBinding(binding: FragmentMapBinding) {
        binding.viewModel = viewModel
    }

    override fun getLayoutId(): Int = R.layout.fragment_map

}