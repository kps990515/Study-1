package com.mdy.android.musicplayer2;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mdy.android.musicplayer2.ListFragment.OnListFragmentInteractionListener;
import com.mdy.android.musicplayer2.domain.Music;
import com.mdy.android.musicplayer2.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final OnListFragmentInteractionListener mListener;

    // Gilde에 context를 주기 위해 선언
    private Context context = null;
    // 데이터 저장소
    private final List<Music.Item> datas;

    public ListAdapter(Set<Music.Item> items, OnListFragmentInteractionListener listener) {
        mListener = listener;

        // set에서 데이터 꺼내서 사용을 하는데 index를 필요로 하는 경우 array 에 담는다
        datas = new ArrayList<>(items);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null)
            context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // datas 저장소에 들어가 있는 Music.Item 한개를 꺼낸다. (position에 맞게끔)
        //Music.Item item = datas.get(position);

        holder.position = position;

        holder.mIdView.setText(datas.get(position).id);
        holder.mContentView.setText(datas.get(position).title);

        //holder.imgAlbum.setImageURI(datas.get(position).albumArt);
        Glide
                .with(context)                          // 글라이드 사용
                .load(datas.get(position).albumArt)     // 로드할 대상 Uri
                .placeholder(R.mipmap.icon)             // 로드가 안됐을 경우
                .bitmapTransform(new CropCircleTransformation(context))
                .into(holder.imgAlbum);                 // 이미지를 출력할 대상을 지정 (입력될 이미지뷰)


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static final int STOP = 0;
    static final int PLAY = 1;
    static final int PAUSE = 2;
    MediaPlayer player = null;
    int playerStatus = STOP;


    public void play(int position){
        // 1. 미디어 플레이어 사용하기
        Uri musicUri = datas.get(position).musicUri;
        if(player != null) {
            player.release();
        }
        player = MediaPlayer.create(context, musicUri);

        // 2. 설정
        player.setLooping(false);   // 반복여부

        // 3. 시작
        player.start();

        playerStatus = PLAY;
    }

    public void pause(){
        player.pause();
        playerStatus = PAUSE;
    }

    public void replay(){
        player.start();
    }

    public void goDetail(int position){

    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public int position;
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageView imgAlbum;
        public final ImageButton btnPause;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            imgAlbum = (ImageView) view.findViewById(R.id.imgAlbum);
            btnPause = (ImageButton) view.findViewById(R.id.btnPause);



            // 플레이
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    play(position);
                    btnPause.setImageResource(android.R.drawable.ic_media_pause);
                    btnPause.setVisibility(View.VISIBLE);
                }
            });


            btnPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (playerStatus){
                        case PLAY:
                            pause();
                            // pause 가 클릭되면 이미지 모양이 play 로 바뀐다.
                            btnPause.setImageResource(android.R.drawable.ic_media_play);
                            break;
                        case PAUSE:
                            replay();
                            playerStatus = PLAY;
                            btnPause.setImageResource(android.R.drawable.ic_media_pause);
                            break;
                    }
                }
            });


            // 상세보기로 이동 -> 뷰페이저로 이동
            mView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    goDetail(position);
                    return true;    // return true를 하면 롱클릭 후 onClick이 실행되지 않도록 해준다.
                }
            });
        }








    }





}