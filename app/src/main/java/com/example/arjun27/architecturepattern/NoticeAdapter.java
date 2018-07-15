package com.example.arjun27.architecturepattern;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.EmployeeViewHolder> {

    private NoticeList dataList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public NoticeAdapter(NoticeList dataList , RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }


    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtNoticeTitle.setText(dataList.getNoticeArrayList().get(position).getTitle());
        holder.txtNoticeBrief.setText(dataList.getNoticeArrayList().get(position).getBrief());
        holder.txtNoticeFilePath.setText(dataList.getNoticeArrayList().get(position).getFileSource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.getNoticeArrayList().get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.getNoticeArrayList().size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtNoticeTitle, txtNoticeBrief, txtNoticeFilePath;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            txtNoticeTitle =  itemView.findViewById(R.id.txt_notice_title);
            txtNoticeBrief =  itemView.findViewById(R.id.txt_notice_brief);
            txtNoticeFilePath =  itemView.findViewById(R.id.txt_notice_file_path);

        }
    }
}