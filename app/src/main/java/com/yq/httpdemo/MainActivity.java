package com.yq.httpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = ((TextView) findViewById(R.id.tv_result));
        HttpService.init(new OkhttpProcessor(OkHttpClientUtil.getClient()));
//        HttpService.init(new OkhttpProcessor(new OkHttpClient()));

//        String url = "https://192.168.1.240/phone/interest/getInterestRankingByMemberName.json";
        String url = "https://192.168.1.240/help/help_dynamic.jhtml?id=31";
//        url = "https://api.github.com/users/octocat/repos";

//        url+="?memberName=18516692370";

        Map<String, Object> map = new HashMap<>();

        map.put("memberName", "18516692370");

        /**
         * 用{@link HttpCallback}方便解析
         * {@link HttpCallback1<T>} 只适用于解析具体的类，不适用于二次泛型，及{@link ReturnMessage<T>}的情况
         */
        HttpService.getServiceInstance().get(url, null, new HttpCallback() {

            @Override
            public void onSuccess(final String body) {

                Log.i("mainactivity_http", "onSuccess: " + body);

//                ReturnMessage<MemberGuessInfo> returnMessage = JsonUtil.getReturnMsgByT1(body, new TypeToken<ReturnMessage<MemberGuessInfo>>() {
//                });

                tv.setText(body);

                tv.setText(Html.fromHtml(body));

            }

            @Override
            public void onFailure(String e) {

            }
        });
//        HttpService.getServiceInstance().post(url, map, new HttpCallback1<MemberGuessInfo>() {
//
//            @Override
//            public void onSuccess(MemberGuessInfo response) {
//
//                ((TextView) findViewById(R.id.tv_result)).setText(response.toString());
//
//            }
//
//            @Override
//            public void onFailure(String e) {
//
//            }
//        });
    }

    public class MemberGuessInfo implements Serializable {

        private static final long serialVersionUID = -4766220195233580087L;

        private int id;

        private String memberName;

        private double bonusScoreCount;

        private int guessCount;

        private int bonusNumCount;

        private int ranking;

        private int type;

        private int weeks;

        private int totalPoints;

        private double pre;

        public int getId() {

            return id;

        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMemberName() {
            return memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
        }

        public double getBonusScoreCount() {
            return bonusScoreCount;
        }

        public void setBonusScoreCount(double bonusScoreCount) {
            this.bonusScoreCount = bonusScoreCount;
        }

        public int getGuessCount() {
            return guessCount;
        }

        public void setGuessCount(int guessCount) {
            this.guessCount = guessCount;
        }

        public int getBonusNumCount() {
            return bonusNumCount;
        }

        public void setBonusNumCount(int bonusNumCount) {
            this.bonusNumCount = bonusNumCount;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getWeeks() {
            return weeks;
        }

        public void setWeeks(int weeks) {
            this.weeks = weeks;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }

        public double getPre() {
            return pre;
        }

        public void setPre(double pre) {
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "MemberGuessInfo{" +
                    "id=" + id +
                    ", memberName='" + memberName + '\'' +
                    ", bonusScoreCount=" + bonusScoreCount +
                    ", guessCount=" + guessCount +
                    ", bonusNumCount=" + bonusNumCount +
                    ", ranking=" + ranking +
                    ", type=" + type +
                    ", weeks=" + weeks +
                    ", totalPoints=" + totalPoints +
                    ", pre=" + pre +
                    '}';
        }
    }
}
