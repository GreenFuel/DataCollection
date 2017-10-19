package com.example.tr.datacollection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmInfo extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Spinner spCaraccident;
    private Spinner spTqcondition;
    private Spinner spLightcondition;
    private Spinner spRoutecondition;
    private Spinner spRouteposition;
    private Spinner spJck;
    private Spinner spJcktype;
    private Spinner spTsposition;

    private Spinner spWorktype;
    private Spinner spHavepeople;
    private Spinner spXczhifa;
    private Spinner spOnbulid;
    private Spinner spRouteLev;

    private Spinner spbianyuanxianlx;
    private Spinner spzhongxinxianlx;
    private Spinner spchedaobiaoji;
    private Spinner spjiaotongkzlx;
    private Spinner spzhuchedaolx;
    private Spinner spjiaochakoucds;
    //工作区
    private CheckBox ckWorkPlace;
    private LinearLayout WorkPlace;

    private EditText editlimitSpeed;
    private EditText chedaoWidth;
    private EditText lujianWidth;
    private EditText centerWidth;
    private String workPlaceR = "no";
    private LinearLayout layoutRouteBaseInfo;
    private LinearLayout layoutControllerType;
    public EmInfo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_em_info, container, false);
        intiView(view);
        return view;
    }

    private void intiView(View view) {
        //宽度
        chedaoWidth = (EditText) view.findViewById(R.id.sp_chedaowidth);
        lujianWidth = (EditText) view.findViewById(R.id.sp_lujianwidth);
        centerWidth = (EditText) view.findViewById(R.id.sp_zhongjianwidth);
        layoutRouteBaseInfo  = (LinearLayout) view.findViewById(R.id.lay_routeinfo) ;
        layoutControllerType = (LinearLayout) view.findViewById(R.id.lay_jtkzlx);
        //工作区
        WorkPlace = (LinearLayout) view.findViewById(R.id.workplace);
        ckWorkPlace = (CheckBox) view.findViewById(R.id.checkbox_workplace);
        ckWorkPlace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    WorkPlace.setVisibility(LinearLayout.VISIBLE);
                    workPlaceR = "yes";
                }else{
                    WorkPlace.setVisibility(LinearLayout.GONE);
                    workPlaceR = "no";
                }
            }
        });

//车间事故
        spCaraccident =(Spinner) view.findViewById(R.id.sp_caraccident);
        String[] strspCaraccident={	"追尾碰撞","正面碰撞","侧面碰撞（同向）","侧面碰撞（对向）","侧面","碰撞（直角）","侧面碰撞（角度不确定）",
                "同向刮擦","对向刮擦","其他角度碰撞"};
        spCaraccident.setAdapter(new MyAdapter(strspCaraccident,view.getContext()).getAdaper());
//事故城市


//是否有工人
        String[] strHavepeopel={"否","是","未知"};
        spHavepeople =(Spinner) view.findViewById(R.id.sp_havepeople);
        spHavepeople.setAdapter(new MyAdapter(strHavepeopel,view.getContext()).getAdaper());
//立交区域
        spJck = (Spinner) view.findViewById(R.id.sp_jck);
        String[] strspJck={"否","是","未知"};
        spJck.setAdapter(new MyAdapter(strspJck,view.getContext()).getAdaper());

//交叉口类型
        spJcktype= (Spinner) view.findViewById(R.id.sp_jcktype);
        String[] strspJcktype={"非交叉口","十字交叉口","T形交叉口","Y形交叉口","L形交叉口","环形交叉口","环岛","五或更多条交叉口","立交区域"};
        spJcktype.setAdapter(new MyAdapter(strspJcktype,view.getContext()).getAdaper());
        Log.i("iteminfo","okkk");
        spJcktype.setEnabled(true);
//        spJcktype.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.i("iteminfo","onItemClick");
//            }
//        });
        spJcktype.setOnItemSelectedListener(this);
        /*spJcktype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i<8 && i >0) {
                    layoutRouteBaseInfo.setVisibility(View.VISIBLE);
                    layoutControllerType.setVisibility(View.GONE);
                }else {
                    layoutControllerType.setVisibility(View.VISIBLE);
                    layoutRouteBaseInfo.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/


//光照情况
        spLightcondition  =(Spinner)  view.findViewById(R.id.sp_lightcondition);
        String[] strspLightcondition={"白天","凌晨","夜晚","黄昏","夜间无路灯照明","夜间光线状况不明","其他	未知"};
        spLightcondition.setAdapter(new MyAdapter(strspLightcondition,view.getContext()).getAdaper());
//是否发生在建设区
        spOnbulid = (Spinner) (Spinner) view.findViewById(R.id.sp_onbulid);
        String[] strspOnbulid={"否","是","未知"};
        spOnbulid.setAdapter(new MyAdapter(strspOnbulid,view.getContext()).getAdaper());
//致因条件，环境
//道路等级
        spRouteLev = (Spinner) view.findViewById(R.id.sp_routelev);
        String[] strspRouteLev={	"01 高速公路","02 快速路","03 主干道","04 次干道","05 支路"};
        spRouteLev.setAdapter(new MyAdapter2(strspRouteLev,view.getContext()).getAdaper());
//道路状况
        spRoutecondition =(Spinner)  view.findViewById(R.id.sp_routecondition);
        String[] strspRoutecondition={	"干燥","潮湿","积雪","泥泞","	积冰/霜	积水（固定，流动）","砂石	泥、灰尘、沙砾	油","其他","未知"};
        spRoutecondition.setAdapter(new MyAdapter(strspRoutecondition,view.getContext()).getAdaper());
//车道位置
        spRouteposition = (Spinner) view.findViewById(R.id.sp_chedaoposition);
        String[] strspRouteposition={"在路中","在路肩","路中心线","在路旁","三角区","隔离带	","停车道路或区域","非道路中，未知位置","道路（公共行车道）","未知"};
        spRouteposition.setAdapter(new MyAdapter(strspRouteposition,view.getContext()).getAdaper());

//道路限速
        editlimitSpeed = (EditText) view.findViewById(R.id.sp_speedlimit);

//天气状况
        spTqcondition = (Spinner) view.findViewById(R.id.sp_tqcondition);
        String[] strspTqcondition={"晴朗","多云","雾，烟，烟雾","雨","雨夹雪或冰雹","冻雨或冻雾雨","雪","飘雪","严重侧风","沙尘","其他","未知"};
        spTqcondition.setAdapter(new MyAdapter(strspTqcondition,view.getContext()).getAdaper());

//特殊位置
        spTsposition = (Spinner) view.findViewById(R.id.sp_tsposition);
        String[] strspTsposition={"未知","进/出口匝道","与进/出口匝道相关","铁路平交道口","与立交相关","私有道路","与私有道路相关",
                "公用路径或小道","加速/减速车道","直通道路","其他以上未列出但与交叉口相关区域","收费站"};
        spTsposition.setAdapter(new MyAdapter(strspTsposition,view.getContext()).getAdaper());

//作业区类型        
        spWorktype =(Spinner)  view.findViewById(R.id.sp_worktype);
        String[] strspWorktype={"车道关闭","车道变换","工作于路肩或中央带","间歇或移动作业","其他"};
        spWorktype.setAdapter(new MyAdapter(strspWorktype,view.getContext()).getAdaper());
        
// 现场执法  
        spXczhifa = (Spinner) view.findViewById(R.id.sp_xczhifa);
        String[] strspXczhifa={"无","仅有执法人员","仅有执法车辆"};
        spXczhifa.setAdapter(new MyAdapter(strspXczhifa,view.getContext()).getAdaper());

         spbianyuanxianlx = (Spinner)view.findViewById(R.id.sp_bianyuanxian)  ;
        String[] strspbianyuanxianlx = {"无标记边缘线","标准宽度边缘线","较宽的边缘线","其他"};
        spbianyuanxianlx.setAdapter(new MyAdapter(strspbianyuanxianlx,view.getContext()).getAdaper());

         spzhongxinxianlx = (Spinner)view.findViewById(R.id.sp_zhongxinxian)  ;
        String[] strspzhongxinxianlx = {"无标记中心线","标准中心线标记","有振动减速带的中心线"};
        spzhongxinxianlx.setAdapter(new MyAdapter(strspzhongxinxianlx,view.getContext()).getAdaper());

        spchedaobiaoji = (Spinner)view.findViewById(R.id.sp_chedaoxianbj)  ;
        String[] strspchedaobiaoji = {"无车道线","标准车道线","较宽的车道线"};
        spchedaobiaoji.setAdapter(new MyAdapter(strspchedaobiaoji,view.getContext()).getAdaper());

         spjiaotongkzlx = (Spinner)view.findViewById(R.id.sp_jiaotongkzlx)  ;
        String[] strspjiaotongkzlx = {"无控制","交叉口内停车标志","全向停车标志","全向闪灯（交叉路红灯）","全向闪灯（主要道路黄灯，次要道路红灯）","交叉口内让行标志","定时信号灯（两相位）","定时信号灯（多相位）","半感应信号灯（两相位）","半感应信号灯（多相位）","全感应信号灯（两相位）","全感应信号灯（多相位） ","其他","未知"};
        spjiaotongkzlx .setAdapter(new MyAdapter(strspjiaotongkzlx,view.getContext()).getAdaper());

         spzhuchedaolx = (Spinner)view.findViewById(R.id.sp_zhuxiancds)  ;
        String[] strspzhuchedaolx = {"单车道","双车道","三车道","四到六车道","七或更多车道","未知"};
        spzhuchedaolx.setAdapter(new MyAdapter(strspzhuchedaolx,view.getContext()).getAdaper());

         spjiaochakoucds = (Spinner) view.findViewById(R.id.sp_jiaochajds);
        String[] strspjiaochakoucds = {"单车道","双车道","三车道","四到六车道","七或更多车道","未知"};
         spjiaochakoucds .setAdapter(new MyAdapter(strspjiaochakoucds,view.getContext()).getAdaper());



        Date date = new Date(System.currentTimeMillis());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");


        initClick(view);
    }

    private void initClick(View view) {
       // spAcctype.set


         spTqcondition.setOnItemSelectedListener(this);
         spLightcondition.setOnItemSelectedListener(this);
         spRoutecondition.setOnItemSelectedListener(this);
         spRouteposition.setOnItemSelectedListener(this);
         spJck.setOnItemSelectedListener(this);
         spJcktype.setOnItemSelectedListener(this);
         spTsposition.setOnItemSelectedListener(this);

         spWorktype.setOnItemSelectedListener(this);
         spHavepeople.setOnItemSelectedListener(this);
         spXczhifa.setOnItemSelectedListener(this);
         spOnbulid.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View view) {

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        Log.i("shijians","in");
//        Log.i("shijians","in"+i);
//        Log.i("shijians","viewid:"+view.getId());
//        Log.i("shijians","adapterViewid:"+adapterView.getId());
//        Log.i("shijians","R.id.shijian"+R.id.shijian);
        switch (adapterView.getId()){
            case R.id.sp_jcktype:
                if (i<8 && i >0) {
                    layoutControllerType.setVisibility(View.VISIBLE);
                    layoutRouteBaseInfo.setVisibility(View.GONE);

                }else {
                    layoutRouteBaseInfo.setVisibility(View.VISIBLE);
                    layoutControllerType.setVisibility(View.GONE);
                }
                break;
        }
        Log.i("shijians","in"+i);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //获取数据

   public String  Routeposition() {//路面位置
        return spRouteposition.getSelectedItem().toString();
   }
   public String  pengzhuangleixing() {//碰撞类型
        return "未知";
   }
   public String  liJiaoQuYu() {//立交区域
        return spJck.getSelectedItem().toString();
   }
   public String  Jcktype() {//交叉口类型
        return spJcktype.getSelectedItem().toString();
   }
   public String  Teshuposition() {//特殊位置
        return spTsposition.getSelectedItem().toString();
   }
   public String  Tianqicondition() {//天气状况
        return spTqcondition.getSelectedItem().toString();
   }
   public String  zhaomingcondition() {//照明状况
        return spLightcondition.getSelectedItem().toString();
   }
   public String  luMianCondition() {//路面状况
        return spRoutecondition.getSelectedItem().toString();
   }
   public String  luMianLev() {//路面等级
        return spRouteLev.getSelectedItem().toString();
   }

   public String  limitSpeed() {//限速
        return editlimitSpeed.getText().toString();
   }
   public String  chedaowidth() {//车道宽度
        return chedaoWidth.getText().toString();
   }

   public String  luJianWidth() {//路肩宽度
        return lujianWidth.getText().toString();
   }

    public String  bianYuanXianle() {//边缘线类型
        return spbianyuanxianlx.getSelectedItem().toString();
    }

   public String  zhongyanwidht() {//中央带宽带
        return centerWidth.getText().toString();
   }
   public String  zhongXinXian() {//中心线类型
        return spzhongxinxianlx.getSelectedItem().toString();
   }
   public String  chedaoxianbj() {//车道线标记
        return spchedaobiaoji.getSelectedItem().toString();
   }
   public String  jiaotongkzlx() {//交通控制类型
        return spjiaotongkzlx.getSelectedItem().toString();
   }
   public String  zhuchedaoshu() {//主车道数
        return spzhuchedaolx.getSelectedItem().toString();
   }
   public String  jiaochajiedaoshu() {//交叉街道数
        return spjiaochakoucds.getSelectedItem().toString();
   }
   public String  WorkPlaceR() {//与工作区相关
        return workPlaceR;
   }
   public String  Worktype() {//工作区类型
        return spWorktype.getSelectedItem().toString();
   }
   public String  Havepeople() {//是否存在工人
        return spHavepeople.getSelectedItem().toString();
   }
   public String  xianChangZhifa() {//现场执法
        return spXczhifa.getSelectedItem().toString();
   }
}
