package org.androidtown.recycler


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import kotlinx.android.synthetic.main.recyclerview_item.view.*

//RecyclerView.adapter를 상속받은 Class// Main에서 mainRecyclerView.adapter로 mapping시킨다
class MyRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //아이템들의 배열
    var scentMembers = ArrayList<ScentMember>()

    init
    {
        scentMembers.add(ScentMember(R.drawable.img_01, "Poppy", "#poppy", "#depression"))
        scentMembers.add(ScentMember(R.drawable.img2, "Freesia", "#Freesia", "#depression"))
        scentMembers.add(ScentMember(R.drawable.img_03, "Jabong", "#Jabong", "#depression"))
        scentMembers.add(ScentMember(R.drawable.img_04, "Lemon", "#Lemon", "#depression"))
        scentMembers.add(ScentMember(R.drawable.img_05, "Lilac", "#Lilac", "#depression"))
        scentMembers.add(ScentMember(R.drawable.img_06, "Pine", "#Pine", "#depression"))
        scentMembers.add(ScentMember(R.drawable.img_07, "Jasmine", "#Jasmine", "#depression"))
        scentMembers.add(ScentMember(R.drawable.img_08, "Lavandula", "#Lavandula", "#depression"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        //XML 디자인 한 부분 적용
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)

        return ItemCell(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    {
        //XML 디자인한 부분에 안에 내용 변경 (image, name, info1, info2)
        if ( position == 0 )
        {
            var Size: Int = scentMembers.size
            (holder as ItemCell).title.text = "My Scent "
            holder.scentSize.text = "$Size"
            holder.scentName.maxHeight = 0
            holder.scentInfo1.maxHeight = 0
            holder.scentInfo2.maxHeight = 0
        } else
        {
            (holder as ItemCell).scentImage.setImageResource(scentMembers[position-1].m_Image)
            holder.scentName.text = scentMembers[position-1].m_Name
            holder.scentInfo1.text = scentMembers[position-1].m_Info1
            holder.scentInfo2.text = scentMembers[position-1].m_Info2
        }
    }

    override fun getItemCount(): Int
    {
        //아이템의 개수 측정
        return scentMembers.size + 1
    }

    private class ItemCell(view: View) : RecyclerView.ViewHolder(view)
    {
        var title = view.itemTitle
        var scentSize = view.itemScentSize
        var scentImage = view.itemScentImage
        var scentName = view.itemScentName
        var scentInfo1 = view.itemScentInfo1
        var scentInfo2 = view.itemScentInfo2
    }
}
