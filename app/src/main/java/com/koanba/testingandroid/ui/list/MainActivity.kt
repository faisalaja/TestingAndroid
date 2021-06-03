package com.koanba.testingandroid.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.koanba.testingandroid.databinding.ActivityMainBinding
import com.koanba.testingandroid.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private var numberPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(mainBinding.root)

        mainBinding.apply {
            btnNext.setOnClickListener {
                numberPage += 1
                setPageList(numberPage)
            }
            btnPrev.setOnClickListener {
                if (numberPage != 1) {
                    numberPage -= 1
                    setPageList(numberPage)
                }
            }
        }

        mainViewModel.getListUser.observe(this, {

            mainBinding.pageNumber.text = it.page.toString()

            mainAdapter = MainAdapter(it.data)
            mainBinding.rvMain.apply {
                layoutManager = LinearLayoutManager(
                    this@MainActivity, LinearLayoutManager.VERTICAL, false
                )
                adapter = mainAdapter
                setHasFixedSize(true)
                addItemDecoration(
                    DividerItemDecoration(
                        this@MainActivity,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }
        })
    }

    override fun onStart() {
        super.onStart()
        setPageList(numberPage)
    }

    private fun setPageList(pageNumber: Int) {
        mainViewModel.getList(pageNumber)
    }
}