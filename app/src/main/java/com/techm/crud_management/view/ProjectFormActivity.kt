package com.techm.crud_management.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.techm.crud_management.R
import com.techm.crud_management.adapter.AdapterProject
import com.techm.crud_management.application.ApplicationContext
import com.techm.crud_management.roomdatabase.ModelProject
import com.techm.crud_management.utils.ResponseStatus
import com.techm.crud_management.utils.toast
import com.techm.crud_management.viewmodel.ViewModelProject
import kotlinx.android.synthetic.main.activity_project.*

class ProjectFormActivity : AppCompatActivity(), AdapterProject.ItemClickListener {
    private lateinit var mDataViewModel: ViewModelProject
    private lateinit var mAdapter: AdapterProject
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)
        supportActionBar?.title=getString(R.string.add_project)
        mDataViewModel = ViewModelProvider(this).get(ViewModelProject::class.java)

        /**
         * Setting blank adapter for initialize
         */
        mAdapter = AdapterProject(ArrayList(), ApplicationContext.context, this)
        linearLayoutManager = LinearLayoutManager(this)
        projectDataList.layoutManager = linearLayoutManager
        projectDataList.adapter = mAdapter

        buttonAdd.setOnClickListener {
            if (projectName.text.toString().isNotEmpty()) {
                mDataViewModel.insertProject(projectName.text.toString())
                projectName.setText("")
            }
        }
        /**
         * API Live data observer
         * */
        mDataViewModel.mProjectStatus.observe(this, Observer {

            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    toast(getString(R.string.record_save_successfully))

                    //clearText()
                }
                ResponseStatus.FAIL ->
                    toast(getString(R.string.serviceFailureError))

            }
        })
        mDataViewModel.mProjectData.observe(this, Observer {
            mAdapter.setList(it)
        })
    }


    override fun onItemClick(mModelProject: ModelProject, position: Int) {

    }
}
