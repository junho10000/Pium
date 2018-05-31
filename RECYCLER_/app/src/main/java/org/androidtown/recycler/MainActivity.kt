package org.androidtown.recycler

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //RecyclerView의 layout을 그리드뷰로 만들것으로 정의 하는 부분 // 첫번쨰 라인은 spanCount를 1로 지정해준다.

        var layoutManager = GridLayoutManager(this, 3)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0) 3 else 1
            }
        }
        mainRecyclerView.layoutManager = layoutManager

        //어뎁터로 연결
        val myRecyclerViewAdapter = MyRecyclerViewAdapter()
        mainRecyclerView.adapter = myRecyclerViewAdapter


    }




}
