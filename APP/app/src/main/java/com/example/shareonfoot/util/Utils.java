package com.example.shareonfoot.util;

import android.content.Context;
import android.util.Log;

import com.example.shareonfoot.R;
import com.google.gson.internal.LinkedTreeMap;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Utils {

    public Map<String, String> mapColors;
    public String[] color_name;
    public String[] color_code;
    Context context;


    public static class Kind {
        //final static int ALL = 0;
        public final static int FOOD = 0;
        public final static int CAFE = 1;
        public final static int DESERT = 2;
        public final static int PLAY = 3;
        public final static int BOOKSTORE = 4;
        public final static int SALON = 5;
        public final static int BAR = 6;
        public final static int FASHION = 7;
        public final static int OTHER = 8;
        public static final List<Integer> kindList = new ArrayList<Integer>(Arrays.asList(FOOD,CAFE,DESERT,PLAY,BOOKSTORE,SALON,BAR,FASHION,OTHER));

        public static final HashMap<String,Integer> kindNumMap = new HashMap<>();
        static {
            kindNumMap.put("음식", FOOD);
            kindNumMap.put("카페", CAFE);
            kindNumMap.put("디저트", DESERT);
            kindNumMap.put("놀거리", PLAY);
            kindNumMap.put("서점", BOOKSTORE);
            kindNumMap.put("미용실", SALON);
            kindNumMap.put("포차", BAR);
            kindNumMap.put("패선", FASHION);
            kindNumMap.put("기타", OTHER);
        }
    }


    static int [][] score_rule= new int[][]{
        {50,10,	50,	40,	40,	40,	20,	20,	20,	20,	40,	40,	40,	40,	20,	50,	20,	20,	50},
        {50	,10	,30	,50	,50	,40	,40	,40	,20	,50	,50	,50	,40	,40	,50	,50	,50	,20	,40},
        {50	,30	,20	,20	,20	,20	,20	,20	,50	,10	,20	,50	,0	,0	,20	,20	,50	,20	,40},
        {50	,50	,20	,50	,50	,40	,50	,50	,20	,20	,20	,20	,40	,40	,20	,20	,20	,20	,20},
        {50	,50	,50	,50	,50	,40	,20	,20	,20	,50	,40	,20	,40	,40	,20	,20	,50	,20	,20},
        {40	,50	,20	,40	,40	,20	,20	,20	,20	,50	,40	,10	,20	,20	,20	,20	,20	,20	,20},
        {30	,30	,20	,20	,20	,20	,10	,40	,50	,10	,10	,50	,0	,0	,20	,20	,20	,20	,20},
        {50	,30	,20	,10	,10	,20	,40	,10	,50	,10	,10	,50	,0	,0	,20	,20	,20	,20	,20},
        {0	,20	,50	,20	,20	,20	,50	,50	,20	,20	,20	,50	,50	,50	,20	,20	,20	,20	,20},
        {40	,50	,50	,40	,40	,50	,40	,40	,50	,40	,50	,50	,0	,0	,50	,20	,50	,20	,20},
        {40	,50	,50	,40	,40	,50	,40	,40	,50	,10	,20	,10	,0	,0	,50	,20	,50	,20	,20},
        {30	,50	,50	,40	,40	,50	,50	,50	,50	,40	,40	,10	,40	,40	,50	,20	,50	,20	,20},
        {30	,20	,20	,20	,20	,10	,20	,20	,50	,20	,40	,50	,10	,10	,20	,20	,50	,20	,20},
        {50	,20	,20	,40	,40	,10	,20	,20	,50	,20	,40	,50	,10	,10	,20	,20	,50	,20	,20},
        {40	,10	,20	,40	,40	,20	,40	,40	,20	,40	,40	,40	,20	,20	,20	,20	,20	,20	,20},
        {40	,50	,20	,20	,20	,20	,20	,20	,20	,20	,40	,40	,10	,10	,20	,20	,20	,20	,20},
        {20	,30	,50	,50	,50	,30	,20	,20	,20	,50	,50	,50	,50	,50	,20	,20	,20	,20	,20},
        {40	,30	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,10},
        {50	,40	,40	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,20	,10	,40}
    };

    public static class ColorNum {
        public final static int BLACK = 0;
        public final static int WHITE = 1;
        public final static int GRAY = 2;
        public final static int IVORY = 3;
        public final static int BEIGE = 4;
        public final static int PINK = 5;
        public final static int RED = 6;
        public final static int WINE = 7;
        public final static int PURPLE = 8;
        public final static int SKY_BLUE = 9;
        public final static int BLUE = 10;
        public final static int NAVY = 11;
        public final static int GREEN = 12;
        public final static int OLIVE_GREEN = 13;
        public final static int YELLOW = 14;
        public final static int ORANGE = 15;
        public final static int BROWN = 16;
        public final static int GOLD = 17;
        public final static int SILVER = 18;


        public final static List<Integer> achromatic_colors = Arrays.asList(BLACK,WHITE,GRAY); //무채색 계열

        public final static List<Integer> white_colors = Arrays.asList(IVORY,WHITE); //화이트 계열
        public final static List<Integer> beige_colors = Arrays.asList(BEIGE, IVORY,WHITE); //베이지 계열
        public final static List<Integer> soft_colors = Arrays.asList(BROWN,GOLD, IVORY,BEIGE); //브라운 계열
        public final static List<Integer> pink_color = Arrays.asList(PINK); //핑크
        public final static List<Integer> purple_color = Arrays.asList(PURPLE, PINK); //퍼플
        public final static List<Integer> red_colors = Arrays.asList(RED,WINE, PINK); //레드 계열
        public final static List<Integer> sky_blue_colors = Arrays.asList(SKY_BLUE); //스카이블루
        public final static List<Integer> blue_colors = Arrays.asList(BLUE, SKY_BLUE); //블루 계열
        public final static List<Integer> navy_colors = Arrays.asList(NAVY, BLUE); //네이비 계열
        public final static List<Integer> green_colors = Arrays.asList(GREEN,OLIVE_GREEN); //그린 계열
        public final static List<Integer> yellow_colors = Arrays.asList(YELLOW,ORANGE); //옐로우 계열
        public final static List<Integer> gray_color = Arrays.asList(GRAY); //그레이
        public final static List<Integer> black_color = Arrays.asList(BLACK); //블랙

    }

    public static final HashMap<String,Integer> colorNumMap = new HashMap<>();
    static {
        colorNumMap.put("블랙", ColorNum.BLACK);
        colorNumMap.put("화이트", ColorNum.WHITE);
        colorNumMap.put("그레이", ColorNum.GRAY);
        colorNumMap.put("아이보리", ColorNum.IVORY);
        colorNumMap.put("베이지", ColorNum.BEIGE);
        colorNumMap.put("핑크", ColorNum.PINK);
        colorNumMap.put("레드", ColorNum.RED);
        colorNumMap.put("와인", ColorNum.WINE);
        colorNumMap.put("퍼플", ColorNum.PURPLE);
        colorNumMap.put("스카이블루", ColorNum.SKY_BLUE);
        colorNumMap.put("블루", ColorNum.BLUE);
        colorNumMap.put("네이비", ColorNum.NAVY);
        colorNumMap.put("그린", ColorNum.GREEN);
        colorNumMap.put("올리브그린", ColorNum.OLIVE_GREEN);
        colorNumMap.put("옐로우", ColorNum.YELLOW);
        colorNumMap.put("오렌지", ColorNum.ORANGE);
        colorNumMap.put("브라운", ColorNum.BROWN);
        colorNumMap.put("골드", ColorNum.GOLD);
        colorNumMap.put("실버", ColorNum.SILVER);
    }


    public static final HashMap<String,String> colorIntMap = new HashMap<>();
    static {
        colorIntMap.put("블랙",      "#000000"  );
        colorIntMap.put("화이트",     "#FFFFFF"  );
        colorIntMap.put("그레이",     "#808080"      );
        colorIntMap.put("아이보리",    "#FFFFF0"  )   ;
        colorIntMap.put("베이지",     "#D4B886"  );
        colorIntMap.put("핑크",      "#FFC0CB"  );
        colorIntMap.put("레드",      "#DC143C"  );
        colorIntMap.put("와인",      "#8B0000"  );
        colorIntMap.put("퍼플",      "#800080"  );
        colorIntMap.put("스카이블루",   "#87CEEB"     );
        colorIntMap.put("블루",      "#0000FF"  );
        colorIntMap.put("네이비",     "#000080"  );
        colorIntMap.put("그린",      "#008000"  );
        colorIntMap.put("올리브그린",   "#556B2F"     );
        colorIntMap.put("옐로우",     "#FFFF00"  );
        colorIntMap.put("오렌지",     "#FFA500"  );
        colorIntMap.put("브라운",     "#8B4513"  );
        colorIntMap.put("골드",      "#FFD700"  );
        colorIntMap.put("실버",      "#C0C0C0"  );
    }

    public String getCategory(String s) {
        switch (s.substring(3)) {
            case "1":
                return "음식점";
            case "2":
                return "역사관광지";
            case "3":
                return "자연관광지";
            case "4":
                return "체험관광지";
            case "5":
                return "테마관광지";
            case "6":
                return "기타관광지";
        }
        return "추천지";
    }

    public String getTagCategory(String s) {
        if (s.substring(2, 3).equals("0")) {
            Log.e("===1", s.substring(2, 3));
            switch (s.substring(3)) {
                case "0":
                    Log.e("=====1", s.substring(3));
                    return "귀여운";
                case "1":
                    Log.e("=====1", s.substring(3));
                    return "사랑스러운";
                case "2":
                    Log.e("=====1", s.substring(3));
                    return "달콤한";
                case "3":
                    Log.e("=====1", s.substring(3));
                    return "아기자기한";
                case "4":
                    Log.e("=====1", s.substring(3));
                    return "예쁜";
                case "5":
                    Log.e("=====1", s.substring(3));
                    return "즐거운";
                case "6":
                    Log.e("=====1", s.substring(3));
                    return "쾌활한";
                case "7":
                    Log.e("=====1", s.substring(3));
                    return "신선한";
            }
        } else if (s.substring(2, 3).equals("1")) {
            switch (s.substring(3)) {
                case "0":
                    return "내추럴한";
                case "1":
                    return "자연적인";
                case "2":
                    return "전원적인";
                case "3":
                    return "편안한";
                case "4":
                    return "감성적인";
                case "5":
                    return "풍성한";
                case "6":
                    return "정다운";
                case "7":
                    return "포근한";
                case "8":
                    return "소박한";
            }
        } else if (s.substring(2, 3).equals("2")) {
            switch (s.substring(3)) {
                case "0":
                    return "온화한";
                case "1":
                    return "소박한";
                case "2":
                    return "따뜻한";
                case "3":
                    return "부드러운";
                case "4":
                    return "매끄러운";
                case "5":
                    return "동양적인";
                case "6":
                    return "유연한";
                case "7":
                    return "안정된";
                case "8":
                    return "순수한";
            }
        } else if (s.substring(2, 3).equals("3")) {
            switch (s.substring(3)) {
                case "0":
                    return "경쾌한";
                case "1":
                    return "활동적인";
                case "2":
                    return "밝은";
                case "3":
                    return "재미있는";
                case "4":
                    return "개방적인";
                case "5":
                    return "선명한";
                case "6":
                    return "새로운";
                case "7":
                    return "돋보이는";
                case "8":
                    return "젊은";
            }
        } else if (s.substring(2, 3).equals("4")) {
            switch (s.substring(3)) {
                case "0":
                    return "화려한";
                case "1":
                    return "매력적인";
                case "2":
                    return "장식적인";
                case "3":
                    return "색감이 다양한";
                case "4":
                    return "컬러풀한";
                case "5":
                    return "환상적인";
                case "6":
                    return "복잡한";
                case "7":
                    return "뛰어난";
                case "8":
                    return "다양한";
            }
        } else if (s.substring(2, 3).equals("5")) {
            switch (s.substring(3)) {
                case "0":
                    return "우아한";
                case "1":
                    return "멋진";
                case "2":
                    return "세련된";
                case "3":
                    return "고급스러운";
                case "4":
                    return "기품있는";
                case "5":
                    return "아름다운";
            }
        } else if (s.substring(2, 3).equals("6")) {
            switch (s.substring(3)) {
                case "0":
                    return "은은한";
                case "1":
                    return "단정한";
                case "2":
                    return "정돈된";
                case "3":
                    return "심플한";
                case "4":
                    return "가지런한";
            }
        } else if (s.substring(2, 3).equals("7")) {
            switch (s.substring(3)) {
                case "0":
                    return "다이나믹한";
                case "1":
                    return "역동적인";
                case "2":
                    return "액티브한";
                case "3":
                    return "기운찬";
                case "4":
                    return "개성적인";
            }
        } else if (s.substring(2, 3).equals("8")) {
            switch (s.substring(3)) {
                case "0":
                    return "모던한";
                case "1":
                    return "진보적인";
                case "2":
                    return "도시적인";
                case "3":
                    return "실용적인";
                case "4":
                    return "현대적인";
                case "5":
                    return "하이테크한";
                case "6":
                    return "인공적인";
                case "7":
                    return "딱딱한";
                case "8":
                    return "서양적인";
            }
        }
        return "fail";
    }


    public ArrayList<Object> setRecommendPath (HashMap map, ArrayList<Object>... lists) {
        ArrayList<Object> resultList = new ArrayList<>();
        Random random = new Random();
        int list0_size = lists[0].size();
        int list1_size = lists[1].size();
        int list2_size = lists[2].size();

        for(int i=0; i<3; i++) {

            HashMap<String, Object> responseMap = new HashMap();
            String waypoint = "";
            responseMap.put("start", map.get("start_lng")+","+map.get("start_lat"));
            responseMap.put("goal", map.get("goal_lng")+","+map.get("goal_lat"));

            if(list0_size > 0) {
                int randomCount = random.nextInt(list0_size);
                LinkedTreeMap<String,Object> wayPoint = (LinkedTreeMap<String,Object>) lists[0].get(randomCount);
                waypoint += wayPoint.get("lng")+","+wayPoint.get("lat")+":";

            }
            if(list1_size > 0) {
                int randomCount = random.nextInt(list1_size);
                LinkedTreeMap<String,Object> wayPoint = (LinkedTreeMap<String,Object>) lists[1].get(randomCount);
                waypoint += wayPoint.get("lng")+","+wayPoint.get("lat")+":";
            }
            if(list2_size > 0) {
                int randomCount = random.nextInt(list2_size);
                LinkedTreeMap<String,Object> wayPoint = (LinkedTreeMap<String,Object>) lists[2].get(randomCount);
                waypoint += wayPoint.get("lng")+","+wayPoint.get("lat")+":";
            }
            responseMap.put("waypoints", waypoint.substring(0, waypoint.length()-1));
            resultList.add(responseMap);
        }
        return resultList;
    }


    public static CropImage.ActivityBuilder CropImageSetting(){

        return CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setOutputCompressQuality(60)
                .setInitialCropWindowPaddingRatio(0.05f);
    }

    public void setColorUtil(Context context){
        this.context = context;
        color_name = context.getResources().getStringArray(R.array.Color);
        color_code = context.getResources().getStringArray(R.array.Color_Code);

        mapColors = new HashMap<>();

        for(int i=0; i<color_name.length; i++){
            mapColors.put(color_name[i], color_code[i]);
        }
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        // 찾을 hashmap 과 주어진 단서 value
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    public static String convertKor(String korean){
        String english="";
        switch(korean){
            case "음식" :
                english = "food";
            case "카페" :
                english = "cafe";
            case "디저트" :
                english = "dessert";
            case "놀거리" :
                english = "play";
            case "서점" :
                english = "bookstore";
            case "미용실" :
                english = "Salon";
            case "포차" :
                english = "bar";
            case "패션" :
                english = "fashion";
            case "기타" :
                english = "other";
        }
        if(!english.isEmpty())
            return english;
        else
            return korean;
    }

    public static String convertEng(String english){
        String korean="";
        switch(english){
            case "food" :
                korean = "음식";
            case "cafe" :
                korean = "카페";
            case "dessert" :
                korean = "디저트";
            case "play" :
                korean = "놀거리";
            case "bookstore" :
                korean = "서점";
            case "Salon" :
                korean = "미용실";
            case "bar" :
                korean = "포차";
            case "fashion" :
                korean = "패션";
            case "other" :
                korean = "기타";
        }
        if(!korean.isEmpty())
            return korean;
        else
            return english;
    }
}

