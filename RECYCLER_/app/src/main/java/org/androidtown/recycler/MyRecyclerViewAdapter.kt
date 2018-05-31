package org.androidtown.recycler


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

import de.hdodenhof.circleimageview.CircleImageView

//RecyclerView.adapter를 상속받은 Class// Main에서 mainRecyclerView.adapter로 mapping시킨다


class MyRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //아이템들의 배열
    var memberDTOs = ArrayList<MemberDTO>()

    init {
        memberDTOs.add(MemberDTO(R.drawable.img_01, "Poppy", "#poppy", "#depression"))
        memberDTOs.add(MemberDTO(R.drawable.img2, "Freesia", "#Freesia", "#depression"))
        memberDTOs.add(MemberDTO(R.drawable.img_03, "Jabong", "#Jabong", "#depression"))
        memberDTOs.add(MemberDTO(R.drawable.img_04, "Lemon", "#Lemon", "#depression"))
        memberDTOs.add(MemberDTO(R.drawable.img_05, "Lilac", "#Lilac", "#depression"))
        memberDTOs.add(MemberDTO(R.drawable.img_06, "Pine", "#Pine", "#depression"))
        memberDTOs.add(MemberDTO(R.drawable.img_07, "Jasmine", "#Jasmine", "#depression"))
        memberDTOs.add(MemberDTO(R.drawable.img_08, "Lavandula", "#Lavandula", "#depression"))


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        //XML 디자인 한 부분 적용
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)


        return RowCell(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //XML 디자인한 부분에 안에 내용 변경 (image, name, hashtag, hashtag2)

        if (position == 0) {
            var Size: Int = memberDTOs.size
            (holder as RowCell).title.text = "My Scent "
            holder.scentSize.text = "$Size"
            holder.name.maxHeight = 0
            holder.hashtag.maxHeight = 0
            holder.hashtag2.maxHeight = 0


        } else {
            (holder as RowCell).circleImageView.setImageResource(memberDTOs[position-1].image)
            holder.name.text = memberDTOs[position-1].name
            holder.hashtag.text = memberDTOs[position-1].hashtag
            holder.hashtag2.text = memberDTOs[position-1].hashtag2

        }


    }

    override fun getItemCount(): Int {

        //아이템의 개수 측정
        return memberDTOs.size + 1
    }


    private class RowCell(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var scentSize: TextView
        var circleImageView: CircleImageView
        var name: TextView
        var hashtag: TextView
        var hashtag2: TextView

        init {
            title = view.findViewById(R.id.title)
            scentSize = view.findViewById(R.id.scentSize)
            circleImageView = view.findViewById(R.id.profile_image)
            name = view.findViewById(R.id.name)
            hashtag = view.findViewById(R.id.hashtag)
            hashtag2 = view.findViewById(R.id.hashtag2)
        }
    }


}
