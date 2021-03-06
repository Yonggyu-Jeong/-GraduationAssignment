package com.example.shareonfoot.subfragment;

import androidx.fragment.app.Fragment;

//수정해야 함. cardview_codi_info 포함해서 codi_main 액티비티에 선언된 모든 변수들
//layout_codi에서 카드뷰 코디로 바꿔야 함

public class TabFragment_Codi_inCodiMain extends Fragment {
    /*
    String identifier; //프래그먼트의 종류를 알려줌
    String size;

    int gridsize;
    String pagesize;

    ImageView iv_heart;
    ImageView iv_modify;
    ImageView iv_delete;
    TextView tv_cloNo;
    TextView tv_cloFavorite;
    boolean is_favorite;


    int page=0;
    RecyclerView rv_clothes;
    ArrayList<String> ImageUrlList = new ArrayList<String>();
    ArrayList<ClothesVO> clothesList = new ArrayList<ClothesVO>();
    //리사이클러뷰 어댑터
    ClothesListAdapter clothesListAdapter;
    Call<List<ClothesVO>> cloListCall; // 옷 VO 리스트를 응답으로 받는 http 요청


    public static TabFragment_Codi_inCodiMain newInstance(String identifier, String size) {

        Bundle args = new Bundle();
        args.putString("identifier", identifier);  // 키값, 데이터
        args.putString("size", size);

        TabFragment_Codi_inCodiMain fragment = new TabFragment_Codi_inCodiMain();
        fragment.setArguments(args);
        return fragment;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle args = getArguments(); // 데이터 받기
        if(args != null)
        {
            identifier = args.getString("identifier");
            size = args.getString("size");
        }

        switch (size){
            case "small":
                gridsize = 4; //스몰 그리드 4x5
                pagesize="25"; //스몰 페이지 사이즈 25
                break;
            case "medium":
                gridsize = 3; //미디엄 그리드 3x4
                pagesize="17"; //미디엄 페이지 사이즈 17
                break;
            case "large":
                gridsize = 2; //라지 그리드 2x3
                pagesize="7"; //라지 페이지 사이즈 7
                break;
        }

        //리사이클러뷰 어댑터 초기화
        clothesListAdapter = new ClothesListAdapter(getActivity(),ImageUrlList, R.layout.fragment_recyclerview, size);

        clothesListAdapter.setOnItemClickListener(new ClothesListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, ImageView iv_Clothes) {
                ((activity_codi_main) Objects.requireNonNull(getActivity())).Cloth_Info.setVisibility(View.VISIBLE);
                Glide.with((((activity_codi_main) getActivity()).iv_image).getContext()).load(ImageUrlList.get(position)).into(((activity_codi_main) getActivity()).iv_image);
                Glide.with((((activity_codi_main) getActivity()).iv_edit_image).getContext()).load(ImageUrlList.get(position)).into(((activity_codi_main) getActivity()).iv_edit_image);
                ((activity_codi_main)getActivity()).tv_name.setText(clothesList.get(position).getName());
                ((activity_codi_main)getActivity()).tv_category.setText(clothesList.get(position).getClosetName());
                ((activity_codi_main)getActivity()).tv_detailcategory.setText(clothesList.get(position).getCategory());
                ((activity_codi_main)getActivity()).tv_season.setText(clothesList.get(position).getSeason());
                ((activity_codi_main)getActivity()).tv_brand.setText(clothesList.get(position).getBrand());
                ((activity_codi_main)getActivity()).tv_size.setText(clothesList.get(position).getCloSize());
                ((activity_codi_main)getActivity()).tv_date.setText(clothesList.get(position).getDate());

                ((activity_codi_main)getActivity()).tv_cloNo.setText(Integer.toString(clothesList.get(position).getNo()));
                if("yes".equals(clothesList.get(position).getLike())){
                    iv_heart.setImageResource(R.drawable.heart_color);
                    tv_cloFavorite.setText("yes");
                }
                else{
                    iv_heart.setImageResource(R.drawable.heart_empty);
                    tv_cloFavorite.setText("no");
                }

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //현재 페이지수와 함께 웹서버에 옷 데이터 요청
        new networkTask().execute(Integer.toString(page));

        //리사이클러 뷰 설정하기
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rv_clothes = (RecyclerView) view.findViewById(R.id.tab_clothes_rv);
        rv_clothes.setLayoutManager(new GridLayoutManager(getContext(), gridsize)); //그리드 사이즈 설정
        rv_clothes.setAdapter(clothesListAdapter);
        rv_clothes.setNestedScrollingEnabled(true);
        rv_clothes.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if (!rv_clothes.canScrollVertically(-1)) {
                    //스크롤이 최상단이면 데이터를 갱신한다
                    //page = 0;
                    //new networkTask().execute(Integer.toString(page));
                    //Log.e("test","데이터 갱신");
                }
                else if (!rv_clothes.canScrollVertically(1)) {
                    //스크롤이 최하단이면 웹서버에 다음 페이지 옷 데이터 요청
                    new networkTask().execute(Integer.toString(++page));
                    Log.e("test","페이지 수 증가");
                }
                else {
                }
            }
        });

        iv_heart = ((activity_codi_main)getActivity()).iv_heart;
        iv_modify = ((activity_codi_main)getActivity()).iv_modify;
        iv_delete = ((activity_codi_main)getActivity()).iv_delete;
        tv_cloNo = ((activity_codi_main)getActivity()).tv_cloNo;
        tv_cloFavorite = ((activity_codi_main)getActivity()).tv_cloFavorite;
        
        BtnOnClickListener onClickListener = new BtnOnClickListener();
        iv_heart.setOnClickListener(onClickListener);
        iv_modify.setOnClickListener(onClickListener);
        iv_delete.setOnClickListener(onClickListener);

        return view;
    }

    public class networkTask extends AsyncTask<String, Void, List<ClothesVO>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            startTime = Util.getCurrentTime();
        }

        @Override
        protected List<ClothesVO> doInBackground(String... params) {

            switch(identifier){
                case "share" : //모든 옷 조회
                    cloListCall = ClothesService.getRetrofit(getActivity()).myAllClothes(params[0], pagesize);
                    break;
                case "top" : //카테고리 top 조회
                case "bottom" : //카테고리 bottom 조회
                case "suit" : //카테고리 suit 조회
                case "outer" : //카테고리 outer 조회
                case "shoes" : //카테고리 shoes 조회
                case "bag" : //카테고리 bag 조회
                case "accessory" : //카테고리 accessory 조회
                    cloListCall = ClothesService.getRetrofit(getActivity()).chooseCategory(identifier, params[0], pagesize);
                    break;
                case "favorite" : //즐겨찾기 여부가 "yes"인 옷 가져오기
                    cloListCall = ClothesService.getRetrofit(getActivity()).favoriteClothes("yes", params[0], pagesize);
                    break;
            }
            //인자 param[0]은 page.


            try {
                return cloListCall.execute().body();

                // Do something with the response.
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }






        @Override
        protected void onPostExecute(List<ClothesVO> clolist) {
            super.onPostExecute(clolist);
            if(clolist!=null) {
                for(ClothesVO e:clolist) {
                    //옷 데이터를 받아온 후 이미지 url 리스트를 갱신
                    ImageUrlList.add(new String(Global.baseURL+e.getFilePath()));
                    clothesList.add(e);
                    Log.e("item", e.getFilePath());
                }
                clothesListAdapter.notifyDataSetChanged();
            }
        }
    }

    public class FavoriteTask extends AsyncTask<ClothesVO, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(ClothesVO... ClothesFilter) {

            Call<String> stringCall = ClothesService.getRetrofit(((activity_codi_main)getActivity()).getApplicationContext()).modifyClothes(ClothesFilter[0]);
            try {
                return stringCall.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    public class DeleteTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... cloNo) {

            Call<String> stringCall = ClothesService.getRetrofit(((activity_codi_main)getActivity()).getApplicationContext()).deleteClothes(cloNo[0]);
            try {
                return stringCall.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }






    class BtnOnClickListener implements Button.OnClickListener {
        String res="";

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.iv_heart :
                    //필터가 될 vo 설정
                    ClothesVO clothesFilter = new ClothesVO();
                    clothesFilter.setNo(Integer.parseInt(tv_cloNo.getText().toString()));
                    boolean reverted_favorite;
                    //즐겨찾기 여부 불러와서 반대값으로 설정
                    if("yes".equals(tv_cloFavorite.getText().toString())){
                        clothesFilter.setLike("no");
                        reverted_favorite = false;
                    }
                    else{
                        clothesFilter.setLike("yes");
                        reverted_favorite = true;
                    }

                    try {
                        res = new FavoriteTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, clothesFilter).get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e("tag",res);
                    if("ok".equals(res)){
                        if(reverted_favorite){
                            Toast.makeText(((activity_codi_main)getActivity()).getApplicationContext(), "즐겨찾기에 추가했습니다.", Toast.LENGTH_SHORT).show();
                            tv_cloFavorite.setText("yes");
                            iv_heart.setImageResource(R.drawable.heart_color);
                        }else{
                            Toast.makeText(((activity_codi_main)getActivity()).getApplicationContext(), "즐겨찾기를 해제했습니다.", Toast.LENGTH_SHORT).show();
                            tv_cloFavorite.setText("no");
                            iv_heart.setImageResource(R.drawable.heart_empty);
                        }
                    }
                    else
                        Toast.makeText(((activity_codi_main)getActivity()).getApplicationContext(), "즐겨찾기 실패", Toast.LENGTH_SHORT).show();
                    break ;

                case R.id.iv_modify :
                    //((activity_codi_main)getActivity()).Cloth_Info.setVisibility(View.GONE);
                    ((activity_codi_main)getActivity()).Cloth_Info_edit.setVisibility(View.VISIBLE);
                    ((activity_codi_main)getActivity()).tv_edit_date.setText(((activity_codi_main)getActivity()).tv_date.getText());
                    break ;

                case R.id.iv_delete : //삭제
                    //확인 Alert 다이얼로그
                    try {
                        res = new DeleteTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tv_cloNo.getText().toString()).get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if("ok".equals(res)){
                        Toast.makeText(((activity_codi_main)getActivity()).getApplicationContext(), "옷을 삭제했습니다.", Toast.LENGTH_SHORT).show();
                        ((activity_codi_main)getActivity()).Cloth_Info.setVisibility(View.GONE);

                        Intent intent = ((activity_codi_main)getActivity()).getIntent();
                        //intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        ((activity_codi_main)getActivity()).finish();
                        startActivity(intent);
                    }else{
                        Toast.makeText(((activity_codi_main)getActivity()).getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }



    //프래그먼트 갱신
    private void refresh(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.detach(this).attach(this).commit();
    }
/*
    @Override
    public void onDestroy() {
        super.onDestroy();
        try
        {
            if (networkTask.getStatus() == AsyncTask.Status.RUNNING)
            {
                networkTask.cancel(true);
            }
            else
            {
            }
        }
        catch (Exception e)
        {
        }
    }

 */
}
